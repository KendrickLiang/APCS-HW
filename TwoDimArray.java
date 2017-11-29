/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Kendrick Liang
// APCS1 pd8
// HW34 -- 2D arrays
// 2017-11-17

public class TwoDimArray
{
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
	for (int x = 0; x < a.length; x++){
	    for (int y = 0; y < a[x].length; y++){
		System.out.println(a[x][y]);
	    }
	}
    }
    
    
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {
	for (int[] x: a){
	    for (int y: x){
		System.out.println(y);
	    }
	}
    }
    
    
    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {
	int total = 0;
	for (int x = 0; x < a.length; x++){
	    for (int y = 0; y < a[x].length; y++){
		total += a[x][y];
	    }
	}
	return total;
    }
    
    
    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int total = 0;
	for (int x = 0; x < m.length; x++){
	    total += sumRow(x, m);
	}
	return total;
    }
    
    
    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int total = 0;
	for (int y = 0; y < a[r].length; y++){
	    total += a[r][y];
	}
	return total;
    }
    
    
    //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int total = 0;
	for (int y: m[r]){
	    total += y;
	}
	return total;
    }
    
    
    public static void main( String [] args )
    {
	
	  int [][] m1 = new int[4][2];
	  int [][] m2 = { {2,4,6}, {3,5,7} };
	  int [][] m3 = { {2}, {4,6}, {1,3,5} };
	  print1(m1);
	  print1(m2);
	  print1(m3);
	  print2(m1);
	  print2(m2);
	  print2(m3);
	  System.out.print("testing sum1...\n");
	  System.out.println("sum m1 : " + sum1(m1));
	  System.out.println("sum m2 : " + sum1(m2));
	  System.out.println("sum m3 : " + sum1(m3));
	  System.out.print("testing sum2...\n");
	  System.out.println("sum m1 : " + sum2(m1));
	  System.out.println("sum m2 : " + sum2(m2));
	  System.out.println("sum m3 : " + sum2(m3));
    }
    
}//end class TwoDimArray