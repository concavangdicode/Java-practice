/*
*
* [TaDuyAnhA4Q1]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeault]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 4]
* QUESTION: [question 1]
*
* PURPOSE: [Making the game Score-abble]
*/
import java.util.*;

public class TaDuyAnhA4Q1{
    public static final int[] LETTER_SCORES = new int[] {
        1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
      };
    public static final String[]LETTERS = new String[]{
        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    public static final String BLANK = ".", DLS = "!", DWS = "+", BOTH = "*";
    public static boolean firstWord = true;
    public static void main(String[]args){
        gamePlay();
    }

    /*The method manipulates the game play 
     * First, player would enter number of rows and columns, then the board will be printed
     * Then the player would enter the word
     * If the word is the first word, the method "printFirstWord" would be used to print the word and calculate its score
     * If the boolean firstWord is false, the method "printWord" would be used to print the other words and calculate their score
     * If the the word is "exit", the game will end
     */
    public static void gamePlay(){
        Scanner scanner; 
        int row = 0, column = 0;
        boolean validRowCol = false;
        String word = "";
        boolean endGame = false;
        

        while(!validRowCol){
            try{
                System.out.println("Please enter the odd numbers of row and column: "); 
                scanner = new Scanner(System.in);
                System.out.println("Number of row: "); 
                row = scanner.nextInt();
                System.out.println("Number of column:"); 
                column = scanner.nextInt(); 
                if(row % 2 != 0 && column % 2 != 0 && row > 0 && column > 0){
                    validRowCol = true;
                }
                else{
                    validRowCol = false;
                    System.out.println("Number of rows or columns is not odd \n");
                }
            } catch(InputMismatchException ime){
                System.out.println("The input is not numbers \n");
                validRowCol = false;
            }     
        } 
        String[][]board = board(row, column);
        printBoard(board);
        while(!endGame){
            word = input();
            if(word.equals("EXIT")){
                System.out.println("The end");
                endGame = true;
            }
            else{
                if(firstWord == true){
                    System.out.println("Score: " + printFirstWord(board, row, column, word));
                    printBoard(board);
                }
                else{
                    System.out.println("Score: " + printWord(board, row, column, word));
                    printBoard(board);
                }
            }
        }
    }

    /*
     * The method input() takes input from user. 
     * Then, it converts the word to upper case and checks the validity of the word. 
     * If the input includes alphabet characters, the method will return the word. 
     * If the input includes any character which is not an alphabet characters, the error message will be printed and requires the user to enter new input
     */
    public static String input(){
        String word = ""; 
        boolean validWord = false;
        Scanner scanner;

        while(!validWord){
           boolean invalid = false;
           System.out.println("Please enter a word");
           scanner = new Scanner(System.in);
           word = scanner.nextLine().toUpperCase(); 
             for(int i = 0; i < word.length() && !invalid; i++){
                if(word.charAt(i) < 65 || word.charAt(i) > 90){
                    invalid = true;
                 }     
               }
             if(invalid == false){
                validWord = true;
               }
             else if(invalid == true){
                System.out.println("The word is invalid please try again\n");
             }
          }
        return word;
    }

    /*This method create board which takes numbers of rows and columns as parameters 
    */
    public static String[][] board(int row, int col){
        String[][] board = new String[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(r == 0 || r == row-1 || c == 0 || c == col-1){
                    board[r][c] = DWS;
                }
                else if(r == row/2 && c == col/2){
                    board[r][c] = DLS;
                }
                else{
                    board[r][c] = BLANK;
                }
            }
        }

        for(int i = 1; i <= row/2; i++){
            if(i == row/2){
               board[row/2 - i][col/2 - i] = BOTH; 
               board[row/2 - i][col/2 + i] = BOTH;
               board[row/2 + i][col/2 - i] = BOTH; 
               board[row/2 + i][col/2 + i] = BOTH;
            }
            else{
               board[row/2 - i][col/2 - i] = DLS; 
               board[row/2 - i][col/2 + i] = DLS;
               board[row/2 + i][col/2 - i] = DLS; 
               board[row/2 + i][col/2 + i] = DLS;
            }   
        }
        return board;
    }
    
