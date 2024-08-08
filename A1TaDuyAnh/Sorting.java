// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// NAME : Duy Anh Ta
// STUDENT NUMBER : 7967807
// COURSE : COMP 2140
// ASSIGNMENT : assignment 1
// QUESTION : question 3
//
// REMARKS : Sorting the array of points based on distance to the reference point
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.util.Random;
import java.util.Scanner;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: IllegalArgumentException
    //
    // PURPOSE : print message of customized exception
    // PARAMETERS : String message;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class IllegalArgumentException extends Exception{
    public IllegalArgumentException(String message){
        super(message);
    }
}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: Empty
    //
    // PURPOSE : print message of customized exception
    // PARAMETERS : String message;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Empty extends Exception{
    public Empty(String message){
        super(message);
    }
}

public class Sorting{
    public static void main(String[]args){
        try{
            if(args.length % 2 != 0 && args.length > 2){
                throw new IllegalArgumentException("Missing a coordinate value ");
            }
            else if(args.length <= 2){
                throw new Empty("The array is empty");
            }
            else{
                Double[]array = new Double[args.length];
                for(int i = 0; i < array.length; i++){
                    array[i] = Double.parseDouble(args[i]);
                }
                Point ref = new Point(array[0], array[1]);
                if(array.length > 2 && array.length % 2 == 0){
                    int start = 2; 
                    int pairs = (array.length-start)/2;
                    Point[]points = new Point[pairs];
                    int i = start; 
                    int keepTrack = 0;
                    while (i < array.length) {
                        points[keepTrack] = new Point(array[i], array[i+=1]);
                        i++;
                        keepTrack++;
                    }
                    printPoints(insertionSort(points, ref, false));
                    printPoints(insertionSort(points, ref, true));
                    printPoints(quicksort(points, ref, false));
                    printPoints(quicksort(points, ref, true));
                    System.out.println("is sorted descending?: "+ isSorted(insertionSort(points, ref, false), ref, false));
                    System.out.println("is sorted ascending?: "+ isSorted(insertionSort(points, ref, true), ref, true));
                    System.out.println("is sorted ascending?: "+ isSorted(quicksort(points, ref, false), ref, true));
                    System.out.println("is sorted ascending?: "+ isSorted(quicksort(points, ref, true), ref, true));
                }
            }
        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        } catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage() + " which is number mismatch exception");
        } catch(Empty e){
            System.out.println(e.getMessage());
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: printPoints
    //
    // PURPOSE : print elements of the array
    // PARAMETERS : array of Point;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void printPoints(Point[]array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: isSorted
    //
    // PURPOSE : check if the array is sorted ascending or descending
    // PARAMETERS : array of Point, reference point, boolean ascending;
    // RETURN : boolean value (true or false) 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean isSorted ( Point [] points, Point ref, boolean ascending){ 
        
        boolean isSorted = true;
        //ascending order
        if(ascending == true){
            for(int i = 0; i < points.length - 1; i++){
                if(points[i].calcDistance(ref) > points[i+1].calcDistance(ref)){
                    isSorted = false;
                }
            }
        }

        //descending order
        if(ascending == false){
            for(int i = 0; i < points.length - 1; i++){
                if(points[i].calcDistance(ref) < points[i+1].calcDistance(ref)){
                    isSorted = false;
                }
            }
        }
        return isSorted;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: insertionSort
    //
    // PURPOSE : sort the array in ascending or descending order by insertion sort method
    // PARAMETERS : array of Point, reference point, boolean ascending;
    // RETURN : a new sorted array 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Point[] insertionSort(Point[] points, Point ref, boolean ascending){

        Point[]sortArray = new Point[points.length]; 
        //copy array 
        for(int i = 0; i < sortArray.length; i++){
            sortArray[i] = points[i];
        }
        // ascending
        if(ascending == true){
            for(int i = 1; i < sortArray.length; i++){ 
                for(int j = i-1; j >= 0; j--){
                    if(sortArray[j+1].calcDistance(ref) < sortArray[j].calcDistance(ref)){
                        swap(sortArray, j+1,j);
                    }
                }
            }
        }
        //descending
        else if(ascending == false){
            for(int i = 1; i < sortArray.length; i++){ 
                for(int j = i-1; j >= 0; j--){
                    if(sortArray[j+1].calcDistance(ref) > sortArray[j].calcDistance(ref)){
                        swap(sortArray, j+1, j);
                    }
                }
            }
        }
        return sortArray;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: quicksort
    //
    // PURPOSE : sort the array by quicksort method
    // PARAMETERS : array of Point, reference point, boolean randomPivot;
    // RETURN : a new sorted array 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Point [] quicksort ( Point [] points, Point ref, boolean randomPivot ){
        Point[]sortArray = new Point[points.length]; 
        //copy array 
        for(int i = 0; i < sortArray.length; i++){
            sortArray[i] = points[i];
        }
        
        //high = array.length - 1
        if(randomPivot == true){
            quicksortRandomPivot(sortArray, 0, sortArray.length - 1, ref);
        } 
        else if(randomPivot == false){
            quicksortFirstPivot(sortArray, 0, sortArray.length - 1, ref);
        }
        return sortArray;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: quicksortRandomPivot
    //
    // PURPOSE : sort the array by quicksort method when choosing random pivot
    // PARAMETERS : array of Point, reference point, beginning and end index of array;
    // RETURN :  
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void quicksortRandomPivot(Point[]points, int low, int high, Point ref){
        if(low < high){
            int pivot = partitionRandomPivot(points, low, high, ref);
            quicksortRandomPivot(points, low, pivot - 1, ref);
            quicksortRandomPivot(points, pivot+1, high, ref);
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: partitionRandomPivot
    //
    // PURPOSE : arrange the value less than random pivot to the left and the other to the right then return the position of the pivot
    // PARAMETERS : array of Point, reference point, beginning and end index of array;
    // RETURN : position of pivot 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static int partitionRandomPivot(Point[]points, int low, int high, Point ref){
        randomPivot(points, low, high);
        Point pivot = points[high]; //the random pivot is at the end of the array

        int pointer = low - 1;
        for(int i = low; i <= high - 1; i++){
            if(points[i].calcDistance(ref) < pivot.calcDistance(ref)){
                pointer++; 
                swap(points, pointer, i);
            }
        }
        swap(points, high, pointer+1);
        return pointer+1;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: randomPivot
    //
    // PURPOSE : generate a random pivot and swap it with the value at the end of the array
    // PARAMETERS : array of Point, beginning and end index of array;
    // RETURN :  
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void randomPivot(Point[]points, int low, int high){
        Random random = new Random(); 
        int pivot = random.nextInt(high-low)+low; 

        //swap the random pivot with the last element of the array
        //the random pivot is now at the end position of the array
        swap(points, pivot, high);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: quicksortFirstPivot
    //
    // PURPOSE : sort the array by quicksort method with the first pivot
    // PARAMETERS : array of Point, reference point, beginning and end index of array;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void quicksortFirstPivot(Point[]points, int low, int high, Point ref){
        if(points.length == 0 || points.length == 1){ //base case
            return;
        }
        else if(low < high){
            int pivot = partitionFirstPivot(points, low, high, ref);
            quicksortFirstPivot(points, low, pivot - 1, ref);
            quicksortFirstPivot(points, pivot + 1, high, ref);
        }
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: partitionFirstPivot
    //
    // PURPOSE : arrange the value less than first pivot to the left and the other to the right then return the position of the pivot
    // PARAMETERS : array of Point, reference point, beginning and end index of array;
    // RETURN : position of pivot 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static int partitionFirstPivot(Point[]points, int low, int high, Point ref){ //high = length - 1
        Point pivot = points[low];
        int pointer = low;
        for(int j = low + 1; j <= high; j++){
            if(points[j].calcDistance(ref) < pivot.calcDistance(ref)){
                pointer++;
                swap(points, j, pointer);
            }
        }
        swap(points, low, pointer);
        return pointer;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: swap
    //
    // PURPOSE : swap 2 points
    // PARAMETERS : array of Point, 2 different index;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void swap(Point[]points, int i, int j){
        Point temp = points[i];
        points[i] = points[j]; 
        points[j] = temp;
    }
}
class Point{
    private double xCoord; 
    private double yCoord; 
    private double distance;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: Point
    //
    // PURPOSE : constructor for a point
    // PARAMETERS : x and y coordinates
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public Point(double xCoord, double yCoord){
        this.xCoord = xCoord; 
        this.yCoord = yCoord;
    }

     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: calcDistance
    //
    // PURPOSE : calculate the distance between 2 points
    // PARAMETERS : a reference point
    // RETURN : distance
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public double calcDistance(Point anotherPoint){
        distance = Math.sqrt(Math.pow((this.xCoord - anotherPoint.xCoord),2) + Math.pow((this.yCoord - anotherPoint.yCoord),2));
        return distance;
    }


    public String toString(){
        return "(" + xCoord + ", " + yCoord +")";
    }
}