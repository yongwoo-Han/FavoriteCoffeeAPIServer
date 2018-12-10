package com.coffee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix="naver")
@NoArgsConstructor
@Data
public class PropertyConfigBean {
	
	private String clientId;
	private String clientSecret;
}
