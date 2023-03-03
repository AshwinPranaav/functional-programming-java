package com.samples.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreamFactoryMethods {

	public static void main(String[] args) {
		IntStream intStream1 = IntStream.range(1, 6); // 1 to 5
		IntStream intStream2 = IntStream.rangeClosed(1, 6); // 1 to 6
		
		System.out.println("IntStream range:");
		intStream1.forEach(System.out::println);
		System.out.println("IntStream rangeClosed:");
		intStream2.forEach(System.out::println);
		
		DoubleStream doubleStream = DoubleStream.generate(Math::random).limit(5);
		System.out.println("DoubleStream only:");
		doubleStream.forEach(System.out::println);
		
		System.out.println("LongStream rangeClosed:");
		LongStream.rangeClosed(1, 6).forEach(System.out::println);
		
		System.out.println("DoubleStream from LongStream:");
		LongStream.rangeClosed(1, 6).asDoubleStream().forEach(System.out::println);
		
	}

}
