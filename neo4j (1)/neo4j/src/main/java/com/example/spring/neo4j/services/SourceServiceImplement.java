package com.example.spring.neo4j.services;

import com.example.spring.neo4j.nodes.Answears;
import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.forms.SourceForm;
import com.example.spring.neo4j.converters.SourceFormToSource;
import com.example.spring.neo4j.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SourceServiceImplement implements SourceService {
    private SourceRepository sourceRepository;
    private SourceFormToSource sourceFormToSource;

    @Autowired
    public SourceServiceImplement(SourceRepository sourceRepository, SourceFormToSource sourceFormToSource) {
        this.sourceRepository = sourceRepository;
        this.sourceFormToSource = sourceFormToSource;
    }


    @Override
    public List<Source> listAll() {
        List<Source> sources = new ArrayList<>();
        sourceRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).forEach(sources::add); //fun with Java 8
        return sources;
    }

    @Override
    public Source getById(Long id) {
        return sourceRepository.findById(id).orElse(null);
    }

    @Override
    public Source saveOrUpdate(Source source) {
        sourceRepository.save(source);
        return source;
    }

    @Override
    public void delete(Long id) {
        sourceRepository.deleteById(id);
    }

    @Override
    public Source saveOrUpdateSourceForm(SourceForm sourceForm) {
        Source savedSource = saveOrUpdate(sourceFormToSource.convert(sourceForm));

        System.out.println("Saved Product Id: " + savedSource.getId());
        return savedSource;
    }

    @Override
    public Source findByName(String name) {
        return sourceRepository.findByName(name);
    }

    @Override
    public Source updateRating(Source source, Answears answears) {
        System.out.println("in updateRating");

        Float resetRate = Float.sum(10,0) ;
        source.setRate(resetRate);
        sourceRepository.save(source);

        if (answears.getHouseType() != null){
        switch (answears.getHouseType()){
            case "option1":
                if (source.getHouseType().matches(".*1.*")==false){
                    Float newRateValue = Float.sum(0,0) ;
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            case "option2":
                if (source.getHouseType().matches(".*2.*")==false) {
                    Float newRateValue = Float.sum(0, 0);
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            case "option3":
                if (source.getHouseType().matches(".*3.*")==false){
                    Float newRateValue = Float.sum(0,0) ;
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            default:
                break;
        }}


        if (answears.getInvestmentCosts() != null){
            switch (answears.getInvestmentCosts()){
                case "option1":
                    System.out.println(""+answears.getInvestmentCosts());
                    if(source.getInvestcosts()>3000){
                        Float newRateValue = Float.sum(0,0) ;
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                case "option2":
                    if(source.getInvestcosts()>5000){
                        Float newRateValue = Float.sum(0,0);
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                case "option3":
                    if(source.getInvestcosts()>10000){
                        Float newRateValue = Float.sum(0,0);
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                case "option4":
                    break;
                default:
                    System.out.println(""+answears.getInvestmentCosts());
                    System.out.println("No answear to annual costs question");
            }}

        if (answears.getAnnualCosts() != null){
        switch (answears.getAnnualCosts()){
            case "option1":
                System.out.println(""+answears.getAnnualCosts());
                if(source.getYearlycosts()>2000){
                    Float newRateValue = Float.sum(0,0) ;
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            case "option2":
                if(source.getYearlycosts()>5000){
                    Float newRateValue = Float.sum(0,0);
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            case "option3":
                break;
            default:
                System.out.println(""+answears.getAnnualCosts());
                System.out.println("No answear to annual costs question");
        }}

        if (answears.getEcology() != null){
        switch (answears.getEcology()){
            case "0":
                System.out.println("No ecology answar");
                break;
            case "1":
                System.out.println("Do not care about ecology");
                break;
            case "2":
                //source.getFuels().get(0).getEcology()
                Float newRateValue = new Float((Collections.max(source.getFuels(), Comparator.comparing(s -> s.getEcology())).getEcology() * 0.5)) + source.getRate();
                source.setRate(newRateValue);
                break;
            case "3":
                newRateValue = new Float(Collections.max(source.getFuels(), Comparator.comparing(s -> s.getEcology())).getEcology()) + source.getRate();
                source.setRate(newRateValue);
                break;
            default:
                System.out.println("No ecology answar");
        }}

        if (answears.getStorage() != null){
            int minFuelsStorage = Collections.min(source.getFuels(), Comparator.comparing(s -> s.getStorage())).getStorage();
            //source.getFuels().get(0).getStorage()
            switch (answears.getStorage()){
            case "0":
                if(minFuelsStorage<6){
                    Float newRateValue = Float.sum(source.getRate(),0) ;
                    source.setRate(newRateValue);
                }
                else{
                    Float newRateValue = Float.sum(source.getRate(),5) ;
                    source.setRate(newRateValue);
                }
                break;
            case "1":
                if(minFuelsStorage<6){
                    Float newRateValue = Float.sum(source.getRate(),0) ;
                    source.setRate(newRateValue);
                }
                else{
                    Float newRateValue = Float.sum(source.getRate(),3) ;
                    source.setRate(newRateValue);
                }
                break;
            case "2":
                if(minFuelsStorage<6){
                    Float newRateValue = Float.sum(source.getRate(),0) ;
                    source.setRate(newRateValue);
                }
                else{
                    Float newRateValue = Float.sum(source.getRate(),1) ;
                    source.setRate(newRateValue);
                }
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            default:
                System.out.println("No answear to storage question");
        }}

        if (answears.getConservation() != null){
            switch (answears.getConservation()){
                case "true":
                    if(Objects.equals(source.getMaintenanceNeeds(),"low")){
                        Float newRateValue = Float.sum(source.getRate(),6);
                        source.setRate(newRateValue);
                    }
                    else if(Objects.equals(source.getMaintenanceNeeds(),"medium")){
                        Float newRateValue = Float.sum(source.getRate(),3);
                        source.setRate(newRateValue);
                    }

                    break;
                default:
                    System.out.println("No conservation answar "+answears.getConservation());
            }}

        if (answears.getDailyElectricityUse() != null){
            switch (answears.getDailyElectricityUse()){
                case "true":
                    if(source.getName().toLowerCase().contains("panel") || source.getName().toLowerCase().contains("turbina")){
                        Float newRateValue = Float.sum(source.getRate(),5);
                        source.setRate(newRateValue);
                    }
                    break;
                default:
                    System.out.println("No daily electricity use answar ");
            }}

        if (answears.getDailyThermalUse() != null){
            switch (answears.getDailyThermalUse()){
                case "true":
                    if(source.getName().toLowerCase().contains("kolektor")){
                        Float newRateValue = Float.sum(source.getRate(),5);
                        source.setRate(newRateValue);
                    }
                    break;
                default:
                    System.out.println("No daily thermal use answar ");
            }}


        if (answears.getRoofSite() != null){
            switch (answears.getRoofSite()){
                case "south":
                    if(source.getName().toLowerCase().contains("panel") || source.getName().toLowerCase().contains("kolektor")){
                        Float newRateValue = Float.sum(source.getRate(),5);
                        source.setRate(newRateValue);
                    }
                    break;
                case "westEast":
                    break;
                case "none":
                    if(source.getName().toLowerCase().contains("panel") || source.getName().toLowerCase().contains("kolektor")){
                        Float newRateValue = Float.sum(0,0);
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                default:
                    System.out.println("No answear to roof exposition");
            }}

        sourceRepository.save(source);
        return source;
    }

}
