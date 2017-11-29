public class GCD{
    public static int GCD(int a, int b){
	if (Math.max(a, b) % Math.min(a, b) == 0){
	    return Math.min(a, b);
	}
	else{
	    b = Math.max(a, b) - Math.min(a, b);
	    if (a == 0 || b == 0){
		return Math.max(a, b);
	    }
	    else{
		a += b;
		return GCD(a, b);
	    }
	}
    }
    public static void main(String [] args){
	String strGCD = "" + GCD(15, 20);
	System.out.println(strGCD);
    }
}