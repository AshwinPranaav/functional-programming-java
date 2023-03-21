package com.samples.DefaultStatic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class DefaultMethod {

	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		
		// type 1
		List<String> nameList = personList.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println("Before sorting: " + nameList);
		Collections.sort(nameList);
		System.out.println("After sorting: " + nameList);
		
		// type 2
		String nameUnsorted = personList.stream().map(Person::getName).collect(Collectors.joining(", "));
		
		String nameSorted = personList.stream().map(Person::getName).sorted().collect(Collectors.joining(", "));
		
		System.out.println("Before sorting: " + nameUnsorted);
		System.out.println("After sorting: " + nameSorted);
		
		// type 3
		nameList.sort(Comparator.naturalOrder());
		System.out.println(nameList);
		nameList.sort(Comparator.reverseOrder());
	}

}
