package com.springboot.junitmockito.springjunit.service.impl;

import java.util.List;

import com.springboot.junitmockito.springjunit.service.UtilityClass;

interface Dependency {
	List<Integer> retrieveAllStats();
}

public class SystemImpl {
	
	private Dependency dependency;
	
	public int methodCallingAStaticMethod() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for(int stat : stats) {
			sum += stat;
		}
		return UtilityClass.staticMethod(sum);
	}

	private long privateMethod() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for(int stat : stats) {
			sum += stat;
		}
		return sum;
	}
}
