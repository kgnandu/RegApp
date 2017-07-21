package examples.generics.advanced;

import java.util.ArrayList;
import java.util.List;

public class WildCards {

	public static void main(String [] args) {
		List<Number> numberList = new ArrayList<>();
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		numberList.add(30.5);
		
		System.out.printf("NumberList sum is %g%n", sum(numberList));
		
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		
		
		System.out.printf("IntList sum is %g%n", sum(intList));
		
		addToList(new Integer [] { 0, 2}, intList);
		System.out.printf("intList is %s%n", intList);
		
		addToList(new Integer [] { 0, 2}, numberList);
		
		addToList(new Double [] { 0.0, 2.2}, numberList);
		System.out.printf("numberList is %s%n", numberList);
	}
	
	public static double sum(List<? extends Number> list) {
		double sum = 0;
		
		for(Number n : list) {
			sum += n.doubleValue();
		}
		
		return sum;
	}
	
	
	public static <T> void addToList(T [] values, List<? super T> list) {
		for(T i : values) { 
			list.add(i);
		}
	}
	
	/**
	 * Use <? extends Blah> when the list is the "Producer"
	 * This allows us to process a list of Number or anything
	 * that extends Number, and that is okay because all we
	 * want to (or can) do here are Number types of things.
	 * @param list
	 * @return
	public static double sum(List<? extends Number> list) {
		double sum = 0;
		for(Number number : list) {
			sum += number.intValue();
		}
		
		return sum;
	}
	 */
	
	/**
	 * Use <? super T> when the list is the "Consumer"
	 * Here we can process a List of T or any of T's 
	 * super types.  Because we can put a T into all
	 * such lists.
	 * @param values
	 * @param list
	public static <T> void addToList(T [] values, List<? super T> list) {
		for(T i : values) {
			list.add(i);
		}
	}
	 */
}
