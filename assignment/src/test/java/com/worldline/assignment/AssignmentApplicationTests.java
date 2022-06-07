package com.worldline.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.worldline.assignment.service.NumberService;

@SpringBootTest
class AssignmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	public NumberService numberService;

	@Test
	public void isPerfectNumber() {
		Boolean isPerfect;
		isPerfect = numberService.isPerfectNumber(6);
		assertEquals(isPerfect, true);
		isPerfect = numberService.isPerfectNumber(7);
		assertEquals(isPerfect, false);
	}

	@Test
	public void getPerfectNumberSeries() {
		List<Integer> perfectNumberSeries = new ArrayList<Integer>();
		perfectNumberSeries = numberService.getPerfectNumberSeries(1, 497);
		List<Integer> numberSeries = Arrays.asList(6, 28, 496);
		assertIterableEquals(perfectNumberSeries, numberSeries);
	}

}
