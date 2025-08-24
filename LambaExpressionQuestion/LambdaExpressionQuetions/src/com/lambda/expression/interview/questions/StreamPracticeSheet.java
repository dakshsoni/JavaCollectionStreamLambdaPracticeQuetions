package com.lambda.expression.interview.questions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPracticeSheet {

	public static void main(String[] args) {
		
		List<String> userNames = DataProvider.listOfUsername;
		
		/* print All elements */
		
		System.out.println("************* 1. printing All elements start *************\n ");
		
		userNames.stream().forEach(System.out::println);
		
		System.out.println("************* 2. Convert All elements into lowercase *************\n ");
		
		List<String> lowerCaseUserName = userNames.stream().map(String::toLowerCase).toList();
		System.out.println(lowerCaseUserName+"\n");
		
		System.out.println("************* 3. Count no of elements *************\n ");
		
		System.out.println("No of Elements : " + userNames.stream().count() + " userNames List size : " + userNames.size()+"\n");

		System.out.println("************* 4. Remove duplicate elements *************\n ");
		
		List<String> removedDuplicatesUsers = userNames.stream().distinct().toList();
		System.out.println(removedDuplicatesUsers+"\n");
		System.out.println("************* 5. Find Users Starting with 'R' elements ************* \n");
		
		List<String> UsersStartWithR = userNames.stream().filter(p -> p.startsWith("R")).toList();
		System.out.println(UsersStartWithR+"\n");
		
		
		System.out.println("************* 6. Count duplicate elements *************\n");
		Map<String, Long> userMap = userNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(userMap+"\n");
		
		System.out.println("************* 7. Sort elements alphabetically *************\n");
	
		List<String> listOfUsers = userNames.stream().sorted(Comparator.naturalOrder()).toList();
		System.out.print(listOfUsers+"\n");
		
		System.out.println("************* 8. Find Logest String *************\n");
		
		//String LogestUsername = userNames.stream().max((a,b) -> a.length()-b.length()).get();
		String LogestUsername = userNames.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.print(LogestUsername+"\n");
		
		
		System.out.println("************* 9. join String *************\n");
		
		String listOfUsersJoin = userNames.stream().collect(Collectors.joining(", "));
		System.out.print(listOfUsersJoin+"\n");
	
		System.out.println("************* 10. Group by length *************\n");
	
		Map<Integer, List<String>> userssGroupByLength = userNames.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(userssGroupByLength+"\n");
		
		System.out.println("************* 11. Find 1st String length = 6 *************\n");
		
		String findFirstUserLengthGraterThen6 = userNames.stream().filter(p -> p.length() >= 6).findFirst().get();
		System.out.println(findFirstUserLengthGraterThen6+"\n");
	
	
		System.out.println("************* 12. Capitalization of 1st character of all string *************\n");
		
		List<String> firstCahrCaplital = userNames.stream().map(p -> {
			
			String char1St = p.substring(0,1);
			p = char1St.toUpperCase()+p.substring(1);
			return p;
		}).toList();
		
		System.out.println(firstCahrCaplital + "\n");
	
		System.out.println("************* 13. Filter Even Numbers *************\n");
		
		List<Integer> evenNumbers = DataProvider.numbers.stream().filter(p -> p % 2 == 0).toList();
		System.out.println(evenNumbers + "\n");
		
		System.out.println("************* 14. Filter Odd Numbers *************\n");
		
		List<Integer> oddNumbers = DataProvider.numbers.stream().filter(p -> !(p % 2 == 0)).toList();
		System.out.println(oddNumbers + "\n");	
		
		System.out.println("************* 15. Sum of All Numbers *************\n");
		
		int sumOfAllNumbers = DataProvider.numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumOfAllNumbers + "\n");
		
		System.out.println("************* 16. Find Max Number *************\n");
		
		int maxNum = DataProvider.numbers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
		System.out.println(maxNum + "\n");
		
		System.out.println("************* 17. Find Min Number *************\n");
		
		int minNum = DataProvider.numbers.stream().min(Comparator.comparingInt(Integer::intValue)).get();
		System.out.println(minNum + "\n");
		
		System.out.println("************* 18. Find second higest Number *************\n");
		
		int secondHigestNumber = DataProvider.numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(secondHigestNumber + "\n");
	
		System.out.println("************* 19. Find second Last Number *************\n");
		
		int secondLastNumber = DataProvider.numbers.stream().skip(DataProvider.numbers.size()-2).findFirst().get();
		System.out.println(secondLastNumber + "\n");
		
		System.out.println("************* 20. Check any number divisible by 5 *************\n");
		
		Boolean anyNumDivBy5 = DataProvider.numbers.stream().anyMatch(p -> p%5 == 0);
		System.out.println(anyNumDivBy5 + "\n");
	
		System.out.println("************* 21. Partition num based on odd and even *************\n");
		
		Map<Boolean, List<Integer>> partitionNumBasedOnOddEven = DataProvider.numbers.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0));
		System.out.println(partitionNumBasedOnOddEven + "\n");
		
		System.out.println("************* 22. Print All employee name *************\n");
		
		List<Object> EmpNames = DataProvider.ListOfEmp.stream().map(p -> p.get("name")).toList();
		System.out.println(EmpNames + "\n");
		
		System.out.println("************* 23. Filter All Trainee *************\n");
		
		List<Map<String, Object>> allTrainees = DataProvider.ListOfEmp.stream().filter(p -> "Trainee".equals(p.get("Designation"))).toList();
		System.out.println(allTrainees + "\n");
		
		System.out.println("************* 24. Extract Salary as a list *************\n");
		
		List<Object> salariesOfEmployees = DataProvider.ListOfEmp.stream().map(p -> p.get("Salary")).toList();
		System.out.println(salariesOfEmployees + "\n");
		
		System.out.println("************* 25. Total Salary of all Employees *************\n");
		
		int totalSalary = DataProvider.ListOfEmp.stream().mapToInt(p -> (Integer)p.get("Salary")).sum();
		System.out.println(totalSalary + "\n");
		
		System.out.println("************* 26. Group Employees by designation *************\n");
		
		
		Map<String, List<Map<String, Object>>> groupEmployeesByDesignation = DataProvider.ListOfEmp.stream().collect(Collectors.groupingBy(a -> (String)a.get("Designation")));
		System.out.println(groupEmployeesByDesignation + "\n");
		
		System.out.println("************* 27. Max salary of Employee *************\n");
		
		
		Map<String, Object> maxSalary = DataProvider.ListOfEmp.stream().max(Comparator.comparingInt(a -> (Integer)a.get("Salary"))).get();
		System.out.println(maxSalary + "\n");
		
		System.out.println("************* 28. Sort Employee by salary *************\n");
		
		
		//List<Map<String, Object>> sortBySalary = DataProvider.ListOfEmp.stream().sorted((a,b) -> (Integer)a.get("Salary") - (Integer)b.get("Salary")).toList();
		List<Map<String, Object>> sortBySalary = DataProvider.ListOfEmp.stream().sorted(Comparator.comparingInt(a -> (Integer)a.get("Salary"))).toList();
		System.out.println(sortBySalary + "\n");
		
		
		System.out.println("************* 29. Average salary of Employee *************\n");
		
		Double avgSalary = DataProvider.ListOfEmp.stream().mapToInt(p -> (Integer)p.get("Salary")).average().getAsDouble();
		System.out.println(avgSalary + "\n");
		
		System.out.println("************* 30. Name of Employee whoes salary > 8000 *************\n");
		
		List<Object> NamesOfEmpSalaryGraterThen8k = DataProvider.ListOfEmp.stream().filter(p -> (Integer)p.get("Salary") > 8000).map(p -> p.get("name")).toList();
		System.out.println(NamesOfEmpSalaryGraterThen8k + "\n");
		
		System.out.println("************* 31. Check if any Employee is QA > 8000 *************\n");
		
		Boolean checkAnyWhoIsQA = DataProvider.ListOfEmp.stream().anyMatch(p -> "QA".equals((String)p.get("Designation")));
		System.out.println(checkAnyWhoIsQA + "\n");
		
		
		
	
	
	}

}
