/*
*
* [CoffeeShop.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1, phase 3 - 4]
*
* PURPOSE: [This class contains the information and methods for a particular coffee shop]
*/
public class CoffeeShop{
    //Instance variables and variables
    private String nameShop; 
    private double markup; 
    private DrinkOrder[] drinkOrderArray;
    private static int totalOrder = 0;
    private double profit;
    private int pendingOrder = 0;
    
    //Constructor that contains the name of cafe and the variable of markup factor and the array of drink order which is initialized inside the contructor 
    public CoffeeShop(String nameShop, double markup){
        this.nameShop = nameShop;
        this.markup = markup;
        drinkOrderArray = new DrinkOrder[10];
    }
    
    //This method passes variable customer and drink to create the new drink order then add it into array of drink order
    public void newOrder(Customer customer, Drink drink){
        double purchase = drink.calculateCost()*markup; //calculate the amount of money for a drink
        DrinkOrder drinkOrder = new DrinkOrder(customer, drink, purchase); //create a new drink order
        drinkOrderArray[pendingOrder] = drinkOrder; //add drink to array
        totalOrder++; //when creating a new order, the total order is added by 1
        profit += drinkOrder.getProfit(); // the profit equals to total of purchase amount
        pendingOrder += 1; //the pending order is added by 1 when creating a new order
        CoffeeShop coffeeShop = new CoffeeShop(this.nameShop, this.markup); //make a new coffeeShop variable to add to addStore method
        customer.addStore(coffeeShop);  // when a customer order a drink at a coffee shop, the variable coffeeShop would be add to 
                                        // the array of list coffee shop that the customer has visited
    }

    //this method return the name of the coffee shop
    public String getName(){
        return this.nameShop; 
    }

    //this function passes variable customer, then find the information of customer in the array.
    // If the information is found, the position of the information in the array would be return.
    public int returnPosition(Customer customer){
        int pos = 0;
        for(int i = 0; i < drinkOrderArray.length; i++){
            if(drinkOrderArray[i] != null){ //reject null variable in the array
                if((drinkOrderArray[i].returnCustomer()).equals(customer) == true){
                  pos = i;
              } 
            }
        }
        return pos;
    }

    // this method is used to fill orders which passes the customer variable. 
    // If the information of order of a customer is not found in the array, the pendingOrder variable would not decrease.
    // If the information of the order is found, the pendingOrder variable would decrease by 1.
    public void orderFilled(Customer customer){       
       for(int j = 0; j < drinkOrderArray.length; j++){
          if(drinkOrderArray[j] != null){
            if( (customer.equals(drinkOrderArray[j].returnCustomer())) == false){
               pendingOrder -= 0;
            }
            else{
              int remain = drinkOrderArray.length - returnPosition(customer); 
              for(int i = 0; i < remain - 1; i++){
                drinkOrderArray[returnPosition(customer) + i] = drinkOrderArray[returnPosition(customer) + i + 1];
            }
               pendingOrder--;
         }
        }
       } 
    }

    /* this method displayes the pending orders. 
     * first, create the array to print which is initialized by the size of number of pending order which is taken by getNumOrderPending() method
     * the the information of order would be copied from the original array to the array used to print
     * if the number of pending order is 0, the method would print "none", else it would print the information of pending order in the new array
     */
    public void displayOrdersPending(){  
        DrinkOrder[] print = new DrinkOrder[getNumOrderPending()]; 
        int count = 0;
        for(int i = 0; i < drinkOrderArray.length; i++){
            if(drinkOrderArray[i] != null){
                print[count] = drinkOrderArray[i];
                count++;
            }
        }
        if(getNumOrderPending() == 0){
            System.out.println("none");
        }
        else{
            for(int i = 0; i < getNumOrderPending(); i++){
            System.out.println((i+1) + ": " + print[i]);
        }
      }
    }
    
    //this function return the profit
    public double getProfit(){
        return profit;
    }

    //this function return the number of pending orders
    public int getNumOrderPending(){
        return pendingOrder;
    }

    //this function return the total of all orders
    public static int getTotalOrders(){
        return totalOrder;
    }
}