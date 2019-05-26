package com.coffee.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.coffee.config.PropertyConfigBean;
import com.coffee.constant.ConstantData;
import com.coffee.model.perf.PerformanceVO;
import com.coffee.util.ConnectionUtils;

@Service
public class ApiService {

	@Autowired
	private PropertyConfigBean propertyConfigBean;

	private RestTemplate restTemplate;

	/**
	 * 공연/전시 상세정보 조회
	 * 
	 * @param param
	 * @return
	 * @throws MalformedURLException
	 * @throws ProtocolException
	 * @throws IOException
	 * @throws JAXBException
	 */
	public ResponseEntity<?> searchPerformanceDetailInfo(Map<String, Object> param)
			throws IOException, URISyntaxException, JAXBException {

		String serverURL = ConstantData.PUBLIC_URL + "/" + ConstantData.DETAIL_PUBLIC_URL; // 공공 서버 URL
		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi().trim(); // 공공 서비스 API

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(serverURL).queryParam("serviceKey", serverKey)
				.queryParam("seq", param.get("seq")).build(false);

		StringBuilder sb = ConnectionUtils.connectionURLComponent(builder);

		StringReader sr = new StringReader(sb.toString());
		JAXBContext jaxbContext = JAXBContext.newInstance(PerformanceVO.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PerformanceVO performanceVO = (PerformanceVO) unmarshaller.unmarshal(sr);

		System.out.println("Detail -----" + sb);
		System.out.println(performanceVO);

		return ResponseEntity.ok().body(performanceVO);
	}

	/**
	 * 지역/ 기간/ 분류별 리스트 정보 조회
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws JAXBException
	 */
	public ResponseEntity<?> searchPerformanceInformationCheckPeriod(Map<String, Object> param)
			throws IOException, URISyntaxException, JAXBException {

		String serverURL = ConstantData.PUBLIC_URL + "/" + ConstantData.PERIOD_PUBLIC_URL; // 공공 서버 URL
		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi().trim(); // 공공 서비스 API

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(serverURL).queryParam("serviceKey", serverKey)
				.queryParam("sortStdr", 1).queryParam("RequestTime", "20100810:23003422").queryParam("from", 20180101)
				.queryParam("to", 20201201).queryParam("cPage", 1).queryParam("rows", 5).queryParam("place", 1)
				.build(false);

		StringBuilder sb = ConnectionUtils.connectionURLComponent(builder);

		StringReader sr = new StringReader(sb.toString());
		JAXBContext jaxbContext = JAXBContext.newInstance(PerformanceVO.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PerformanceVO performanceVO = (PerformanceVO) unmarshaller.unmarshal(sr);

		System.out.println(performanceVO);

		return ResponseEntity.ok().body(performanceVO);
	}

	public ResponseEntity<?> getBlogDataJson() {

		try {
			// String clientId = propertyConfigBean.getNaver().getClientId(); //Naver Client
			// ID
			// String clientSecret = propertyConfigBean.getNaver().getClientSecret();
			// //Naver Client Secret

			String clientId = propertyConfigBean.getKakao().getRestApi();

			String text = URLEncoder.encode("카카오프렌즈", "UTF-8");
			String apiUrl = ConstantData.KAKAO_GEO_URL_JSON + text;

			HttpHeaders header = new HttpHeaders();
			header.add(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE);
			// header.add("X-Naver-Client-Id", clientId);
			// header.add("X-Naver-Client-Secret", clientSecret);
			header.add("KakaoAK", clientId);

			Map<String, Object> param = new HashMap<>();
			param.put("display", 10);
			param.put("start", 1);
			param.put("sort", "sim");
			ResponseEntity<?> dataJson = new RestTemplate().exchange(apiUrl, HttpMethod.GET,
					new HttpEntity<Map<?, ?>>(param, header), String.class);

			System.out.println(dataJson);
			return dataJson;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
