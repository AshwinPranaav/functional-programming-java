package com.samples.DefaultStatic;

import java.util.List;
import java.util.stream.Collectors;

import com.samples.Dto.Person;

public interface PersonDetails {
	double calculateTotalSalary(List<Person> personList);
	
	default int totalKids(List<Person> personList) {
		return personList.stream().mapToInt(Person::getKids).sum();
	}
	
	static List<String> personNames(List<Person> personList) {
		return personList.stream().map(Person::getName).collect(Collectors.toList());
	}
}
