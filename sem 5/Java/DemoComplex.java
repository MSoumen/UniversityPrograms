import java.io.*;

class Complex{
	int realPart=0, imgPart=0;
	static String number = "";

	Complex(int r, int img){
		realPart=r; imgPart=img;
	}
	 void display(){
		number = String.valueOf(realPart)+"+i"+String.valueOf(imgPart);
		System.out.println(number);
	}
	static String sum(Complex obj1, Complex obj2){
		int realSum = obj1.realPart+obj2.realPart;
		int imgSum = obj1.imgPart+obj2.imgPart;
		return (String.valueOf(realSum)+"+i"+String.valueOf(imgSum));
	}
	static String diff(Complex obj1, Complex obj2){
		int realDiff = obj1.realPart-obj2.realPart;
		int imgDiff = obj1.imgPart-obj2.imgPart;
		return (String.valueOf(realDiff)+"+i"+String.valueOf(imgDiff));
	}
	static String mul(Complex obj1, Complex obj2){
		int realMul = obj1.realPart*obj2.realPart;
		int imgMul = obj1.imgPart*obj2.imgPart;
		return (String.valueOf(realMul)+"+i"+String.valueOf(imgMul));
	}

	static double modulus(Complex obj1){
		int x = obj1.realPart;
		int y = obj1.imgPart;
		return (Math.sqrt((x*x) + (y*y)));
	}
	static String getComplement(Complex obj){
		return String.valueOf(obj.realPart)+"-i"+String.valueOf(obj.imgPart);
	}
}

class DemoComplex{
	static void println(String s){
		System.out.println(s);
	}
	static void print(String s){
		System.out.print(s);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		print("Enter 1st Complex number(a b where a is realPart b is imgPart): ");
		String inps[] = br.readLine().split(" ");
		Complex cnum1 = new Complex(Integer.parseInt(inps[0]), Integer.parseInt(inps[1]));

		print("\nEnter 2nd Complex number(a b where a is realPart b is imgPart): ");
		inps = br.readLine().split(" ");
		Complex cnum2 = new Complex(Integer.parseInt(inps[0]), Integer.parseInt(inps[1]));
		
		System.out.print("Complex number 1 = "); cnum1.display();
		System.out.print("Complex number 2 = "); cnum2.display();
		println("\n------------- Part 1 ---------------");
		System.out.println("Sum = "+Complex.sum(cnum1, cnum2));
		System.out.println("Difference = "+Complex.diff(cnum1, cnum2));
		System.out.println("Multiple = "+Complex.mul(cnum1, cnum2));

		println("\n------------- Part 2 ---------------");
		System.out.printf("Modulus of Complex number 1 = %.2f\n",Complex.modulus(cnum1));
		println("Complement of Complex number 2 = "+Complex.getComplement(cnum1));
	}
}