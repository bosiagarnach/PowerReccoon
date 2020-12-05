package com.example.spring.neo4j.converters;


import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.SourceForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SourceToSourceForm implements Converter<Source, SourceForm> {

    public SourceForm convert(Source source) {
        SourceForm sourceForm = new SourceForm();
        sourceForm.setId(source.getId());
        sourceForm.setDescription(source.getDescription());
        sourceForm.setName(source.getName());
        sourceForm.setRate(source.getRate());
        sourceForm.setUrl(source.getUrl());
        sourceForm.setInvestcosts(source.getInvestcosts());
        sourceForm.setLongdescription(source.getLongdescription());
        sourceForm.setYearlycosts(source.getYearlycosts());
        sourceForm.setHouseType(source.getHouseType());
        return sourceForm;
    }

}
