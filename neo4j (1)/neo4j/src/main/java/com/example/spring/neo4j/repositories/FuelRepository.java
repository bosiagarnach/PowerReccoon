package com.example.spring.neo4j.repositories;

import com.example.spring.neo4j.nodes.Fuel;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FuelRepository extends Neo4jRepository<Fuel,Long> {
}
