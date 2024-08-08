// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// NAME : Duy Anh Ta
// STUDENT NUMBER : 7967807
// COURSE : COMP 2140
// ASSIGNMENT : assignment 1
// QUESTION : question 2
//
// REMARKS : Flood fill the pbm file
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.io.*;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: InvalidFileException
    //
    // PURPOSE : print message of customized exception
    // PARAMETERS : String message;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class InvalidFileException extends Exception{
    public InvalidFileException (String message){
        super(message);
    }
}
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: InvalidInputException
    //
    // PURPOSE :  print message of customized exception
    // PARAMETERS : String message;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class InvalidInputException extends Exception{
    public InvalidInputException (String message){
        super(message);
    }
}


public class FloodFill{
    public static void main(String[]args){
        try{
            String file = args[0]; 
            int x = Integer.parseInt(args[1]); 
            int y = Integer.parseInt(args[2]); 
            int targetColor = Integer.parseInt(args[3]); 
            mainFloodFill(file,x,y,targetColor);
        } catch (NumberFormatException nfe){
            System.out.println("The input of x-coordinate or y-coordinate or targetColor is not a number");
        }   
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: mainFloodFill
    //
    // PURPOSE : contain checking method, floodfill method, and print method 
    // PARAMETERS : String file, x coordinate, y coordinate, a constant value of desired color;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void mainFloodFill(String file, int x, int y, int targetColor) {
        String line = "";
        int row = 0, col = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            line = reader.readLine(); //first line
            String magicNumber = line;
            if(!(line.equals("P1")) || line == null){ //check if the first line of the file contains the magic number P1
                throw new InvalidFileException("This is not valid PBM file format since it does not contain the magic number P1 or the magic number is not P1");
            }
            String[]dimensions = reader.readLine().split(" "); //second line  
            if(dimensions.length != 2 || dimensions == null){ //check if the second line contains only x and y coordinates
                throw new InvalidFileException("This is not valid PBM file format since the dimension value is not valid");
            }
            col = Integer.parseInt(dimensions[0]); 
            row = Integer.parseInt(dimensions[1]);
            checkInputValidity(row, col, x, y, targetColor);
            int[][]image = new int[row][col]; 
 
            for(int i = 0; i < row; i++){
              String[]content = reader.readLine().split(" ");
              for(int j = 0; j < col; j++){
                image[i][j] = Integer.parseInt(content[j]); 
              }
            }
            floodFill(x, y, targetColor, image, row, col);
            printImage(row, col, image, magicNumber);   
        } catch (InvalidFileException ife){
            System.out.println(ife.getMessage());
        } catch(InvalidInputException iie){
            System.out.println(iie.getMessage());
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: printImage
    //
    // PURPOSE : print the image
    // PARAMETERS : number of row and column, array of image and the magic number;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void printImage(int row, int col, int[][]image, String magicNumber){
        System.out.println(magicNumber + "\n" + col + " " + row);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: floodFill
    //
    // PURPOSE : flood fill the disired color by recursion 
    // PARAMETERS : String file, x coordinate, y coordinate, a constant value of desired color;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void floodFill(int x, int y, int targetColor, int[][]image, int row, int col){
        //base case: if the x or y coordinate is out of bound or the color at the current position is the desired color then halt
        if(x >= row || x < 0 || y >= col || y < 0 || image[x][y] == targetColor){
            return;
        }
        else{
            image[x][y] = targetColor; //set the desired color at the current position
            floodFill(x - 1, y, targetColor, image, row, col); //flood fill the left
            floodFill(x + 1, y, targetColor, image, row, col); //flood fill the right
            floodFill(x, y - 1, targetColor, image, row, col); //flood fill the top
            floodFill(x, y + 1, targetColor, image, row, col); //flood fill the bottom
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // nameOfMethod: checkInputValidity
    //
    // PURPOSE : check the validity of the x,y coordinate and the disired color 
    // PARAMETERS : number of row and column, x coordinate, y coordinate, a constant value of desired color;
    // RETURN : 
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void checkInputValidity(int row, int col, int x, int y, int targetColor) throws InvalidInputException{
        //if the x, y coordinate is out of bound then throw exception
        if(x >= row || y >= col || x < 0 || y < 0 ){
            throw new InvalidInputException("The input of coordinate is out of bound");
        }
        //if the desired color is not 1(black) and 0(white) then throw exception
        else if(targetColor != 1 && targetColor != 0){
            throw new InvalidInputException("The target color is not 1(black) or 0(white)");
        }
    }
}

/*Input size of recursive method is N = m x n where m is the number of row and n is the number of column
 *In the worst case, each position of 2D array is visited once and for each position, four recursive calls are made 
 *The total number of recursive calls in the worst case is proporstional to the number of the number of positions in the array, which is m x n 
 *Therefore, the time complexity of the recursive method is O(m x n)
*/

