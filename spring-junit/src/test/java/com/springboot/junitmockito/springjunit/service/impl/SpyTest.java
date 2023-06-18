package com.springboot.junitmockito.springjunit.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpyTest {
	
	@Test
	void testMock() {
		
		List<String> mockList = mock(List.class);
		
		mockList.add("one");
		mockList.add("two");
		
		verify(mockList).add("one");
		verify(mockList).add("two");
		
		assertThat(mockList, hasSize(0));
	}
	
	@Test
	void testSpy() {
		
		List<String> list = new ArrayList<>();
		List<String> spyList = spy(list);
		
		spyList.add("one");
		spyList.add("two");
		
		verify(spyList).add("one");
		verify(spyList).add("two");
		
		assertThat(spyList, hasSize(2));
	}

}
