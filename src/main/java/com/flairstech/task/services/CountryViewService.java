package com.flairstech.task.services;


import com.flairstech.task.entities.CountryView;
import com.flairstech.task.exceptions.CountryWithCodeNotExsist;
import com.flairstech.task.rep.CountryViewRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryViewService {

    @Autowired
    CountryViewRep countryViewRep;

    public CountryViewService() {
    }

    public CountryView getCountryData(String code){
        CountryView countryView = countryViewRep.findOneByCode(code);
        if(countryView == null){
            throw  new CountryWithCodeNotExsist("INVALID_COUNTRY_CODE");
        }else
        return countryView;
    }

    public CountryViewService(CountryViewRep countryViewRep) {
        this.countryViewRep = countryViewRep;
    }

    public CountryViewRep getCountryViewRep() {
        return countryViewRep;
    }

    public void setCountryViewRep(CountryViewRep countryViewRep) {
        this.countryViewRep = countryViewRep;
    }
}
