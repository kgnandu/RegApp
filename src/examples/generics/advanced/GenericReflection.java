package examples.generics.advanced;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

public class GenericReflection {

	public static void main(String[] args) {
		GenericReflectionVO<Integer, String> name = new GenericReflectionVO<>(10, "smith");
		Class<?> cl = name.getClass();
		List<String> ls = new ArrayList<>();
		
		dumpClass(ls);
	}
	
	public static void dumpClass(Object o) {
		Class<?> cl = o.getClass();
		System.out.println("Class: " + cl);
		TypeVariable<?>[] tvs = cl.getTypeParameters();
		for (TypeVariable<?> tv : tvs) {
			System.out.println("Type Variable: " + tv);
			Type[] upperBounds = tv.getBounds();
			for (Type bound : upperBounds) {
				System.out.println("\tUpper Bound: " + bound);
			}
		}
		Type[] types = cl.getGenericInterfaces();
		for (Type t : types) {
			System.out.println("Interface: " + t);
		}

		Type supClass = cl.getGenericSuperclass();
		System.out.println("GenericSuperClass = " + supClass);

		Constructor<?>[] ctors = cl.getDeclaredConstructors();
		for (Constructor<?> ctor : ctors) {
			System.out.println("Constructor : " + ctor);
			types = ctor.getGenericParameterTypes();
			dumpTypeInfo(types);
			/*
			for (Type t : types) {
				System.out.println("\tGeneric Param: " + t);
				if (t instanceof ParameterizedType) {
					ParameterizedType pt = (ParameterizedType) t;
					Type[] types2 = pt.getActualTypeArguments();
					for (Type actualType : types2) {
						System.out.println("\t\tActual Param: " + actualType);
						if (actualType instanceof WildcardType) {
							WildcardType wt = (WildcardType) actualType;
							Type[] upperBounds = wt.getUpperBounds();
							for (Type tt : upperBounds) {
								System.out.println("\t\t\tUpper Bounds: " + tt);
							}
							Type[] lowerBounds = wt.getLowerBounds();
							for (Type tt : lowerBounds) {
								System.out.println("\t\t\tLower Bounds: " + tt);
							}
						}
					}
				}
			}
			*/
		}

		Method[] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("Method: " + method);
			types = method.getGenericParameterTypes();
			dumpTypeInfo(types);
			/*
			for (Type t : types) {
				System.out.println("\tGen Param: " + t);
				if (t instanceof ParameterizedType) {
					ParameterizedType pt = (ParameterizedType) t;
					Type[] actualTypes = pt.getActualTypeArguments();
					for (Type actualType : actualTypes) {
						System.out.println("\t\tActual Param: " + actualType);
						if (actualType instanceof WildcardType) {
							WildcardType wt = (WildcardType) actualType;
							Type[] upperBounds = wt.getUpperBounds();
							for (Type tt : upperBounds) {
								System.out.println("\t\t\tUpper Bounds: " + tt);
							}
							Type[] lowerBounds = wt.getLowerBounds();
							for (Type tt : lowerBounds) {
								System.out.println("\t\t\tLower Bounds: " + tt);
							}
						}
					}
				}
			}
			*/

			Type returnType = method.getGenericReturnType();
			System.out.println("\tGen Return Type: " + returnType);
			dumpTypeInfo(new Type[] {returnType});

		}
	}

	private static void dumpTypeInfo(Type[] types) {

		for (Type t : types) {
			System.out.println("\tGen Param: " + t);
			if (t instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) t;
				Type[] actualTypes = pt.getActualTypeArguments();
				for (Type actualType : actualTypes) {
					System.out.println("\t\tActual Param: " + actualType);
					if(actualType instanceof TypeVariable) {
						TypeVariable<?> wt = (TypeVariable<?>) actualType;
						System.out.println("\t\t\tTypeVariable: " + wt);
						Type[] bounds = wt.getBounds();
						for (Type tt : bounds) {
							System.out.println("\t\t\t\tBounds: " + tt);
						}
					}
					if (actualType instanceof WildcardType) {
						WildcardType wt = (WildcardType) actualType;
						Type[] upperBounds = wt.getUpperBounds();
						for (Type tt : upperBounds) {
							System.out.println("\t\t\tUpper Bounds: " + tt);
						}
						Type[] lowerBounds = wt.getLowerBounds();
						for (Type tt : lowerBounds) {
							System.out.println("\t\t\tLower Bounds: " + tt);
						}
					}
				}
			}
		}
	}

	class MyClass {

	}

}
