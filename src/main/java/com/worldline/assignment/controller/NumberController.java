package com.worldline.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.assignment.service.NumberService;

@RestController
@RequestMapping("/api/")
public class NumberController {

	@Autowired
	private NumberService numberService;

	@GetMapping("/perfectnumber/{perfectNumber}")
	public ResponseEntity isPerfectNumber(@PathVariable Integer perfectNumber) {
		try {
			if (perfectNumber == 0) {
				return new ResponseEntity<>(false, HttpStatus.OK);
			}
			Boolean isPerfectNumber = numberService.isPerfectNumber(perfectNumber);
			return new ResponseEntity<>(isPerfectNumber, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/perfectnumber/{from}/{to}")
	public ResponseEntity getPerfectNumberSeries(@PathVariable Integer from, @PathVariable Integer to) {
		try {
			if (from == 0) {
				from++;
			}
			List<Integer> perfectNumberSeries = numberService.getPerfectNumberSeries(from, to);

			if (perfectNumberSeries.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(perfectNumberSeries, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
