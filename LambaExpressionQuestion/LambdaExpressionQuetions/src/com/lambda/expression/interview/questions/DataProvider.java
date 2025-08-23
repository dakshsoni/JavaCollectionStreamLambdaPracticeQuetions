package com.lambda.expression.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
	
	public static List<String> listOfUsername = new ArrayList();
	public static List<Integer> numbers = new ArrayList();
	
	public static Map<Integer, Integer> map = new HashMap<>();
	
	
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
		
		
		for(int i =0;i<15;i++) {
			numbers.add(i);
		}
	}

	
	
	
	

}
