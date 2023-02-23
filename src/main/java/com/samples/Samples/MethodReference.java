package com.samples.Samples;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReference {

	public static int compare(Integer x, Integer y) {
		return Integer.compare(x, y);
	}
	
	public static boolean checkHeight(Person person) {
		return person.getHeight() >= 140;
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
	}

}
