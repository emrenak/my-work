package hashCodedemo;

public class MyPhoneNumber {

	private int areaCode, prefix, lineNum;
	
	public MyPhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
	}
	
	@Override public boolean equals(Object o) {
		if (o == this)
		return true;
		if (!(o instanceof MyPhoneNumber))
		return false;
		MyPhoneNumber pn = (MyPhoneNumber)o;
		return pn.lineNum == lineNum && pn.prefix == prefix
		&&pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() { 
		return areaCode*prefix*lineNum;
	}
	
	
}
