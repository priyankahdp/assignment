package com.worldline.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

	@Override
	public Boolean isPerfectNumber(Integer perfectNumber) {
		int total = 0;
		for (int i = 1; i <= perfectNumber / 2; i++) {
			if (perfectNumber % i == 0) {
				total += i;
			}
		}
		if (total == perfectNumber) {
			return true;
		} else
			return false;
	}

	@Override
	public List<Integer> getPerfectNumberSeries(Integer from, Integer to) {
		List<Integer> perfectNumberSeries = new ArrayList<>();
		for (int i = from; i < to; i++) {
			if (isPerfectNumber(i)) {
				perfectNumberSeries.add(i);
			}
		}
		return perfectNumberSeries;
	}
}
