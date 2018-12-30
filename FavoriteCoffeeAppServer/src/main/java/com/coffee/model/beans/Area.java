package com.coffee.model.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="area")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Area {

	@Id
	@Column(name="area_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_no")
	private Country country;
	
	@OneToMany(mappedBy="area")
	private List<BeanKinds> bean_kinds = new ArrayList<>();
	
	@CreationTimestamp
	private Timestamp regDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@Builder
	private Area(String name, Country country) {
		this.name = name;
		this.country = country;
	}
	
}
