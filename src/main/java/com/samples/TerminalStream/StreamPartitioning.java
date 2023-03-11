package com.samples.TerminalStream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamPartitioning {

	static Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
	static Predicate<Person> genderPredicate = person -> person.getGender().equals("Male");
	
	static Map<Boolean, List<Person>> partitionByHeight(List<Person> personList) {
		Map<Boolean, List<Person>> map = personList
				.stream()
				.collect(Collectors.partitioningBy(heightPredicate));
		return map;
	}
	
	static Map<Boolean, Set<Person>> partitionByGender(List<Person> personList) {
		Map<Boolean, Set<Person>> set = personList
				.stream()
				.collect(Collectors.partitioningBy(genderPredicate, Collectors.toSet()));
		return set;
	}
	
	static Map<Boolean,Map<Integer,Set<Person>>> partitionByGenderGroupingSet(List<Person> personList) {
		Map<Boolean,Map<Integer,Set<Person>>> set = personList
				.stream()
				.collect(Collectors.partitioningBy(genderPredicate, Collectors.groupingBy(Person::getKids, Collectors.toSet())));
		return set;
	}
	
	static Map<Boolean, Map<String, List<String>>> partitionByHeightHobbies(List<Person> personList) {
		Map<Boolean, Map<String, List<String>>> map = personList
				.stream()
				.collect(Collectors.partitioningBy(heightPredicate, Collectors.toMap(Person::getName, Person::getHobbies)));
		return map;
	}
	
	public static void main(String[] args) {
		/*
		 * partitioningBy() is similar to groupingBy() except it groups based on predicate boolean value
		 */
		List<Person> personList = PersonRepository.getAllPersons();
		
		System.out.println("partitionByHeight");
		Map<Boolean, List<Person>> partitionByHeight = partitionByHeight(personList);
		partitionByHeight.forEach((booleanKey, list) -> {
			System.out.println(booleanKey);
			list.forEach(System.out::println);
		});
		System.out.println();
		
		System.out.println("partitionByGender");
		Map<Boolean, Set<Person>> partitionByGender = partitionByGender(personList);
		partitionByGender.forEach((booleanKey, set) -> {
			System.out.println(booleanKey);
			set.forEach(System.out::println);
		});
		System.out.println();
		
		System.out.println("partitionByGenderGroupingSet");
		Map<Boolean,Map<Integer,Set<Person>>> partitionByGenderGroupingSet = partitionByGenderGroupingSet(personList);
		partitionByGenderGroupingSet.forEach((booleanKey, set) -> {
			System.out.println(booleanKey);
			set.forEach((key, list) -> {
				System.out.println(key);
				list.forEach(System.out::println);
			});
			System.out.println(set);
		});
		System.out.println();
		
		System.out.println("People who are above 140 and their hobbies and those whose doesn't satisfy:");
		Map<Boolean, Map<String, List<String>>> map = partitionByHeightHobbies(personList);
		map.forEach((booleanKey, hobbiesMap) -> {
			System.out.println(booleanKey);
			System.out.println(hobbiesMap);
		});
	}

}