    /*The printFirstWord method takes String[][]board, word, numbers of row and columns as parameters
     * The method will check if the length of the word fits the board. If the the condition is satisfied
     * If the the condition is satisfied, the it calculates the score of the first word then print it horizontally. 
     * After that, it turns the boolean "firstWord" to false.
     * Then the method return the score of the first word
     * If the length of the word is larger than the number of columns, the error message will be promted
     */
    public static int printFirstWord(String[][]board, int row, int col, String word){
      
      if(col/2 + word.length()/2 < col){
        int score = 0; 
        score += calcScoreHorizontal(board, row/2, col/2 - word.length()/2, 0, word);
        printHorizontal(board, row/2, col/2 - word.length()/2, 0, word);  
        firstWord = false;
        return score;
      }     
        else{
            System.out.println("Cannot place the word");
        }
        return -1;
    }

    /*This method print words (excluding the first word), which takes String[][]board, word, numbers of row and columns as parameters
     * The method first check if the any character in the word is as same as any character on the board. 
     * If the position of the duplicated character is found, then the method would check if the word is can be printed horizontally or vertically then calculate its score. 
     * if the word can be printed in many position, the position where the word has highest score will be printed and the method return the highest score. 
     * If the word cannot be printed, the error message will be printed and the score is 0
     */
    public static int printWord(String[][]board, int row, int col, String word){
        boolean vertical = false;
        boolean canPlace = false;
        int score = 0, tmpScore = 0;
        int rowPrint = 0, colPrint = 0, position = 0;

        for(int i = 0; i < word.length(); i++){
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    if(board[r][c].equals(Character.toString(word.charAt(i)))){      
                        if(checkHorizontalValidity(board, r, c, i, word)){
                            tmpScore = calcScoreHorizontal(board, r, c, i, word);
                              if(tmpScore > score){
                                 rowPrint = r; 
                                 colPrint = c;
                                 position = i;
                                 score = tmpScore; 
                                 vertical = false;
                                 canPlace = true;
                            }
                        }
                        
                        if(checkVerticalValidity(board, r, c, i, word)){
                            tmpScore = calcScoreVertical(board, r, c, i, word);
                            if(tmpScore > score){
                                rowPrint = r; 
                                colPrint = c; 
                                position = i;
                                score = tmpScore; 
                                vertical = true;
                                canPlace = true;
                            }
                        }
                    }
                }
            }
        }
        if(!canPlace){
             System.out.println("Cannnot place the word");
        }
        else{
            if(vertical == true){
              printVertical(board, rowPrint, colPrint, position, word);
        }
            else if(vertical == false){
               printHorizontal(board, rowPrint, colPrint, position, word);
        }
      }
        return score;
    }
    
    /*This method checks if the word can be put horizontally in the board. 
     * Parameters: String[][]board, word, row and column of duplicated character
     * If the condition is satisfied, the method would return true; else it would return false 
     */
    public static boolean checkHorizontalValidity(String[][]board, int row, int col, int pos, String word){
        boolean valid = true;
        int startCol = col - pos; 
        if(startCol < 0 || startCol + word.length() > board[0].length){
            return false;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                if(!(board[row][startCol+i].equals(Character.toString(word.charAt(i))) || board[row][startCol+i].equals(DLS) || board[row][startCol+i].equals(DWS) || board[row][startCol+i].equals(BLANK) || board[row][startCol+i].equals(BOTH))){
                    return false;
                }
            }
        }
        return valid;
    }
    /*This method checks if the word can be put vertically in the board. 
     * Parameters: String[][]board, word, row and column of duplicated character
     * If the condition is satisfied, the method would return true; else it would return false 
     */
    public static boolean checkVerticalValidity(String[][]board, int row, int col, int pos, String word){
        boolean valid = true;
        int startRow = row - pos; 
        if(startRow < 0 || startRow + word.length() > board.length){
            return false;
        }
        for(int i = 0; i < word.length(); i++){
           if( !(board[startRow+i][col].equals(Character.toString(word.charAt(i))) || board[startRow+i][col].equals(DLS) || board[startRow+i][col].equals(DWS) || board[startRow+i][col].equals(BLANK) || board[startRow+i][col].equals(BOTH))){
              return false;
                }
            }
        return valid;
    }

    /*this method calculates and returns the score of the word put horizontally
     * Parameters: String[][]board, word, row and column of duplicated character
    */
    public static int calcScoreHorizontal(String[][]board, int row, int col, int pos, String word){
        int result = 0; 
        int startCol = col - pos;
        boolean doubleWordScore = false;

        for(int i = 0; i < word.length(); i++){
            boolean duplicated = false; 
            int tmpScore = 0;

            for(int j = 0; j < LETTERS.length && !duplicated; j++){
              if(board[row][startCol+i].equals(LETTERS[j])){
                duplicated = true;
              }
            }
              
            if(duplicated == false){
                tmpScore = letterScore(Character.toString(word.charAt(i)));
                
                if(board[row][startCol+i].equals(DLS)){
                    tmpScore *= 2;
                }
                else if(board[row][startCol+i].equals(DWS)){
                    doubleWordScore = true;
                }
                else if(board[row][startCol+i].equals(BOTH)){
                    tmpScore *= 2;
                    doubleWordScore = true;
                }
              }
            result += tmpScore;
        }
            if(doubleWordScore == true){
                result *= 2;
            }
        return result;
    }

    /*this method calculates and returns the score of the word put vertically
     * Parameters: String[][]board, word, row and column of duplicated character
    */
    public static int calcScoreVertical(String[][]board, int row, int col, int pos, String word){
        int result = 0;
        boolean doubleWordScore = false;
        int startRow = row - pos;

        for(int i = 0; i < word.length(); i++){
            boolean duplicated = false; 
            int tmpScore = 0;

            for(int j = 0; j < LETTERS.length && !duplicated; j++){
              if(board[startRow+i][col].equals(LETTERS[j])){
                duplicated = true;
              }
            }
              
            if(duplicated == false){
                tmpScore = letterScore(Character.toString(word.charAt(i)));
                
                if(board[startRow+i][col].equals(DLS)){
                    tmpScore *= 2;
                }
                else if(board[startRow+i][col].equals(DWS)){
                    doubleWordScore = true;
                }
                else if(board[startRow+i][col].equals(BOTH)){
                    tmpScore *= 2;
                    doubleWordScore = true;
                }
              }
            result += tmpScore;
        }
            if(doubleWordScore == true){
                result *= 2;
            }
        return result;
    }

    /*this method print the word in the vertical way 
     * Parameters: String[][]board, word, row and column of duplicated character
    */
    public static void printVertical(String[][]board, int row, int col, int pos, String word){
        int startRow = row - pos;
        for(int i = 0; i < word.length(); i++){
            board[startRow+i][col] = Character.toString(word.charAt(i));
        }
    }

    /*this method print the word in the horizontal way 
     * Parameters: String[][]board, word, row and column of duplicated character
    */
    public static void printHorizontal(String[][]board, int row, int col, int pos, String word){
        int startCol = col - pos;
        for(int i = 0; i < word.length(); i++){
            board[row][startCol+i] = Character.toString(word.charAt(i));
        }
    }

    /* The method returns the score of the character
     * Paramether: character
     */
    public static int letterScore(String character){
        int score = 0;
        for(int i = 0; i < LETTERS.length; i++){
            if(LETTERS[i].equals(character)){
                score = LETTER_SCORES[i];
            }
        }
        return score;
    }

    /* The method print the board
     * Paramether: 2D array board
     */
    public static void printBoard(String[][]board){
        String print = "";
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                print += board[r][c];
            }
            print += "\n";
        }
        System.out.print(print);
    }
}