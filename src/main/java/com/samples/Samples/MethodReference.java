package com.samples.Samples;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class MethodReference {

	public static int compare(Integer x, Integer y) {
		return Integer.compare(x, y);
	}
	
	public static boolean checkHeight(Person person) {
		return person.getHeight() >= 140;
	}
	
	public boolean checkGenderisMale(Person person) {
		return person.getGender().equals("Male");
	}
	
	public boolean checkGenderisFemale(Person person) {
		return person.getGender().equals("Female");
	}
	
	public static void main(String[] args) {
		Comparator<Integer> comp = MethodReference::compare;
		System.out.println("App::compare : " + comp.compare(1, 10));
		
		Function<String, String> func = string -> string.toUpperCase();
		Function<String, String> func1 = String::toUpperCase;
		System.out.println("Func: " + func.apply("ashwin"));
		System.out.println("Func1 using method reference: " + func1.apply("ashwin"));
		
		Predicate<Person> personPredicate = MethodReference::checkHeight;
		System.out.println("Person predicate using method reference: " + personPredicate.test(PersonRepository.getPerson()));
		
		Predicate<Person> malePredicate = new MethodReference()::checkGenderisMale;
		System.out.println("Male person: " + malePredicate.test(PersonRepository.getPerson()));
		
		MethodReference methodReference = new MethodReference();
		
		Predicate<Person> femalePredicate = methodReference::checkGenderisFemale;
		System.out.println("Female person: " + femalePredicate.test(PersonRepository.getPerson()));
	}

}
