package com.samples.Optional;

import java.util.Optional;

import com.samples.Dto.Address;
import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class OptionalMap {

	static void optionalMap() {
		Optional<Person> per = PersonRepository.getPersonOptional();
		per.ifPresent(person -> {
			String name = per.map(Person::getName).orElse("No data found");
			System.out.println("Name: " + name);
		});
		
	}
	
	static void optionalFlatMap() {
		Optional<Person> per = PersonRepository.getPersonOptional();
		if(per.isPresent()) {
			// we use flatMap because, Person::getAddress returns Address... using map would return Optional<Optional<Address>> instead of Optional<Address>
			Optional<Address> addressFlatMap = per.flatMap(Person::getAddress);
			System.out.println(addressFlatMap.isPresent() ? addressFlatMap.get() : Optional.empty());
		}
	}
	
	static void optionalMapFilter() {
		Optional<Person> per = PersonRepository.getPersonOptional().filter(person -> person.getHeight() >= 140);
		per.ifPresent(person -> System.out.println(person.getAddress().get())); // Address is Optional in dto
	}
	
	public static void main(String[] args) {
		optionalMap();
		optionalFlatMap();
	}

}
