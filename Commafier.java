public class Commafier{
    public static String commafyR(int a){
	String strInt = "" + a;
	if (a == 0){
	    return "000";
	}
	if (strInt.length() <= 3){
            return strInt;
	}
	else{
	    if (strInt.length() % 3 == 0){
		return strInt.substring(0, 3) + "," + commafyR(Integer.parseInt(strInt.substring(3)));
	    }
	    else{
		return strInt.substring(0, strInt.length() % 3) + "," + commafyR(Integer.parseInt(strInt.substring(strInt.length() % 3)));
	    }
	}
    }
    public static String commafyF(int a){
	String strInt = "" + a;
	String result = "";
	for (int x = 1; x <= strInt.length(); x++){
	    String digit = strInt.substring(strInt.length() - x, strInt.length() - x + 1);
	    result = digit + result;
	    if (x % 3 == 0 && strInt.length() > 3){
		result = "," + result;
	    }
	}
	return result;
    }
    public static void main(String args []){
	for (String s: args){
	    System.out.println(commafyR(Integer.parseInt(s)));
	    System.out.println(commafyF(Integer.parseInt(s)));
	}
    }
}