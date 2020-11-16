package com.example.spring.neo4j.converters;

import com.example.spring.neo4j.Source;
import com.example.spring.neo4j.SourceForm;
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
        return source;
    }

}
