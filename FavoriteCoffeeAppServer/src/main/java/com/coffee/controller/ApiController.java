package com.coffee.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.config.PropertyConfigBean;
import com.coffee.constant.ConstantData;
import com.coffee.service.ApiService;

@RestController
@RequestMapping(value=ConstantData.BASIC_URL)
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("searchFromNaver")
	public ResponseEntity<?> searchFromNaver(@RequestParam Map<String, Object> param) {
		return ResponseEntity.ok().body(apiService.getBlogDataJson());
	}
	
}
