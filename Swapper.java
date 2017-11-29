/*
Kendrick Liang
APCS1 pd8
HW40 -- Make It Better
2017-11-26
*/
/*
I first made a print function based on the print function from TwoDimArray.java (HW 34).
This time I made elements in the same row print on a horizontal line while those of a different one are separated by white space.
For swapping, I made my program request four inputs from the user in the order of 1st location row, 1st location column, 
2nd location row, and 2nd location column. If the inputs were too large, the user was prompted to try again. Eventually, the String
in the first location is replaced by that of the 2nd location, and vice versa.
 */
import cs1.Keyboard;
public class Swapper{
    public static final String CHARS =  "abcdefghijklmnopqrstuvwxyz";
    public static int genRows(){
	return (int)(Math.random() * 10);
    }
    public static int genCols(){
	return (int)(Math.random() * 10);
    }
    public static int wordLength(){
	if (Math.random() < 0.5){
	    return 3;
	}
	else{
	    return 4;
	}
    }
    public static String getChar(){
	int pos = (int)(Math.random() * CHARS.length());
	return CHARS.substring(pos, pos + 1);
    }
    public static String genWord(){
	int strLength = wordLength();
	String retStr = "";
	for (int x = 0; x < strLength; x++){
	    retStr += getChar();
	}
	return retStr;
    }
    public static void populate(String[][] s){
	for (int x = 0; x < s.length; x++){
	    for (int y = 0; y < s[x].length; y++){
		s[x][y] = genWord();
	    }
	}
    }
    public static void print( String[][] s ){
	for (String[] x: s){
	    for (String y: x){
		System.out.print(y + " ");
	    }
	    System.out.println("\t");
	}
    }
    public static void swap(String[][] s){
	int rows = s.length;
	int cols = s[0].length;
	System.out.println("Pick the row of the first String you want to swap. Row goes from top to bottom, starting from 0 and counting down to " + (rows - 1) + ".");
	int input1 = Keyboard.readInt();
	while (input1 > rows - 1 || input1 < 0){
	    System.out.println("Invalid input. Please try again.");
	    input1 = Keyboard.readInt();
	}
	System.out.println("Pick the column of the first String you want to swap. Column goes from left to right, starting from 0 and counting right to " + (cols - 1) + ".");
	int input2 = Keyboard.readInt();
	while (input2 > cols - 1 || input2 < 0){
	    System.out.println("Invalid input. Please try again.");
	    input2 = Keyboard.readInt();
	}
	System.out.println("Pick the row of the other String you want to swap. Row goes from top to bottom, starting from 0 and counting down to " + (rows - 1) + ".");
	int input3 = Keyboard.readInt();
	while (input3 > rows - 1 || input3 < 0){
	    System.out.println("Invalid input. Please try again.");
	    input3 = Keyboard.readInt();
	}
	System.out.println("Pick the column of the other String you want to swap. Column goes from left to right, starting from 0 and counting right to " + (cols - 1) + ".");
	int input4 = Keyboard.readInt();
	while (input4 > cols - 1 || input4 < 0){
	    System.out.println("Invalid input. Please try again.");
	    input4 = Keyboard.readInt();
	}
	String thing1 = s[input1] [input2];
	s[input1][input2] = s[input3][input4];
	s[input3][input4] = thing1;
    }
    public static void main(String[]args){
	String[][] m = new String[genRows()][genCols()];
	populate(m);
	print(m);
	swap(m);
	print(m);
    }
}