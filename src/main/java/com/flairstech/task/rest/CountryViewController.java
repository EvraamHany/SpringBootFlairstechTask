package com.flairstech.task.rest;

import com.flairstech.task.entities.CountryView;
import com.flairstech.task.services.CountryViewService;
import com.flairstech.task.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "service/country")
public class CountryViewController extends ControllerUtils {
    @Autowired
    CountryViewService countryViewService;

    @RequestMapping(method = RequestMethod.GET, value = "/{code}")
    public @ResponseBody
    Object getCountry(@PathVariable String code)
            throws Exception {
        try {
            CountryView countryView = countryViewService.getCountryData(code);
            return countryView;
        }catch (Exception exp){
            return failResponse(exp.getMessage());
        }


    }



}
