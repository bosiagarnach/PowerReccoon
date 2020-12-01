package com.example.spring.neo4j.nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Power {
    private Long id;
    private String name;

    @Relationship(type="isProducedBy", direction = Relationship.OUTGOING)
    private List<Source> powerSources;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Source> getPowerSources() {
        return powerSources;
    }

    public void setPowerSources(List<Source> powerSources) {
        this.powerSources = powerSources;
    }
}
