//Q5: 

public class Exception5{
	public static void throwMeException() throws NullPointerException{
		throw new NullPointerException("Exception 5");}
	public static void main(String[] args) {
		try{ throwMeException();}
		catch(NullPointerException e){
			System.out.println("NullPointerException handled by throws keyword.");
}}}

/*
javac Exception5.java && java Exception5

javac Exception5.java && java Exception5
IllegalAccessException handled by throws keyword.
*/