import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class TelnetClient {
	public static void main(String[] args) {
		 try {
		    System.out.println("Trying to connect to 10.211.170.12");
			Socket soc=new Socket("10.211.170.12",3868);
			DataInputStream din=new DataInputStream(soc.getInputStream());        
	        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
	        System.out.println("Client connected");
	        //dout.writeUTF(command);
	        soc.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
