/*
Kendrick Liang
APCS1 pd8
hw51 -- Selection
2017-12-11
*/

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    
    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	for (int passCtr = 0; passCtr < data.size() - 1; passCtr++){
	    int mindex = passCtr;
	    for (int j = passCtr + 1; j < data.size(); j++){
		if (data.get(j).compareTo(data.get(mindex)) < 0)
		    mindex = j;
	    }
	    data.set(passCtr, data.set(mindex, data.get(passCtr)));
	}
    }//end selectionSortV
    
    
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> retArr = new ArrayList();
	for (Comparable c: input)
	    retArr.add(c);
	selectionSortV(retArr);
	return retArr;
    }//end selectionSort 
    
    
    public static void main( String [] args ) 
    {
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	ArrayList glon = new ArrayList<Integer>();
	glon.add(7);
	glon.add(1);
	glon.add(5);
	glon.add(12);
	glon.add(3);
	System.out.println( "ArrayList glon before sorting:\n" + glon );
	ArrayList glonSorted = selectionSort( glon );
	System.out.println( "sorted version of ArrayList glon:\n" 
			    + glonSorted );
	System.out.println( "ArrayList glon after sorting:\n" + glon );
	
	ArrayList toto = populate( 10, 1, 1000 );
	System.out.println( "ArrayList toto before sorting:\n" + toto );
	ArrayList totoSorted = selectionSort( toto );
	System.out.println( "sorted version of ArrayList toto:\n" 
			    + totoSorted );
	System.out.println( "ArrayList toto after sorting:\n" + toto );
	
    }//end main
    
}//end class SelectionSort
