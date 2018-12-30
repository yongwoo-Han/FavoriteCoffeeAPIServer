package com.coffee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coffee.model.AreaRepository;
import com.coffee.model.CountryRepository;
import com.coffee.model.beans.Area;
import com.coffee.model.beans.Area.AreaBuilder;
import com.coffee.model.beans.Country;
import com.coffee.model.beans.Country.CountryBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteCoffeeAppServerApplicationTests {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Test
	public void contextLoads() {
//		Naver naver = propertyConfigBean.getNaver();
		CountryBuilder country = Country.builder().countryName("케냐");
		AreaBuilder area = Area.builder().name("어느지역이더라").country(country.build());
		countryRepository.save(country.build());
		areaRepository.save(area.build());
		
		System.out.println(countryRepository.findById((long)1));
		System.out.println(areaRepository.findById("어느지역이더라"));
	}

}
