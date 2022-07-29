import java.io.*;

class Point{
	int x,y;
	Point(int x, int y){
		this.x= x;
		this.y = y;
	}
	Point(){
		x=y=0;
	}

	static double distanceBetween(Point obj1, Point obj2){
		int tmpx = obj1.x - obj2.x;
		int tmpy = obj1.y - obj2.y;

		return (Math.sqrt((tmpx*tmpx) + (tmpy*tmpy)));
	}
}

public class PointDemo{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		System.out.print("Enter 1st Point : ");
		String inps[] = br.readLine().split(" ");
		Point p1= new Point(Integer.parseInt(inps[0]), Integer.parseInt(inps[1]));

		System.out.print("Enter 2nd Point : ");
		inps = br.readLine().split(" ");
		Point p2= new Point(Integer.parseInt(inps[0]), Integer.parseInt(inps[1]));

		System.out.printf("Distance  = %.2f",Point.distanceBetween(p1,p2));

	}
}