import java.util.*;
public class Assignment2Part1 {
  public LinkedList<String> list = new LinkedList<>();
  
  public void reverse() {
    //this part is non-critical and only exists for ease of testing
    list.add("7");
    list.add("9");
    list.add("11");
    
    //iterates, adding the each thing consecutively to the string builder so it is linear time (no traversing the linked list multiple times)
    StringBuilder bldr = new StringBuilder();
    Iterator itr = list.iterator();
    System.out.println(list);
    while (itr.hasNext()) {
      //this adds the element to thte front of the stringbuilder
      bldr.insert(0, itr.next() + " ");
    }
    System.out.println(bldr.toString());
  }
  
  
}