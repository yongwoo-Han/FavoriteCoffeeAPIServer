package com.coffee.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Country {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column()
	private String countryName;
}
