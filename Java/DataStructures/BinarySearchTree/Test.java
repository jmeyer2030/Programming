public class Test {
  public static void main(String args[]) {
   
   BinarySearchTree test = new BinarySearchTree();
   
   /*Below, the following tree is created.
    *    5
    *  3   7
    * 1 4 6 9
   */
   Node a = new Node(5);
   Node b = new Node(3);
   Node c = new Node(7);
   Node d = new Node(1);
   Node e = new Node(4);
   Node f = new Node(6);
   Node g = new Node(9);
   test.setroot(a);
   a.setleft(b);
   a.setright(c);
   b.setleft(d);
   b.setright(e);
   c.setleft(f);
   c.setright(g);
   System.out.println("search test below: expecting to get 1, 5, 7, true");
   System.out.println(test.search(test.getroot(), 1).getkey());
   System.out.println(test.search(test.getroot(), 5).getkey());
   System.out.println(test.search(test.getroot(), 7).getkey());
   System.out.println(test.search(test.getroot(), 314) == null);
   /*Below, the following tree is created.
    *           5
    *      3          7
    *    1   4     6     9
    *  0               8    11
    *                      10
    * 
    * to test if this worked, we test if things are where they should be by manually traversing the tree
   */
   
   
   System.out.println("Inorder traversal test: expecting 1 3 4 5 6 7 9");
   test.inorder(test.getroot());
   System.out.print("\n");
   
   
   test.insert(test.getroot(), 5);
   test.insert(test.getroot(), 11);
   test.insert(test.getroot(), 0);
   test.insert(test.getroot(), 10);
   test.insert(test.getroot(), 8);
   System.out.println("insert test below, we should get 10, 11, 8, and 0");
   System.out.println(test.getroot().getright().getright().getright().getleft().getkey()); // expecting 10
   System.out.println(test.getroot().getright().getright().getright().getkey()); // expecting 11
   System.out.println(test.getroot().getright().getright().getleft().getkey()); //expecting 8
   System.out.println(test.getroot().getleft().getleft().getleft().getkey()); // expecting 0
   
   //tests sum
   System.out.println("sum test result: expecting 64");
   System.out.println(test.sum(test.getroot()));
   //tests kthsmallest
   System.out.println("kthsmallest test result: 0, 11, 11");
   System.out.println(test.kthSmallest(test.getroot(), 1).getkey());
   System.out.println(test.kthSmallest(test.getroot(), 11).getkey());
   System.out.println(test.kthSmallest(test.getroot(), 100).getkey());
   
   System.out.println("delete test below: the 10 should be removed");
   test.inorder(test.getroot());
   test.delete(test.getroot(), 10);
   System.out.print("\n");
   test.inorder(test.getroot());
   //note that not all values work to be removed.
  }
}