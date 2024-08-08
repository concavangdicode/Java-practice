/*
*
* [TaDuyAnhA4Q3]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 4]
* QUESTION: [question 3]
*
* PURPOSE: [Recursion to find The Longest Duplicate Subsequence]
*/
import java.util.Arrays;

public class TaDuyAnhA4Q3 {
  public static void main(String[] args) {
    int[] array;
    
    array = new int[] { 1, 5, 3, 7, 9, 1, 3, 7, 5, 3, 7, 1, 9 };
    verify(3, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 3, 4, 1, 2, 4, 1, 2, 4, 3 };
    verify(4, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    verify(0, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9, 10 };
    verify(1, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4, 5, 6, 1, 2, 1, 2, 3, 4, 5, 1, 2, 3, 4 };
    verify(5, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
    verify(11, longestDuplicateSubsequence(array), Arrays.toString(array));

    array = new int[] { 1, 1, 1, 1, 1 };
    verify(4, longestDuplicateSubsequence(array), Arrays.toString(array));
    
    System.out.println("\n*** End of program. ***");
  }
  
  public static void verify(int expected, int result, String action) {
    if (expected == result) {
      System.out.printf("Test succeeded: %s\n", action);
    } else {
      System.out.printf("Test FAILED (expected %s, got %s): %s\n", expected, result, action);
    }
  }

  // Do not change the functions above here
  // ========================================================================
  // Modify/rewrite the function below, adding any other necessary functions

  public static int longestDuplicateSubsequence(int[] array) {
    return longestDuplicatedSubsequenceRecursion(array, 0, 0, 0);
  }

  public static int longestDuplicatedSubsequenceRecursion(int[]array, int pos1, int pos2, int currLength){
    int length = 0; 
    //base case
    if(pos1 == array.length || pos2 == array.length){
       return currLength;
    }
    /*
     * for(int pos1 = 0; pos1 < array.length; pos1++) (1) {
     *   for(int pos2 = pos1; pos2 < array.length; pos2++) (2){
     *      ............. 
     *    }
     * }
     */

     //This is the first line of the nested loop (1)
    if(pos1 == pos2){
      length = longestDuplicatedSubsequenceRecursion(array, pos1+1, pos2+1, 0);
    }
    //if value at pos1 and pos2 equal, the value at next position would be compared and update the length of duplicated subsequence
    else if(array[pos1] == array[pos2]){
      length = Math.max(currLength, longestDuplicatedSubsequenceRecursion(array, pos1+1, pos2+1, currLength+1));
    }
    //if the value at pos1 and pos2 is not equal, the return the max length of the duplicated subsequence
    else{
      length = currLength;
    }

    //the second line of the nested loop (2)
    currLength = longestDuplicatedSubsequenceRecursion(array, pos1, pos2+1, 0);

    //return the highest length
    return Math.max(currLength, length);
  }
}

