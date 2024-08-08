/*
*
* [TaDuyAnhA4Q2]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 4]
* QUESTION: [question 2]
*
* PURPOSE: [Recursion to find The Ruler Sequence]
*/
public class TaDuyAnhA4Q2 {
  public static void main(String[] args) {
    System.out.println("rulerSequence(5):");
    System.out.println(rulerSequence(5));
    
    System.out.println("\nRunning tests:");
    verifyString("0", rulerSequence(1), "rulerSequence(1)");
    verifyString("010", rulerSequence(2), "rulerSequence(2)");
    verifyString("010201030102010", rulerSequence(4), "rulerSequence(4)");
    verifyString("0102010301020104010201030102010501020103010201040102010301020106010201030102010401020103010201050102010301020104010201030102010", rulerSequence(7), "rulerSequence(7)");
    verifyString("010201030102010401020103010201050102010301020104010201030102010601020103010201040102010301020105010201030102010401020103010201070102010301020104010201030102010501020103010201040102010301020106010201030102010401020103010201050102010301020104010201030102010801020103010201040102010301020105010201030102010401020103010201060102010301020104010201030102010501020103010201040102010301020107010201030102010401020103010201050102010301020104010201030102010601020103010201040102010301020105010201030102010401020103010201090102010301020104010201030102010501020103010201040102010301020106010201030102010401020103010201050102010301020104010201030102010701020103010201040102010301020105010201030102010401020103010201060102010301020104010201030102010501020103010201040102010301020108010201030102010401020103010201050102010301020104010201030102010601020103010201040102010301020105010201030102010401020103010201070102010301020104010201030102010501020103010201040102010301020106010201030102010401020103010201050102010301020104010201030102010", rulerSequence(10), "rulerSequence(10)");
    
    System.out.println("\n*** End of program. ***");
  }
  
  public static void verifyString(String expected, String result, String action) {
    boolean isNull = false;
    boolean nullMatch = false;
    if (expected == null || result == null) {
      isNull = true;
      nullMatch = expected == result;
    }
    if ((isNull && nullMatch) || (!isNull && expected.equals(result))) {
      System.out.printf("Test succeeded: %s\n", action);
    } else {
      System.out.printf("Test FAILED (expected %s, got %s): %s\n", expected, result, action);
    }
  }
  
  public static String rulerSequence(int n) {
    String result = "";
    //base case
    if(n == 0){
      result += "";
    }
    else{
      //using recursion method to make the left-side of the string result
      result += rulerSequence(n-1);
      // Print the value at the middle of the string
      result += Integer.toString(n-1);
       //Using recursion to print the right-side of the string result
      result += rulerSequence(n-1);
    }

    return result;
  }
}