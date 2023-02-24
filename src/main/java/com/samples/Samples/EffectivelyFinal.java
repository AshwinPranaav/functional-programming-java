package com.samples.Samples;

import java.util.function.Consumer;

public class EffectivelyFinal {

	static int classVar = 15;
	
	public static void main(String[] args) {
		int local = 10;
		
		Consumer<Integer> consumer = i -> System.out.println(local + i);
		consumer.accept(10);
		
		// class variables can be declared
		Consumer<Integer> c = classVar -> System.out.println(++classVar); // local classVar
		c.accept(18);
		System.out.println(classVar); // classVar
		
		Consumer<Integer> m = i -> System.out.println(++classVar);
		c.accept(10);
		
		/*
		 * this is not possible as Lambda expression's parameter local cannot redeclare another local variable 
		 * defined in an enclosing scope.
		 */
//		Consumer<Integer> consumer1 = local -> System.out.println(local);
		
		/*
		 * this is not possible because Local variable local defined in an enclosing scope must be final or 
		 * effectively final
		 */
//		Consumer<Integer> consumer2 = i -> System.out.println(local++);
	}

}
