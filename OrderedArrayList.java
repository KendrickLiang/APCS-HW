/*
Kendrick Liang
APCS1 pd8
hw49 -- Halving the Halves
2017-12-07
*/
/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        _data.add( p, newVal );
        return;
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }
    
    /*addBin takes a new element as an argument,
      sets up a range based on the size of the OrderedArrayList,
      and compares the new element to the elements in the middle
      of the OrderedArrayList. If it doesn't fit, addBin will keep
      narrowing the range and adjusting the middle value until a
      fitting position is found.
     */
    public int addBin(Comparable newVal){
	int lo = 0;
	int hi = size() - 1;
	int mid = lo + (hi - 1)/2;
	while (newVal.compareTo(_data.get(mid)) <= 0 || newVal.compareTo(_data.get(mid + 1)) >= 0){
	    if (newVal.compareTo(_data.get(mid)) < 0)
		hi = mid - 1;
	    else
		lo = mid + 1;
	    mid = lo + (hi - 1)/2;
	}
	return mid + 1;
    }
		
	    

  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
    System.out.println("New element 25 can be found at index " + Franz.addBin(25));
  }//end main()

}//end class OrderedArrayList
