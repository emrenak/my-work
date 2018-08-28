package attributes;

import client.CoaAttribute;
import exception.InvalidParameterException;


public class AcctSessionIdAttribute extends CoaAttribute {

	public AcctSessionIdAttribute(int paramInt, byte[] paramArrayOfByte)
			throws InvalidParameterException {
		super(44, paramArrayOfByte);
	}

}
