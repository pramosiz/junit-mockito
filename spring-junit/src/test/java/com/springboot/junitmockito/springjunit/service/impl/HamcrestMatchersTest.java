package com.springboot.junitmockito.springjunit.service.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void testHamcrest() {
		
		List<Integer> scores = new ArrayList<>();
		scores.add(99);
		scores.add(100);
		scores.add(101);
		scores.add(105);
		
		// scores has 4 times
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99, 100));
		
		// every item
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(190)));
		
		// String
		assertThat("", is(emptyOrNullString()));
		assertThat(null, is(emptyOrNullString()));
		
		// Arrays
		Integer[] marks = {1, 2, 3};
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1,2,3));
		assertThat(marks, arrayContainingInAnyOrder(2,1,3));
		
	}

}
