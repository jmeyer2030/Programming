import java.util.Arrays;
class TestSort {
  public static void main(String[] args) {
    Sort test = new Sort();
    
    //insertionsort
    System.out.println("\n" + "Testing insertion Sort");
    int[] testArray = {1,2,3,4,5};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.insertionSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {5,4,3,2,1};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.insertionSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {4,4,4,6,4,2,6,7,8,4,4,3,2,1,7,7};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.insertionSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    
    //quicksort
    System.out.println("\n" + "Testing quick Sort");
    testArray = new int[] {1,2,3,4,5};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.quickSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {5,4,3,2,1};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.quickSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {4,4,4,6,4,2,6,7,8,4,4,3,2,1,7,7};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.quickSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    
    //merge sort
    System.out.println("\n" + "Testing merge sort");
    testArray = new int[] {1,2,3,4,5};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.mergeSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {5,4,3,2,1};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.mergeSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));
    testArray = new int[] {4,4,4,6,4,2,6,7,8,4,4,3,2,1,7,7};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    test.mergeSort(testArray);
    System.out.println("The Sorted array is: " + Arrays.toString(testArray));

   //select
    System.out.println("\n" + "Testing select");
    testArray = new int[] {1,2,3,4,5};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    System.out.println("k = 4, the kth highest element is:" + test.select(testArray, 4));
    testArray = new int[] {4,4,4,6,4,2,6,7,8,4,4,3,2,1,7,7};
    System.out.println("The initial array is:" + Arrays.toString(testArray));
    System.out.println("k = 3, the kth highest element is:" + test.select(testArray, 3));
  }
}