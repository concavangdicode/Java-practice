/*
*
* [DrinkOrder.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1, phase 2]
*
* PURPOSE: [Create the information of the drink order]
*/
public class DrinkOrder{
    //instance variables
    private Customer customer; 
    private Drink drink; 
    private double chargeAmount; 

    //constructor that passes 3 instance variables
    public DrinkOrder(Customer customer, Drink drink, double chargeAmount){
        this.customer = customer; 
        this.drink = drink; 
        this.chargeAmount = chargeAmount; 
    }

    //this boolean method pass the customer variable to check if the name of the customer is matched.
    //If the name is matched, it would return true, else it would return to false.
    public boolean belongsTo (Customer customer){
        boolean belongsTo = false;
        if(this.customer.equals(customer)){
            belongsTo = true;
        }
        return belongsTo;
    }
    
    //this function return the variable customer
    public Customer returnCustomer(){
        return customer;
    }
    
    //this function return the profit which is calculated by the charge amount minus to the cost of making the drink
    public double getProfit(){
        return chargeAmount - drink.calculateCost();
    }

    //return a String containing the customer, amount charged, and drink information
    public String toString(){
        return customer + ", " + "$" + chargeAmount + ": " + drink;
    }
}