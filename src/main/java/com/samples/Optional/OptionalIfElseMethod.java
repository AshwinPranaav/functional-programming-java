package com.samples.Optional;

import java.util.Optional;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class OptionalIfElseMethod {
	
	/**
	 * Optional.orElse(String other)
	 */
	static void orElse() {
		Optional<Person> person = PersonRepository.getPersonOptional();
//		String name = person.isPresent() ? person.get().getName() : "Data not found";
		String name = person.map(Person::getName).orElse("Data not found");
		System.out.println("Optional orElse name: " + name);
	}
	
	/**
	 * Optional.orElseGet(Supplier<? extends T> supplier)
	 */
	static void orElseGet() {
		Optional<Person> person = PersonRepository.getPersonOptional();
		String name = person.map(Person::getName).orElseGet(() -> "Data not found");
		System.out.println("orElseGet Person name: " + name);
	}
	
	static void orElseThrow() {
		Optional<Person> person = PersonRepository.getPersonOptional();
		String name = person.map(Person::getName).orElseThrow(() -> new RuntimeException("Name not found"));
	}
	
	public static void main(String[] args) {
		orElse();
		orElseGet();
		orElseThrow();
	}

}
