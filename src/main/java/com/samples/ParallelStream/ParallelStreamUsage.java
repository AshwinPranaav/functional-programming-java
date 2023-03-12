package com.samples.ParallelStream;

import java.util.List;
import java.util.stream.Collectors;

import com.samples.Dto.PersonRepository;

public class ParallelStreamUsage {

	static List<String> getHobbiesSequential() {
		long start = System.currentTimeMillis();
		List<String> hobbies = PersonRepository.getAllPersons()
								.stream()
								.flatMap(person -> person.getHobbies().stream())
								.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Time taken for getHobbiesSequential: " + (end - start));
		return hobbies;
	}
	
	static List<String> getHobbiesParallel() {
		long start = System.currentTimeMillis();
		List<String> hobbies = PersonRepository.getAllPersons()
								.parallelStream()
								.flatMap(person -> person.getHobbies().stream())
								.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Time taken for getHobbiesParallel: " + (end - start));
		return hobbies;
	}
	
	public static void main(String[] args) {
		System.out.println(getHobbiesSequential());
		System.out.println(getHobbiesParallel());
	}

}
