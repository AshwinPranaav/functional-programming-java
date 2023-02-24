package com.samples.Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class SimpleStreamExample {

	static boolean personPredicateFunction(Person person) {
		return person.getHeight() >= 140;
	}
	
	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
		stream1.forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		Stream<Integer> stream2 = Stream.of(new Integer[] {1, 2, 3, 4, 5, 6});
		stream2.forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		
		Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
		Predicate<Person> genderPredicate = person -> person.getGender().equals("Male");
		Map<String, List<String>> hobbiesMap = PersonRepository.getAllPersons()
											.stream()
//											.filter(SimpleStreamExample::personPredicateFunction)
											.filter(heightPredicate)
											.filter(genderPredicate)
											.collect(Collectors.toMap(Person::getName, Person::getHobbies));
//											.collect(Collectors.toMap(person -> person.getName(), person -> person.getHobbies()));
		System.out.println(hobbiesMap);
		
		List<String> hobbiesList = PersonRepository.getAllPersons()
								.stream() // Stream<Person>
								.flatMap(person -> person.getHobbies().stream()) // Stream<String>
								.collect(Collectors.toList());
		System.out.println(hobbiesList);
		
		List<String> hobbiesList1 = PersonRepository.getAllPersons()
								.stream() // Stream<Person>
								.map(Person::getHobbies) // Stream<List<String>>
								.flatMap(List::stream) // Stream<String>
								.collect(Collectors.toList());
		System.out.println(hobbiesList1);
		
		List<String> distinctHobbiesList = PersonRepository.getAllPersons()
				.stream() // Stream<Person>
				.flatMap(person -> person.getHobbies().stream()) // Stream<String>
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Distinct hobbies: " + distinctHobbiesList);
	}

}
