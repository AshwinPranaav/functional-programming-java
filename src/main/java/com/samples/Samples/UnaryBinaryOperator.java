package com.samples.Samples;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator {

	public static void unaryBinary() {
		UnaryOperator<String> uo = t -> t.toUpperCase();
		System.out.println("Unary Operator: " + uo.apply("ashwin"));
		
		BinaryOperator<Integer> bo = (p1, p2) -> p1;
		System.out.println("Binary Operator: " + bo.apply(1, 1));
		
		BinaryOperator<Integer> boc = (p1, p2) -> p1.compareTo(p2);
		System.out.println("Binary Operator: " + boc.apply(5, 1));
	}
	
	public static void main(String[] args) {
		unaryBinary();
	}

}
