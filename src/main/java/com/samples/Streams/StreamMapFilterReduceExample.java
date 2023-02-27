package com.samples.Streams;

import java.util.function.Predicate;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamMapFilterReduceExample {

	static Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
	static Predicate<Person> malePredicate = person -> person.getGender().equals("Male");
	
	static int kidsCount() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(heightPredicate.and(malePredicate))
				.map(Person::getKids)
				.reduce(0, Integer::sum);
//		.reduce(0, (x, y) -> x + y);
//		.reduce(0, (x, y) -> Integer.sum(x, y));
	}
	
	public static void main(String[] args) {
		System.out.println("Kids count: " + kidsCount());
	}

}
