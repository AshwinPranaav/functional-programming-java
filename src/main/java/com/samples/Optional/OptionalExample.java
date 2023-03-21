package com.samples.Optional;

import java.util.Optional;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class OptionalExample {

	static String myName(String name) {
		return name;
	}
	
	static String myNull(String name) {
		return null;
	}
	
	static String personName(Person person) {
		if(person != null)
			return person.getName(); // this will return, null as we are checking person and not person.getName()
		else
			return "No Data Found";
	}
	
	static Optional<String> personNameWithOptional(Optional<Person> person) {
		if(person.isPresent()) 
			return person.map(Person::getName);
		else
			return Optional.empty();
	}
	
	public static void main(String[] args) {
		// if null Optional.ofNullable() will return Optional.empty
		// and trying to use get() on Optional.empty will throw an error java.util.NoSuchElementException: No value present
		Optional<String> name = Optional.ofNullable(myName("Ashwin"));
		System.out.println(name.get());
		
		Optional<String> nullValue = Optional.ofNullable(myNull("Ashwin"));
		System.out.println(nullValue.isPresent() ? nullValue.get() : "No element present");
		
		System.out.println("Person name: " + personName(new Person()));
		Optional<String> personNameVar = personNameWithOptional(PersonRepository.getPersonOptional());
		System.out.println("Person name Optional: " + personNameVar);
	}

}
