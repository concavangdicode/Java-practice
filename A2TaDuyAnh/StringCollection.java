// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// NAME : Duy Anh Ta
// STUDENT NUMBER : 7967807
// COURSE : COMP 2140
// ASSIGNMENT : assignment 2
// QUESTION : question 1
//
// REMARKS : To design and implement an abstract data type, based on a list, that provides a specified set of features.
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

import java.util.Stack;

public class StringCollection{
    
    private LinkedList stringCollection; 
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: StringCollection
    //
    // PURPOSE : A constructor that creates a new, empty StringCollection
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public StringCollection(){
        stringCollection = new LinkedList();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: StringCollection
    //
    // PURPOSE : Another constructor that takes a String array argument and creates a new StringCollection containing the elements of that array.
    // PARAMETERS : array of string
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public StringCollection(String[]arrayString){
        stringCollection = new LinkedList();
        stringCollection.arrayToLinkedList(arrayString);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: empty
    //
    // PURPOSE : A method that removes the entire contents of the StringCollection, making it empty.
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void empty(){
        stringCollection.empty();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: add
    //
    // PURPOSE : A method that takes a string argument and adds it to the StringCollection
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void add(String string){
        stringCollection.add(string);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: toStringAscending
    //
    // PURPOSE : A method that returns the contents of the StringCollection, in lexicographical order, as a single String.
    // PARAMETERS : No
    // RETURN : An ascending order string of contents of the StringCollection
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public String toStringAscending(){      
        String ascending = "";
        stringCollection.sortAscending();
        Node top = stringCollection.getTop();
        Node curr = top;
        while(curr != null){
            ascending += curr.getData() + " "; 
            curr = curr.getNext();
        }      
        return ascending;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: toStringDescending
    //
    // PURPOSE : A method that returns the contents of the StringCollection, in lexicographical order, as a single String.
    // PARAMETERS : No
    // RETURN : An descending order string of contents of the StringCollection
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public String toStringDescending(){      
        String descending = "";
        stringCollection.sortDescending();
        Node top = stringCollection.getTop(); 
        Node curr = top;
        while(curr != null){
            descending += curr.getData() + " "; 
            curr = curr.getNext();
        }      
        return descending;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: removeOne
    //
    // PURPOSE : A method that takes a String argument and removes one occurrence of it from the StringCollection.
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void removeOne(String string){
        stringCollection.removeOne(string);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: print
    //
    // PURPOSE : A method that print the content of StringCollection
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void print(){
        stringCollection.print();
        System.out.println();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: removeAll
    //
    // PURPOSE : A method that takes a String argument and removes all occurrence of it from the StringCollection.
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void removeAll(String string){
        stringCollection.removeAll(string);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: merge
    //
    // PURPOSE : A method that takes a StringCollection argument and adds all the Strings it contains to the current StringCollection.
    // PARAMETERS : a StringCollection argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void merge(StringCollection newCollection){
       stringCollection.merge(newCollection.stringCollection);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: extract
    //
    // PURPOSE : A method that takes a StringCollection argument and, for each of the Strings it contains, removes an occurrence of it from the current StringCollection.
    // PARAMETERS : a StringCollection argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void extract(StringCollection newCollection){
        stringCollection.extract(newCollection.stringCollection);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getLength
    //
    // PURPOSE : A method that returns the number of Strings in the collection.
    // PARAMETERS : No
    // RETURN : length of number of Strings in the collection
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public int getLength(){
        return stringCollection.getLength();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getTop
    //
    // PURPOSE : A method that returns the top Node of the StringCollection
    // PARAMETERS : No
    // RETURN : the top Node of the StringCollection
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node getTop(){
        return stringCollection.getTop();
    }
}

class LinkedList{
    
    private Node top; 

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: LinkedList
    //
    // PURPOSE : Create constructor for a linked list
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public LinkedList(){
        top = null;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: print
    //
    // PURPOSE : A method that print the content of the linked list
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void print(){
        Node curr = top;
        if(top == null){
            System.out.print("The linked list is empty");
        }
        while (curr != null) {
            System.out.print(curr.getData() + " "); 
            curr = curr.getNext();
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: add
    //
    // PURPOSE : A method that takes a string argument and adds it to the linked list
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void add(String string){
        Node newNode = new Node(string, null);
        if(top == null){
            top = newNode; 
        }
        else{
           Node curr = top, prev = null;
           while(curr != null && curr.getData().compareToIgnoreCase(string) < 0 ){
              prev = curr; 
              curr = curr.getNext(); 
           }
           if(curr == null){ //add at the end of linked list
              prev.setNext(newNode);
           }
           else{
              if(prev != null){ //add at the middle of linked list
                newNode.setNext(curr);
                prev.setNext(newNode);
              }
              else{ //add at the top of linked list
                newNode.setNext(curr);
                top = newNode; 
              }
           }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: arrayToLinkedList
    //
    // PURPOSE : Another method that takes a String array argument and creates a new linked list containing the elements of that array.
    // PARAMETERS : array of string
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void arrayToLinkedList(String[]array){
        Node curr = null;
        for(int i = 0; i < array.length; i++){
            Node newNode = new Node(array[i], null);
            if(top == null){
                top = newNode;
                curr = top; 
            }
            else{
               curr.setNext(newNode);
               curr = curr.getNext();
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: sortDescending
    //
    // PURPOSE : call the head to sort the linked list in the descending order
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void sortDescending () {
        this.top = mergeSortDescending(top);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: mergeSortDescending
    //
    // PURPOSE : a method that sort linked list in descending order
    // PARAMETERS : a node top
    // RETURN : a node head after sorting
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node mergeSortDescending(Node top){
        if(top == null || top.getNext() == null){
            return top;
          }
          else{
            Node mid = findMid(top); 
            Node nextMid = mid.getNext(); 
            mid.setNext(null);
   
            Node left = mergeSortDescending(top); 
            Node right = mergeSortDescending(nextMid); 
            Node sorting = mergeDescending(left, right);
            return sorting;
          }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: mergeDescending
    //
    // PURPOSE : merge two linked lists in descending order
    // PARAMETERS : 2 node top
    // RETURN : a node head after merging
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private Node mergeDescending(Node node1, Node node2){
        Node result = null;
        if(node1 == null){
            return node2; 
        }
        if(node2 == null){
            return node1;  
        }
        if(node1.getData().compareToIgnoreCase(node2.getData()) > 0){
            result = node1; 
            result.setNext(mergeDescending(node1.getNext(), node2));
        }
        else{
            result = node2; 
            result.setNext(mergeDescending(node1, node2.getNext()));
        }
        return result;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: sortAscending
    //
    // PURPOSE : call the head to sort the linked list in the ascending order
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void sortAscending () {
        this.top = mergeSortAscending(top);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: mergeSortAscending
    //
    // PURPOSE : a method that sort linked list in ascending order
    // PARAMETERS : a node top
    // RETURN : a node head after sorting
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node mergeSortAscending(Node top){
       if(top == null || top.getNext() == null){
         return top;
       }
       else{
         Node mid = findMid(top); 
         Node nextMid = mid.getNext(); 
         mid.setNext(null);

         Node left = mergeSortAscending(top); 
         Node right = mergeSortAscending(nextMid); 
         Node sorting = mergeAscending(left, right);
         return sorting;
       }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: mergeAscending
    //
    // PURPOSE : merge two linked lists in ascending order
    // PARAMETERS : 2 node top
    // RETURN : a node head after merging
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private Node mergeAscending(Node node1, Node node2){
        Node result = null;
        if(node1 == null){
            return node2; 
        }
        if(node2 == null){
            return node1;  
        }
        if(node1.getData().compareToIgnoreCase(node2.getData()) <= 0){
            result = node1; 
            result.setNext(mergeAscending(node1.getNext(), node2));
        }
        else{
            result = node2; 
            result.setNext(mergeAscending(node1, node2.getNext()));
        }
        return result;
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: findMid
    //
    // PURPOSE : find the middle node of linked list
    // PARAMETERS : node top
    // RETURN : a node at the middle
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private Node findMid (Node top){
       if(top == null){
         return top;
       }
       else{
         Node slow = top, fast = top; 
         while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext(); 
            fast = fast.getNext().getNext(); 
         }
         return slow;
       }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getTop
    //
    // PURPOSE : return node top
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node getTop(){
        return top;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: empty
    //
    // PURPOSE : change node top to null
    // PARAMETERS : No
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void empty(){
        top = null; 
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: removeOne
    //
    // PURPOSE : A method that takes a String argument and removes one occurrence of it from the linked list
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void removeOne(String string){
        Node curr = top, prev = null; 
        while(curr != null && !(curr.getData().equals(string))){
            prev = curr; 
            curr = curr.getNext();
        }
        if(curr != null){
            if(prev != null && curr.getData().equals(string)){ //remove at middle and last
                prev.setNext(curr.getNext());
            }
            else if(prev == null && curr.getData().equals(string)){ //remove at top
                top = top.getNext();
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: removeAll
    //
    // PURPOSE : A method that takes a String argument and removes all occurrence of it from the linked list.
    // PARAMETERS : a String argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void removeAll(String string){
        Node curr = top, prev = null; 
        while(curr != null){
            if(curr.getData().equals(string) && prev != null){
                curr = curr.getNext();
                prev.setNext(curr);
            }
            else if(curr.getData().equals(string) && prev == null){
               top = top.getNext();
               curr = top;
            }
            else{
                prev = curr; 
                curr = curr.getNext();    
            }       
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: merge
    //
    // PURPOSE : A method that takes a linked list argument and adds all the Strings it contains to the current linked list.
    // PARAMETERS : a linked list argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void merge(LinkedList newList){
        top = mergeSortAscending(top);
        Node curr1 = top; 
        newList.top = newList.mergeSortAscending(newList.top); 
        Node curr2 = newList.top;
        Node prev = null;
      
       while (curr1 != null && curr2 != null) {
          if(curr1.getData().compareToIgnoreCase(curr2.getData()) < 0){
             prev = curr1; 
             curr1 = curr1.getNext();
          }
          else{
             Node copy = new Node(curr2.getData(), curr1);
             if(prev == null){
                top = copy;
                prev = top;
             }
             else{
                prev.setNext(copy);
                prev = prev.getNext();
             }
             curr2 = curr2.getNext();
          }
       }
       if(curr2 != null){
          prev.setNext(curr2);
       }
  }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: extract
    //
    // PURPOSE : A method that takes a lineked list argument and, for each of the Strings it contains, removes an occurrence of it from the current linked list.
    // PARAMETERS : a linked list argument
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void extract(LinkedList newList){
        top = mergeSortAscending(top);
        Node curr1 = top; 
        newList.top = newList.mergeSortAscending(newList.top); 
        Node curr2 = newList.top;
        Node prev = null;
        while(curr2 != null && curr1 != null){
            if(curr1.getData().compareToIgnoreCase(curr2.getData()) < 0){
                prev = curr1;
                curr1 = curr1.getNext(); 
            }
            else if(curr1.getData().compareToIgnoreCase(curr2.getData()) == 0){
                if(prev == null){
                    top = top.getNext(); 
                    curr1 = top;
                }
                else{
                    curr1 = curr1.getNext();
                    prev.setNext(curr1);
                }
                curr2 = curr2.getNext();
            }
            else{
                curr2 = curr2.getNext();
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getLength
    //
    // PURPOSE : return length of content in linked list
    // PARAMETERS : No
    // RETURN : length of content in linked list
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public int getLength(){
        int length = 0; 
        if(top == null){
            return length;
        }
        else{
            Node curr = top; 
            while (curr != null) {
                length += 1; 
                curr = curr.getNext();
            }
            return length;
        }
    }
}
class Node{
    private String data; 
    private Node next;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: Node
    //
    // PURPOSE : constructor for Node
    // PARAMETERS : String data and Node next
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node(String data, Node next){
        this.data = data; 
        this.next = next; 
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getNext
    //
    // PURPOSE : return node next of the node
    // PARAMETERS : No
    // RETURN : node next of the node
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Node getNext(){
        return next;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: setNext
    //
    // PURPOSE : link the node next of the current node to another node
    // PARAMETERS : a Node
    // RETURN : No
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void setNext(Node node){
        this.next = node;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: getData
    //
    // PURPOSE : return the data of the node
    // PARAMETERS : No
    // RETURN : string data
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public String getData(){
        return data;
    }
}

/*
 * uncomment to run main method
 * class Main{
    public static void main(String[]args){
        String[]array = {"bee", "bee", "doe","straw", "and", "bee", "bee", "all", "bee", "string","bee"};
        StringCollection collection1 = new StringCollection(array);
        StringCollection collection2 = new StringCollection();
        StringCollection collection3 = new StringCollection(); 
        collection2.add("string");
        collection2.add("add");
        collection2.add("screw");
        collection2.add("screw");
        collection2.add("bee");
        collection2.add(" ");
        collection2.add(" ");
        collection2.add("//s++");
        collection2.add("Difference");
        collection2.add("Espérer");
        collection2.add("abc");
        collection1.print();
        collection2.print();
        System.out.println(collection1.getLength());
        System.out.println(collection2.getLength());
        collection1.removeOne("and");
        collection1.removeAll("bee");
        collection2.removeAll("screw");
        collection2.removeOne(" ");
        collection1.print();
        collection2.print();
        System.out.println();
       // collection2.removeOne("string");
        System.out.println(collection2.toStringDescending());
        System.out.println(collection2.toStringAscending());
        System.out.println(collection1.toStringDescending());
        System.out.println(collection1.toStringAscending());
        System.out.println(collection1.getTop().getData());
        System.out.println(collection2.getTop().getData());
        System.out.println();

        collection2.merge(collection1);
        //collection2.removeAll("string");
        collection2.print();
        collection1.print();
        System.out.println(collection1.getLength());
        System.out.println(collection2.getLength());
        System.out.println();

        System.out.println(collection1.toStringDescending());
        System.out.println(collection2.toStringAscending());
        System.out.println(collection2.getTop().getData());
        System.out.println(collection2.toStringDescending());
        System.out.println(collection1.getTop().getData());
        System.out.println(collection2.getTop().getData());
        System.out.println();

        collection2.extract(collection1);
        collection2.print();
        collection1.print();
        System.out.println(collection1.getLength());
        System.out.println(collection2.getLength());
        System.out.println();

        collection2.removeOne("string");
        collection2.removeAll("bee");
        collection2.removeAll("screw");
        collection2.print();
        collection1.removeAll("all");
        collection1.removeAll("and");
        collection1.removeOne("bee");
        collection1.print();
        System.out.println(collection2.getLength());
        System.out.println(collection1.getLength());
        System.out.println();

        collection1.empty();
        collection1.print();
    }
}
 */
