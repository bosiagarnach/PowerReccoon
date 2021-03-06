package com.example.spring.neo4j.converters;

import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.forms.SourceForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class SourceFormToSource implements Converter<SourceForm, Source> {
    @Override
    public Source convert(SourceForm sourceForm) {
        Source source = new Source();
        if (sourceForm.getId() != null  && !StringUtils.isEmpty(sourceForm.getId().toString())) {
            source.setId(new Long(sourceForm.getId()));
        }
        source.setDescription(sourceForm.getDescription());
        source.setName(sourceForm.getName());
        source.setRate(sourceForm.getRate());
        source.setUrl(sourceForm.getUrl());
        source.setInvestcosts(sourceForm.getInvestcosts());
        source.setLongdescription(sourceForm.getLongdescription());
        source.setYearlycosts(sourceForm.getYearlycosts());
        source.setHouseType(sourceForm.getHouseType());
        source.setMaintenanceNeeds(sourceForm.getMaintenanceNeeds());
        source.setImage(sourceForm.getImage());
        return source;
    }

}
