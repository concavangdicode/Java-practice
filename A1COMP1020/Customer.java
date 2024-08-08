/*
*
* [Customer.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1, phase 1 - 4]
*
* PURPOSE: [Create the information of customer]
*/
public class Customer{
    // instance variables
    private String firstName; 
    private String lastName; 
    private CoffeeShop[] listCoffeeShops; // the array that contains a list of coffee shop that the customer has visited
    private int keepTrack = 0; // variable to keep track the position in the array of coffee shop that the customer visited

    //constructor that pass String firstName and String lastName, and initialized the array of list of cafes
    public Customer(String firstName, String lastName){
        this.firstName = firstName; 
        this.lastName = lastName;
        listCoffeeShops = new CoffeeShop[3]; //there are only 3 cafes
    }
    //the function compares the first name and last name. if the first name and last name are both valid the function returns true, else it returns false
    public boolean equals (Customer other){
        boolean equals = false;
        if (this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName)){
            equals = true;
        }
        return equals;
    }
    /*
     * the function passes the coffeeShop variable to add the information of the coffee shop to the array of coffee shop. 
     * first it checks if the array is empty or not. If the array is empty, the information of the coffee shop would be added to the array
     * If the array is not empty, it would check through the array to make sure there is no duplication
     */
    public void addStore(CoffeeShop coffeeShop){
        boolean empty = true;
        boolean duplicated = false;

        // the for loop is used to check whether the array is empty. If the boolean empty is false, then the for loop would break
        for(int i = 0; i < listCoffeeShops.length && empty == true; i++){ 
            if(listCoffeeShops[i] == null){
                empty = true;
            }
            else empty = false;
        }
        //if the array is empty, than add the coffeeShop parameter to the array
        if(empty == true){
            listCoffeeShops[keepTrack] = coffeeShop;
            keepTrack++;
        }
        // if the array is not empty, first pass the parameter through the array to check duplication. If it is not duplicated, then add to the array
        else{
            for(int i = 0; i < listCoffeeShops.length && duplicated == false; i++){
                if(listCoffeeShops[i] != null){
                    if((coffeeShop.getName().equals(listCoffeeShops[i].getName()))){
                    duplicated = true;
                }
              }        
            }
            if(duplicated == false){
                 listCoffeeShops[keepTrack] = coffeeShop;
                 keepTrack++;
            }
         }           
    }

    //this function return the name of coffee shop that the customer has visited
    public void displayStoresVisited(){
        for(int i = 0; i < listCoffeeShops.length; i++){
            if(listCoffeeShops[i] != null){
                System.out.println(listCoffeeShops[i].getName());
            }
        }
    }

    //return the cafe shop, which customer visited, has the shortest waitlist
    public CoffeeShop getShortestWait(){
        CoffeeShop shortestWait = null; //the variable used to assign the coffee shop has the shortest waitlist
        int realLength = 0;
        //first find new length for the new array that equals to the number of cafe shops in the listCoffeeShops array
        for(int i = 0; i < listCoffeeShops.length; i++){
            if(listCoffeeShops[i] != null){
                realLength++;
            }
        }
        //make a new copy array that does not include null variable in order to conduct comparison
        CoffeeShop[] compareArray = new CoffeeShop[realLength];
        int count = 0; //integer to keep track the position 
        //copy the data from old array to new array
        for(int i = 0; i < listCoffeeShops.length; i++){
            if(listCoffeeShops[i] != null){
                compareArray[count] = listCoffeeShops[i];
                count++;
            }
        }
        //method to find the shortest waitlist
         int shortest = compareArray[0].getNumOrderPending(); 
         int keepTrackPosition = 0;
         //if length of array equals to 1, than assigns the shortestWait variable equals to the first index of array
         if(realLength == 1){
             shortestWait = compareArray[0];
         }
         //if not make the comparison in for loop to find 
         else {
            for(int i = 1; i < compareArray.length; i++){
                if(shortest > compareArray[i].getNumOrderPending()){
                    shortest = compareArray[i].getNumOrderPending(); 
                    keepTrackPosition = i;
                }
            }
            shortestWait = compareArray[keepTrackPosition];
         }
         return shortestWait;
    }

    //toString method returns a String containing the customer's last and first names
    public String toString(){
        return lastName + ", " + firstName;
    }
}