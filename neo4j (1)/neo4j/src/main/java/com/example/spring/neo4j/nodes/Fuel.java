package com.example.spring.neo4j.nodes;

import org.neo4j.driver.util.Pair;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Fuel {
    private Long id;
    private String name;
    private Integer ecology;
    private Integer storage;
    private Integer costs;


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


    public Integer getEcology() {
        return ecology;
    }

    public void setEcology(Integer ecology) {
        this.ecology = ecology;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }
}
