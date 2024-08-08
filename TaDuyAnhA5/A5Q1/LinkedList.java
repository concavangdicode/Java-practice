/*
*
* [LinkedList.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: [Class LinkedList]
*/
public class LinkedList{
    private Node firstInLine; 
    
    public LinkedList(){
        firstInLine = null;
    }
    //Add new node to the back of linked list
    public void addToBack (String name){
        Node newNode = new Node(name, null);
        Node curr = firstInLine;

        if(curr == null){
            firstInLine = newNode;
        }
        else{
           addToBackRecursion(curr, newNode);
        }
    }
    //Helper method for addToBack
    private void addToBackRecursion(Node curr, Node newNode){
        if(curr.getNext() == null){
            curr.setNext(newNode);
        }
        else{
            addToBackRecursion(curr.getNext(), newNode);
        }
    }
    //Method that remove node at particular index
    //If index < 0 then print error message
    //If index = 0, set top as next node
    //If index > 0, find the node at that index, then remove it
    public String remove(int index){
        Node curr = firstInLine; 
        Node prev = firstInLine;
        
        if(index < 0){
            return "Invalid call to remove()";
        }
        if(index == 0){
          if(firstInLine != null){
            String name = firstInLine.getPersonName(); 
            firstInLine = firstInLine.getNext();
            return name + " has been removed from the list.";
          }
          else{
            return "Invalid call to remove()";
          }
        }
        else{
            return removeRecursion(index, 0, prev, curr);
        }      
    }
    //Helper method for remove method
    private String removeRecursion(int index, int count, Node prev, Node curr){
        
        if(curr.getNext() == null || prev.getNext() == null){
            return "Invalid call to remove()";
        }
        if(count + 1 == index){
            prev = curr; 
            curr = curr.getNext();
            String name = curr.getPersonName();
            prev.setNext(curr.getNext());
            return name + " has been removed from the list.";
           
        }
        else{
            prev = curr; 
            curr = curr.getNext();
           return removeRecursion(index, count+1, prev, curr);
        }
    }
    //Meethod return the size of linked list
    public int size(){
        int count = 0; 
        Node curr = firstInLine; 

        return sizeRecursion(curr, count);
    
    }
    //helper method for size method
    private int sizeRecursion(Node curr, int count){
        if(curr == null){
            return count; 
        }
        else{
            return sizeRecursion(curr.getNext(), count+1);
        }
    }
    //return the data at top node
    public String getHeadData(){
        if(firstInLine == null){
            return "There is no data";
        }
        else{
            return firstInLine.getPersonName();
        }
    }
    //Display all data in linked list
    public void displayQueue(){
        Node curr = firstInLine; 
        displayQueueRecursion(curr);
    }
    //helper method for displayQueue
    public void displayQueueRecursion(Node curr){
        if(curr != null){
            System.out.println(curr.getPersonName()); 
            displayQueueRecursion(curr.getNext());
        }
    }
    
}