package attributes;

import java.util.ArrayList;
import java.util.List;

import client.CoaAttribute;
import exception.InvalidParameterException;

public class VendorSpecificAttribute extends CoaAttribute {

	int vendorId = 9;
	
	private List<CoaAttribute> subAttributes = new ArrayList<CoaAttribute>();

	public VendorSpecificAttribute(int paramInt, byte[] paramArrayOfByte)
			throws InvalidParameterException {
		super(26, paramArrayOfByte);
		// TODO Auto-generated constructor stub
	}
	
	public void addSubAttribute(String name, String value) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("type name is empty");
		if (value == null || value.length() == 0)
			throw new IllegalArgumentException("value is empty");

//		RadiusAttribute attribute = createRadiusAttribute(getDictionary(),
//				9, type.getTypeCode());
//		attribute.setAttributeValue(value);
//		addSubAttribute(attribute);
	}

	public void addSubAttribute(CoaAttribute attribute) {
		subAttributes.add(attribute);
	}

	
}
