package examples.generics.simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * The following example illustrates
 * the use of a type-safe collection
 */
public class CorruptTestExample {

  public static void main(String[] args) {
    //typesafe List of String elements
    List<String> myList = Collections.checkedList(new ArrayList<String>(), String.class);

    //convert args into a List<String>
    List<String> argList = Arrays.asList(args);
    myList.addAll(argList);

    //call third-party api which uses raw types
    //ThirdPartyAPI.addElement(myList);

    //Iterator is now also typesafe
    Iterator<String> theArgs = myList.iterator();
    while(theArgs.hasNext()) {
      String nextArg = theArgs.next();
    }
    
    
    /*
    //Using a Checked List allows you to see where 
    //objects of the wrong type are being inserted.
    //Mostly useful for debugging.
    List<String> checkedList = Collections.checkedList(myList, String.class);
    //call third-party api which uses raw types
    //Now, the Exception will happen at insertion time.
    ThirdPartyAPI.addElement(checkedList);

    //Iterator is now also typesafe
    theArgs = checkedList.iterator();
    while(theArgs.hasNext()) {
      String nextArg = theArgs.next();
    }
    */
  }
}
