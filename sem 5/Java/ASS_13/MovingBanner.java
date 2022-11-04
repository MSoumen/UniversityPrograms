import java.awt.*;
import java.applet.*;
/*<applet code="MovingBanner" width=100 height=100></applet>*/
public class MovingBanner extends Applet implements Runnable{
	String bannerText = "My Name Is Soumen ";
	volatile boolean stopAnimation;
	int state;
	Thread t;

	// public void init(){
	// 	setBackground(Color.BLACK);
	// 	setForeground(Color.GREEN);
	// }
	public void start(){
		setBackground(Color.BLACK);
		setForeground(Color.GREEN);

		stopAnimation=false;
		t = new Thread();
		t.start();
	}
	public void stop(){
		stopAnimation=true;
		t=null;
	}

	public void paint(Graphics g){
		char c = bannerText.charAt(0);
		bannerText = bannerText.substring(1, bannerText.length());
		bannerText += c; //String.valueOf(c);

		g.drawString(bannerText, 20, 20);
	}

	public void run(){
		while(true){
			repaint();
		
			try{Thread.sleep(200);}
			catch(InterruptedException e){System.out.println("Interrupted!");}
		
			if(stopAnimation) break;
		}
	}
}