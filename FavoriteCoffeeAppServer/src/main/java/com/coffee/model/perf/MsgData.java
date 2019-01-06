package com.coffee.model.perf;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="msgBody")
@Data
public class MsgData {

    private int totalCount;
    private int cPage;
    private int rows;
    private int from;
    private int to;
    private int place;
    private int sortStdr;
    
    @XmlElement(name="perforList")
    private List<PerforListDTO> perforList;
}
