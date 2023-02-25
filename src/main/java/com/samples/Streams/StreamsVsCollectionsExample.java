package com.samples.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamsVsCollectionsExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Lisa");
		names.add("Adam");
		names.add("Nancy");
		
		System.out.print("Iteration 1: ");
		for(String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
		
		System.out.print("Iteration 2: ");
		for(String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
		
		System.out.print("Stream iteration: ");
		Stream<String> namesStream = names.stream();
		namesStream.forEach(name -> System.out.print(name + " "));
		
		/* you can't iterate over it again
		 * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		 * namesStream.forEach(name -> System.out.println(name)); */
		
		List<String> personNames = PersonRepository.getAllPersons()
								.stream()
								.peek(person -> System.out.println(person)) // it is an intermediate step
								.map(Person::getName)
								.peek(System.out::println) // it is an intermediate step
								.collect(Collectors.toList());
		
	}

}
