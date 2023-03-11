package com.samples.TerminalStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamSummingAveraging {

	static int sumTotalKids() {
		return PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.summingInt(Person::getKids));
	}
	
	static double averageHeight() {
		return PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.averagingInt(Person::getHeight));
	}
	
	public static void main(String[] args) {
		System.out.println("Total kids: " + sumTotalKids());
		System.out.println("Average Height: " + averageHeight());
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sum = intList.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum of integers: " + sum);
	}

}
