package com.example.spring.neo4j.nodes;

import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Answears {
    private String houseType;
    private String familyType;
    private String investmentCosts;
    private String annualCosts;
    private String conservation;
    private String storage;
    private String ecology;
    private String agd;
    private String dailyElectricityUse;
    private String dailyThermalUse;
    private String roofSite;

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

    public String getInvestmentCosts() {
        return investmentCosts;
    }

    public void setInvestmentCosts(String investmentCosts) {
        this.investmentCosts = investmentCosts;
    }

    public String getAgd() {
        return agd;
    }

    public void setAgd(String agd) {
        this.agd = agd;
    }

    public String getDailyElectricityUse() {
        return dailyElectricityUse;
    }

    public void setDailyElectricityUse(String dailyElectricityUse) {
        this.dailyElectricityUse = dailyElectricityUse;
    }

    public String getDailyThermalUse() {
        return dailyThermalUse;
    }

    public void setDailyThermalUse(String dailyThermalUse) {
        this.dailyThermalUse = dailyThermalUse;
    }

    public String getRoofSite() {
        return roofSite;
    }

    public void setRoofSite(String roofSite) {
        this.roofSite = roofSite;
    }
}
