import java.util.*;
import java.util.PriorityQueue;
import java.lang.Integer;
class Sort{
  
  //merge sort algorithm
  void mergeSort(int[] input) {
    int[] temp = new int[input.length];
    myMergeSort(input, temp, 0, input.length - 1);
  }
  
  void myMergeSort(int[] arr, int[] temp, int start, int end) {

    if (end - start == 0) 
      return;
    int middle = split(start, end);
    myMergeSort(arr, temp, start, middle);
    myMergeSort(arr, temp, middle + 1, end);
    merge(arr, temp, start, middle, middle + 1, end);
  }
  
  int split(int first, int last) {
    return (first + last)/2;
  }
  
  void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
    int i = leftStart;
    int j = rightStart;
    int k = leftStart;
    while(i <= leftEnd && j <= rightEnd){
    if (arr[i] >= arr[j]) {
       temp[k] = arr[i];
       i++;
    } else {
      temp[k] = arr[j];
      j++;
    }
    k++;
    }
    while (i <= leftEnd) {//only one of these should run because the above loop will run until one of the lists has been finished.
      temp[k] = arr[i];
      i++;
      k++;
    }
     while (j <= rightEnd) {
       temp[k] = arr[j];
       j++;
       k++;
     }

    for (i = leftStart; i <= rightEnd; i++)
      arr[i] = temp[i];
  }
  
  void quickSort(int[] input) {
    myquickSort(input, 0, input.length - 1);
  }
  
  
  //recursively calls itself to sort
  void myquickSort(int[] input, int first, int last) {
    if(first >= last)
      return;
    int split = partition(input, first, last);
    if (split == last) { //means that last is in place
      myquickSort(input, first, last - 1);
    }
    else if (split == first){ //means first is in place
      myquickSort(input, first + 1, last);
    }
    else {//means split is somewhere in the middle
      myquickSort(input, first, split);
      myquickSort(input, split + 1, last);
    }
    return;
  }
  
  int partition(int[] input, int first, int last) {//goes through the array from first to last and sorts it in half
    int i = first;
    int j = last;
    int pivotval = input[i];
    int pivotspot = i;
    while (true) {//does the following until i >= j
      while(input[i] >= pivotval && i < last) { //advances i if it is greater than or equal to pivot, stops when a value is less. Because if it is greater, it is in the right spot. Always passes the pivot, because it is equal to input[i]
        i++;
      }
      while(input[j] < pivotval && j > first) {//advances j if it is less than the pivot, stops when a value is greater
        j--; 
      }
      if (i < j && input[j] >= input[i]) {
        swap(input, i, j);
      } else {
        swap(input, pivotspot, j);
        return j;
      }
    }
  }
  void swap(int[] arr, int i, int j) {
    int placeholder = arr[i];
    arr[i] = arr[j];
    arr[j] = placeholder;
  }
  
  //sorts to descending order. 
  void insertionSort(int[] input) {
    for (int i = 1; i < input.length; i++) { //goes for each element starting from the second one
      int toinsert = input[i]; //we save the element we are working on
      for (int j = 0; j < i && input[i - j] > input[i - j - 1]; j++) { //runs to make space if needed, this space will eventually be at input[i - j - 1]
          input[i - j] = input[i - j - 1];
          input[i - j - 1] = toinsert;
      }
    }
  }
  
  void upgradedQuickSort(int[] input, int k) {
  
  }
  
  int select(int[] input, int k) {
    int n = input.length;
    PriorityQueue<Integer> queue =  new PriorityQueue<Integer>(n-k);
    for (int i = 0; i < n; i++) {
      queue.add(-1 * input[i]);
    }
    for (int j = k; j < k; j++) {
      queue.remove(queue.peek());
    }
    //System.out.println(Arrays.toString(queue.toArray()));
    int j = (int) queue.toArray()[0];
    return -1 * j;
  
  }
  
}