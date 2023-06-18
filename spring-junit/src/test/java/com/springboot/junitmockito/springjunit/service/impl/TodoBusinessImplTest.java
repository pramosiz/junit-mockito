package com.springboot.junitmockito.springjunit.service.impl;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.junitmockito.springjunit.service.TodoService;

@ExtendWith(MockitoExtension.class)
class TodoBusinessImplTest {

	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Test
	void testRetrieveTodosNotRelatedToSpring() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
		
		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring(anyString());
		
		// Then
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());
		
		// Then
		verify(todoServiceMock, times(1)).deleteTodo("Learn to dance");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring_BDD() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());
		
		// Then
		then(todoServiceMock).should().deleteTodo("Learn to dance");
		
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring_BDD_argumentCapture() {
		
		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());
		
		// Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertEquals("Learn to dance", stringArgumentCaptor.getValue());
		
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring_BDD_argumentCaptureMultipleTimes() {
		
		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// Given
		List<String> todos = Arrays.asList("Learn to Rock", "Learn Spring", "Learn to dance");
		given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring(anyString());
		
		// Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertEquals(2, stringArgumentCaptor.getAllValues().size());
	}

}
