package com.coffee.model.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="bean_kinds")
@Data
public class BeanKinds {

	@Id
	@Column(name = "beanName", nullable = false, unique = true)
	private String beanName; //커피 원두이름
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="country_no", referencedColumnName="country_no")
				, @JoinColumn(name="area_name", referencedColumnName="area_name")})
	private Area area;
	
	@Column(name = "smell", nullable = false)
	private int smell; // 향
	
	@Column(name = "acidity", nullable = false)
	private int acidity; // 산도
	
	@Column(name = "sweetTaste", nullable = false)
	private int sweetTaste; // 단맛
	
	@Column(name = "bitterTaste", nullable = false)
	private int bitterTaste; // 쓴맛
	
	@Column(name = "bodyFeeling", nullable = false)
	private int bodyFeeling; // 바디
	
	@CreationTimestamp
	private Timestamp regDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
}

