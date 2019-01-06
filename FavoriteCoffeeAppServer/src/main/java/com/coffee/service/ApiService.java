package com.coffee.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.coffee.config.PropertyConfigBean;
import com.coffee.constant.ConstantData;
import com.coffee.model.perf.PerformanceVO;

@Service
public class ApiService {

	@Autowired
	private PropertyConfigBean propertyConfigBean;
	
	private RestTemplate restTemplate;
	
	
	public ResponseEntity<?> searchPerformanceInformationCheckPeriod1() throws IOException, URISyntaxException, JAXBException {
		
		String serverURL = ConstantData.PUBLIC_URL + "/" + ConstantData.PERIOD_PUBLIC_URL; // 공공 서버 URL
		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi().trim(); // 공공 서비스 API
		
//		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi(); // 공공 서비스 API
//		String requestURL = serverURL + "&ServiceKey=" + serverKey + "&sortStdr=1&RequestTime=20100810%3A23003422&from=20180101&to=20201201&cPage=1&rows=10&place=1";
		
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(serverURL)
				.queryParam("ServiceKey", "jXdXc1GXAE0yd3d2HHUM8dy%2B126jZGEFWeXIb7zoZyPPYLTaM4csywE8P9PZFLbejXaA41AxjP3LDVjHudHrTw%3D%3D")
				.queryParam("sortStdr", 1)
				.queryParam("RequestTime", "20100810:23003422")
				.queryParam("from", 20180101)
				.queryParam("to", 20201201)
				.queryParam("cPage", 1)
				.queryParam("rows", 10)
				.queryParam("place", 1)
				.build(false);
		
		URL url = new URL(builder.toUriString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        StringReader sr = new StringReader(sb.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(PerformanceVO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PerformanceVO performanceVO = (PerformanceVO) unmarshaller.unmarshal(sr);
        
        System.out.println(performanceVO);
		
		return ResponseEntity.ok().body(performanceVO);
	}
	
	/**
	 * 기간별 공연 정보 조회
	 * @return
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public ResponseEntity<?> searchPerformanceInformationCheckPeriod() throws IOException, URISyntaxException {
		
		String serverURL = ConstantData.PUBLIC_URL + "/" + ConstantData.PERIOD_PUBLIC_URL; // 공공 서버 URL
		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi().trim(); // 공공 서비스 API
		
		String testUrl = "http://www.culture.go.kr/openapi/rest/publicperformancedisplays/area";
//		String requestURL = serverURL + "?ServiceKey=" + decodeServerKey;
		
//		URI requestURI = new URI(requestURL);
		restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(serverURL)
				.queryParam("serviceKey", "jXdXc1GXAE0yd3d2HHUM8dy+126jZGEFWeXIb7zoZyPPYLTaM4csywE8P9PZFLbejXaA41AxjP3LDVjHudHrTw==")
//				.queryParam("sortStdr", 1)
//				.queryParam("RequestTime", "20100810:23003422")
//				.queryParam("from", 20180101)
//				.queryParam("to", 20201201)
//				.queryParam("cPage", 1)
//				.queryParam("rows", 10)
//				.queryParam("place", 1)
				.build(false);
		
		ResponseEntity<?> data = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(header), String.class);
//		PerformanceVO forEntity = restTemplate.getForObject(builder.toUriString(), PerformanceVO.class);
		System.out.println(data.getBody());
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	/**
	 * 공연/전시 상세 정보 조회
	 * @return
	 */
	public ResponseEntity<?> performanceDisplayDetailsCheck() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
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
