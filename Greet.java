public class Greet {
    public static void main( String[] args ){
	String greeting;
	
	BigSib richard = new BigSib("Word up");
	BigSib grizz = new BigSib("Hey ya");
	BigSib dotCom = new BigSib("Sup");
	BigSib tracy = new BigSib("Salutations");
	BigSib empty = new BigSib();

	greeting = richard.greet("freshman");
	System.out.println(greeting);
	
	greeting = tracy.greet("Dr. Spaceman");
	System.out.println(greeting);
	
	greeting = grizz.greet("Kong Fooey");
	System.out.println(greeting);
	
	greeting = dotCom.greet("mom");
	System.out.println(greeting);

	greeting = empty.greet("CodingBat");
	System.out.println(greeting);
    }
}