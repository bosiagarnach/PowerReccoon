package com.example.spring.neo4j;

import org.neo4j.driver.util.Pair;

public class SourceForm {


    private Long id;
    private String name;
    private String description;
    private String url;
    private Long rate;

    private String longdescription;
    private Pair<Integer, Integer> investcosts;
    private Integer yearlycosts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getLongdescription() {
        return longdescription;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public Pair<Integer, Integer> getInvestcosts() {
        return investcosts;
    }

    public void setInvestcosts(Pair<Integer, Integer> investcosts) {
        this.investcosts = investcosts;
    }

    public Integer getYearlycosts() {
        return yearlycosts;
    }

    public void setYearlycosts(Integer yearlycosts) {
        this.yearlycosts = yearlycosts;
    }
}
