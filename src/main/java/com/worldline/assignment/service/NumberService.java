package com.worldline.assignment.service;

import java.util.List;

public interface NumberService {

	public Boolean isPerfectNumber(Integer perfectNumber);

	public List<Integer> getPerfectNumberSeries(Integer from, Integer to);

}
