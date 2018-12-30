package com.coffee.model.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country implements Serializable{

	@Id
	@Column(name="country_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="countryName")
	private String countryName;
	 
	@CreationTimestamp
	private Timestamp regDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@OneToMany(mappedBy="country")
	private List<Area> areas = new ArrayList<>();
	
	@Builder
	private Country(String countryName) {
		this.countryName = countryName;
	}
}
