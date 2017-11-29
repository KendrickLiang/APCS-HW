/***
  driver for class Coin
  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Move the "TOP" line below the first statement. 
  (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver
{
    public static void main( String[] args )
    {
	int x = 15;

	int y = 30;

	int matchCtr = 0;
	
	Coin mine = new Coin();
	
	Coin yours = new Coin( "quarter" );
	int heads1 = yours.getHeadsCtr();
	Coin wayne = new Coin( "dollar", "heads" );
	int heads2 = wayne.getHeadsCtr();
	
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);
	while (heads1 < x && heads2 < x){
	    System.out.println("\nAfter flipping...");
	    if (yours.getUpFace() == "heads"){
		heads1 += 1;
		String strHeads1 = "" + heads1;
		System.out.println("yours has " + strHeads1 + " heads.");
	    }
	    if (wayne.getUpFace() == "heads"){
		heads2 += 1;
		String strHeads2 = "" + heads2;
		System.out.println("wayne has " + strHeads2 + " heads.");
	    }
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);
	    
	    
	    if ( yours.equals(wayne) ) {
		System.out.println( "Matchee matchee!" );
		matchCtr += 1;
	    }
	    else{
		System.out.println( "No match. Firestarter you can not be.");
	    }
	}
	System.out.println("--------------------------------------------------------------");
	while (matchCtr < y){
	    System.out.println("\nAfter flipping...");
	    yours.flip();
	    wayne.flip();
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);
	    
	    
	    if ( yours.equals(wayne) ) {
		System.out.println( "Matchee matchee!" );
		matchCtr += 1;
	    }
	    else{
		System.out.println( "No match. Firestarter you can not be.");
	    }
	    String strMatch = "" + matchCtr;
	    System.out.println(strMatch + " matches made.");
	}
	System.out.println("--------------------------------------------------------------");
	while (matchCtr < 13000 || (matchCtr % 2001 != 0)){
	    System.out.println("\nAfter flipping...");
	    yours.flip();
	    wayne.flip();
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);
	    
	    
	    if ( yours.equals(wayne) ) {
		System.out.println( "Matchee matchee!" );
		matchCtr += 1;
	    }
	    else{
		System.out.println( "No match. Firestarter you can not be.");
	    }
	    String strMatch = "" + matchCtr;
	    System.out.println(strMatch + " matches made.");
	}
    }//end main()
    
}//end class
