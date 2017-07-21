package examples.generics.advanced;

import java.util.ArrayList;
import java.util.List;

public class PreWildCards {

	public static void main(String [] args) {
		List<Number> numberList = new ArrayList<>();
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		numberList.add(30.5);
		
		System.out.printf("NumberList sum is %g%n", sum(numberList));
		
		/*
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		
		System.out.printf("IntegerList sum is %g%n", sum(intList));
		
		Integer [] iarr = { 0, 5, 15 };
		String [] sarr = { "a", "b" };
		
		addToList(iarr, intList);
		System.out.println("IntList after adding is " + intList);
		
		addToList(iarr, numberList);
		
		List<String> strList = new ArrayList<>();

		List<Object> objList = new ArrayList<>();
		addToList(iarr, objList);
		
		
		List<Double> doubleList = new ArrayList<>();
		doubleList.add(10.);
		doubleList.add(20.);
		doubleList.add(30.);
		
		Double [] darr = { 0. , 5., 15. };

		addToList(darr, doubleList);

		System.out.println("DoubleList after adding is " + doubleList);
		
		System.out.printf("Double sum is %g%n", sum(doubleList));
		*/
	}
	
	public static double sum(List<Number> list) {
		double sum = 0;
		for(Number number : list) {
			sum += number.doubleValue();
		}
		return sum;
	}
	
	
	public static void addToList(Integer [] values, List<Integer > list) {
		for(Integer  i : values) {
			list.add(i);
		}
	}

}
