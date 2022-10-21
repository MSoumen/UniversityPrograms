/*
//Q1.
// Output
System defined information
MainThread = Thread[main,5,main]
After changing thread name : Thread[Soumen's_Thread,5,main]
Now saying 1-10 in 0.5s interval:
1 2 3 4 5 6 7 8 9 10
Thread finishes its work.
*/
public class CustomThread_01{
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("System defined information\n"+
			"MainThread = "+t);
		t.setName("Soumen's_Thread");
		System.out.println("After changing thread name : "+t);

		System.out.println("Now saying 1-10 in 0.5s interval:");
		for(int i=1; i<=10; i++){
			try{Thread.sleep(500);}
			catch(InterruptedException e){System.out.println("Main thread interrupted.");}

			System.out.print(i+" ");
		}
		System.out.println("\nThread finishes its work.");
	}
}