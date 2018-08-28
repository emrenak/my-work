package client;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import exception.InvalidParameterException;

public class CoaAttribute {
	private static final int HEADER_LENGTH = 2;
	private byte[] packetBytes;

	public CoaAttribute(int paramInt, byte[] paramArrayOfByte)
			throws InvalidParameterException {
		if (paramInt > 256)
			throw new InvalidParameterException(
					"type must be small enough to fit in a byte (i.e. less than 256) and should be chosen from static final constants defined in RadiusValues");
		if (null == paramArrayOfByte)
			throw new InvalidParameterException("Value cannot be NULL");
		int i = 2 + paramArrayOfByte.length;
		ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i);
		try {
			localByteArrayOutputStream.write(paramInt);
			localByteArrayOutputStream.write(i);
			localByteArrayOutputStream.write(paramArrayOfByte);
			localByteArrayOutputStream.flush();
		} catch (IOException localIOException1) {
			throw new InvalidParameterException(
					"Error constructing RadiusAttribute");
		}
		this.packetBytes = localByteArrayOutputStream.toByteArray();
		try {
			localByteArrayOutputStream.close();
		} catch (IOException localIOException2) {
		}
	}

	public int getType() {
		return this.packetBytes[0];
	}

	public byte[] getValue() {
		int i = this.packetBytes.length - 2;
		byte[] arrayOfByte = new byte[i];
		System.arraycopy(this.packetBytes, 2, arrayOfByte, 0, i);
		return arrayOfByte;
	}

	protected final byte[] getBytes() {
		return this.packetBytes;
	}
}
