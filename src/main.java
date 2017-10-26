import java.util.Scanner;
import java.util.InputMismatchException;

class pair{
    public char ch;
    public int frequency;
}

public class main {

    public static String alphabeticalSort (String str){
        char[] charAry = str.toCharArray();
        for (int i = 0; i < charAry.length; i++) {
            for (int j = 0; j < charAry.length; j++) {
                if (j + 1 < charAry.length) {
                    if (charAry[j] > charAry[j + 1]) {
                        char temp = charAry[j];
                        charAry[j] = charAry[j + 1];
                        charAry[j + 1] = temp;
                    }
                }
            }
        }
        return String.valueOf(charAry);
    }

    public static void getFrequencies (String str){

        int firstIndexOfType = 0;
        char currentChar;
        int lastIndexOfType = 0;
        boolean seenBefore[]= new boolean[str.length()];

        while (firstIndexOfType < str.length()) {
            if(!seenBefore[firstIndexOfType]) {
                currentChar = str.charAt(firstIndexOfType);
                int total = 1;
                if (lastIndexOfType >= 0) {
                    for (int i = firstIndexOfType + 1; i < str.length(); i++) {
                        if (str.charAt(i) == currentChar) {
                            total++;
                            seenBefore[i] = true;
                        }
                    }
                }
                System.out.println(currentChar + " freq: " + total);
            }
            firstIndexOfType++;
        }
        System.out.println("\n");
    }

    public static pair[] getPairs (String str){

        int nextpair = 0;
        pair thepairs[] = new pair[str.length()];
        int firstIndexOfType = 0;
        char currentChar;
        int lastIndexOfType = 0;
        boolean seenBefore[]= new boolean[str.length()];

        while (firstIndexOfType < str.length()) {
            if(!seenBefore[firstIndexOfType]) {
                currentChar = str.charAt(firstIndexOfType);
                int total = 1;
                if (lastIndexOfType >= 0) {
                    for (int i = firstIndexOfType + 1; i < str.length(); i++) {
                        if (str.charAt(i) == currentChar) {
                            total++;
                            seenBefore[i] = true;
                        }
                    }
                }
                pair p = new pair();
                p.ch = currentChar;
                p.frequency = total;
                thepairs[nextpair] = p;
                nextpair++;
            }
            firstIndexOfType++;

        }
        pair answer[] = new pair[nextpair];
        for(int i = 0; i<nextpair; i++){

            answer[i] = thepairs[i];

        }
        return answer;
    }

    public static void frequencySort (pair[]thepairs){

        for (int i = 0; i < thepairs.length; i++) {
            for (int j = 0; j < thepairs.length; j++) {
                if (j + 1 < thepairs.length) {
                    if (thepairs[j].frequency < thepairs[j + 1].frequency || thepairs[j].frequency == thepairs[j + 1].frequency && thepairs[j].ch > thepairs[j+1].ch) {
                        pair temp = thepairs[j];
                        thepairs[j] = thepairs[j + 1];
                        thepairs[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static  void charTypes(char[] array){   //Lists the types and amounts of different characters

        int charNumber = 0;
        int numNumber=0;
        int blankNumber=0;
        int symNumber=0;
        int i=0;

        while(i<array.length){
            char charTypes=array[i];
            int ascii = (int) (charTypes);

            if(65<=ascii&&ascii<=90||97<=ascii&&ascii<=122){    //Determines if the value being input is a letter
                charNumber++;
            }
            else if(48<=ascii&ascii<=57){     //Determines if the value being input is a number
                numNumber++;
            }
            else if(ascii==32){    //Determines if the value being input is a space
                blankNumber++;
            }
            else{
                symNumber++;   //If the previous 3 do not hit, will automatically add 1 to symbols
            }
            i++;
        }
        System.out.println("Textual Character count: "+charNumber);
        System.out.println("Numerical Character count: "+numNumber);
        System.out.println("WhiteSpace Character count: "+blankNumber);
        System.out.println("Symbol Character count: "+symNumber);
        System.out.println("\n");
    }

    public static void main(String[] args) {     //Start text and menu selection during the program

        Scanner scnr=new Scanner(System.in);
        int input=0;
        String userInput="";

        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted");
        userInput=scnr.nextLine();
        System.out.println("");

        while(input!=4){

            System.out.println("Please select the option you would like to see");
            System.out.println("");
            System.out.println("1. Display the characters alphabetically");
            System.out.println("2. Display sorted frequencies");
            System.out.println("3. Show types of character frequencies");
            System.out.println("4. Exit");

            try{
                input = scnr.nextInt();
            }

            catch (InputMismatchException e){
                scnr.next();
                input=0;
            }

            if(input==1){
                userInput = alphabeticalSort(userInput);
                getFrequencies (userInput);
                input=0;
            }

            else if(input==2){
                pair[]thepairs = (getPairs(userInput));
                frequencySort(thepairs);
                for (int i = 0; i < thepairs.length; i++) {
                    System.out.println(thepairs[i].ch + " freq: " +  thepairs[i].frequency);
                }
                System.out.println("\n");
                input = 0;
            }

            else if(input==3){
                char[] inputArray=userInput.toCharArray();
                charTypes(inputArray);
                input=0;
            }

            else if(input==4){
                System.out.println("");
                System.out.println("Character Sorter Exited Successfully");
                System.exit(0);
            }

            else if(input<1||input>4){
                System.out.println("");
                System.out.println("Error, bad input, please enter a number 1-4");
                System.out.println("");
                input=0;
            }

        }
    }

}