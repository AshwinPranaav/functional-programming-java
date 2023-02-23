package com.samples.Samples;

public class FunctionalInterfaceExample {

	static void funcInterface() {
		X1 inter = (site) -> System.out.println("implementation");
		inter.add("Hello");
	}
	
	public static void main(String[] args) {
		funcInterface();
	}

	@FunctionalInterface
	interface X1 {
		void add(String site);

		default void add1() {
			System.out.println("default");
		}

		static void flushConnection() {
			System.out.println("static");
		}
	}
}
