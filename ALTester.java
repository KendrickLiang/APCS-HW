/*
Kendrick Liang
APCS1 pd8
HW46 -- Al<B> Sorted!
2017-12-4
*/
import java.util.ArrayList;
public class ALTester{
    static int _size = 23;
    public static void populate(ArrayList a){
	for (int i = 0; i < _size; i++)
	    a.add((Integer)((int)(Math.random() * _size)));
    }
    public static boolean sorted(ArrayList a){
	for (int i = 0; i < _size - 1; i++){
	    if ((int)a.get(i) > (int)a.get(i + 1)) {
		return false;
	    }
	}
	return true;
    }
    public String toString(ArrayList a){
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += (int)a.get(i) + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }
    public static void main(String[] args){
	ArrayList foo = new ArrayList();
	populate(foo);
	System.out.println(foo);
	System.out.println(sorted(foo));
    }
}