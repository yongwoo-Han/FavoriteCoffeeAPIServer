package com.coffee.model.perf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="response")
@Data
public class PerformanceVO {
	
	@XmlElement(name="msgBody")
	private MsgData msgData;
}
