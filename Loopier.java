public class Loopier{
    public static int indexCtr = 0;
    public static int matchCtr = 0;
    public static void pop(int[] nums){
	for (int x = 0; x < nums.length; x++){
	    nums[x] = (int)(Math.random() * nums.length);
	}
    }
    public static String strInt(int[] nums){
	String strInt = "[";
	for (int x = 0; x < nums.length; x++){
	    if (x < nums.length - 1){
		strInt += nums[x] + ", ";
	    }
	    else{
		strInt += nums[x];
	    }
	}
	return strInt + "]";
    }
    public static int linSearch(int[] a, int target){
	for (int x = 0; x < a.length; x++){
	    if (a[x] == target){
		return x;
	    }
	}
	return -1;
    }
    public static int linSearchR(int[] a, int target){
	if (indexCtr == a.length) {
	    return -1;
	}else if (a[indexCtr] == target){
	    return indexCtr;
	}else{
	    indexCtr += 1;
	    return linSearchR(a, target);
	}
    }
    public static int freq(int[] a, int target){
	int freqCtr = 0;
	for (int x = 0; x < a.length; x++){
	    if (a[x] == target){
		freqCtr += 1;
	    }
	}
	return freqCtr;
    }
    public static int freqR(int[] a, int target){
	if (linSearch(a, target) == -1 || indexCtr == a.length){
	    return matchCtr;
	}
	else if (a[indexCtr] == target){
	    matchCtr += 1;
	}
	indexCtr += 1;
	return freqR(a, target);
    }
    public static void main(String[] args){
	int[] intArray = new int[10];
	pop(intArray);
	System.out.println(strInt(intArray));
	System.out.println(linSearch(intArray, 5));
	System.out.println(linSearchR(intArray, 5));
	System.out.println(freq(intArray, 5));
	System.out.println(freqR(intArray, 5));
    }
}
