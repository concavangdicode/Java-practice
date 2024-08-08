/*
*
* [Node.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: [Class Node]
*/
public class Node{
    private String personName; 
    private Node next; 

    public Node(String p, Node n){
        personName = p;
        next = n;
    }
    //Set next
    public void setNext(Node next){
        this.next = next;
    }
    //Get next
    public Node getNext(){
        return next;
    }
    //Return name
    public String getPersonName(){
        return personName;
    }

}