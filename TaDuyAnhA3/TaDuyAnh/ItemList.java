/*
*
* [ItemList.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: [Create an item list]
*/
import java.util.ArrayList;

public class ItemList{
    private ArrayList<Item> arrayItem = new ArrayList<Item>(); 
    private int keepTrackPos;

    //this method passes an item and find if the item is in the array of item.
    // if the item is found, it would be returned and its position would be assigned to 'keepTrackPos' variable which is used in 'decrease' method. 
    //If it is not found, the method would return null
    public Item findItem(String item){
        Item itemFound = null; 
        for(int i = 0; i < arrayItem.size(); i++){
            if((arrayItem.get(i).getName()).equals(item)){
                itemFound = arrayItem.get(i);
                keepTrackPos = i;
            }
        }
        return itemFound;
    }
    
    //This method passes the name and quantity of an item. 
    //If 'findItem' method returns null, which means that item is not in list. Then the item would be added to the arrayItem
    //If 'findItem' method returns the item, which means that item is already in the list so the quantity of item would be increase by 'increaseQuantity' method
    public void increase(String name, int quantity){
        if(findItem(name) == null){
            Item newItem = new Item(name, quantity); 
            arrayItem.add(newItem);
        }
        else{
            Item itemFound = findItem(name);
            itemFound.increaseQuantity(quantity);
        }
    } 

    //This method passes the name and quantity of an item. 
    //If 'findItem' method returns null, which means that item is not in list. Then the error message would be printed
    //If 'findItem' method returns the item, which means that item is already in the list so the quantity of item would be decrease by 'decreaseQuantity' method. 
    //However, if the decreased amount is larger than the current quantity, the error message would also be printed.
    //After decreasing quantity, if the quantity less or equal than 0, the item would be removed from the array. The removed item's position is the "keepTrackPos"
    public void decrease(String name, int quantity){
        if(findItem(name) == null){
            System.out.println("Warning: decreasing quantity of " + name + " by " + quantity + " but not in list");
        }
        else {
            if(findItem(name).getQuantity() < quantity){
                int currQuantity = findItem(name).getQuantity();
                System.out.println("Warning: decreasing quantity of " + name + " by " + quantity + " but only " + currQuantity +" in list");
                findItem(name).decreaseQuantity(quantity);
            }
            else{
                findItem(name).decreaseQuantity(quantity);
            }
            if(findItem(name).getQuantity() <= 0){
              arrayItem.remove(keepTrackPos);
            }
        }
        
    }
    //this method print the array of list following descend ing order of quantity and ascending order of alphabet
    public void print(){
        for(int i = 0; i < arrayItem.size()-1; i++){
            //sorting the list by descending order of quantity
           if(arrayItem.get(i).getQuantity() < arrayItem.get(i+1).getQuantity()){
             Item copyItem = arrayItem.get(i);
             arrayItem.set(i, arrayItem.get(i+1));
             arrayItem.set(i+1, copyItem);
           }
           else{
            //sorting the list by ascending order of alphabet
             if(arrayItem.get(i).getName().compareTo(arrayItem.get(i+1).getName()) > 0){
                 Item copyItem = arrayItem.get(i);
                 arrayItem.set(i, arrayItem.get(i+1));
                 arrayItem.set(i+1, copyItem);
             }
           }
        }
        //print the list
       arrayItem.forEach(item -> System.out.println(item));
    }

}
