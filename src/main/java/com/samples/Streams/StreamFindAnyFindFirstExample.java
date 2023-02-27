package com.samples.Streams;

import java.util.Optional;
import java.util.function.Predicate;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamFindAnyFindFirstExample {

	static Predicate<Person> personPredicate1 = person -> person.getHeight() >= 140;
	static Predicate<Person> personPredicate2 = person -> person.getGender().equals("Female");
	
	static Optional<Person> findAny() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(personPredicate1) // if predicate is not there it could return anything (not necessary though)
				// and like filter you can have map, or anything
				.findAny();
	}
	
	static Optional<Person> findFirst() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(personPredicate2) // if predicate is not there it could return anything (not necessary though)
				// and like filter you can have map, or anything
				.findAny();
	}
	
	public static void main(String[] args) {
		Optional<Person> findAny = findAny();
		if(findAny.isPresent()) {
			System.out.println("Find Any: " + findAny.get());
		} else {
			System.out.println("No record");
		}
		
		Optional<Person> findFirst = findFirst();
		if(findFirst.isPresent()) {
			System.out.println("Find First: " + findFirst.get());
		} else {
			System.out.println("No record");
		}
	}

}
