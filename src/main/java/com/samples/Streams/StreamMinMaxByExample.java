package com.samples.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamMinMaxByExample {

	static Optional<Person> getShortestPerson() {
		Optional<Person> shortestPerson = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.minBy(Comparator.comparing(Person::getHeight)));
		return shortestPerson;
	}
	
	static Optional<Person> getTallestPerson() {
		Optional<Person> tallestPerson = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));
		return tallestPerson;
	}
	
	static List<Person> getAllTallestPersons() {
		List<Person> personList = new ArrayList<>();
		Optional<Person> tallestPersonOptional = getTallestPerson();
		
		Person tallestPerson = tallestPersonOptional.isPresent() ? tallestPersonOptional.get() : null;
		if(null != tallestPerson) {
			personList = PersonRepository.getAllPersons()
					.stream()
					.filter(person -> person.getHeight() == tallestPerson.getHeight())
					.collect(Collectors.toList());
		}
		return personList;
	}
	
	public static void main(String[] args) {
		System.out.println("Shortest person: " + getShortestPerson().get());
		System.out.println("Tallest person: " + getTallestPerson().get());
		System.out.println("Tallest group: " + getAllTallestPersons());
	}

}
