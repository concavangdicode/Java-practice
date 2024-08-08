/*
*
* [Genomic.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 2]
*
* PURPOSE: [Looking for the most common sequence in a genome]
*/
import java.util.ArrayList;

public class Genomic {
  //task 1 
  //The method passes a string and the given pattern to count how many times that pattern is found in a string 
  public static int patternCount(String ori, String pattern) {
    int count = 0;
    for(int i = 0; i <= ori.length() - pattern.length(); i++){
        if(ori.substring(i, i+pattern.length()).equals(pattern)){
            count++;
        }
    }
    return count;
  }
  //task 2
  //The method passes a string and the length of each pattern to find all pattern in a string
  //if the array is empty or the pattern is not found in the array, it would be added to the array
  public static ArrayList<Word> findAllPatterns(String ori, int k){
     ArrayList<Word>arrayWord = new ArrayList<Word>();
     
     for(int i = 0; i <= ori.length() - k; i++){   
        String subString = ori.substring(i, i+k);
        if(arrayWord.isEmpty()){
            int frequency = patternCount(ori, subString); // the frequency is found by patternCount method
            arrayWord.add(new Word(subString, frequency));
        }
        else {
            boolean duplicated = false;
            for(int j = 0; j < arrayWord.size(); j++){
            if(arrayWord.get(j).equals(subString) == true){
                duplicated = true;
            }
          }
            if(duplicated == false){
                int frequency = patternCount(ori, subString);
                arrayWord.add(new Word(subString,frequency));
            }
          }      
        }  
     return arrayWord;
  }
  //task 3
  //This method passes an ArrayList<Word> and sorts pattern by selection sort
  //A new array is created and copy all the data in the original array. 
  //The sorting process is manipulated in the copyArray
  public static ArrayList<Word> sortPatternsByFrequency(ArrayList<Word> words){
    ArrayList<Word>copyArray = new ArrayList<Word>();
    for(int i = 0; i < words.size(); i++){
        copyArray.add(words.get(i));
    }
    //sorting by frequency
    for(int i = 0; i < copyArray.size() - 1; i++){
        for(int j = i+1; j < copyArray.size(); j++){
            if(copyArray.get(j).getFrequency() > copyArray.get(i).getFrequency()){
                Word tmpFrq = copyArray.get(i);
                copyArray.set(i, copyArray.get(j));
                copyArray.set(j, tmpFrq);
            }
        }
    }
    //sorting by ascending alphabet order
    for(int i = 0; i < copyArray.size() - 1; i++){
        for(int j = i+1; j < copyArray.size(); j++){
            if(copyArray.get(i).getFrequency() == copyArray.get(j).getFrequency()){       
                  if((copyArray.get(i).getPattern()).compareTo((copyArray.get(j).getPattern())) > 0){
                    Word tmpChar = copyArray.get(i);
                    copyArray.set(i, copyArray.get(j));
                    copyArray.set(j, tmpChar);
                  }
                }
            }
        }
    return copyArray;
  }
  //task 4 
  //This method passes an ArrayList<Word> and finds the maximum frequency of the pattern in array list 
  public static int findTopFrequency(ArrayList<Word> words){
    int highest = words.get(0).getFrequency();
    for(int i = 1; i < words.size(); i++){
        if(words.get(i).getFrequency() > highest){
            highest = words.get(i).getFrequency();
        }
    }
    return highest;
  }
 
  //task 5  
  // The method passes a string and the length of each pattern to find the patterns have the highest frequency 
  public static String frequentWords(String ori, int k){
      String output = "";
      ArrayList<String>array = new ArrayList<String>();
      ArrayList<Word> arrayPattern = findAllPatterns(ori, k);
      ArrayList<Word> sortedArrayPattern = sortPatternsByFrequency(arrayPattern);
      int highestFrequency = findTopFrequency(sortedArrayPattern);
      for(int i = 0; i < sortedArrayPattern.size(); i++){
        if(sortedArrayPattern.get(i).getFrequency() == highestFrequency){
            array.add((sortedArrayPattern.get(i)).getPattern()); 
        }
      }
      output =  "[" + String.join(", ", array) + "]"; 
      return output;
  }
}
