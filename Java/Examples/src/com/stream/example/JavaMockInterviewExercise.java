package com.stream.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaMockInterviewExercise {

	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Sakthi", "Kannan", "Anil","Ashok","Nallasivam");
		 List<String> check = nameList.stream().filter(name -> name.length()>1)
				 .map(name -> name.toUpperCase()).distinct().
				 
				 collect(Collectors.toList());
		
		// 1. Filter names less than five characters using stream
		List<String> filteredList = nameList.stream()
											.filter(name -> name.length()>5).sorted()
//											.sorted(Comparator.reverseOrder()))
											.collect(Collectors.toList());
		Collections.sort(filteredList, (nameA, nameB) -> nameA.compareTo(nameB));
		System.out.println(filteredList);
		
		Collections.reverse(filteredList);
		System.out.println(filteredList);
		
		// 2. (a) Convert List of String to Map like name as a key and length of the name as value.
		Map<String,Integer> namesMap = new HashMap<>();
										nameList.stream()
												.forEach(name -> {
														namesMap.put(name, name.length());
														});
		
		// 2. (b) Concert the same without forEach 
		Map<String,Integer> nameLengthMap = nameList.stream()
													.collect(Collectors.toMap(
															Function.identity(), name -> name.length()));
		// To print output List and Map
//		System.out.println(nameList);
//		System.out.println(filteredList);
//		System.out.println(namesMap);
//		System.out.println(nameLengthMap);
		
	}

}
