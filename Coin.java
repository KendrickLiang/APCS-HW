/*
Kendrick Liang
APCS1 pd 8
HW #15 -- Wayne's World
2017-10-12
*/
public class Coin{
    private double value;
    private String upFace;
    private String name;
    private int flipCtr;
    private int headsCtr;
    private int tailsCtr;
    private double bias;
    public Coin(){
	value = 0.0;
	upFace = "heads";
	name = null;
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;
    }
    public Coin(String newName){
	value = 0.0;
	upFace = "heads";
	name = newName;
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;
	assignValue();
    }
    public Coin(String newName, String newFace){
	value = 0.0;
	upFace = newFace;
	name = newName;
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;
	assignValue();
    }
    public String toString() {
        return String.format(name + " -- " + upFace);
    }
    public void flip(){
	flipCtr += 1;
	if ( Math.random() < bias ){
	    upFace = "heads";
	    headsCtr += 1;
	}
	else{
	    upFace = "tails";
	    tailsCtr += 1;
	}
    }
    public boolean equals(Object obj){
        if (obj == this){
            return true;
	}
	if (obj == null){
	    return false;
	}
	if (obj instanceof Coin){
	    Coin test = (Coin) obj;
	    if (test.upFace == this.upFace){
		return true;
	    }
	}
	return false;
    }
    public void assignValue(){
	if (name == "penny"){
	    value = 0.01;
	}
	else if (name == "nickel"){
	    value = 0.05;
	}
	else if (name == "dime"){
	    value = 0.1;
	}
	else if (name == "quarter"){
	    value = 0.25;
	}
	else {
	    value = 1.00;
	}
    }
    public int getHeadsCtr(){
	return this.headsCtr;
    }
    public String getUpFace(){
	return this.upFace;
    }
}