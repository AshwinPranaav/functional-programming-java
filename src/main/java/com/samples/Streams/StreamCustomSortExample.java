package com.samples.Streams;

import java.util.Comparator;
import java.util.List;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamCustomSortExample {

	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		
		System.out.println("Sort by name: ");
		personList.stream()
		.sorted(Comparator.comparing(Person::getName))
		.forEach(System.out::println);
		
		System.out.println("Sort by height: ");
		personList.stream()
		.sorted(Comparator.comparing(Person::getHeight))
		.forEach(System.out::println);
		
		System.out.println("Sort by height descending: ");
		personList.stream()
		.sorted(Comparator.comparing(Person::getHeight).reversed())
		.forEach(System.out::println);
	}

}
