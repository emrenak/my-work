package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import exception.CoaException;
import exception.InvalidParameterException;

public class CoaPacket {

	public static final int MIN_PACKET_LENGTH = 20;
	public static final int MAX_PACKET_LENGTH = 4096;
	public static final short RADIUS_HEADER_LENGTH = 20;
	public static final String EMPTYSTRING = "";
	public static final int ACCESS_REQUEST = 1;
	public static final int ACCESS_ACCEPT = 2;
	public static final int ACCESS_REJECT = 3;
	public static final int ACCOUNTING_REQUEST = 4;
	public static final int ACCOUNTING_RESPONSE = 5;
	public static final int ACCOUNTING_STATUS = 6;
	public static final int PASSWORD_REQUEST = 7;
	public static final int PASSWORD_ACCEPT = 8;
	public static final int PASSWORD_REJECT = 9;
	public static final int ACCOUNTING_MESSAGE = 10;
	public static final int ACCESS_CHALLENGE = 11;
	public static final int STATUS_SERVER = 12;
	public static final int STATUS_CLIENT = 13;
	public static final int COA_REQUEST = 43;
	public static final int RESERVED = 255;
	private static Object nextPacketIdLock = new Object();
	private static byte nextPacketId = 0;
	private int packetType = 0;
	private byte packetIdentifier = 0;
	private Map attributes;

	public CoaPacket(int paramInt) throws InvalidParameterException {
		this(paramInt, getAndIncrementPacketIdentifier(), new ArrayList());
	}

	public CoaPacket(int paramInt, byte paramByte)
			throws InvalidParameterException {
		this(paramInt, paramByte, new ArrayList());
	}

	public CoaPacket(int paramInt, List paramList)
			throws InvalidParameterException {
		this(paramInt, getAndIncrementPacketIdentifier(), paramList);
	}

	public CoaPacket(int paramInt, byte paramByte, List paramList)
			throws InvalidParameterException {
		if ((paramInt < 1) || (paramInt > 256))
			throw new InvalidParameterException("Type was out of bounds");
		if (null == paramList)
			throw new InvalidParameterException("Attribute List was null");
		this.packetType = paramInt;
		this.packetIdentifier = paramByte;
		this.attributes = new HashMap();
		setAttributes(paramList);
	}

	@SuppressWarnings("unchecked")
	public void setAttribute(CoaAttribute paramCoAAttribute)
			throws InvalidParameterException {
		if (null == paramCoAAttribute)
			throw new InvalidParameterException("radiusAttribute was null");
		validateAttribute(paramCoAAttribute);
		synchronized (this.attributes) {
			this.attributes.put(new Integer(paramCoAAttribute.getType()),
					paramCoAAttribute);
		}
	}

	@SuppressWarnings("unchecked")
	public void setAttributes(List paramList) throws InvalidParameterException {
		if (null == paramList)
			throw new InvalidParameterException("Attribute List was null");
		Iterator localIterator = paramList.iterator();
		while (localIterator.hasNext()) {
			CoaAttribute localRadiusAttribute;
			try {
				localRadiusAttribute = (CoaAttribute) localIterator.next();
				validateAttribute(localRadiusAttribute);
			} catch (ClassCastException localClassCastException) {
				throw new InvalidParameterException(
						"Attribute List contained an entry that was not a net.sourceforge.jradiusclient.RadiusAttribute");
			}
			synchronized (this.attributes) {
				this.attributes.put(
						new Integer(localRadiusAttribute.getType()),
						localRadiusAttribute);
			}
		}
	}

	protected void validateAttribute(CoaAttribute paramRadiusAttribute)
			throws InvalidParameterException {
	}

	public CoaAttribute getAttribute(int paramInt)
			throws InvalidParameterException, CoaException {
		if ((paramInt < 0) || (paramInt > 256))
			throw new InvalidParameterException(
					"attributeType is out of bounds");
		CoaAttribute localRadiusAttribute = null;
		synchronized (this.attributes) {
			localRadiusAttribute = (CoaAttribute) this.attributes
					.get(new Integer(paramInt));
		}
		if (null == localRadiusAttribute)
			throw new CoaException("No attribute found for type " + paramInt);
		return localRadiusAttribute;
	}

	@SuppressWarnings("rawtypes")
	public Collection getAttributes() {
		return this.attributes.values();
	}

	public byte getPacketType() {
		return (byte) this.packetType;
	}

	public byte getPacketIdentifier() {
		return this.packetIdentifier;
	}

	protected final byte[] getAttributeBytes() throws CoaException {
		ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
		synchronized (this.attributes) {
			@SuppressWarnings("rawtypes")
			Iterator localIterator = this.attributes.values().iterator();
			while (localIterator.hasNext())
				try {
					localByteArrayOutputStream
							.write(((CoaAttribute) localIterator.next())
									.getBytes());
				} catch (IOException localIOException) {
					throw new CoaException(
							"Error writing bytes to ByteArrayOutputStream!!!");
				}
			byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
			return arrayOfByte;
		}
	}

	private static byte getAndIncrementPacketIdentifier() {
		synchronized (nextPacketIdLock) {
			nextPacketId++;
			return nextPacketId;
		}
	}
}