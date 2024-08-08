/*
*
* [Item.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: [Create an item]
*/
public class Item{
    String name; 
    int quantity; 
    //Constructor of Item which includes name and quantity
    public Item(String name, int quantity){
        this.name = name; 
        this.quantity = quantity;
    }

    //return the name of item
    public String getName(){
        return name;
    }

    //return the quantity of item
    public int getQuantity(){
        return quantity;
    }

    //increase the quantity by the given amount
    public void increaseQuantity(int increaseAmount){
        quantity += increaseAmount;
    }

    //decrease the quantity by given amoount
    public void decreaseQuantity(int decreaseAmount){
        quantity -= decreaseAmount;
    }
    public String toString(){
        return quantity + " - " + name; 
    }
}