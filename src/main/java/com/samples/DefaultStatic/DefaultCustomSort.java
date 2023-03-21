package com.samples.DefaultStatic;

import java.util.Comparator;
import java.util.List;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class DefaultCustomSort {

	static Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
	static Comparator<Person> heightComparator = Comparator.comparingDouble(Person::getHeight);
	
	static void sortByName(List<Person> personList) {
		personList.sort(nameComparator);
		System.out.println(personList);
	}
	
	static void sortByHeight(List<Person> personList) {
		personList.sort(heightComparator);
		System.out.println(personList);
	}
	
	static void sortByHeightAndName(List<Person> personList) {
		personList.sort(heightComparator.thenComparing(nameComparator));
		System.out.println(personList);
	}
	
	static void sortByNameWithNullsFirst(List<Person> personList) {
		Comparator<Person> nullComparator = Comparator.nullsFirst(nameComparator);
		personList.sort(nullComparator);
		System.out.println(personList);
	}
	
	static void sortByNameWithNullsLast(List<Person> personList) {
		Comparator<Person> nullComparator = Comparator.nullsLast(nameComparator);
		personList.sort(nullComparator);
		System.out.println(personList);
	}
	
	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		sortByName(personList);
		sortByHeight(personList);
		sortByHeightAndName(personList);
		sortByNameWithNullsFirst(personList);
		sortByNameWithNullsLast(personList);
	}

}
