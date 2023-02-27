package com.samples.Streams;

import java.util.Arrays;
import java.util.List;

public class StreamLimitExample {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Mango");
		fruits.stream().limit(3).forEach(System.out::println);
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		int sum1 = integers.stream().limit(4).reduce(0, Integer::sum);
		System.out.println("Sum limit 4: " + sum1);
		
		int sum2 = integers.stream().skip(2).reduce(0, Integer::sum);
		System.out.println("Sum skip 2: " + sum2);
		
		int sum3 = integers.stream().limit(6).skip(10).reduce(0, Integer::sum); // everything works for limit and skip
		System.out.println("Sum limit 4 and skip 2: " + sum3);
	}

}
