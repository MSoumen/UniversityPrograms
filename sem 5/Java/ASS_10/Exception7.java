// write a program in java to implement exception handling in such a manner there should be two try blocks 
// one of which will be generating a NullPointerException followed by a finally block
// which will display the message "Display inspite of NullPointerException"
/// and another try block should contain an explicit return statement followed by a finally block that displays the message
// "Display inspite of return";

class Custom{
	void func(){
		System.out.println("Custom.func()");
	}
	
}
class Driver{
	static int stubMethod(){
		Custom obj = new Custom();
//		try block 1
		try{
			obj=null;
			obj.func();
		}
		catch(NullPointerException e){ e.printStackTrace();}
		finally{ System.out.println("Display inspite of NullPointerException\n\n");}

//		try block 2
		try{
			int a = 4/0;
			return a;
		}
		catch(ArithmeticException e){ e.printStackTrace();}
		finally{ System.out.println("Display inspite of Return");}
		
		return -1;
	}
}

public class Exception7{
	public static void main(String[] args) {
		Driver.stubMethod();
	}
		
}