import java.util.*;
public class CustomSQueue {
  Stack<Integer> stacka = new Stack<Integer>();
  Stack<Integer> stackb = new Stack<Integer>();
 
  CustomSQueue() {
  }
   
  void add(Integer newint) {
    stacka.push(newint);  
  }
 
  Integer poll() {
    //first we check if there is anything to dequeue
    if (stacka.size() < 1)
      throw new EmptyStackException();
    
    //we save an int for size because size will change as things are moved between stacks
    int size = stacka.size();
    //here we basically put stack a upside down in stack b
    for (int i = 0; i < size; i++) {
      stackb.push(stacka.pop());
    }
    //we draw from b
    Integer result = stackb.pop();
    //then we flip the stack back over into a
    for (int i = 0; i < size - 1; i++) {
      stacka.push(stackb.pop());
    }
    
  return result;
  }
  
}
