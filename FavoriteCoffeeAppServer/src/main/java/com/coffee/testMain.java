package com.coffee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class testMain {

	
	public static String transform(String input) {
		
		try {
			
			char[] dataList = new char[input.length()];
			String result = "";
			
			for(int i = 0 ; i < input.length() ; i++) {
				dataList[i] = input.charAt(i);
			}
	        
			for(int i = 0 ; i < dataList.length ; i++) {
				int cnt = dataList.length - i;
				char tempData = dataList[i];
				while(cnt != i && cnt > 0) {
					if(tempData == dataList[cnt-1]) {
						result += tempData;
						break;
					}
					cnt--;
				}
			}
			System.out.println("ddd" + result);
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			 throw new UnsupportedOperationException("Waiting to be implemented.");
		}
       
    }
    
    public static void main(String[] args) {
        System.out.println(testMain.transform("abbcbbb"));        
    }
}
