public class Repeater{
    static String fence = "|";
    public static String fenceW(int numPosts){
	while (numPosts > 1){
	    fence += "--|";
	    numPosts -= 1;
	}
	return fence;
    }
    public static String fenceR(int numPosts){
	fence = "|";
	if (numPosts == 1){
	    return fence;
	}
	else {
	    return fence += "--" + fenceR(numPosts - 1);
	}
    }
    public static void main(String[] args){
	System.out.println(fenceW(3));
	System.out.println(fenceR(3));
    }
}