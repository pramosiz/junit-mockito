package com.springboot.junitmockito.springjunit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JunitServiceImplTest {

	private static JunitServiceImpl junitService;
	
	@BeforeAll
	static void setup() {
		junitService = new JunitServiceImpl();
	}
	
	@Test
	void testTruncateAInFirst2Positions() {
		String actual = junitService.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({"CD, ACD", "CD, AACD", "CD, CD"})
	void testTruncateAInFirst2Positions_paramatized(String expected, String input) {
		assertEquals(expected, junitService.truncateAInFirst2Positions(input));
	}
	
	@Test
	void testAreFirstAndLast2CharactersTheSame() {
		assertFalse(junitService.areFirstAndLast2CharactersTheSame("ABCD"));
		assertTrue(junitService.areFirstAndLast2CharactersTheSame("ABAB"));
	}
	
	@Test
	void testAreFirstAndLast2CharactersTheSame_nullCase() {
		assertThrows(NullPointerException.class, () -> {
			junitService.areFirstAndLast2CharactersTheSame(null);
		});
	}
	

}
