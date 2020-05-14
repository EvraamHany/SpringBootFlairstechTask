package com.flairstech.task.rep;

import com.flairstech.task.entities.CountryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryViewRep extends JpaRepository<CountryView, String> {
    CountryView findOneByCode(String code);
}
