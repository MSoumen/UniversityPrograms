import java.net.*;

class CheckIP{
	public static void main(String args[]) throws UnknownHostException{
		InetAddress localHostIP = InetAddress.getLocalHost();
		System.out.println("My IP address : "+localHostIP);

		String website = "fast.com";
		InetAddress remoteHostIP = InetAddress.getByName(website);
		System.out.println(website+"'s IP: "+remoteHostIP);
	}
}