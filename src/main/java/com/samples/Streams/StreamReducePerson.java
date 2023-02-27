package com.samples.Streams;

import java.util.Optional;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamReducePerson {

	static void combineNames() {
		String personNames = PersonRepository.getAllPersons()
							.stream()
							.map(Person::getName)
							.reduce("", (name1, name2) -> name1 + " " + name2); 
		// this reduce needs an intial value if there is any operation done on the values
		System.out.println("Person names: " + personNames);
	}
	
	static String longestPersonName() {
		return PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2)
				.get(); 
		// this reduce doesn't need an intial if we return something
		
	}
	
	static Optional<Person> getTallestPerson() {
		return PersonRepository.getPersonOptional()
				.stream()
				.reduce((person1, person2) -> person1.getHeight() > person2.getHeight() ? person1 : person2);
		// this reduce doesn't need an intial if we return something
	}
	
	public static void main(String[] args) {
		combineNames();
		Optional<Person> tallestPerson = getTallestPerson();
		System.out.println("Tallest person: " + tallestPerson.get());
		longestPersonName();
	}

}
