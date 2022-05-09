import java.util.*;
public class BinarySearchTree {
  private Node root;
  
  private int sum = 0; //this is a helper field for the sum method
  
  private LinkedList<Node> treelist = new LinkedList<Node>(); //helper field for kthsmallest method
  //getter and setter method for root
  Node getroot() {
    return this.root;
  }
  
  void setroot(Node root) {
    this.root = root;
  }
  
  
  
  Node insert(Node root, int key) {
    if (root == null)
      return null;
    if (key > root.getkey()) {
      if (root.getright() == null){
        Node insert = new Node(key);
        insert.setparent(root);
        root.setright(insert);
        return insert;
      }
      return insert(root.getright(), key); //if right node exists and key is bigger than the root
    }
    else if (key < root.getkey()) {
      if (root.getleft() == null){
        Node insert = new Node(key);
        insert.setparent(root);
        root.setleft(insert);
        return insert;
      }
      return insert(root.getleft(), key);//if left node exists and key is smaller than the root
    }
    return root; // covers if they are equal
  }
  
  void inorder(Node root) {
     if (root != null) {
      inorder(root.getleft());
      System.out.print(root.getkey() + " ");
      inorder(root.getright());
    }
  }
  
  //This method makes the field sum equal to the sum of all keys in the tree.
  void addtosum(Node root) {
     if (root != null) {
      addtosum(root.getleft());
      sum = sum + root.getkey();
      addtosum(root.getright());
    }
  }
  
  int sum(Node root) {
    sum = 0;
    this.addtosum(root);
    return sum;
  }
  
  void treelist(Node root) {
    if (root != null) {
      treelist(root.getleft());
      treelist.add(root);
      treelist(root.getright());
    }
  }
  
 Node kthSmallest(Node root, int k) {
   treelist.clear();
   this.treelist(this.getroot());
   if (k > treelist.size())
     return treelist.getLast();
   return treelist.get(k-1);
  }

  Node search(Node root, int key) {
    if (root == null)
      return null;
    if (root.getkey() == key)
      return root;
    if (key > root.getkey())
      return search(root.getright(), key);
    else 
      return search(root.getleft(), key);
  }
  
  Node delete(Node root, int key) {
    if (this.search(root, key) == null)
      return null;
    Node tobedeleted = this.search(root, key);
    if (this.search(root, key).getright() == null && this.search(root, key).getleft() == null) { //no children
      if (this.search(root, key).getparent().getright() == tobedeleted) //if it is right of its parent
        this.search(root, key).getparent().setright(null);
      if (this.search(root, key).getparent().getleft() == tobedeleted) //if it is left of its parent
        this.search(root, key).getparent().setleft(null);
    }
    else if (this.search(root, key).getright() != null & this.search(root, key).getleft() != null) {//two children
      Node replacement = kthSmallest(this.search(root, key).getright(), 1);
      replacement.setparent(tobedeleted.getparent());
      replacement.setright(tobedeleted.getright());
      replacement.setleft(tobedeleted.getleft());
      replacement.getleft().setparent(replacement);
      replacement.getright().setparent(replacement);
      this.delete(replacement.getleft(), replacement.getkey());
    }  
    else { //one child
      if (this.search(root, key).getright() != null) {//if right child exists
        if(this.search(root, key).getparent().getright() == this.search(root, key)) { //if deleted node is right of its parent
          tobedeleted.getparent().setright(tobedeleted.getright());//sets parents child to tobedeleteds child
          tobedeleted.getright().setparent(tobedeleted.getparent());
        }
        if(this.search(root, key).getparent().getright() == this.search(root, key)) { //if deleted node is left of its parent
          tobedeleted.getparent().setleft(tobedeleted.getright());//sets parents child to tobedeleteds child
          tobedeleted.getright().setparent(tobedeleted.getparent());
        }
      }
      else {  //if left child exists
        tobedeleted = this.search(root, key);
        System.out.println(tobedeleted.getkey());
        if(tobedeleted.getparent().getright() == tobedeleted) { //if deleted node is right of its parent
          tobedeleted.getparent().setright(tobedeleted.getleft());//sets parents child to tobedeleteds child
          tobedeleted.getleft().setparent(tobedeleted.getparent());
        }
        if(tobedeleted.getparent().getleft() == tobedeleted) { //if deleted node is left of its parent
          tobedeleted.getparent().setleft(tobedeleted.getleft());//sets parents child to tobedeleteds child
          tobedeleted.getleft().setparent(tobedeleted.getparent());
        }
       }
     
      }
    return tobedeleted;
    }
    
      
}