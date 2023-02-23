package com.samples.Samples;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

	static void biConsumerExample() {
		BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> {
			System.out.println(name + " " + hobbies);
		};
		BiConsumer<String, Double> salaryConsumer = (name, salary) -> {
			System.out.println(name + " " + salary);
		};
		
		List<Person> personList = PersonRepository.getAllPersons();
		personList.forEach(person -> personConsumer.accept(person.getName(), person.getHobbies()));
		
		personList.forEach(person -> {
//			personConsumer.andThen(salaryConsumer).accept(null, null);
			/*we can't use andThen method because both consumers are of different types*/
			personConsumer.accept(person.getName(), person.getHobbies());
			salaryConsumer.accept(person.getName(), person.getSalary());
		});
	}
	
	public static void main(String[] args) {
		biConsumerExample();
	}

}
