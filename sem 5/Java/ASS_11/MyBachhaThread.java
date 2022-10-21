class MyBachhaThread impliments Runnable{
	Thread t;
	int s, e;
	public MyBachhaThread(int s, int e){
		t = new Thread(this);
		this.s = s;
		this.e = e;
	}

	public void run(){
		System.out.println(t.getName()+" Counting from "+e+" to "+s);
		for(int i=e; i>=s; i--){
			try{Thread.sleep(500);}
			catch(InterruptedException e){System.out.println(t+" interrupted.");}

			System.out.println(i+" ");
		}
	}

	public void start(){
		t.start();
	}
	public void stop(){
		t.stop();
	}
}

class CustomThread_02{
	public static void main(String[] args) {
		MyBachhaThread t1 = new MyBachhaThread(10, 20);
		MyBachhaThread t2 = new MyBachhaThread(22, 44);

		t1.start(); t2.start();
		
		for(int i=9; i>=1; i--){
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.println(t+" interrupted.");}

			System.out.println(i+" ");
		}
	}
}