package examples.generics.simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/**
 * OldWayExample illustrates using a raw type
 * Collection. Raw type collections are not
 * typesafe
 */
public class OldWayExample {

  public static void main(String[] args) {
	  args = new String[] { "one", "two", "tree" };
    List myList = new ArrayList(100);
  
    
    //convert args into a List
    List argList = Arrays.asList(args);
    //add Strings to list
    myList.addAll(argList);
    //list is not typesafe, can add any objectString
    
    
    ListIterator theArgs = myList.listIterator();
    //step through list elements
    while (theArgs.hasNext()) {
      String nextArg = (String)theArgs.next();
      System.out.println(nextArg);
    }
    
  }
}
