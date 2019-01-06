package com.coffee.constant;

public class ConstantData {

	public final static String BASIC_URL = "/api/*"; //React에서 요청되는 기본 URL
	
	// Naver 블로그
	public final static String NAVER_BLOG_URL_JSON = "https://openapi.naver.com/v1/search/blog.json?query="; //네이버 블로그 검색용 URL (JSON)
	public final static String NAVER_BLOG_URL_XML = "https://openapi.naver.com/v1/search/blog.xml?query="; //네이버 블로그 검색용 URL (XML)
	
	// Naver 지도
	public final static String NAVER_GEO_URL_JSON = "https://openapi.naver.com/v1/map/geocode.json?query="; //네이버 블로그 검색용 URL (XML)
	
	// 다음(카카오) 지도
	public final static String KAKAO_GEO_URL_JSON = "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000"; //네이버 블로그 검색용 URL (XML)
	
	// 공공 데이터 조회 URL
	public final static String PUBLIC_URL = "http://www.culture.go.kr/openapi/rest/publicperformancedisplays";
	
	// 기간별 공연 정보 조회
	public final static String PERIOD_PUBLIC_URL = "period";
	
	
	
	
}
