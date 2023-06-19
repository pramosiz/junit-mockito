package com.springboot.junitmockito.springjunit.service.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.springboot.junitmockito.springjunit.entity.Employee;
import com.springboot.junitmockito.springjunit.service.UtilityClass;

@ExtendWith(MockitoExtension.class)
class SystemImplTest {

	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemImpl systemImpl;
	
	@Test
	void testCallingAStaticMethod() {
		List<Integer> stats = Arrays.asList(1,2,3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
		systemImpl.methodCallingAStaticMethod();
		
		int result = systemImpl.methodCallingAStaticMethod();
		assertEquals(150,  result);
	}
	
	@Test
	void testAPrivateMethod() {
		List<Integer> stats = Arrays.asList(1,2,3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		long result = ReflectionTestUtils.invokeMethod(systemImpl, "privateMethod");
		
		assertEquals(6, result);
	}
	
	@Test
	void testReflectionTestUtilsSetField() {
		
		Employee employee = new Employee();
		ReflectionTestUtils.setField(employee, "id", 1);
		assertEquals(1, employee.getId());
	}
	
	@Test
	void testMockConstructor() {
		
		try(MockedConstruction<Employee> employeeMocked = mockConstruction(Employee.class)) {
			Employee employee = new Employee();
			when(employee.getId()).thenReturn(1);
			assertEquals(1, employee.getId());
			
			// Get a List of all created mocks
			List<Employee> constructed = employeeMocked.constructed();
			assertThat(constructed, hasSize(1));
		}
		
	}

}
