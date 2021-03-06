package com.example.spring.neo4j.repositories;

import com.example.spring.neo4j.nodes.Source;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SourceRepository  extends Neo4jRepository<Source, Long> {
    Source findByName(String name);
}
