package com.springboot.junitmockito.springjunit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {

	@Test
	void testListSize() {
		
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	void testListSize_multipleValues() {
		
		// Given
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	void testListGet_BDD() {
		
		// Given
		List listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn(2);
		
		// When
		int number = (int) listMock.get(3);
		
		// Then
		assertEquals(2, number);
	}

}
