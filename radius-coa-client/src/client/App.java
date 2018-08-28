package client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import packets.CoaRequest;
import exception.CoaException;
import exception.InvalidParameterException;

public class App {

	private static byte[] NAS_ID;
	private static byte[] NAS_IP;
	
	public static void main(String[] args) throws UnknownHostException {
		String sessionId = "1231245454677";
		String calledStationId = "905325698745";
		String callingStationId = "9053525412587";
		String chargableUserId = "52325458756@vodafone.net";
		String nasIdentifier = null;
		String nasIpAddress = null;
		byte[] nasIp = null;
		byte[] nasPort = null;
		try {
			//nasIpAddress = InetAddress.getLocalHost().getHostAddress();
			//nasIpAddress = "127.0.0.1"; // request sender ip, should be in 4 bytes
			nasIp = new byte[] {127,0,0,1};
			nasIdentifier =  InetAddress.getLocalHost().getHostName(); // req sender host name
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		/*Note that this is
		using "port" in its sense of a physical connection on the NAS, not
		in the sense of a TCP or UDP port number.
		Either NAS-Port or NAS-Port-Id SHOULD be present in an Access-
		Request packet, if the NAS differentiates among its ports. NASPort-
		Id is intended for use by NASes which cannot conveniently
		number their ports.*/
		String nasPortId = "1";
		// Request sender NAS port number, should be in bytes and length has to be 6 bytes. 
		nasPort = new byte[] {3,0,0,1};
		String userName = "52325458756@vodafone.net";
		String vendorSpec1 = "bras";

		try {
			CoaClient  coaClient  = new CoaClient("10.201.83.108", 3799, -1, "secret", 6000);
			CoaRequest coaRequest = new CoaRequest(sessionId, calledStationId, callingStationId, chargableUserId, null, nasIdentifier, 
					nasIp, nasPort, nasPortId, userName , vendorSpec1);
			coaClient.sendRequest(coaRequest);
		} catch (CoaException coe) {
			System.out.println("Error occured");
			coe.printStackTrace(); 
		} catch (InvalidParameterException e ) {
			System.out.println("Error occured");
			e.printStackTrace();
		}
	}

}
