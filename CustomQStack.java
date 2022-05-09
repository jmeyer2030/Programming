import java.util.*;
public class CustomQStack {
  public Queue<Integer> q = new LinkedList<Integer>();
  
  CustomQStack() {
  
  }
  //returns true if empty, false if not
  boolean empty() {
    if (q.size() == 0)
      return true;
    return false;
  }
  
  
  //adds a new element to the top of the stack
  void push(int newint) {
      q.add(newint);
  }
  
  
  //removes the top element of the stack, works by cycling through the list to make the top element the bottom so it will be dequeued.
  int pop() {
    if (this.empty() == true)
      throw new EmptyStackException();
    for (int i = 0; i < q.size() - 1; i++) {
      q.add(q.remove());
    }
    return q.remove();
  }
  
}