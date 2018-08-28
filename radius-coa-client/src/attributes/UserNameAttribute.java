package attributes;

import client.CoaAttribute;
import exception.InvalidParameterException;

public class UserNameAttribute extends CoaAttribute {

	public UserNameAttribute(int paramInt, byte[] paramArrayOfByte)
			throws InvalidParameterException {
		super(1, paramArrayOfByte);
	}

}
