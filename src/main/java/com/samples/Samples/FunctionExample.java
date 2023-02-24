package com.samples.Samples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class FunctionExample {

	static void function() {
		Function<String, String> f1 = name -> name.toUpperCase();
		Function<String, String> f2 = name -> name.concat(" features");
		
		Predicate<Person> heightGreaterThanEqual140 = person -> person.getHeight() >= 140;
		Predicate<Person> isMale = person -> person.getGender().equalsIgnoreCase("male");
		
		System.out.println("F1: " + f1.apply("java"));
		System.out.println("F2: " + f2.apply("java"));
		System.out.println("F3: " + f1.apply("java"));
		System.out.println("And then: " + f1.andThen(f2).apply("java"));
		System.out.println("Compose: " + f1.compose(f2).apply("java"));
		
		Function<List<Person>, Map<String, Double>> f3 = personList -> {
			Map<String, Double> map = new HashMap<>();
//			personList.forEach(person -> {
//				map.put(person.getName(), person.getSalary());
//			});
			map = personList.stream().filter(heightGreaterThanEqual140.and(isMale)).collect(Collectors.toMap(person -> person.getName(), person -> person.getSalary()));
			return map;
		};
		
		BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf = (personList, predicate) -> {
			Map<String, Double> map = new HashMap<>();
			map = personList.stream().filter(heightGreaterThanEqual140.and(predicate)).collect(Collectors.toMap(person -> person.getName(), person -> person.getSalary()));
			return map;
		};
		
		List<Person> personList = PersonRepository.getAllPersons();
		System.out.println(f3.apply(personList));
	}
	
	public static void main(String[] args) {
		function();
	}

}
