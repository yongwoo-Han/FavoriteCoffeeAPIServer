package com.coffee.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.model.beans.Area;

public interface AreaRepository extends JpaRepository<Area, String> {

}
