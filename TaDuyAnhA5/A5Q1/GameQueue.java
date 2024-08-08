/*
*
* [GameQueue.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: [Class GameQueue]
*/
public class GameQueue implements Queue{
    LinkedList list = new LinkedList();
    //add new person at the back of the list
    public void enqueue(String personName){
        list.addToBack(personName);
    }
    //check if the list is empty
    public boolean isEmpty(){
       return list.size() == 0;
    }
    //get the size of the list
    public int size(){
        return list.size();
    }
    //remove the first person of the list
     public String dequeue(){
        if(list.size() >= 0){
            return list.remove(0); //list index starts at 0
        }
        else{
            return "Unable to dequeue since list is empty";
        }
    }
    //show the information of first person in list without dequeue 
    public String peek(){
        return list.getHeadData();
    }
    //show information of all node in the list
    public void displayQueue(){  
        list.displayQueue();   
    }
}