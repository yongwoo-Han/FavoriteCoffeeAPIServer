package com.coffee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.coffee.config.api.Kakao;
import com.coffee.config.api.Naver;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix="open-api")
@NoArgsConstructor
@Data
public class PropertyConfigBean {
	
	private Kakao kakao;
	private Naver naver;
}

