/*
Kendrick Liang
APCS1 pd 8
HW #20 -- For the Love of Strings
2017-10-19
*/
public class Foresrever{
    public static String fenceF(int posts){
	String fence = "";
	for (int x = 0; x < posts; x++){
	    if (x == 0){
		fence = "|";
	    }
	    else{
		fence += "--|";
	    }
	}
	return fence;
    }
    public static String reverseF(String s){
	String reverse = "";
	for (int x = s.length()-1;x >= 0; x--){
	    reverse += s.substring(x);
	    s = s.substring(0, x);
	}
	return reverse;
    }
    public static String reverseR(String s) 
    {     
        if ((s==null)||(s.length() <= 1) )
            return s;
        return reverseR(s.substring(1)) + s.substring(0, 1);
    }
    public static void main(String [] args){
	System.out.println(fenceF(3));
	System.out.println(reverseF("stressed"));
	System.out.println(reverseR("stressed"));
    }
}