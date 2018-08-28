package packets;

import attributes.AcctSessionIdAttribute;
import attributes.CalledStationIdAttibute;
import attributes.CallingStationIdAttribute;
import attributes.ChargebleUserIdAttribute;
import attributes.NASIPAddressAttribute;
import attributes.NASIdentifierAttribute;
import attributes.NASPortAttribute;
import attributes.NASPortIdAttribute;
import attributes.UserNameAttribute;
import client.CoaPacket;
import exception.InvalidParameterException;

public class CoaRequest extends CoaPacket {

	public CoaRequest(String sessionId, String calledStationId, String callingStationId, 
			String chargeableUserId, String framedIpAddress, String nasIdentifie, 
			byte[] nasIpAddress, byte[] nasPort, String nasPortId, String userName, String vendorSpecific) throws InvalidParameterException {
		super(COA_REQUEST);
		byte[] nasIp = new byte[] {127,0,0,1};
		setAttribute(new AcctSessionIdAttribute(-1, sessionId.getBytes()));
		setAttribute(new CalledStationIdAttibute(-1, calledStationId.getBytes()));
		setAttribute(new CallingStationIdAttribute(-1, callingStationId.getBytes()));
		setAttribute(new ChargebleUserIdAttribute(-1, chargeableUserId.getBytes()));
		setAttribute(new NASIdentifierAttribute(-1, nasIdentifie.getBytes()));
		setAttribute(new NASIPAddressAttribute(-1,nasIpAddress));
		setAttribute(new NASPortAttribute(-1, nasPort));
		setAttribute(new NASPortIdAttribute(-1, nasPortId.getBytes()));
		setAttribute(new UserNameAttribute(-1, userName.getBytes()));
		//setAttribute(new VendorSpecificAttribute(-1, vendorSpecific.getBytes()));
	}

}
