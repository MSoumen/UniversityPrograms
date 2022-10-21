/*
// Q3.
// Output:
Thread Elder is active ? = true
Thread Younger is active ? = true
MainThread i = 58
Thread Elder is active ? = true
Thread Younger is active ? = true


Thread Elder is active ? = true
Thread Younger is active ? = true
MainThread i = 57
Thread Elder is active ? = true
Thread Younger is active ? = true


Thread Elder is active ? = true
Thread Younger is active ? = true
MainThread i = 56
Thread Elder is active ? = true
Thread Younger is active ? = true


Thread Elder is active ? = true
Thread Younger is active ? = true
MainThread i = 55
Thread Elder is active ? = false
Thread Younger is active ? = false

Thread Elder is active ? = false
Thread Younger is active ? = false
MainThread Exited.
*/
class MyBachhaThread implements Runnable{
	Thread t;
	public MyBachhaThread(String name){
		t = new Thread(this);
		t.setName(name);
	}

	public void run(){
		for(int i=1; i<=7; i++){
			try{Thread.sleep(500);}
			catch(InterruptedException e){System.out.println(t+" interrupted.");}
		}
	}

	public String getName(){
		return t.getName();
	}

	public void start(){
		t.start();
	}
}


public class CustomThread_03{
	public static void checkIfActive(MyBachhaThread t1, MyBachhaThread t2){
		System.out.println("Thread "+t1.getName()+" is active ? = "+t1.t.isAlive());
		System.out.println("Thread "+t2.getName()+" is active ? = "+t2.t.isAlive());
	}

	public static void main(String[] args) {
		MyBachhaThread t1 = new MyBachhaThread("Elder"),
						t2 = new MyBachhaThread("Younger");

		t1.start();
		t2.start();

		for(int i=58; i>=55; i--){
			System.out.println();
			checkIfActive(t1, t2);
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println("MainThread interrupted.");}

			System.out.println("MainThread i = "+i);
			checkIfActive(t1, t2);
			System.out.println();
		}
		try{
			t1.t.join();
			t2.t.join();
		}catch(Exception e){e.printStackTrace();}

		checkIfActive(t1, t2);
		System.out.println("MainThread Exited.");
	}
}