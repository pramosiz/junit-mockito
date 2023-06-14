package com.springboot.junitmockito.springjunit.service;

import org.springframework.stereotype.Service;

@Service
public class JunitService {

	public String truncateAInFirst2Positions(String str) {
		
		if(str.length() <= 2 ) {
			return str.replaceAll("A", " ");
		}
		String first2Chars = str.substring(0, 2);
		String stringMinusFirst2Chars = str.substring(2);
		
		return first2Chars.replaceAll("A", " ".concat(stringMinusFirst2Chars));
	}
	
}
