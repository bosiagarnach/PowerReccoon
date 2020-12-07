package com.example.spring.neo4j;

import com.example.spring.neo4j.nodes.Fuel;
import org.neo4j.driver.util.Pair;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

public class SourceForm {

    private Long id;
    private String name;
    private String description;
    private String url;
    private Float rate;

    private String longdescription;
    private Integer investcosts;
    private Integer yearlycosts;

    @Relationship(type="Fueled", direction = Relationship.OUTGOING)
    private List<Fuel> fuels;

    private String houseType;
    private String maintenanceNeeds;


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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getLongdescription() {
        return longdescription;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public Integer getYearlycosts() {
        return yearlycosts;
    }

    public void setYearlycosts(Integer yearlycosts) {
        this.yearlycosts = yearlycosts;
    }

    public List<Fuel> getFuels() {
        return fuels;
    }

    public void setFuels(List<Fuel> fuels) {
        this.fuels = fuels;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getInvestcosts() {
        return investcosts;
    }

    public void setInvestcosts(Integer investcosts) {
        this.investcosts = investcosts;
    }

    public String getMaintenanceNeeds() {
        return maintenanceNeeds;
    }

    public void setMaintenanceNeeds(String maintenanceNeeds) {
        this.maintenanceNeeds = maintenanceNeeds;
    }
}
