package com.flairstech.task.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countryview")
public class CountryView implements Serializable {
    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    @Column(name = "life_expectancy")
    private Integer lifeExpectancy;
    private String language;

    public CountryView() {
    }

    public CountryView(String code, String name, String continent, String region, Integer lifeExpectancy, String language) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.lifeExpectancy = lifeExpectancy;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
