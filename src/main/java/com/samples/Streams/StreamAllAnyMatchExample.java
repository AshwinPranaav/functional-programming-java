package com.samples.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamAllAnyMatchExample {

	static Predicate<String> fruitPredicate = fruit -> fruit.length() > 7;
	static Predicate<Person> personPredicate1 = person -> person.getHeight() >= 140;
	static Predicate<Person> personPredicate2 = person -> person.getGender().equals("Male");
	static Predicate<Person> falsePersonPredicate = person -> person.getGender().equals("fkjsdfnkn");
	
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Mango", "Pineapple");
		System.out.println("Fruit all match: " + fruits.stream().allMatch(fruitPredicate)); // false
		System.out.println("Fruit any match: " + fruits.stream().anyMatch(fruitPredicate)); // true
		
		System.out.println("Person all match: " + PersonRepository.getAllPersons().stream()
				.allMatch(personPredicate1));
		System.out.println("Person any match 1: " + PersonRepository.getAllPersons().stream()
				.anyMatch(personPredicate1.and(personPredicate2))); 
		System.out.println("Person any match 2: " + PersonRepository.getAllPersons().stream()
				.anyMatch(personPredicate1.and(falsePersonPredicate))); 
		// false as there's no gender fkjsdfnkn although personPredicate1 is true
	}

}
