package com.coffee;

import java.io.*;
import java.util.*;

public class Needle {
    public static int count(String needle, InputStream haystack) throws Exception {
    	
    	int resultCount = 0;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(haystack));
    	
    	try {
			while(reader.ready()) {
				if(reader.readLine().contains(needle)) {
					resultCount ++;
				}
			}
    		
		} catch (Exception e) {
			// TODO: handle exception
			throw new UnsupportedOperationException("Waiting to be implemented.");
		}
    	
        return resultCount;
    }
    
    public static void main(String[] args) throws Exception {
        String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

        try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
            System.out.println(Needle.count("there", inStream));
        }
    }
}