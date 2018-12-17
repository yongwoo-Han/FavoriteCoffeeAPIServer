package com.coffee.model.beans;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BeanKinds {

	private String beanName;
	private int smell; // 향
	private int acidity; // 산도
	private int sweetTaste; // 단맛
	private int bitterTaste; // 쓴맛
	private int bodyFeeling; // 바디
}

