//Q2.
// Output:
/*
Tiger Counting from 15 to 10

Lion Counting from 27 to 22

ChildThread Tiger i : 15
ChildThread Lion i : 27

MainThread i = 5
ChildThread Tiger i : 14
ChildThread Lion i : 26
ChildThread Tiger i : 13
ChildThread Lion i : 25

MainThread i = 4
ChildThread Tiger i : 12
ChildThread Lion i : 24
ChildThread Tiger i : 11
ChildThread Lion i : 23

MainThread i = 3
ChildThread Tiger i : 10
ChildThread Lion i : 22

MainThread i = 2

MainThread i = 1
*/

class MyBachhaThread implements Runnable{
	Thread t;
	int s, e;
	public MyBachhaThread(int s, int e, String name){
		t = new Thread(this);
		this.s = s;
		this.e = e;
		t.setName(name);
	}

	public void run(){
		System.out.println(t.getName()+" Counting from "+e+" to "+s+"\n");
		for(int i=e; i>=s; i--){
			try{Thread.sleep(500);}
			catch(InterruptedException e){System.out.println(t+" interrupted.");}

			System.out.println("ChildThread "+t.getName()+" i : "+i+" ");
		}
	}

	public void start(){
		t.start();
	}
	// public void stop(){
	// 	t.stop();
	// }
}

public class CustomThread_02{
	public static void main(String[] args) {
		MyBachhaThread t1 = new MyBachhaThread(10, 15, "Tiger");
		MyBachhaThread t2 = new MyBachhaThread(22, 27, "Lion");

		t1.start(); t2.start();

		for(int i=5; i>=1; i--){
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println("MainThread interrupted.");}

			System.out.println("\nMainThread i = "+i);
		}
	}
}