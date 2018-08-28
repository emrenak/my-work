import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.tinyradius.packet.CoaRequest;
import org.tinyradius.packet.RadiusPacket;
import org.tinyradius.util.RadiusClient;
import org.tinyradius.util.RadiusEndpoint;
import org.tinyradius.util.RadiusException;


public class CoARadiusClient extends RadiusClient {
	
	Log logger = LogFactory.getLog(CoARadiusClient.class);

	public CoARadiusClient(RadiusEndpoint client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

	public CoARadiusClient(String hostName, String sharedSecret) {
		super(hostName, sharedSecret);
		// TODO Auto-generated constructor stub
	}
	
	public synchronized RadiusPacket sendCoA(CoaRequest request) 
	throws IOException, RadiusException {
		if (logger.isInfoEnabled())
			logger.info("send Accounting-Request packet: " + request);
		
		RadiusPacket response = communicate(request, getCoaPort());
		if (logger.isInfoEnabled())
			logger.info("received packet: " + response);
		
		return response;
	}
	
	public int getCoaPort(){
		return 3799;
	}

}
