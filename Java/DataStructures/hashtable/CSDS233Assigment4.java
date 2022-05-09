//This is the class used to make the hash table. It is very compartmentalized to better show the mechanics and reduce repeated code blocks.
import java.util.*;
class CSDS233Assignment4 {
  //this is the initial hash table
  LinkedList<CSDS233Assignment4.Element>[] hashtable = new LinkedList[5];
  
 //table load factor
  private double loadfactor;
  
  //table size
  private int tablesize = 5;
  
  //number of elements in the table
  private int tableload = 0;
  
//Constructor
  public CSDS233Assignment4() {
   //fill is a method that puts linked lists into the array
   this.fill();
  }
  
//subclass that stores the key and its frequency. "Element" refers to the structure that stores a key, and the frequency associated with that key.
  class Element extends CSDS233Assignment4 {
    private String key;
    private int frequency;
    
    //increases frequency by one if duplicates are added.
    void incrementFrequency() {
      this.frequency = this.frequency + 1;
    }
    
    //sets the key
    void setKey(String key) {
      this.key = key;
    }
    
    //returns the key
    String getKey() {
      return key;
    }
    
    //returns the frequency
    int getFrequency() {
      return frequency;
    }
    
    //sets the frequency
    void setFrequency(int frequency) {
      this.frequency = frequency;
    }
    
    //constructor
    public Element(String key) {
      this.setFrequency(1);
      this.setKey(key);
    }
  }
  
  //wordcount method, goes through the array created with split and inserts it into the hash table. 
  String wordCount(String input) {
    String[] wordarray = input.split("\\P{Alpha}+");
    StringBuilder bldr = new StringBuilder();
    if (wordarray.length > 0) {
      for (int i = 0; i < wordarray.length; i++) {
        if (wordarray[i].toString().equals("") != true)
          //note that insert calls the rehashing
          insert(wordarray[i].toString());
      }
    }
    for (int i = 0; i < tablesize; i++) {
     //loops through elements in the linkedlist and adds them to the hash table
      try {
      int j = 0;
      while (hashtable[i].get(j) != null) {
        bldr.append("\"" + hashtable[i].get(j).getKey() + "\"" + "x" + hashtable[i].get(j).getFrequency() + " ");
        j++;
      }
      } catch(Exception e) {
      }
    }
    return bldr.toString();
  }
  
  
  //fills the array with linked lists. I was having issues constructing an array list that worked, so this was my solution
  void fill(){
    for (int i = 0; i < hashtable.length; i++) {
       hashtable[i] = new LinkedList();
    }
  }
  
  //refreshes the table loadfactor after an element is added. If the load factor is one, it rehashes.
  //note that the table load counts only new elements, not repeats.
  void loadRefresh() {
    tableload++;
    loadfactor = tableload/tablesize;
    if (loadfactor == 1)
      this.rehash();
  }
  
  //searches for a key, returns the element
  Element search(String key) {
    try {
      hashtable[Math.abs(key.hashCode()) % tablesize].getFirst();
    }
    catch(Exception e) {
      return null;
    }
    int i = 0;
    try {
    while(hashtable[Math.abs(key.hashCode()) % tablesize].get(i) != null) {
      if (hashtable[Math.abs(key.hashCode()) % tablesize].get(i).getKey().equals(key))
        return hashtable[Math.abs(key.hashCode()) % tablesize].get(i);
      i++;
    }
    }catch(Exception e) {
    }
    return null;
  }
  
  //insert checks if the key is already there, if it is, frequency is incremented. Otherwise the new element and is added.
  void insert(String s) {
    if (this.search(s) == null){
      hashtable[Math.abs(s.hashCode()) % tablesize].add(new Element(s));
      this.loadRefresh();
    }
    else if(this.search(s).getKey().equals(s)) {
      this.search(s).incrementFrequency();
    }  
  }
  
//creates a hash table twice the size as the old one, and adds all the elements of the old table to it. This is only run if the load factor becomes 1.
  void rehash() {
   //creates a copy of the old hashtable so we can make a bigger one and still use the insert method.
   LinkedList<CSDS233Assignment4.Element>[] oldhashtable = hashtable;
   tablesize = tablesize * 2;
   //creates new 2x sized table
   LinkedList<CSDS233Assignment4.Element>[] newhashtable = new LinkedList[tablesize];
   hashtable = newhashtable;
   this.fill();
   //iterates through small table
   for (int i = 0; i < tablesize / 2; i++) {
     //loops through elements in the linkedlist and adds them to the hash table. Error handling is needed in case the linked list is empty.
     try {
     int j = 0;
     while (oldhashtable[i].get(j) != null) {
       this.insert(oldhashtable[i].get(j).getKey());
       j++;
     }
     } catch(Exception e) {
     }
     }
   }
}
