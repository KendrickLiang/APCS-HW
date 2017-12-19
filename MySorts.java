/*
Team Red
Kendrick Liang
APCS1 Pd8
hw55 -- Never Fear, Big Oh Is Here!
2017-12-14
*/

/******************
 * class MySorts contains the implementations of 3 sorts
 * For linear search:
 * best case: newVal can be inserted at beginning (would only run one time, meaning O(1))
 * worst case: newVal has to be inserted at end (would run n times to reach end, meaning O(n))
 * For binary search:
 * best case: newVal can be added in the middle (O(1) because it runs one time to place it the middle index where it starts from)
 * worst case: newVal is at end or one index away from middle (addBin would have to keep halving the ArrayList until it found its value, so O(log2n))
 *****************/


import java.util.ArrayList;
public class MySorts{

    // VOID version of InsertionSort                                             
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // best case: all elements are already sorted in ascending order. Runs n times to compare and make sure each element < the next. O(n).
    // worst case: all elements are in descending order. Runs n times to compare and each time n swaps are made. O(n^2).
    public static void insertionSortV( ArrayList<Comparable> data )
    {
	int swapCtr = 0;
	//n-1 passes are required                                                   
	for (int passCtr = 1; passCtr < data.size(); passCtr ++){// runs n times to compare adjecent elements
	    System.out.println( "commencing pass #" + passCtr + "...");             
	    //passCtr also signifies where the partition is between sorted/unsorted       
	    for (int i = passCtr; i > 0; i--){// runs another n times to commence swap
		//swapping into order                                         
		if (data.get(i).compareTo(data.get(i-1)) < 0){
		    Comparable smaller = data.get(i);
		    Comparable swapper = data.get(i - 1);
		    data.set(i-1, smaller);
		    data.set(i, swapper);
		    swapCtr += 1;
		}
	    }
	}
	System.out.println("" + swapCtr + " swaps made");
    }//end insertionSortV 


    // VOID version of SelectionSort                                                                  
    // Rearranges elements of input ArrayList                                        
    // postcondition: data's elements sorted in ascending order
    // There is no best or worst case scenario
    // No matter what, the correct index has to be found n for n elements, and each element will always swap into
    // their correct position, even if they are already there, so O(n^2) for all cases.
    public static void selectionSortV( ArrayList<Comparable> data )
    {
	int swapCtr = 0;
        //makes n-1 passes across collection                                                                 
        for (int passCtr = 1; passCtr < data.size(); passCtr ++ ){// runs n times to swap elements into correct position

            System.out.println( "commencing pass #" + passCtr + "..." );                                 

            //uses reigning champ method to find the smallest Comparable                              
            int minInd = passCtr - 1;
            for (int i = passCtr - 1; i < data.size(); i++){// runs n times to find correct position
                if (data.get(minInd).compareTo(data.get(i)) > 0)
                    minInd = i;
            }

            //swaps smallest with passCtr - 1 index                                                    
            Comparable smallest = data.get(minInd);
            Comparable swapW = data.get(passCtr - 1);
            data.set(passCtr - 1, smallest);
            data.set(minInd, swapW);
	    swapCtr += 1;
            System.out.println("min value in this pass: " + data.get(minInd));          
            System.out.println(data);                                                           
        }
	System.out.println("" + swapCtr + " swaps made");
    }//end selectionSortV   


    // VOID version of bubbleSort                                                        
    // Rearranges elements of input ArrayList                                                     
    // postcondition: data's elements sorted in ascending order   
    // best case: all elements are already sorted in ascending order. Runs n times to compare and make sure each element < the next. O(n).
    // worst case: all elements are in descending order. Runs n times to compare and each time n swaps are made. O(n^2).                                   
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	int swapCtr = 0;
        //the amount of passes that is necessary is the amount of items minus 1                        
        for (int pass  = data.size() - 1; pass >= 1; pass -= 1){// runs n times to compare adjecent elements
	    System.out.println( "commencing pass #" + (data.size() - pass) + "..." );
            for (int ctr = data.size() - 1; ctr >= 1; ctr -= 1){// runs another n times to commence swap
                Comparable first = data.get(ctr);
                Comparable second = data.get(ctr - 1);
                if (first.compareTo(second) < 0){
                    //swap if out of order:                                                     
                    data.set(ctr, second);
                    data.set(ctr - 1, first);
		    swapCtr += 1;
                }
            }
        }
	System.out.println("" + swapCtr + " swaps made");
    }//end bubbleSortV



}