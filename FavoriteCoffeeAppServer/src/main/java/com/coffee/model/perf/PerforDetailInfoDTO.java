package com.coffee.model.perf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="perforInfo")
@Data
public class PerforDetailInfoDTO {

	private int seq;			//공연/전시번호
	private String startDate;	//공연 시작일자
	private String endDate;		//공연 종료일자
	private String place;		//장소
	private String realmName;	//분류명 (연극)
	private String area;		//지역
	private String subTitle;	//공연부제목
	private String price;		//가격
	private String contents1;	//상세정보 1
	private String contents2;	//상세정보 2
	private String url;			//관람 URL
	private String phone;		//문의처
	private String gpsX;		//GPS-X좌표
	private String gpsY;		//GPS-Y좌표
	private String imgUrl;		//이미지
	private String placeUrl;	//공연장URL
	private String placeAddr;	//공연장 주소
	private String placeSeq;    //문화예술공간 일련번호
}
