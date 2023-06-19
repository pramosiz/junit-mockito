package com.springboot.junitmockito.springjunit.service;

public class UtilityClass {

	public static int staticMethod(long value) {
		throw new RuntimeException("I don't want to be executed");
	}
}
