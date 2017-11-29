public class BigSib {
    private String helloMsg;
    public BigSib(String str){
	helloMsg = str;
    }
    public BigSib(){
	helloMsg = "I love";
    }
    public static void main (String[] args){
	//The CS Dojo is mad helpful!
    }
    public String greet (String name){
	return helloMsg + " " + name;
    }
}
