class Outer{
	Outer(){
		System.out.println("Outer class Constructor.");
	}

	class Inner{
		int num;
		Inner(int a){
			num=a;
			System.out.println("Inner class Constructor.");
		}
		void display(){
			System.out.println("Inner :: num = "+num);
		}
	}

	static class InnerStatic{
		static int num=10;
		static void display(int n){
			System.out.println("InnerStatic :: num = "+n);
		}
	}

	void callNestedClass(){
		Inner inObj = new Inner(40);
		inObj.display();
	}
}

public class OuterDemo{
	public static void main(String[] args) {
		Outer obj = new Outer();
		//calling Inner display using Outer method
		obj.callNestedClass();

		//directly calling Inner class
		Outer.Inner inObj = new Outer().new Inner(50);
		inObj.display();

		Outer.InnerStatic.display(10);
	}
}