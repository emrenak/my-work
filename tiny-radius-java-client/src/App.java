import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.tinyradius.packet.CoaRequest;
import org.tinyradius.util.RadiusException;


public class App {

	public static void main(String[] args) {
		String host;
		host = "10.201.83.108";
		String shared = "shared";
		String sessionId = "1231245454677";
		String calledStationId = "905325698745";
		String callingStationId = "9053525412587";
		String chargableUserId = "52325458756@vodafone.net";
		String nasIdentifier = "this.is.my.nas-identifier.de";
		String userName = "52325458756@vodafone.net";
		String ipAddress = null;
		try {
			 ipAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String nasPort = "0";
		CoARadiusClient rc = new CoARadiusClient(host, shared);
		CoaRequest coaRequest = new CoaRequest();
		coaRequest.addAttribute("Acct-Session-Id", sessionId);
		coaRequest.addAttribute("Called-Station-Id", calledStationId);
		coaRequest.addAttribute("Calling-Station-Id", callingStationId);
		//coaRequest.addAttribute("Chargeable-User-Identity", chargableUserId);
		coaRequest.addAttribute("NAS-Identifier", nasIdentifier);
		coaRequest.addAttribute("NAS-Port", nasPort);
		coaRequest.addAttribute("NAS-IP-Address", ipAddress);
		coaRequest.addAttribute("User-Name",userName);
		try {
			rc.sendCoA(coaRequest);
		} catch (IOException | RadiusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
