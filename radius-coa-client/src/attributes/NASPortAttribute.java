package attributes;

import client.CoaAttribute;
import exception.InvalidParameterException;

public class NASPortAttribute extends CoaAttribute {

	public NASPortAttribute(int paramInt, byte[] paramArrayOfByte)
			throws InvalidParameterException {
		super(5, paramArrayOfByte);
	}

}
