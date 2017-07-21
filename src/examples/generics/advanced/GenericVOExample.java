package examples.generics.advanced;

public class GenericVOExample {

	public static void main(String[] args) {
		// create instances of the GenericVO
		GenericVO<String, String> name = new GenericVO<>("John",
				"Doe");

		GenericVO<String, String> name2 = new GenericVO<String, String>("John",
				"Doe");

		GenericVO<String, Integer> user = new GenericVO<String, Integer>(
				"john_doe123", 123457);

		// get name field <B>
		String lastName = name.getFieldB();
		System.out.println("name's field <B> is: " + lastName);

		// get user field <B>
		Integer userId = user.getFieldB();
		System.out.println("users's field <B> is: " + userId);

		// Call areEqual function
		System.out.println("name and name2 equal? " + areEqual(name, name2));
		
		for(int i = 0; i < 100; i++) {
			for(int j = 10; j < 200; j++) {
				
			}
		}

	}

	public static <A, B> boolean areEqual(GenericVO<A, B> obj1,
			GenericVO<A, B> obj2) {
		return obj1.getFieldA().equals(obj2.getFieldA())
				&& obj1.getFieldB().equals(obj2.getFieldB());
	}

}
