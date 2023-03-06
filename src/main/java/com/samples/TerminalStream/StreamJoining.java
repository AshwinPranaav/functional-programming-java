package com.samples.TerminalStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.samples.Dto.Person;
import com.samples.Dto.PersonRepository;

public class StreamJoining {
	
	static String personStreamJoining() {
		String str = PersonRepository.getAllPersons().stream()
				.map(Person::getName)
//				.collect(Collectors.joining());
				.collect(Collectors.joining(", "));
		return str;
	}
	
	public static void main(String[] args) {
		char[] ch = {'a', 'b', 'c', 'd', 'e', 'f'};
		
		String joined1 = Stream.of(ch).map(c -> new String(c)).collect(Collectors.joining());
		System.out.println("Collectors.joining(): " + joined1);
		
		String[] str = {"a", "b", "c", "d", "e", "f"};
		
		String joined2 = Stream.of(str).map(s -> new String(s)).collect(Collectors.joining(", "));
		System.out.println("Collectors.joining(delimiter): " + joined2);
		
		String joined3 = Stream.of(str).map(s -> new String(s)).collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Collectors.joining(delimiter, prefix, suffix): " + joined3);
		
		System.out.println("Person joining(): " + personStreamJoining());
	} 
}
