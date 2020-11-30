package com.example.spring.neo4j.services;

import com.example.spring.neo4j.nodes.Answears;
import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.SourceForm;

import java.util.List;

public interface SourceService {
    List<Source> listAll();
    Source getById(Long id);
    Source saveOrUpdate(Source source);
    void delete(Long id);
    Source saveOrUpdateSourceForm(SourceForm sourceForm);
    Source findByName(String name);


    Source updateRating(Source source, Answears answears);
}
