package com.coffee.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.constant.ConstantData;
import com.coffee.service.ApiService;

@RestController
@RequestMapping(value = ConstantData.BASIC_URL)
public class ApiController {

	@Autowired
	private ApiService apiService;

	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

	/**
	 * 공연/전시 지역별, 분류별, 기간별 리스트 조회
	 * 
	 * @param param
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws JAXBException
	 */
	@RequestMapping("searchPerformanceList")
	public ResponseEntity<?> searchPerformanceList(@RequestParam Map<String, Object> param) throws IOException, URISyntaxException, JAXBException {
		return ResponseEntity.ok().body(apiService.searchPerformanceInformationCheckPeriod(param));
	}

	/**
	 * 공연/전시 지역별, 분류별, 기간별 상세조희
	 * 
	 * @param param
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws JAXBException
	 */
	@PostMapping("searchPerformanceInfo")
	public ResponseEntity<?> searchPerformanceInfo(@RequestParam Map<String, Object> param) throws IOException, URISyntaxException, JAXBException {
		return ResponseEntity.ok().body(apiService.searchPerformanceDetailInfo(param));
	}

}
