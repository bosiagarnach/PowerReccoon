package com.example.spring.neo4j.services;

import com.example.spring.neo4j.nodes.Answears;
import com.example.spring.neo4j.nodes.Source;
import com.example.spring.neo4j.SourceForm;
import com.example.spring.neo4j.converters.SourceFormToSource;
import com.example.spring.neo4j.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        sourceRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(sources::add); //fun with Java 8
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
                    if(source.getInvestcosts()>3001){
                        Float newRateValue = Float.sum(0,0) ;
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                case "option2":
                    if(source.getInvestcosts()>5001){
                        Float newRateValue = Float.sum(0,0);
                        source.setRate(newRateValue);
                        sourceRepository.save(source);
                        return source;
                    }
                    break;
                case "option3":
                    if(source.getInvestcosts()>10001){
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
                if(source.getYearlycosts()>501){
                    Float newRateValue = Float.sum(0,0) ;
                    source.setRate(newRateValue);
                    sourceRepository.save(source);
                    return source;
                }
                break;
            case "option2":
                if(source.getYearlycosts()>1001){
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
                Float newRateValue = new Float((source.getFuels().get(0).getEcology() * 0.5)) + source.getRate();
                source.setRate(newRateValue);
                break;
            case "3":
                newRateValue = new Float(source.getFuels().get(0).getEcology()) + source.getRate();
                source.setRate(newRateValue);
                break;
            default:
                System.out.println("No ecology answar");
        }}

        if (answears.getStorage() != null){
            switch (answears.getStorage()){
            case "0":
                if(source.getFuels().get(0).getStorage()<6){
                    Float newRateValue = Float.sum(source.getRate(),0) ;
                    source.setRate(newRateValue);
                }
                else{
                    Float newRateValue = Float.sum(source.getRate(),5) ;
                    source.setRate(newRateValue);
                }
                break;
            case "1":
                if(source.getFuels().get(0).getStorage()<5){
                    Float newRateValue = Float.sum(source.getRate(),0) ;
                    source.setRate(newRateValue);
                }
                else{
                    Float newRateValue = Float.sum(source.getRate(),3) ;
                    source.setRate(newRateValue);
                }
                break;
            case "2":
                if(source.getFuels().get(0).getStorage()<5){
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
                    System.out.println("there is true conservation answar "+answears.getConservation());
                    if(Objects.equals(source.getMaintenanceNeeds(),"low")){
                        Float newRateValue = Float.sum(source.getRate(),6);
                        System.out.println("newRateValue "+newRateValue);

                        source.setRate(newRateValue);
                        System.out.println("source get rate "+source.getRate());

                    }
                    else if(Objects.equals(source.getMaintenanceNeeds(),"medium")){
                        Float newRateValue = Float.sum(source.getRate(),3);
                        System.out.println("newRateValue "+newRateValue);

                        source.setRate(newRateValue);
                        System.out.println("newRateValue "+source.getRate());

                    }

                    break;
                default:
                    System.out.println("No conservation answar "+answears.getConservation());
            }}

        sourceRepository.save(source);
        return source;
    }

}
