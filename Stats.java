/* Team JK - Johnny Wong, Kendrick Liang
   APCS pd 8
   HW 19 -- gcd 3 ways
   2017-10-18 */

public class Stats {
    
    public static void sop (String str){
	System.out.println(str);
    }
    public static int mean(int a, int b){
	return (a+b)/2; // return the average of a and b
    }
    public static double mean(double a, double b){
	return (a+b)/2; // return the average of a and b
    }
    public static int max(int a, int b){
	if (a > b){ // if a > b, return a
	    return a;
	}
	return b; // otherwise return b
    }
    public static double max(double a, double b){
	if (a > b){ // if a > b, return a
	    return a;
	}
	return b; // otherwise return b
    }
    public static int geoMean(int a, int b){
	return ((int) Math.sqrt(a*b)); // typecast data type int onto the value of sqrt(a*b) and return it
    }
    public static double geoMean(double a, double b){	
	return Math.sqrt(a*b); // return sqrt(a*b)
    }
    public static int max(int a, int b, int c){
	return max(max(a,b),max(b,c)); // return max between the max of a and b and the max of b and c
    }
    public static double max(double a, double b, double c){
	return max(max(a,b),max(b,c)); // return max between the max of a and b and the max of b and c
    }
    public static int geoMean(int a, int b, int c){
	return ((int) Math.pow((a * b * c), (1.0/3.0))); // typecast data type int onto the value of Math.pow((a*b*c),(1.0/3.0)), which is the cube root of abc, and return it
    }
    public static double geoMean(double a, double b, double c){
	return Math.pow((a * b * c), (1.0/3.0)); // return cube root of abc
    }
    /* When the maximum of two numbers is divisible by the minumum, 
       return minimum as gcd. Otherwise, find remainder of the two integers,
       assign minimum of two numbers to a, assign remainder to b, and repeat process.
     */
    public static int gcdER(int a, int b){
	if (max(a,b) % Math.min(a, b) == 0){
	    return Math.min(a,b);
	}
	else{
	    int max = max(a, b), min = Math.min(a, b);
	    max -= min;
	    if (max == 0 || min == 0){
		return max(max, min);
	    }
	    else{
		return gcdER(max, min);
	    }
	}
    }
    public static int gcdEW(int a, int b){
	int remainder = max(a,b) % Math.min(a, b);
	while (remainder > 0){
	    a = Math.min(a, b);
	    b = remainder;
	    remainder = a % b;
	}
	return Math.min(a, b);
    }
    public static int gcd(int a, int b){
	int gcd = 1, count = 1, min = Math.min(a,b);
	while (count <= min){
	    if (a % count == 0 && b % count == 0){
		gcd = count;
	    }
	    count += 1;
	}
	return gcd;
    }

    
    public static void main (String [] args){
	Stats testMe = new Stats();
	
	//HW 12 Tests...
	
	sop("====================================");
	sop("Mean: ");
	System.out.println(testMe.mean(1,3)); // should be 2
	sop("====================================");
	sop("Mean: ");
	System.out.println(testMe.mean(1,2)); // should be 1
	sop("====================================");
	sop("Mean: ");
	System.out.println(testMe.mean(-2,-5)); // should be -3
	sop("====================================");
	sop("Mean: ");
	System.out.println(testMe.mean(1.1,2.4)); // should be 1.75
	sop("====================================");
	sop("Mean: ");
	System.out.println(testMe.mean(-1.1,-2.4)); // should -1.75
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(5,10)); // should be 10
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(9,6)); // should be 9
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(9,9)); // should be 9
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(5.5,5.55)); // should be 5.55
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(-5.4,-5.39)); // should be -5.39
	sop("====================================");
	sop("geoMean: ");
	System.out.println(testMe.geoMean(5,10)); // should be 7
	sop("====================================");
	sop("geoMean: ");
	System.out.println(testMe.geoMean(7.5,6.9)); // should be 7.193747...
	
	//HW 13 Tests...
	
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1,2,3)); // should be 3
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(2,1,3)); // should be 3
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(3,1,2)); // should be 3
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1,3,2)); // should be 3
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1,1,1)); // should be 1
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1.5,1.6,1.7)); // should be 1.7
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1.7,1.6,1.5)); // should be 1.7
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1.6,1.7,1.5)); // should be 1.7
	sop("====================================");
	sop("Max: ");
	System.out.println(testMe.max(1.0,1.0,1.0)); // should be 1.0
	sop("====================================");
	sop("geoMean: ");
	System.out.println(testMe.geoMean(10,5,7)); // should be 7
	sop("====================================");
	sop("geoMean: ");
	System.out.println(testMe.geoMean(10.0,5.0,7.0)); // should be 7.04729...

	// HW 19 Tests...
	sop("====================================");
	sop("gcdER: ");
	System.out.println(gcdER(15,20)); // should be 5
	sop("====================================");
	sop("gcdEW: ");
	System.out.println(gcdEW(15,20)); // should be 5
	sop("====================================");
	sop("gcd: ");
	System.out.println(gcd(15,20)); // should be 5
	
	
    } // end of main method
} // end of class Stats
