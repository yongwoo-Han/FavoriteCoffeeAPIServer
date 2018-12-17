package com.coffee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.text.IsEmptyString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coffee.config.PropertyConfigBean;
import com.coffee.config.api.Naver;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteCoffeeAppServerApplicationTests {

	@Autowired
	private PropertyConfigBean propertyConfigBean; 
	
	@Test
	public void contextLoads() {
//		Naver naver = propertyConfigBean.getNaver();
		String restApi = propertyConfigBean.getKakao().getRestApi();
		System.out.println(restApi);
		assertNotNull(restApi);
	}

}
