package com.samples.TerminalStream;

import java.util.stream.Collectors;

import com.samples.Dto.PersonRepository;

public class StreamCounting {
	
	// to sum kids you could use reduce() or Collectors.summingInt()
	static long countKids() {
		return PersonRepository.getAllPersons()
				.stream()
				.map(per -> per.getKids())
				.reduce(Integer::sum).get();
	}
	
	static long countPeopleWithKids() {
		return PersonRepository.getAllPersons()
				.stream()
				.map(per -> per.getKids())
				.filter(kids -> kids > 0)
				.collect(Collectors.counting());
		// 		.count()
	}

	public static void main(String[] args) {
		System.out.println(countKids());
		System.out.println(countPeopleWithKids());
	}

}
