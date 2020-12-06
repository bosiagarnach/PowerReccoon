package com.example.spring.neo4j;

import com.example.spring.neo4j.converters.SourceToSourceForm;
import com.example.spring.neo4j.nodes.Answears;
import com.example.spring.neo4j.nodes.Power;
import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.repositories.FuelRepository;
import com.example.spring.neo4j.repositories.PowerRepository;
import com.example.spring.neo4j.services.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@RestController
@Controller
public class SourceController {


    private SourceService sourceService;

    private SourceToSourceForm sourceToSourceForm;

    private PowerRepository powerRepository;

    @Autowired
    public void setSourceToSourceForm(SourceToSourceForm sourceToSourceForm) {
        this.sourceToSourceForm = sourceToSourceForm;
    }

    @Autowired
    public void setSourceService(SourceService sourceService) {
        this.sourceService = sourceService;
    }
    @Autowired
    public void setPowerRepository(PowerRepository powerRepository) {
        this.powerRepository = powerRepository;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/source/list";
    }

    @RequestMapping("/userview")
    public String loadUserView(Model model){
        List<Power> powers = new ArrayList<>();
        powerRepository.findAll(Sort.by(Sort.Direction.DESC, "name")).forEach(powers::add);
        List<Source> thermalSources = powers.get(0).getPowerSources();
        List<Source> electricalSources = powers.get(1).getPowerSources();
        Comparator<Source> compareByRate = (Source s1, Source s2) -> s1.getRate().compareTo(s2.getRate());
        Collections.sort(thermalSources, compareByRate.reversed());
        Collections.sort(electricalSources, compareByRate.reversed());
        model.addAttribute("thermalSources",thermalSources);
        model.addAttribute("electricalSources",electricalSources);
        model.addAttribute("sources", sourceService.listAll());
        model.addAttribute("answears", new Answears());
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

    @GetMapping("/sourceFuels/{name}")
    public Source getInfo(@PathVariable String name){
        return sourceService.findByName(name);
    }


    @RequestMapping(value = "/userview", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("answears") Answears answears, Model model) {
        List<Source> sourceList = sourceService.listAll();
        for (int i = 0; i < sourceList.size();i++){
            System.out.println(" "+i);
            Source source = sourceList.get(i);

            sourceService.updateRating(source,answears);
   //         if (source.getRate()==0){
     //           List<Source> thermalSources = model.getAttribute("thermalSources");
      //          sourc.removeIf(e -> e.getId().equals(id));
      //      }
        }

        System.out.println("" + answears.getStorage());

        return "redirect:userview";
    }


}
