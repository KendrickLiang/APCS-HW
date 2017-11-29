import java.io.File;
import java.util.Scanner;

//Tres Mosqueteros (Isaac Jon, Kendrick Liang, Johnny Wong)
//APCS1 pd 8
//HW 24 -- Imetay Otay Ineshay
//2017-10-27

/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: VOWELS is constant and accessable by all of the methods in this class.
    private static final String VOWELS = "AaEeIiOoUu"; //VOWELS constant
    private static final String PUNC = "!?.,;:"; 


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	if (w.length() == 0 || letter.length() != 1)
	    return false;
	return w.indexOf(letter) != -1; //Returns true if index of letter is not equal to -1 (meaning it is present)
    }


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	if (letter.length() != 1) //Returns false if input is not a single letter
	    return false;
	return hasA(VOWELS, letter); //If letter is part of VOWELS then true is returned
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	int pos = 0; //index of string
	int count = 0; //result, number of vowels
	if (w.length() == 0) //Returns 0 if w is null
	    return 0;
	while (pos < w.length()) { //While position is less than length of w
	    if (isAVowel(w.substring(pos, pos + 1))) //Check if the character is vowel 
		count += 1; //Add 1 to count if it is
	    pos += 1; //Add 1 to pos to continue to iterate through string  
	}
	return count; //Once pos reaches length of string, returns count
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	if (w.length() == 0) //If w is null, return false
	    return false;
	return countVowels(w) != 0; //If countVowels != 0, it means there is a vowel, so hasAVowel returns true
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	int pos = 0; //index of string
	String result = ""; //result, string containing all the vowels of w
	if (w.length() == 0) //If w is null, tell reader to input valid string
	    return "Please enter valid string";
	while (pos < w.length()) { //While position is less than length of w
	    if (isAVowel(w.substring(pos, pos + 1))) //Checks if character is vowel
		result += w.substring(pos, pos + 1); //Adds character to result if it is
	    pos += 1;  //Add 1 to pos to continue to iterate through string
	}
	return result; //Returns result once pos reaches length of string
    }
    /*=========================================
      pre: w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =========================================*/
    public static String firstVowel(String w) {
	if (hasAVowel(w)){
	    return allVowels(w).substring(0, 1); //If w has a vowel, assembles string of all vowels and returns first character
	}
	else{
	    return ""; //w can't be null, or not have a vowel
	}
    }
    /*=========================================
      pre: w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =========================================*/
    public static boolean beginsWithVowel(String w) {
	if (w.length() == 0) //w can't be null
	    return false;
	return isAVowel(w.substring(0, 1)); //returns boolean value of if first character is vowel
    }
    /*=========================================
      pre: w.length() > 0
      post: isFirstCap("Apple") --> true
      isFirstCap("apple") --> false
      =========================================*/
    public static boolean isFirstCap(String w){
	if (w.length() == 0){ //w can't be null
	    return false;
	}
	return w.substring(0,1).equals(w.substring(0,1).toUpperCase()); // returns boolean value of if first character is equal to the capitalized version of the first character
    }
    /*=========================================
      pre: w.length() > 0
      post: hasPunct("apple!") --> true
      hasPunct("apple") --> false
      =========================================*/
    public static boolean hasPunct(String w){
	if (w.length() == 0){ //w can't be null
	    return false;
	}
	return PUNC.indexOf(w.substring(w.length()-1)) != -1; // returns boolean value if punctuation is found at the end of the inputted String
    }
    /*=========================================
      pre: w.length() > 0
      post: isYVowel("yellow") --> false
            isYVowel("mystery") --> true
            isYVowel("rhythm") --> true
      =========================================*/
     public static boolean isYVowel(String w){
	 if (w.length() == 0){ //w can't be null
	     return false;
	 }
	 w = w.toLowerCase(); // make w lowercase
         for (int index = 0; index < w.length(); index++){
	     if (w.substring(index,index+1).equals("y")){
		 if (w.indexOf("y") == 0){ // test if first instance of 'y' is the first letter of w
		     return false;
		 }
		 else if (VOWELS.indexOf(w.substring(w.indexOf("y")-1, w.indexOf("y"))) == -1){ // test if character before first instance of 'y' is not a vowel
		     // test if index is currently at end of w
		     // if not at the end of the word test if the character after first instance of 'y' is not a vowel
		     return (index == w.length() - 1) || (VOWELS.indexOf(w.substring(w.indexOf("y")+1, w.indexOf("y")+2)) == -1);
		 }
	     }
	 }
	 return false; // return false otherwise 
	 
	 
     }
    
    
    
    
    /*=========================================
      pre: w.length() > 0
      post: engToPig("apple")  --> "appleway"
            engToPig("strong") --> "ongstray"
            engToPig("java")   --> "avajay"
	    engToPig("Hi there bud how are you?") -> "Ihay erethay udbay owhay areway ouyay?"
            engToPig("Don't be a bad piggy!") -> "On'tday ebay away adbay iggypay!"
      =========================================*/
    public static String engToPig(String w) {
	String pigCons = ""; //Consonant that is moved to end
	String punc = "";
	if (w.length() == 0){ //w can't be null
	    return "Invalid string entry";
	}
	if (isYVowel(w)){
	    String newVowels = VOWELS + "yY";
	    if (hasA(newVowels, w.substring(0,1))){ // the case that the first letter is a vowel
		return w + "way";
	    }
	    else{ // case where first letter(s) are consonants
		return w.substring(w.indexOf(firstVowel(w)), w.indexOf(firstVowel(w)) + 1) + w.substring(w.indexOf(firstVowel(w)) + 1) + w.substring(0, w.indexOf(firstVowel(w))) + "ay";
	    }
	}
	if (!hasAVowel(w)){
	    return w + "way";
	}
	if (hasA(w, " ")) { //If w has a space, call function on each separate word, then add them back together
	    return engToPig(w.substring(0, w.indexOf(" "))) + " " + engToPig(w.substring(w.indexOf(" ") + 1));
	}
	if (beginsWithVowel(w) && pigCons.equals("")){ //If w starts with a vowel, pigCons is w.
	    pigCons = "w";
	}
	else{
	    while (!beginsWithVowel(w)){ //while w doesn't begin with a vowel,
		pigCons += w.substring(0, 1); //it collects the sequence that forms the consonant sound
		w = w.substring(1);
	    }
	    if (isFirstCap(w)){
		pigCons = pigCons.toLowerCase();
		w = w.substring(0, 1).toUpperCase() + w.substring(1);
	    }
	    if (hasPunct(w)){
		punc += w.substring(w.length() - 1, w.length());
		w = w.substring(0, w.length() - 1);
	    }
	}
	return w + pigCons + "ay" + punc;
    }


    public static void main( String[] args ) 
    {
	System.out.println("========================Testing hasA=============================");
	System.out.println(hasA("cat", "a")); //true
	System.out.println(hasA("cat", "b")); //false
	System.out.println(hasA("", "a")); //false
	System.out.println(hasA("cat", "sd")); //false
	System.out.println("==========================Testing isAVowel==========================");
	System.out.println(isAVowel("a")); //true
	System.out.println(isAVowel("e")); //true
	System.out.println(isAVowel("b")); //false
	System.out.println(isAVowel("as")); //false
	System.out.println("=========================Testing countVowels========================");
	System.out.println(countVowels("meatballa")); //4
	System.out.println(countVowels("adlsfkjhwealjhfvablkjeahn")); //6
	System.out.println(countVowels("")); //0
	System.out.println("=========================Testing hasAVowel=========================");
	System.out.println(hasAVowel("cat")); //true
	System.out.println(hasAVowel("zzz")); //false
	System.out.println(hasAVowel("")); //false
	System.out.println("=====================Testing allVowels===============================");
	System.out.println(allVowels("meatballa")); //eaaa
	System.out.println(allVowels("wrtypg")); //""
	System.out.println(allVowels("cat")); //a
	System.out.println(allVowels("")); //Please enter valid string 
	System.out.println("====================Testing firstVowel======================");
	System.out.println(firstVowel("acet")); // a
	System.out.println(firstVowel("caet")); // a
	System.out.println(firstVowel("ctea")); // e
	System.out.println(firstVowel("")); // ""
	System.out.println("=======================Testing beginsWithVowel==========================");
	System.out.println(beginsWithVowel("")); // false
	System.out.println(beginsWithVowel("acat")); // true
	System.out.println(beginsWithVowel("cast")); // false
	System.out.println("=======================Testing isFirstCap==========================");
	System.out.println(isFirstCap("Apple")); // true
	System.out.println(isFirstCap("apple")); // false
	System.out.println(isFirstCap("")); // false
	System.out.println("=======================Testing hasPunct==========================");
	System.out.println(hasPunct("Apple!")); // true
	System.out.println(hasPunct("apple")); // false
	System.out.println(hasPunct("")); // false
	System.out.println("=======================Testing isYVowel==========================");
	System.out.println(isYVowel("Yellow")); // false
	System.out.println(isYVowel("mystery")); // true
	System.out.println(isYVowel("rhythm")); // true
	System.out.println("===========================Testing engToPig==========================");
	System.out.println(engToPig("")); //""
	System.out.println(engToPig("apple")); //appleway
	System.out.println(engToPig("meatball")); //eatballmay
	System.out.println(engToPig("java")); //avajay
	System.out.println(engToPig("strong")); //ongstray
	System.out.println(engToPig("hi there bud how are you.")); //ihay erethay udbay owhay areway ouyay.
	System.out.println(engToPig("ApPle")); // Appleway
	System.out.println(engToPig("xD")); // xDay
	System.out.println(engToPig("Yellow")); // Ellowyay
	System.out.println(engToPig("don't")); // on'tday
	System.out.println(engToPig("Don't be a bad piggy!")); //On'tday ebay away adbay iggypay!
	//ScannerTestDriver
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()){
	    System.out.println(engToPig(sc.next()));
	}
	
    }//end main()
    
}//end class Pig
