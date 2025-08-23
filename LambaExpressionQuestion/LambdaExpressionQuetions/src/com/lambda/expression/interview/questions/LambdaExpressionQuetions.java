package com.lambda.expression.interview.questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.jar.Attributes.Name;
import java.util.stream.Collectors;

public class LambdaExpressionQuetions {

	public static void main(String[] args) {

		// 1. Iterating List using lambda Expression

		List<Integer> list = List.of(1, 2, 4, 5, 2, 6, 8);

		list.stream().forEach(System.out::print);

		// 2. Filtering a List using lambda Expression

		List<Integer> list2 = list.stream().filter(p -> p % 2 == 0).toList();

		System.out.println("\nAll even numbers : " + list2);

		// 3. Sorting a List using lambda Expression

		List<Integer> assendingSortUsingStream = list.stream().sorted().toList();
		List<Integer> accendingSortUsingCollectionSort = new ArrayList<>(list);
		accendingSortUsingCollectionSort.sort(null);

		System.out.println("\nSorted List from list in Accending Order using stream : " + assendingSortUsingStream);
		System.out.println("\nSorted List from list in Accending Order using collection sort : "
				+ accendingSortUsingCollectionSort);

		Comparator<Integer> comparator = Comparator.comparing(Integer::intValue).reversed();

		List<Integer> dessendingSortUsingStream = list.stream().sorted(comparator).toList();
		List<Integer> dessendingSortUsingCollectionSort = new ArrayList<>(list);
		dessendingSortUsingCollectionSort.sort(comparator);

		System.out.println("\nSorted List from list in Decending Order using Stream : " + dessendingSortUsingStream);
		System.out.println("\nSorted List from list in Decending Order using Collection sort : "
				+ dessendingSortUsingCollectionSort);

		// 4. Using Custom Functional interface.

		// 4.1 using lambda expression

		Calculator addTwoNum = (a, b) -> a + b;
		Calculator multiplyTwoNum = (a, b) -> a * b;
		Calculator divideTwoNum = (a, b) -> a / b;
		Calculator subtractTwoNum = (a, b) -> a - b;

		System.out.println("Add two numbers 5 or 10 = " + addTwoNum.calculateResult(5, 10));
		System.out.println("Multiply two numbers 5 and 10 = " + multiplyTwoNum.calculateResult(5, 10));
		System.out.println("Subtract 10 from 5 = " + subtractTwoNum.calculateResult(10, 5));
		System.out.println("10 divided by 5 = " + divideTwoNum.calculateResult(10, 5));

		// 4.2 using method reference

		Calculator addTwoNumMethodRef = BasicMathCalculator::sum;
		Calculator multiplyTwoNumMethodRef = new BasicMathCalculator()::multiply;
		Calculator divideTwoNumMethodRef = new BasicMathCalculator()::divide;
		Calculator subtractTwoNumMethodRef = new BasicMathCalculator()::subtract;

		System.out.println(
				"Add two numbers 5 or 10 using method reference = " + addTwoNumMethodRef.calculateResult(5, 10));
		System.out.println("Multiply two numbers 5 and 10 using method reference = "
				+ multiplyTwoNumMethodRef.calculateResult(5, 10));
		System.out.println(
				"Subtract 10 from 5 using method reference = " + subtractTwoNumMethodRef.calculateResult(10, 5));
		System.out.println("10 divided by 5 using method reference = " + divideTwoNumMethodRef.calculateResult(10, 5));

		// 5. Map Iteration

		// 5.1 via lambda and stream.

		Map<String, Integer> nameAgeMap = new HashMap<>();

		nameAgeMap.put("Deepak", 30);
		nameAgeMap.put("Pulkit", 35);
		nameAgeMap.put("Gourav", 20);
		nameAgeMap.put("Dinesh", 25);
		nameAgeMap.put("Sonu", 50);

		System.out.println("\n ------ Map Iteration using stream with lambda ----------------\n");
		nameAgeMap.keySet().stream()
				.forEach(p -> System.out.println("My name is " + p + " and i am " + nameAgeMap.get(p) + " Years old."));

		// 5.2 via lambda.
		System.out.println("\n ------ Map Iteration using map.forEach with lambda ----------------\n");

		nameAgeMap
				.forEach((name, age) -> System.out.println("My name is " + name + " and i am " + age + " Years old."));

		// 6. Creating a Thread via lambda

		Thread thread = new Thread(() -> {

			System.out.println("\n------------- Thread created via lambda expression ------------");
		});

		thread.start();

		// 7. Lambda in Optional

		Optional<String> optional = Optional.ofNullable("Deepak");

		optional.ifPresentOrElse(System.out::println, () -> System.out.println("Optional is empty"));

		Optional<String> optional1 = Optional.ofNullable("sunil");

		System.out.println(
				"-------- Optional orElse() called when Object is not null does not return default object ---------");
		System.out.println(optional1.orElse(getOrElseValue()));
		System.out.println(optional1.orElseGet(() -> getOrElseGet()));

		Optional<String> optional2 = Optional.ofNullable(null);

		System.out.println("-------- Optional orElse() called when object is null return default object ---------");
		System.out.println(optional2.orElse(getOrElseValue()));
		System.out.println(optional2.orElseGet(() -> getOrElseGet()));

		// 8. Lambda with predicate functional interface

		Predicate<Integer> predicate = a -> a > 5;
		System.out.println("Predicate Result as 2 > 5 : " + predicate.test(2));

		// 9. Lambda with Bifunction functional interface

		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
		System.out.println("BiFunction Result as sum 5 + 10 : " + biFunction.apply(5, 10));

		// 10. Lambda with Consumer functional interface

		Consumer<Integer> consumer = (a) -> System.out.println(a > 10 ? "true" : "false");
		consumer.accept(25);

		// 11. Lambda with Supplier functional interface
		Supplier<String> supplier = () -> "Hello Deepak! Supplier Called";
		System.out.println(supplier.get());

		// 12. Lambda with Function functional interface
		Function<Integer, String> functionInterface = (a) -> "Hello Deepak! Given number is : " + a;
		System.out.println(functionInterface.apply(10));

		// 13. Lambda with UnaryOperator functional interface

		UnaryOperator<Integer> unaryOperator = (t) -> t * t;
		System.out.println("Squae of 5 using unaryOperator : " + unaryOperator.apply(5));

		// 14. Lambda with BinaryOperator functional interface

		BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
		System.out.println("Multiply 2 numbers using binaryOperator : " + binaryOperator.apply(5, 10));

		// 15. Lambda with Stream Reduce
		
		System.out.println("Stream Reduce : " + list.stream().reduce((a,b) -> a+b).get());
		
		// 16. Lambda with Distinct Records
		
		System.out.println("Using Stream distint() : " + list.stream().distinct().toList());
		System.out.println("Using Stream collect set : " + list.stream().collect(Collectors.toSet()));
		
		//test();
		
		System.out.println(new BigInteger("13").isProbablePrime(1));
		
		String a = String.valueOf(344);
		System.out.println(a.equals(new StringBuilder(a).reverse().toString()));
	}

	private static void test() {
		
		System.out.println(findAllSelfDividingNumbers(10, 30));
		
	}
	
	 public static ArrayList<Integer> findAllSelfDividingNumbers(int lower, int upper) {
	        
	        ArrayList<Integer> arrayList = new ArrayList<>();
	        
	        for(int i = lower; i <= upper; i++){

	            int k = i;
	            boolean isDivisible = true;

	            while(k > 0){

	                int temp = k % 10;
	                

	                if(temp == 0 || lower % temp !=0) {

	                    isDivisible = false;
	                    break;

	                }

	                k = k / 10;
	            }

	            if(isDivisible){

	                arrayList.add(i);
	            }
	            

	        }

	        return arrayList;
	    }

	private static String getOrElseGet() {
		System.out.print("----- OrElseGet Called ---");
		return "OrElseGet";
	}

	private static String getOrElseValue() {

		System.out.print("----- OrElse Called ---");
		return "OrElse";
	}

	class Student {

		public Student() {

		}
	}

}
