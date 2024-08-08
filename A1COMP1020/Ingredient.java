/*
*
* [Ingredient.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1, phase 1]
*
* PURPOSE: [Create the information of ingredient]
*/
public class Ingredient{
    //instance variable
    private String name; 
    private int amount; 
    private double price; 
    
    //constructor that passes three above variables
    public Ingredient(String name, int amount, double price){
        this.name = name; 
        this.amount = amount; 
        this.price = price;
    }
    //return the cost of ingredients
    public double getCost(){
        return this.price*this.amount/1000;
    }
    // toString method return name, amount and price of ingredient
    public String toString(){
        return this.name + ", " + this.amount + " mls" + ", " + "$" + this.price + "/L";
    }
}