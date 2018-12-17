package com.coffee.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Area {

	@Column()
	private String areaName;
	
	@Column()
	private Long countryId;
	
	
	
}
