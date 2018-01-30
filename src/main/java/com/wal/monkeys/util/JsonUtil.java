package com.wal.monkeys.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wal.monkeys.model.User;

public class JsonUtil {
	
	public String returnJson(User user) {
		
		String jsonString = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = objectMapper.writeValueAsString(user);
			
			System.out.println("JSON String: "+jsonString);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return (jsonString);
		
	}

}
