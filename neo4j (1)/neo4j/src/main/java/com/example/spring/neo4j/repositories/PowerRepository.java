package com.example.spring.neo4j.repositories;

import com.example.spring.neo4j.nodes.Power;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PowerRepository extends Neo4jRepository<Power, Long> {
}
