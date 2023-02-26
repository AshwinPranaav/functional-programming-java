package com.samples.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamFlatMapExample {
	
	static List<String> hobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies) // .map(person -> person.getHobbies())
				.flatMap(List::stream) // .flatMap(hobbies -> hobbies.stream())
				.collect(Collectors.toList());
		/* return personList.stream()
				.flatMap(person -> person.getHobbies().stream())
				.collect(Collectors.toList()); */
	}
	
	static List<String> distinctHobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	static long countHobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.count();
	}

	public static void main(String[] args) {
		List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8, 10);
		
		List<List<Integer>> listofList = Arrays.asList(oddNumbers, evenNumbers);
		System.out.println("Before flatten: " + listofList);
		
		List<Integer> flattenedList = listofList.stream()
									.flatMap(list -> list.stream()) // .flatMap(List::stream)
									.collect(Collectors.toList());
		System.out.println("After flatten: " + flattenedList);
		
		System.out.println("Person hobbies with duplicates: " + hobbies(PersonRepository.getAllPersons()));
		System.out.println("Person hobbies without duplicates: " + distinctHobbies(PersonRepository.getAllPersons()));
		System.out.println("Person hobbies count: " + countHobbies(PersonRepository.getAllPersons()));
	}

}
