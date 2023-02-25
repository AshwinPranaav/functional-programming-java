package com.samples.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamMapExample {

	static List<String> toUpperCaseTransformList(List<Person> personList) {
		return personList.stream()
				.map(Person::getName) // map can be used to get the data we want 
				.map(String::toUpperCase) // or we use to transform the data
				.collect(Collectors.toList());
	}
	
	static Set<String> toUpperCaseTransformSet(List<Person> personList) {
		return personList.stream()
				.map(Person::getName) // map can be used to get the data we want 
				.map(String::toUpperCase) // or we use to transform the data
				.collect(Collectors.toSet());
	}
	
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");
		
		List<Integer> eachFruitsLength = fruits.stream().map(String::length).collect(Collectors.toList());
		System.out.println(eachFruitsLength);
		
		System.out.println("List: " + toUpperCaseTransformList(PersonRepository.getAllPersons()));
		System.out.println("Set: " + toUpperCaseTransformSet(PersonRepository.getAllPersons()));
	}

}
