package com.samples.Streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamFilterExample {

	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		
		Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
		Predicate<Person> malePredicate = person -> person.getGender().equals("Male");
		personList.stream()
		.filter(heightPredicate)
		.filter(person -> person.getGender().equals("Male"))
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		personList.stream()
		.filter(heightPredicate.and(malePredicate))
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}

}
