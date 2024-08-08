/*
*
* [TaDuyAnhA2Q1.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 2]
* QUESTION: [question 1]
*
* PURPOSE: [Create "Map class"]
*/
import java.io.*;
import java.util.ArrayList;
public class Map{
    private String name; 
    private int year; 
    private String fileName; 
    private ArrayList<String> code = new ArrayList<String>(); // array list to store the secret in file text
    private String secret = "";
    private boolean isEncrypted = true;
    private boolean isAdded = false;

    //Constructor for the Map object
    public Map(String name, int year, String fileName){
        this.name = name; 
        this.fileName = fileName; 
        this.year = year;
    }
    //return the name
    public String getName(){
        return name;
    }
    //return file name
    public String getFile(){
        return fileName;
    }
    //add each line of file text of secret to the array
    public void addToArray(String lineCode){
        if(isAdded == false){
            code.add(lineCode);
        }   
    }
    // when adding content of file text to the array is finished, change the boolean isAdded to true in order to cease the duplication in case the adding method is called more than one
    public boolean finishAdd(){
        return isAdded = true;
    }
    //print the content of ArrayList<String> code
    public void printCode(){
        for(int i = 0; i < code.size(); i++){
            if(code.get(i) != null){
              System.out.println(code.get(i));
            }
        }
    }
    //return the ArrayList<String> code
    public ArrayList<String> getArray(){
        return code;
    }
    //return boolean isEncrypted
    public boolean isEncrypted(){
        return this.isEncrypted;
    }
    //change boolean isEncrypted to false
    public void decrypted(){
        this.isEncrypted = false; 
    }
    //change boolean isEncrypted to true and boolean isAdded to false
    public void reset(){
        this.isEncrypted = true;
        this.isAdded = false;
    }
    //pass the a string to set the parameter secret of Map object
    public void setSecret(String secret){
        this.secret = secret;
    }
    //return secret
    public String getSecret(){
        return secret;
    }
    public String toString(){
        return "Name: " + getName() + " -" + " Year: "+ year + " -" + " File Name: " + getFile() + " -" + " Is encrypted?: " + isEncrypted() + " -" + " Secret: " + getSecret();
    }

}