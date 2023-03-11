package com.samples.TerminalStream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamMapping {

	static List<String> mappingName() {
		List<String> namesUsual = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		
		List<String> names = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.mapping(Person::getName, Collectors.toList()));
		return names;
	}
	
	static Set<String> mappingNameSet() {
		Set<String> namesUsual = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.collect(Collectors.toSet());
		
		Set<String> namesSet = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.mapping(Person::getName, Collectors.toSet()));
		return namesSet;
	}
	
	public static void main(String[] args) {
		System.out.println(mappingName());
		System.out.println(mappingNameSet());
	}

}
