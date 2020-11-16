package com.example.spring.neo4j.services;

import com.example.spring.neo4j.Source;
import com.example.spring.neo4j.SourceForm;
import com.example.spring.neo4j.converters.SourceFormToSource;
import com.example.spring.neo4j.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SourceServiceImplement implements SourceService {
    private SourceRepository sourceRepository;
    private SourceFormToSource sourceFormToSource;

    @Autowired
    public SourceServiceImplement(SourceRepository sourceRepository, SourceFormToSource sourceFormToSource) {
        this.sourceRepository = sourceRepository;
        this.sourceFormToSource = sourceFormToSource;
    }


    @Override
    public List<Source> listAll() {
        List<Source> sources = new ArrayList<>();
        sourceRepository.findAll(Sort.by(Sort.Direction.DESC, "rate")).forEach(sources::add); //fun with Java 8
        return sources;
    }

    @Override
    public Source getById(Long id) {
        return sourceRepository.findById(id).orElse(null);
    }

    @Override
    public Source saveOrUpdate(Source source) {
        sourceRepository.save(source);
        return source;
    }

    @Override
    public void delete(Long id) {
        sourceRepository.deleteById(id);

    }

    @Override
    public Source saveOrUpdateSourceForm(SourceForm sourceForm) {
        Source savedSource = saveOrUpdate(sourceFormToSource.convert(sourceForm));

        System.out.println("Saved Product Id: " + savedSource.getId());
        return savedSource;
    }


}
