package com.coffee.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.coffee.constant.ConstantData;

public class testMain {

	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		// TODO Auto-generated method stub

//		String string = URLEncoder.encode("http://www.culture.go.kr/openapi/rest/publicperformancedisplays/period?ServiceKey=jXdXc1GXAE0yd3d2HHUM8dy+126jZGEFWeXIb7zoZyPPYLTaM4csywE8P9PZFLbejXaA41AxjP3LDVjHudHrTw==", "UTF-8");
//		System.out.println(string);
//		
//		String test = URLDecoder.decode("jXdXc1GXAE0yd3d2HHUM8dy%2B126jZGEFWeXIb7zoZyPPYLTaM4csywE8P9PZFLbejXaA41AxjP3LDVjHudHrTw%3D%3D", "UTF-8");
//		System.out.println(test);
//		
//		String serverURL = ConstantData.PUBLIC_URL; // 공공 서버 URL
////		String serverKey = propertyConfigBean.getPublicPerformance().getServerApi(); // 공공 서비스 API
//		String requestURL = serverURL + "ServiceKey=jXdXc1GXAE0yd3d2HHUM8dy%2B126jZGEFWeXIb7zoZyPPYLTaM4csywE8P9PZFLbejXaA41AxjP3LDVjHudHrTw%3D%3D" + "&sortStdr=1&RequestTime=20100810%3A23003422&from=20180101&to=20201201&cPage=1&rows=10&place=1";
//		URL url = new URL(requestURL);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
//        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        System.out.println(sb.toString());
	}

}
