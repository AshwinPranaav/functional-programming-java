package com.samples.DefaultStatic;

import java.util.List;
import java.util.stream.Collectors;

import com.samples.Dto.Person;

public class PersonDetailsImpl implements PersonDetails {

	@Override
	public double calculateTotalSalary(List<Person> personList) {
		return personList.stream().mapToDouble(Person::getSalary).sum();
	}

}
