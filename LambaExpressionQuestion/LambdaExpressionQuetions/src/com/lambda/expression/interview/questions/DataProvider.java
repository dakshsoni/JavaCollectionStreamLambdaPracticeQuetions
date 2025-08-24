package com.lambda.expression.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

	public static List<String> listOfUsername = new ArrayList();
	public static List<Integer> numbers = new ArrayList();

	public static List<Map<String, Object>> ListOfEmp = List.of(
			Map.of("id", 1, "name", "Deepak", "Designation", "Trainee", "Salary", 10000),
			Map.of("id", 2, "name", "Rohan", "Designation", "Software Engineer", "Salary", 20000),
			Map.of("id", 3, "name", "Kamal", "Designation", "Senior Software Engneer", "Salary", 40000),
			Map.of("id", 4, "name", "Shalu", "Designation", "Trainee", "Salary", 15000),
			Map.of("id", 5, "name", "Roni", "Designation", "QA", "Salary", 8000));

	static {

		listOfUsername.add("Rohan");
		listOfUsername.add("Sohan");
		listOfUsername.add("Mohan");
		listOfUsername.add("Janam");
		listOfUsername.add("Kalam");
		listOfUsername.add("Aman");
		listOfUsername.add("Raman");
		listOfUsername.add("Raman");
		listOfUsername.add("Janam");
		listOfUsername.add("JanamKill");
		listOfUsername.add("JanamMill");
		listOfUsername.add("deepak");

		for (int i = 0; i < 15; i++) {
			numbers.add(i);
		}
	}

}
