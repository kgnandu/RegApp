package examples.generics.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsInheritance {

	public GenericsInheritance() {

		List<Number> numberList = new ArrayList<>();
		List<? extends Number> extendsNumber = numberList;
		List<? super Number> superNumber = numberList;

		List<Integer> integerList = new ArrayList<>();
		List<? extends Integer> extendsInteger = integerList;
		List<? super Integer> superInteger = integerList;
		
		extendsNumber = integerList;
		extendsNumber = extendsInteger;
		
		superInteger = superNumber;
		superInteger = numberList;
	}
	
	public <T> void swapPos(T[] arr, int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public static void main(String [] args) throws ClassNotFoundException {
		List<Integer> l1 = Arrays.asList(5, 3, 5);
		int max = findMax(l1, 0, 3);
		
		List<String> l2 = Arrays.asList("1", "z", "a");
		String maxString = findMax(l2, 0, 3);
		
		System.out.println("max = " + max + ", maxString = " + maxString);
		
		List<? extends Derived> lb1 = Arrays.asList(new Derived(), new DoubleDerived(), new Derived());
		
		Derived d = findMax(lb1, 0, 3);
		System.out.println("max Derived = " + d);
		
		List<DoubleDerived> lb2 = Arrays.asList(new DoubleDerived(), new DoubleDerived(), new DoubleDerived());
		
		DoubleDerived dd = findMax(lb2, 0, 3);
		System.out.println("max DoubleDerived = " + dd);
		
		/*
		Method [] intMethods = Integer.class.getMethods();
		for(Method method : intMethods) {
			System.out.println(method.toGenericString());
		}
		*/
	}
	
	public static <T extends Comparable<? super T>> T findMax(List<T> input, int begin, int end) {
		T result = input.get(0);
		for(int i = begin; i < end; i++) {
			T thing = input.get(i);
			if(thing.compareTo(result) > 0) {
				result = thing;
			}
		}
		return result;
	}

}

class Base {}

class Derived extends Base implements Comparable<Derived>
{
	private static int nextId = 0;
	private int id = ++nextId;
	
	@Override
	public int compareTo(Derived o) {
		return id < o.id ? -1 : id == o.id ? 0 : 1;
	}
	
	public void foo() {
		Node<Circle> nc = new Node<>();
		Node<? extends Shape>  ns = nc;
		
		Node2<String> node = new Node2<>();
		Comparable<String> comp = node;
	}
	
	public String toString() {
		return "Derived : " + id;
	}
	
}

class DoubleDerived extends Derived { 
	public String toString() {
		return "Double Derived: " + super.toString();
	}
}

class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node<T> { /* ... */ }

class Node2<T> implements Comparable<T> {
    public int compareTo(T obj) { return 0;}
}