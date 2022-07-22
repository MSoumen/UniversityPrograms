public class Box_22July{
	double height, width, depth;
	//constructor Overloading
	public Box(double h, double w, double d){
		height = h;
		width = w;
		depth = d;
	}
	public Box(double len){
		height = width = depth = len;
	}
	public Box(){
		height = width = depth = 0.0;
	}

	//copy constructor
	public Box(Box bobj){
		this.height = bobj.height;
		this.width = bobj.width;
		this.depth = bobj.depth;
	}

	public double getVolume(){
		return (height*width*depth);
	}

	public boolean equals(Box obj){
		if(this.height==obj.height &&
			this.width == obj.width &&
			this.depth == obj.depth) return true;

		return false;
	}

	public void displayDimensions(){
		System.out.print("Height="+this.height+
			", Width="+this.width+
			", Depth="+this.depth+"\n");
	}

	public void printParam(int a){
		System.out.println("You Gives "+a);
	}
	public void printParam(int a, int b){
		System.out.println("You Gives "+a+", "+b);
	}
	public void printParam(int a, int b, int c){
		System.out.println("You Gives "+a+", "+b+", "+c);
	}

}