/*
Kendrick Liang
APCS1 pd8
HW37 -- Be Rational
2017-11-17
 */
public class Rational{
    public int p;
    public int q;
    public Rational(){
	p = 0;
	q = 1;
    }
    public Rational(int x, int y){
	if (y == 0){
	    System.out.print("Error: denominator is invalid. ");
	    p = 0;
	    q = 1;
	}
	else{
	    p = x;
	    q = y;
	}
    }
    public String toString(){
	return "" + p + "/" + q;
    }
    public static int max(int a, int b){
	if (a > b){ // if a > b, return a
	    return a;
	}
	return b; // otherwise return b
    }
    public static double floatValue(Rational rat){
	return ((double) rat.p)/rat.q;
    }
    public void multiply(Rational rat){
	this.p *= rat.p;
	this.q *= rat.q;
    }
    public void divide(Rational rat){
	this.p /= rat.p;
	this.q /= rat.q;
    }
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
    public void add(Rational rat){
	if (this.q != rat.q){
	    Rational gcd = new Rational((gcdER(this.q, rat.q)),(gcdER(this.q, rat.q)));
	    int thisDenom = this.q;
	    int ratDenom = rat.q;
	    if (gcd.p != 1){
		this.multiply(gcd);
		rat.multiply(gcd);
	    }
	    else{
		this.q *= ratDenom;
		this.p *= ratDenom;
		rat.q *= thisDenom;
		rat.p *= thisDenom;
	    }
	}
	this.p += rat.p;
    }
    public void subtract(Rational rat){
	if (this.q != rat.q){
	    Rational gcd = new Rational((gcdER(this.q, rat.q)),(gcdER(this.q, rat.q)));
	    int thisDenom = this.q;
	    int ratDenom = rat.q;
	    if (gcd.p != 1){
		this.multiply(gcd);
		rat.multiply(gcd);
	    }
	    else{
		this.q *= ratDenom;
		this.p *= ratDenom;
		rat.q *= thisDenom;
		rat.p *= thisDenom;
	    }
	}
	this.p -= rat.p;
    }
    public int gcd(){
	return gcdER(this.p, this.q);
    }
    public void reduce(){
	Rational gcd = new Rational(gcd(), gcd());
	this.divide(gcd);
    }
    public int compareTo(Rational rat){
	if ((this.q * rat.p) == (this.p * rat.q)){
	    return 0;
	}
	else if ((this.q * rat.p) < (this.p * rat.q)){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    public static void main(String[]args){
	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2
	Rational z = new Rational(1,0); //Tries to store rational number 1/0
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	System.out.println(z);
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r);
	r.divide(s);//Divides r by s, changes r to 2/3. s remains 1/2
	System.out.println(r);
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	System.out.println(r);
	r.subtract(s); //Subtracts r by s, changes r to 4/6.  s remains 1/2
	System.out.println(r);
	System.out.println(r.compareTo(s));
	t.reduce(); //Changes t to 2/9
	System.out.println(t);
    }
}
