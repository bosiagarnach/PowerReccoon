package com.example.spring.neo4j.nodes;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Answears {
    private String houseType;
    private String familyType;
    private String investmentRange;
    private String annualCosts;
    private String conservation;
    private String storage;
    private String ecology;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }

    public String getInvestmentRange() {
        return investmentRange;
    }

    public void setInvestmentRange(String investmentRange) {
        this.investmentRange = investmentRange;
    }


    public String getConservation() {
        return conservation;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getEcology() {
        return ecology;
    }

    public void setEcology(String ecology) {
        this.ecology = ecology;
    }

    public String getAnnualCosts() {
        return annualCosts;
    }

    public void setAnnualCosts(String annualCosts) {
        this.annualCosts = annualCosts;
    }
}
