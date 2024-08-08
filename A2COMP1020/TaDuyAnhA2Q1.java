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
* PURPOSE: [Make the game "The secret of the island"]
*/
import java.util.*; 
import java.io.*;

public class TaDuyAnhA2Q1{
    public static final String ADDRESS = "C:\\Users\\DELL\\Downloads\\"; //Address of the file. Please change when you run the code
    public static final String FILE = "folio.txt"; //file name
    public static final String SECRET_FILE = "secret.txt"; //file name
    public static ArrayList<Map> arrayMap = new ArrayList<Map>(); //Array list for Map object
    public static Map chosenMap; //parameter stores currently chosen map
    public static void main(String[]args){
        readFile();
        display();
        gamePlay();
    }

    /*Display the options */
    public static void display(){
        System.out.println("Welcome to the Secret of the Island! Choose an option to start the game.");
        System.out.println( "1-See all maps" + "\n" + 
        "2-Open map" + "\n" + 
        "3-Decrypt map" + "\n" + 
        "4-Write down secret" + "\n" + 
        "5-Send information to Captain Lila" + "\n" + 
        "0-Exit" + "\n");
    }
    
    /*This function runs the game.
     * If the boolean exits is false, the game still continue. Otherwise, the game will end.
     * The player will choose one option and do as the instruction. 
     * If the player chooses option 3 or 4 or 5 without choosing map, the option will be displayed so the player could choose the map in option 2 before continuing the game.
     * If the input that is out of the provided options in the game (including alphabets and numbers), the option also will be displayed for player to choose again.
     */
    public static void gamePlay(){
        boolean exit = false;
        Scanner scanner; 
        int chosenNum = -1; //parameter stores the option number
        try{
            while(!exit){
              System.out.println("Option:");
              scanner = new Scanner(System.in); 
              if(scanner.hasNextInt()){
                 chosenNum = scanner.nextInt(); 
                    if(chosenNum == 1){
                        option1();
                    }
                    else if(chosenNum == 2){
                        option2();
                    }
                    else if(chosenNum == 3){
                        if(chosenMap == null){
                            System.out.println("The map has not been chosen yet, please try again");
                            scanner = new Scanner(System.in);
                        }
                        else {
                            option3(chosenMap);
                        }
                    }
                    else if(chosenNum == 4){
                        if(chosenMap == null){
                            System.out.println("The map has not been chosen yet, please try again");
                            scanner = new Scanner(System.in);
                        }
                        else {
                            option4();
                        }
                    }
                    else if(chosenNum == 5){
                        if(chosenMap == null){
                            System.out.println("The map has not been chosen yet, please try again");
                            scanner = new Scanner(System.in);
                        }
                        else {
                            option5();
                        }
                    }
                    else if(chosenNum == 0){
                        exit = true;
                        System.out.println("The end");
                        option0();
                    }
                    else if(chosenNum < 0 && chosenNum > 5){    
                        scanner = new Scanner(System.in);
                    }
                } 
            }
        } catch(InputMismatchException ime){   // catch mismatched input
             System.out.println(ime.getMessage());
        } 
    }
    /* This method reads the folio.txt file
     * the first line in folio.txt is the number of map
     * In below lines, each line will be split by split(",") into 3 tokens and they will be stored in an array
     * The first token is name, the second is year and the last one is the file which link to the maps
     * These three tokens will be used to define a Map object. There are total three lines, thus there are 3 Map objects
     */
    public static void readFile(){
        String read = ""; 
        int numOfMap = 0; 
        int index = 0; //the parameter to keep track the number of processed map object
        try{
            BufferedReader br = new BufferedReader(new FileReader(ADDRESS+FILE));
            read = br.readLine();
            numOfMap = Integer.parseInt(read);
            while(index < numOfMap && read != null){
                read = br.readLine();
                String[] tmp  = read.split(","); 
                String name = tmp[0]; 
                int year = Integer.parseInt(tmp[1]); 
                String file = tmp[2]; 
                Map map = new Map(name, year, file);
                arrayMap.add(map);
                index++;
            }
            br.close();
        } catch(FileNotFoundException ffe){ // catch the exception if can not find the file
            System.out.println("File not found, please try again");
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    /* This method will print the information of 3 maps */
    public static void option1(){
        for(int i = 0; i < arrayMap.size(); i++){
            System.out.println(arrayMap.get(i));
        }
    }
    /*In this method, the player is required to enter a map
     * Then the findMap() method will compare the input that player has entered. 
     * If the map is found, it would be read by readFileMap() method and valid boolean changes to true in order to break the loop. 
     * Otherwise, the player has to enter the name again
     */
    public static void option2(){
        Scanner scanner;
        String name;
        System.out.println("Please choose a map");
        boolean valid = false;
        try{
           while(!valid){
            scanner = new Scanner(System.in); 
            name = scanner.nextLine();
            Map map = findMap(name);
            if(map == null){
                System.out.println("Can not find map, please try again");
            }
            else{
                 readFileMap(map);
                 valid = true;
            }      
          }                 
        } catch(InputMismatchException ime){ //catch mismatched input 
            System.out.println("Please try again");
            scanner = new Scanner(System.in);
        } catch(NullPointerException npe){              // This will catch the null pointer exception. 
            System.out.println("Please try again");   //Since in case that the map can not found, the map would be null therefore readFileMap() method can not pass the parameter map. 
            scanner = new Scanner(System.in);
        }
    }
    /*this method decrypts the code
     *the parameter map will be passed into this method
     *first the method will get the array of code number from the Object Map
     *Then, it will pass through the for loop to process each index of the array
     *The null index will be skipped
     *In each index, the blank will be split by split(" "). 
     *However, the empty index will exist after split the blank so the IF condition will ignore the empty index. 
     *After that, the string will be split the comma by split ",". Each index of a String[] array after split comma will be converted to integer then convert to character. 
       These character will be added to "String text" parameter
     *The boolean isEncryped in Map Object will be changed to false by instance method decrypted()
     *The method return the String of secret after decrypted
     */
    public static String option3(Map chosenMap){      
        ArrayList<String> array = chosenMap.getArray();
        String text = "";
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) != null){
                String[]tmp = array.get(i).split(" "); 
                for(int j = 0; j < tmp.length; j++){
                  if(!(tmp[j].equals(""))){
                    String[]tmp2 = tmp[j].split(","); 
                    for(int k = 0; k < tmp2.length; k++){
                        char convert = (char)Integer.parseInt(tmp2[k]);
                        text += String.valueOf(convert); 
                     }
                     text += " "; // the blank will be add between each index of the array after converted to String
                   }
                }
            }
        }
        chosenMap.decrypted();
        System.out.println(text);
        return text;
    }

    /* This method will updated the secret in Map object 
     * The player is required to enter the secret display on screen
     * Then the input will be compared to the displayed secret by checkValid() method which pass the input and String secret
     * if checkValid() return true, the secrete will be updated. Otherwise, the player has to re-enter the secret
    */
    public static void option4(){
        System.out.println("Please enter the secret as the following line");
        String input = "";
        String secret = option3(chosenMap); // the String secret return from option3 method
        boolean valid = false;
        Scanner scanner;
        try{
             while(!valid){
                 scanner = new Scanner (System.in); 
                input = scanner.nextLine();
                if(checkValid(secret, input) == true){
                    chosenMap.setSecret(input);
                    System.out.println("The secret has been updated"); 
                    valid = true;
                  } 
                else{
                    System.out.println("The input is not matched. Please try again");
                }
             }
                
        } catch(InputMismatchException ime){ // catch mismatched input
            System.out.println("Please try again");
        } catch(StringIndexOutOfBoundsException sioobe){ //catch the exception in case the input that player enter is larger than the secret 
            System.out.println("Please try again");
        }
    }
    /*This method take the secret in Map object then write on secret.txt file */
    public static void option5(){
        try{
            FileWriter fileWriter = new FileWriter(ADDRESS+SECRET_FILE);
            BufferedWriter output = new BufferedWriter(fileWriter); 
            for(int i = 0; i < arrayMap.size(); i++){
                output.write(arrayMap.get(i).getSecret() + "\n");
                output.flush();
            }
            System.out.println("The secret has been updated on file text");
            output.close();
        } catch(FileNotFoundException ffe){ //catch the exception in case the file is not found
            System.out.println("Please check the file");
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    /*delete the file and delete secret in Map Object */
    public static void option0(){
        File file = new File(ADDRESS + SECRET_FILE);
        for(int i = 0; i < arrayMap.size(); i++){
            arrayMap.get(i).reset();
            arrayMap.get(i).setSecret("");
            file.delete();
        }
    }
    //The method first delete all white space in 2 Strings. Then it compares 2 String. If they are matched, the boolean will return true, otherwise it will return false
    public static boolean checkValid(String code, String input){
        boolean valid = true; 
        code = code.replaceAll("\\s+","");
        input = input.replaceAll("\\s+","");
        for(int i = 0; i < code.length() && valid == true; i++){
            if(code.charAt(i) == input.charAt(i)){
                valid = true;
            }
            else{
                valid = false;
            }
        }
        return valid;
    }
    //This method passes String name to find the appropriate map in the array of Map Object
    public static Map findMap(String name){
        Map map = null;
        for(int i = 0; i < arrayMap.size(); i++){
            if(name.equals(arrayMap.get(i).getName())){
                map = arrayMap.get(i);
                chosenMap = map;
            }
        }
        return map;
    }
    /*This method read the information 
     * The method passes parameter Map, which is used to get the file of map. 
     * The file is used to read the information in the file text. 
     */
    public static void readFileMap(Map map){
        String line = ""; 
        int maximumLine = 5;
        String file = ADDRESS + map.getFile();
        try{
             BufferedReader br = new BufferedReader(new FileReader(file)); 
            for(int i = 0; i < maximumLine; i++){
                line = br.readLine(); 
                map.addToArray(line);
            }
            map.finishAdd(); //cease the duplication of content of file text in case the option 2 is called more than one time for one map
            map.printCode(); //print the code inside file text
            br.close();
        } catch(FileNotFoundException ffe){ // catch exception if file is not found
          System.out.println(ffe.getMessage());
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}