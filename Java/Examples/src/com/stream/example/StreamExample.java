package com.stream.example;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		//		List<String> arrlist = Arrays.asList("book",null,"laptop","pen");
		//		List<String> value = arrlist.stream().filter(Objects::nonNull).map(obj -> obj.concat("s")).collect(Collectors.toList());
		//		value.forEach(System.out :: println);
		//		List<Integer> oddList = Arrays.asList(1,3,5,7,9);
		//		List<Integer> evenList = Arrays.asList(2,4,6,8,0);
		//		List<List<Integer>>  numbers = new ArrayList<>();
		//		numbers.add(oddList);
		//		numbers.add(evenList);
		//		System.out.println("Before flattening");
		//		numbers.forEach(System.out :: println);
		//		System.out.println("After Flattening");
		//		 List<Integer> dgfdg = numbers.stream().flatMap(List:: stream).collect(Collectors.toList());
		//		 System.out.println(dgfdg);
		//		 
		//		 
		//		 Map<String,Integer> map = new HashMap<>();
		//		 map.put("A", 1);
		//		 map.put("B",6);
		//		 map.put("C", 8);
		//		 
		//		 System.out.println(map);
		//		 
		//		 List<Integer> intList = new ArrayList<>();
		//		 
		//		 map.entrySet().stream().filter(entry -> entry.getValue() > 5)
		//		 .map(entry -> entry.getValue()*6)
		//		 .forEach(System.out :: println);
		//		 
		//		 
		//		 
		//		 
		////		 List<String> strList = new ArrayList<>();
		////		map.entrySet().stream().forEach(entry -> {
		////			intList.add(entry.getValue());
		////			int asd = entry.getValue();
		////			if()
		////		});
		//		 System.out.println(intList);
		//		 

		//		 List<String> namesList = Arrays.asList("Sakthi", "Kannan", "Anil","Ashok","Nallasivam");

		//		 Map<String,Integer> namesMap = new HashMap<>();

		//		 namesList.stream().forEach(name -> {
		//			 namesMap.put(name, name.length());
		//		 });

		//		 System.out.println(namesMap);
		//		 List<String> smallNameList = namesList.stream().filter(name -> name.length() <5).collect(Collectors.toList());
		//		
		//System.out.println(smallNameList);
		//IntStream nameInt = namesList.stream().filter(Objects::nonNull).mapToInt(name -> name.length());
		//		 
		//		 namesList.stream().map(name -> namesMap.put(name, name.length()));
		//		 
		//		 System.out.println(namesMap);
		//		 Map<String, Integer> namesMapWithoutForEach = namesList.stream().collect(Collectors.toMap(name -> name,name -> name.length()));
		//		 Map<String, Integer> namesMapWithoutForEach1 = namesList.stream().collect(Collectors.toMap(Function.identity(),name -> name.length()));
		//		 
		//		 
		//		 System.out.println(namesMapWithoutForEach);
		//		 

		//		 

				List<String> namesList = Arrays.asList("Sakthi", "Kannan", "Anil","Ashok","Nallasivam");
		//		
		//		List<String> nameFilterList = namesList.stream().filter(name -> name.length()<=5).collect(Collectors.toList());
		//		Map<String, Integer> namesMapUsingForEach = new HashMap<>();
		//		namesList.stream().forEach(name -> {
		//			namesMapUsingForEach.put(name, name.length());
		//		});
		//		Map<String, Integer> namesMap = namesList.stream().collect(Collectors.toMap(name -> name, name -> name.length()));
		//		Map<String, Integer> namesGroupMap = namesList.stream().collect(Collectors.toMap(Function.identity(), name -> name.length())); 
		//		System.out.println(namesList);
		//		System.out.println(nameFilterList);
		//		System.out.println(namesMapUsingForEach);
		//		System.out.println(namesMap);
		//		System.out.println(namesGroupMap);
		//		


		//		 Map<Integer, List<String>> namesMapUsingGroupBy = namesList.stream()
		//				.collect(Collectors.groupingBy(String :: length));
		//		 
		//		 
		//		 System.out.println(namesMapUsingGroupBy);
		//		 Collections.sort(List<>, null);
		//		 
		//		 Comparator<Integer> comp = new Comparator<Integer>() {
		//
		//			@Override
		//			public int compare(Integer o1, Integer o2) {
		//				if(o1=o2)
		//				return 0;
		//			}
		//		};

//		List<Integer> intList = new ArrayList<Integer>();
//
//		intList.add(100);
//		intList.add(200);
//		intList.add(150);
//		intList.add(120);
//		intList.add(210);
//		intList.add(20);
//
//		Integer total = intList.stream().reduce(0, (a,b) -> a+b );
//		System.out.println(total);
//		Integer total1 = intList.stream().collect(Collectors.summingInt(Integer :: intValue));		 
//		System.out.println(total1);
//		int total2 = intList.stream().mapToInt(Integer::intValue).sum();
//		System.out.println(total2);
////		
//		String s1 = "abc";
//		String s2 = new String("abc");
//		String s3 = "abc";
//		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1==s2);
//		System.out.println(s1.equals(s3));
//		System.out.println(s1==s3);
//		int a =10;
//		try(Scanner scanner = new Scanner(new File("testRead.txt")); 
//			    PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
//			
//		}
		
//		"Convert ArrayList into threadsafe can be done in 2 ways:
//		List<Integer> numList = Collections.synchronizedList(new ArrayList<Integer>());
//		CopyOnWriteArrayList<String> array= new CopyOnWriteArrayList<String>(); 
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("aa", 11);
		map.put("bb", 12);
		
		 List<String> result = namesList.stream().filter(ls->ls.length()>=1)
				 .sorted(Comparator.reverseOrder())
                 .collect(Collectors.toList());
		 
		
		 
		 // Collections.sort(result, com);
		
//		Collections.sort(result, (s1, s2) -> s1.compareTo(s2));

System.out.println("ascending order of list result" +result);

Collections.sort(result,Collections.reverseOrder()); 
//-> fine.Is there any possible to do within sorted  itself?

System.out.println("descending order " + result);



//count the frequency of the elements in a list

Set<String> distinct = new HashSet<>(result);

Map<String, Long> check = namesList.stream().collect(Collectors.groupingBy(
		Function.identity(), Collectors.counting()));

//
//for(String s:distinct) {
//
//      System.out.println(s +": " + Collections.frequency(list, s));  -à this way is fine. Is there any possible to find without using collections inbuild method?    Check with siva for reference
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}


