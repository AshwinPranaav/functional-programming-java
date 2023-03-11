package com.samples.TerminalStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamGrouping {

	static Map<String, List<Person>> groupByGender(List<Person> personList) {
		Map<String, List<Person>> listByGender = personList
				.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		//		.collect(Collectors.groupingBy(Person::getGender, Collectors.toList()));
		return listByGender;
	}
	
	static Map<String, Long> countByGender(List<Person> personList) {
		Map<String, Long> countByGender = personList
				.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		return countByGender;
	}
	
	static Map<String, List<Person>> groupByHeight(List<Person> personList) {
		Map<String, List<Person>> groupByHeight = personList
				.stream()
				.collect(Collectors.groupingBy(person -> person.getHeight() > 140 ? "Tall" : "Short"));
		return groupByHeight;
	}
	
	static Map<String, Map<String, List<Person>>> twoLevelGrouping(List<Person> personList) {
		Map<String, Map<String, List<Person>>> multiGroup = personList
		.stream()
		.collect(Collectors.groupingBy(Person::getGender, 
										Collectors.groupingBy(person -> person.getHeight() > 140 ? "Tall" : "Short")));
		return multiGroup;
	}
	
	static Map<String, Integer> twoLevelGroupingCount(List<Person> personList) {
		Map<String, Integer> multiGroup = personList
		.stream()
		.collect(Collectors.groupingBy(Person::getGender, 
										Collectors.summingInt(Person::getKids)));
		return multiGroup;
	}
	
	static Map<String, List<Person>> threeLevelGrouping(List<Person> personList) {
		Map<String, List<Person>> multiGroup = personList
				.stream()
				.collect(Collectors.groupingBy(Person::getGender, HashMap::new, Collectors.toList()));
		return multiGroup;
	}
	
	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		
		Map<String, List<Person>> listByGender = groupByGender(personList);
		
		listByGender.forEach((gender, list) -> {
			System.out.println("Gender: " + gender);
			list.forEach(System.out::println);
		});
		
		// another way of printing
		listByGender.entrySet().forEach(entry -> {
			System.out.println("Gender: " + entry.getKey());
			entry.getValue().forEach(System.out::println);
		});
		
		// yet another way to print
		Stream.of(listByGender).forEach(item -> {
			item.forEach((gender, list) -> {
				System.out.println("Gender: " + gender);
				list.forEach(System.out::println);
			});
		});
		
		
		Map<String, Long> countByGender = countByGender(personList);
		countByGender.forEach((gender, count) -> {
			System.out.println("Gender: " + gender + ", Count: " + count);
		});
		
		Map<String, List<Person>> groupByHeight = groupByHeight(personList);
		groupByHeight.forEach((category, list) -> {
			System.out.println("Category: " + category);
			list.forEach(System.out::println);
		});
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Multi level grouping: ");
		Map<String, Map<String, List<Person>>> multiGroup = twoLevelGrouping(personList);
		multiGroup.forEach((gender, heightMap) -> {
			System.out.println("Gender: " + gender);
			heightMap.forEach((category, list) -> {
				System.out.println("Category: " + category);
				list.forEach(System.out::println);
			});
		});
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Kids based on gender: " + twoLevelGroupingCount(personList));
		
		System.out.println("-----------------------------------------------------------");
		Map<String, List<Person>> threeLevelGrouping = threeLevelGrouping(personList);
		threeLevelGrouping.forEach((gender, list) -> {
			System.out.println("Gender: " + gender);
			list.forEach(System.out::println);
		});
	}

}
