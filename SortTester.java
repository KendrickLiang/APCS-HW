/*
Clara Mohri, Kendrick Liang
APCS1 pd8
hw53 -- Solid Comparative Analysis
2017-12-13
*/

import java.util.ArrayList;

public class SortTester{

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

    public static void main (String[] args){
	
	//random scenario
	System.out.println("\nUsing bubbleSort on random ArrayList glen...");
	ArrayList<Comparable> glen = populate(5, 1, 1000);
	System.out.println("ArrayList glen before sorting:\n" + glen);
	MySorts.bubbleSortV(glen);
	System.out.println("\nArrayList glen after sorting:\n" + glen);
	
	//worst case scenario 
	//if the array is in reverse order (descending order)
	System.out.println("\nUsing bubbleSort on worst case Arraylist...");
	ArrayList<Comparable> coco = new ArrayList<Comparable>();
	coco.add(10);
	coco.add(9);
	coco.add(8);
	coco.add(7);
	coco.add(6);
	System.out.println("ArrayList coco before sorting:\n" + coco);
	MySorts.bubbleSortV(coco);
	System.out.println("\nArrayList coco after sorting:\n" + coco);
	
	//best case scenario
	//if the array is already sorted
	System.out.println("\nUsing bubbleSort on best case Arraylist...");
	ArrayList<Comparable> bestcase1 = new ArrayList<Comparable>();
	bestcase1.add(1);
	bestcase1.add(2);
	bestcase1.add(3);
	bestcase1.add(4);
	bestcase1.add(5);
	System.out.println("ArrayList bestcase1 before sorting:\n" + bestcase1);
	MySorts.bubbleSortV(bestcase1);
	System.out.println("\nArrayList bestcase1 after sorting:\n" + bestcase1);

	//random scenario
	System.out.println("\nUsing selectionSort on random ArrayList glon...");
	ArrayList<Comparable> glon = populate(5, 1000, 1500);
	System.out.println("ArrayList glon before sorting:\n" + glon);
	MySorts.selectionSortV(glon);
	System.out.println("\nArrayList glon after sorting:\n" + glon);
	
	//worst case scenario 
	//if none of the elements are in their correct position
	System.out.println("\nUsing selectionSort on worst case Arraylist...");
	ArrayList<Comparable> toto = new ArrayList<Comparable>();
	toto.add(5);
	toto.add(4);
	toto.add(3);
	toto.add(2);
	toto.add(1);
	System.out.println("ArrayList toto before sorting:\n" + toto);
	MySorts.selectionSortV(toto);
	System.out.println("\nArrayList toto after sorting:\n" + toto);
	
	//best case scenario
	//if the array is already sorted
	System.out.println("\nUsing selectionSort on best case Arraylist...");
	ArrayList<Comparable> bestcase2 = new ArrayList<Comparable>();
	bestcase2.add(6);
	bestcase2.add(7);
	bestcase2.add(8);
	bestcase2.add(9);
	bestcase2.add(10);
	System.out.println("ArrayList bestcase2 before sorting:\n" + bestcase2);
	MySorts.selectionSortV(bestcase2);
	System.out.println("\nArrayList bestcase2 after sorting:\n" + bestcase2);

	//random scenario
	System.out.println("\nUsing insertionSort on random ArrayList glan...");
	ArrayList<Comparable> glan = populate(5, 1200, 2400);
	System.out.println("ArrayList glan before sorting:\n" + glan);
	MySorts.insertionSortV(glan);
	System.out.println("\nArrayList glan after sorting:\n" + glan);
	
	//worst case scenario 
	//if the array is in reverse order (descending order)
	System.out.println("\nUsing insertionSort on worst case Arraylist...");
	ArrayList<Comparable> lolo = new ArrayList<Comparable>();
	lolo.add(20);
	lolo.add(19);
	lolo.add(18);
	lolo.add(17);
	lolo.add(16);
	System.out.println("ArrayList lolo before sorting:\n" + lolo);
	MySorts.insertionSortV(lolo);
	System.out.println("\nArrayList lolo after sorting:\n" + lolo);
	
	//best case scenario
	//if the array is already sorted
	System.out.println("\nUsing insertionSort on best case Arraylist...");
	ArrayList<Comparable> bestcase3 = new ArrayList<Comparable>();
	bestcase3.add(11);
        bestcase3.add(12);
        bestcase3.add(13);
	bestcase3.add(14);
	bestcase3.add(15);
	System.out.println("ArrayList bestcase3 before sorting:\n" + bestcase3);
	MySorts.insertionSortV(bestcase3);
	System.out.println("\nArrayList bestcase3 after sorting:\n" + bestcase3);
    }
}
