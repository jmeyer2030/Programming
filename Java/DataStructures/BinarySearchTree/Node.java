public class Node {
 private Node parent;
 private Node left;
 private Node right;
 private int key;
 
 public Node(int key) {
   this.setkey(key);
 }
 
 //getter and setter methods
 Node getparent() {
   return this.parent;
 }
 Node getleft() {
   return this.left;
 }
 
 Node getright() {
   return this.right;
 }
 
 int getkey() {
   return key;
 }
 
 void setparent(Node parent) {
   this.parent = parent;
 }
 
 void setleft(Node left) {
   this.left = left;
 }
 
 void setright(Node right) {
   this.right = right;
 }
 
 void setkey(int key) {
   this.key = key;
 }
}