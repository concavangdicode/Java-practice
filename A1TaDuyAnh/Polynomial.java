// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// NAME : Duy Anh Ta
// STUDENT NUMBER : 7967807
// COURSE : COMP 2140
// ASSIGNMENT : assignment 1
// QUESTION : question 1
//
// REMARKS : Calculating the polynomial function
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Polynomial{
    
      public static void main(String[]args){
        double[]array = new double[]{8.0,2.0,5.0,4.0}; 
        double x = 4.0; 
        System.out.println(p_recur(x, array));
        System.out.println(p_iter(x, array));
    }
    
    

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: p_iter
    //
    // PURPOSE : calculating the polynomial of the array of constant by iteration
    // PARAMETERS : a constant x and an array of constants;
    // RETURN : return the value of polynomial
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double p_iter(double x, double[]array){
        double result = 0; 
        for(int i = 0; i < array.length; i++){
            double pow = 1;
            for(int j = 0; j < i && i != 0; j++){
                pow *= x;
            }
            result += (array[i] * pow);
        }
        return result;
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: p_recur
    //
    // PURPOSE : calculating the polynomial of the array of constant by recursion
    // PARAMETERS : a constant x and an array of constants;
    // RETURN : return the result calculated by the helper method
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double p_recur(double x, double[]array){
        return p_recur_helper(x, array[0], array, 0);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: p_recur_helper
    //
    // PURPOSE : calculating the polynomial of the array of constant by recursion for the p_recur method
    // PARAMETERS : a constant x, a constant value in the array, an array of constants, a value to keep track the position in the array;
    // RETURN : return the value of polynomial
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static double p_recur_helper(double x, double a, double[]array, int track){
       if(track == array.length-1){
         return array[track];
       }
       else{
         track++;
         return a + x * p_recur_helper(x, array[track], array, track);
       }
    }
}

/* 
 * Input size of p_iter() is "n" (the length of the array)
 * The outer loop performs "n" operations. 
 * The inner loop performs "i" operations for each iteration of the outer loop where "i" is the current index of the outer loop. In the worst case, the inner loop performs "n" operations
 * So the time complexity of p_iter() is O(n^2)
 * 
 * Input size of p_recur() is "n" (the length of the array)
 * The recursion performs "n" operations. 
 * So the time complexity of p_recur() is O(n)
*/