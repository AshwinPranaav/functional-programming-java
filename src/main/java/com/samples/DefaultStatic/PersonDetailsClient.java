package com.samples.DefaultStatic;

import java.util.List;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class PersonDetailsClient {

	static List<Person> personList = PersonRepository.getAllPersons();
	
	public static void main(String[] args) {
		PersonDetails pd = new PersonDetailsImpl();
		System.out.println("Total salary: " + pd.calculateTotalSalary(personList));
		System.out.println("Total kids: " + pd.totalKids(personList));
		System.out.println("Names: " + PersonDetails.personNames(personList));
	}

}
