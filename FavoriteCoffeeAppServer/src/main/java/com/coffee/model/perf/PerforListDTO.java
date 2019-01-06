package com.coffee.model.perf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="perforList")
@Data
public class PerforListDTO {
    
    private int seq;
    private int startDate;
    private int endDate;
    private float gpsX;
    private float gpsY;
    private String thumbnail;
    private String title;
    private String place;
    private String realmName;
    private String area;
}
