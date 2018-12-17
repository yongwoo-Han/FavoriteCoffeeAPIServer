package com.coffee.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coffee.config.PropertyConfigBean;
import com.coffee.constant.ConstantData;

@Service
public class ApiService {

	@Autowired
	private PropertyConfigBean propertyConfigBean;
	
	public ResponseEntity<?> getBlogDataJson() {
		
		try {
//			String clientId = propertyConfigBean.getNaver().getClientId(); //Naver Client ID
//			String clientSecret = propertyConfigBean.getNaver().getClientSecret(); //Naver Client Secret
			
			String clientId = propertyConfigBean.getKakao().getRestApi();
					
			String text = URLEncoder.encode("카카오프렌즈", "UTF-8");
			String apiUrl = ConstantData.KAKAO_GEO_URL_JSON + text;
			
			HttpHeaders header = new HttpHeaders();
			header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
//			header.add("X-Naver-Client-Id", clientId);
//			header.add("X-Naver-Client-Secret", clientSecret);
			header.add("KakaoAK", clientId);
			
			Map<String, Object> param = new HashMap<>();
			param.put("display", 10);
			param.put("start", 1);
			param.put("sort", "sim");
			ResponseEntity<?> dataJson = new RestTemplate().exchange(apiUrl, HttpMethod.GET, new HttpEntity<Map<?, ?>>(param, header), String.class);
			
			System.out.println(dataJson);
			return dataJson;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
