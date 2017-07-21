package examples.generics.advanced;

import java.util.ArrayList;
import java.util.List;

public class GenericReflectionVO<A extends Number, B> extends ArrayList<A>{

	A fieldA;
	B fieldB;
	
	GenericReflectionVO(A a, B b) {
		fieldA = a;
		fieldB = b;
	}
	

	public void setFieldA(A a) {
		this.fieldA = a;
	}

	public A getFieldA() {
		return fieldA;
	}

	public void setFieldB(B b) {
		this.fieldB = b;
	}

	public B getFieldB() {
		return fieldB;
	}
	
	public void foo() {
		List<String> ls = new ArrayList<>();
		List<Improbable> ln = new ArrayList<>();
		
		blah(ls, ln);
	}
	
	public <T extends Number & Runnable> List<T> blah(List<String> list, List<T> something) {
		
		return null;
		
	}
	
	class Improbable extends Number implements Runnable
	{

		@Override
		public void run() {
			System.out.println("An Improbable Run");
		}

		@Override
		public double doubleValue() {
			return 0;
		}

		@Override
		public float floatValue() {
			return 0;
		}

		@Override
		public int intValue() {
			return 0;
		}

		@Override
		public long longValue() {
			return 0;
		}
		
	}
}
