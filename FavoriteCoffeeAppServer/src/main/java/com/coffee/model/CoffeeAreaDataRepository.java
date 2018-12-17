package com.coffee.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.model.beans.Country;

public interface CoffeeAreaDataRepository extends JpaRepository<Country, Long> {

}