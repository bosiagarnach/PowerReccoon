package com.example.spring.neo4j;

import com.example.spring.neo4j.converters.SourceToSourceForm;
import com.example.spring.neo4j.services.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SourceController {


    private SourceService sourceService;

    private SourceToSourceForm sourceToSourceForm;

    @Autowired
    public void setSourceToSourceForm(SourceToSourceForm sourceToSourceForm) {
        this.sourceToSourceForm = sourceToSourceForm;
    }

    @Autowired
    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/source/list";
    }

    @RequestMapping("/userview")
    public String loadUserView(Model model){
        model.addAttribute("sources", sourceService.listAll());
        return "source/userview";
    }

    @RequestMapping({"/source/list", "/source"})
    public String listSources(Model model){
        model.addAttribute("sources", sourceService.listAll());
        return "source/list";
    }

    @RequestMapping("/source/show/{id}")
    public String getSource(@PathVariable String id, Model model){
        model.addAttribute("source", sourceService.getById(Long.valueOf(id)));
        return "source/show";
    }

    @RequestMapping("source/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Source source = sourceService.getById(Long.valueOf(id));
        SourceForm sourceForm = sourceToSourceForm.convert(source);

        model.addAttribute("sourceForm", sourceForm);
        return "source/sourceform";
    }

    @RequestMapping("/source/new")
    public String newSource(Model model){
        model.addAttribute("sourceForm", new SourceForm());
        return "source/sourceform";
    }

    @RequestMapping(value = "/source", method = RequestMethod.POST)
    public String saveOrUpdateSource(SourceForm sourceForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "source/sourceform";
        }

        Source savedSource = sourceService.saveOrUpdateSourceForm(sourceForm);

        return "redirect:/source/show/" + savedSource.getId();
    }

    @RequestMapping("/source/delete/{id}")
    public String delete(@PathVariable String id){
        sourceService.delete(Long.valueOf(id));
        return "redirect:/source/list";
    }


}
