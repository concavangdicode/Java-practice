/*
*
* [Drink.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1, phase 2]
*
* PURPOSE: [Create the information of the drink]
*/
public class Drink{
    //instance variables
    private String nameDrink; 
    private Ingredient[]ingredientArray = new Ingredient[50]; //50 is the random size for the array
    private int keepTrack = 0; // variable to keeptrack position of data in array

    //constuctor that passes parameter String name of the drink
    public Drink(String nameDrink){
        this.nameDrink = nameDrink;
    }
    //this function is used to add the name of ingredient to the array of ingredient
    public void addIngredient(Ingredient nameIngredient){
        ingredientArray[keepTrack] = nameIngredient; 
        keepTrack++;
    }

    //method that calculate the total cost of ingredient than return 
    public double calculateCost(){
        double cost = 0; 
        for(int i = 0; i < ingredientArray.length; i++){
            if(ingredientArray[i] != null){
                cost += ingredientArray[i].getCost();
            }
        }
        return cost;
    }
    //toString method that returns a String containing the drink's name and list of ingredients.
    public String toString(){
        String returnIngredient = "";
        for(int i = 0; i < ingredientArray.length; i++){
            if(ingredientArray[i] != null){
                returnIngredient +=  "\n" + "\t" + ingredientArray[i];
            }
        }
        return nameDrink + ", " + "Ingredients: " + returnIngredient + "\n";
    }
}