import java.io.*;

public class BoxDemo_22July{
	public static void display(double h, double w, double d){
		Box obj = new Box();
		System.out.println("\nConstructor with no parameter\nBox() gives volume = "+obj.getVolume());
		Box cube = new Box(h);
		System.out.println("\nConstructor with 1 parameter\nBox("+h+") gives volume = "+cube.getVolume());
		Box boxObj = new Box(h,w,d);
		System.out.println("\nConstructor with 3 parameter\n"+
			"Box("+h+","+w+","+d+") gives volume = "+boxObj.getVolume());
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		System.out.print("Enter FatBox's height, width and depth : ");
		String inps[] = br.readLine().split(" ");
		double h = Double.parseDouble(inps[0]),
			w = Double.parseDouble(inps[1]),
			d = Double.parseDouble(inps[2]);

		System.out.println("\n------- Assignment 2 ----------");
		display(h,w,d);

		System.out.println("\n------- Assignment 3A ----------");
		Box aBox = new Box(h,w,d);
		System.out.print("Enter ThinBox's height, width and depth : ");
		inps = br.readLine().split(" ");
		h = Double.parseDouble(inps[0]);
		w = Double.parseDouble(inps[1]);
		d = Double.parseDouble(inps[2]);
		Box bBox = new Box(h,w,d);
		System.out.print("FatBox and ThinBox have ");
		if(bBox.equals(aBox)) System.out.println("SAME Dimensions.");
		else System.out.println("DIFFERENT Dimensions.");

		//Copy constractor example
		System.out.println("\n------- Assignment 3B ----------");
		Box fatBoxClone = new Box(aBox);
		System.out.println("FatBox has dimensions : "); aBox.displayDimensions();
		System.out.println("FatBoxClone has dimensions : "); fatBoxClone.displayDimensions();

		System.out.println("\n------- Assignment 4 ----------");
		aBox.printParam(40);
		aBox.printParam(69, 39);
		aBox.printParam(78, 8, 87);
	}
}