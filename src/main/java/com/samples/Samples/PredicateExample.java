package com.samples.Samples;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class PredicateExample {

	static void myPredicate() {
		Predicate<Person> heightGreaterThanEqual140 = person -> person.getHeight() >= 140;
		Predicate<Person> isMale = person -> person.getGender().equalsIgnoreCase("male");
		BiPredicate<Integer, String> biPredicate = (height, gender) -> height >= 140 && gender.equalsIgnoreCase("male");
		
		Person person = PersonRepository.getPerson();
		boolean result = heightGreaterThanEqual140.test(person);
		System.out.println("Person height greate than equal to 140 ?: " + result);
		
		List<Person> personList = PersonRepository.getAllPersons();
		List<Person> filteredPersonList = personList.stream()
				.filter(heightGreaterThanEqual140.and(isMale)).collect(Collectors.toList());
		filteredPersonList.forEach(filteredPerson -> {
			System.out.println("Filtered person list: " + filteredPerson);
		});
		
		BiConsumer<String, List<String>> biConsumer = (name, hobbies) -> {
			System.out.println(name + " : " + hobbies);
		};
		
		Consumer<Person> personHobbiesSatisfyingPredicates = per -> {
			if(heightGreaterThanEqual140.and(isMale).test(per)) {
				biConsumer.accept(per.getName(), per.getHobbies());
			}
		};
		
		Consumer<Person> personHobbiesSatisfyingByPredicates = per -> {
			if(biPredicate.test(per.getHeight(), per.getGender())) {
				biConsumer.accept(per.getName(), per.getHobbies());
			}
		};
		
		personList.forEach(personHobbiesSatisfyingPredicates);
	}
	
	public static void main(String[] args) {
		
	}

}
