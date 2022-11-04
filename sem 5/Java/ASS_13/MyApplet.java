import java.applet.*;
import java.awt.*;

/*<applet code="MyApplet" width=640 height=420></applet>*/
public class MyApplet extends Applet{
	// public void start(){
	// 	repaint();
	// }
	public void paint(Graphics g){
		g.drawString("Hello World", 640/2, 420/2);
	}
}