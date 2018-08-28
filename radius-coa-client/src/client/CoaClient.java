package client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import exception.CoaException;
import exception.InvalidParameterException;

public class CoaClient {

	private int socketTimeout = 6000;
	private int coaPort = 3799;
	private DatagramSocket socket = null;
	private InetAddress hostname = null;
	private MessageDigest md5MessageDigest;
	private String sharedSecret = "";


	public int getCoaPort() {
		return coaPort;
	}

	public CoaClient(String hostName, int port, int paramInt2, String secret,
			int timeout) throws CoaException, InvalidParameterException {
		setHostname(hostName);
		setSharedSecret(secret);
		try {
			this.socket = new DatagramSocket();
		} catch (SocketException localSocketException) {
			throw new CoaException(localSocketException.getMessage());
		}
		setTimeout(timeout);

		try {
			this.md5MessageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			throw new CoaException(localNoSuchAlgorithmException.getMessage());
		}

		setCoaPort(port);
	}

	private void setSharedSecret(String paramString)
			throws InvalidParameterException {
		if (paramString == null)
			throw new InvalidParameterException(
					"Shared secret can not be null!");
		if (paramString.equals(""))
			throw new InvalidParameterException(
					"Shared secret can not be an empty string!");
		this.sharedSecret = paramString;
	}

	private void setHostname(String paramString)
			throws InvalidParameterException {
		if (paramString == null)
			throw new InvalidParameterException("Hostname can not be null!");
		if (paramString.trim().equals(""))
			throw new InvalidParameterException(
					"Hostname can not be empty or all blanks!");
		try {
			this.hostname = InetAddress.getByName(paramString);
		} catch (UnknownHostException localUnknownHostException) {
			throw new InvalidParameterException(
					"Hostname failed InetAddress.getByName() validation!");
		}
	}

	private void setTimeout(int paramInt) throws InvalidParameterException {
		if (paramInt < 0)
			throw new InvalidParameterException(
					"A negative timeout value is not allowed!");
		this.socketTimeout = paramInt;
		try {
			if (null == this.socket)
				this.socket = new DatagramSocket();
			this.socket.setSoTimeout(this.socketTimeout);
		} catch (SocketException localSocketException) {
		}
	}

	private void setCoaPort(int paramInt) throws InvalidParameterException {
		if ((paramInt > 0) && (paramInt < 65536))
			this.coaPort = paramInt;
		else
			throw new InvalidParameterException("Port value out of range!");
	}

	private DatagramPacket composeRadiusPacket(int port, byte packageType,
			byte packageIdentifier, short length, byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) throws CoaException {
		ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream localDataOutputStream = new DataOutputStream(
				localByteArrayOutputStream);
		DatagramPacket localDatagramPacket = null;
		try {
			localDataOutputStream.writeByte(packageType);
			localDataOutputStream.writeByte(packageIdentifier);
			localDataOutputStream.writeShort(length);
			localDataOutputStream.write(paramArrayOfByte1, 0,
					paramArrayOfByte1.length);
			localDataOutputStream.write(paramArrayOfByte2, 0,
					paramArrayOfByte2.length);
			localDatagramPacket = new DatagramPacket(new byte[length], length);
			localDatagramPacket.setPort(port);
			localDatagramPacket.setAddress(this.hostname);
			localDatagramPacket.setLength(length);
			localDatagramPacket.setData(localByteArrayOutputStream
					.toByteArray());
			localDataOutputStream.close();
			localByteArrayOutputStream.close();
		} catch (IOException localIOException) {
			throw new CoaException(localIOException.getMessage());
		}
		return localDatagramPacket;
	}

	public CoaPacket sendRequest(CoaPacket paramRadiusPacket)
			throws InvalidParameterException, CoaException {
		if (null == paramRadiusPacket)
			throw new InvalidParameterException(
					"requestPacket parameter cannot be null");
		byte b1 = paramRadiusPacket.getPacketType();
		if (b1 != 43)
			throw new InvalidParameterException(
					"Invalid type passed in for RadiusPacket");
		try {
			paramRadiusPacket.getAttribute(44);

		} catch (CoaException localRadiusException) {
			throw new InvalidParameterException(
					"Missing RadiusAttribute in Accounting RequestPacket: "
							+ localRadiusException.getMessage());
		}
		byte b2 = paramRadiusPacket.getPacketIdentifier();
		byte[] arrayOfByte1 = paramRadiusPacket.getAttributeBytes();
		short s = (short) (20 + arrayOfByte1.length);
		byte[] arrayOfByte2 = makeRFC2866RequestAuthenticator(b1, b2, s,
				arrayOfByte1);
		DatagramPacket localDatagramPacket = composeRadiusPacket(getCoaPort(),
				b1, b2, s, arrayOfByte2, arrayOfByte1);
		CoaPacket localRadiusPacket = null;
		if ((localDatagramPacket = sendReceivePacket(localDatagramPacket, 3)) != null) {
			System.out.println("!!!! Response is received !!!!");
		} else {
			throw new CoaException("null returned from sendReceivePacket");
		}
		return localRadiusPacket;
	}

	private byte[] makeRFC2866RequestAuthenticator(byte paramByte1,
			byte paramByte2, short paramShort, byte[] paramArrayOfByte) {
		byte[] arrayOfByte = new byte[16];
		for (int i = 0; i < 16; i++)
			arrayOfByte[i] = 0;
		this.md5MessageDigest.reset();
		this.md5MessageDigest.update(paramByte1);
		this.md5MessageDigest.update(paramByte2);
		this.md5MessageDigest.update((byte) (paramShort >> 8));
		this.md5MessageDigest.update((byte) (paramShort & 0xFF));
		this.md5MessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
		this.md5MessageDigest.update(paramArrayOfByte, 0,
				paramArrayOfByte.length);
		this.md5MessageDigest.update(this.sharedSecret.getBytes());
		return this.md5MessageDigest.digest();
	}

	private DatagramPacket sendReceivePacket(
			DatagramPacket paramDatagramPacket, int paramInt)
			throws CoaException {
		if (paramDatagramPacket.getLength() > 4096)
			throw new CoaException("Packet too big!");
		if (paramDatagramPacket.getLength() < 20)
			throw new CoaException("Packet too short !");
		DatagramPacket localDatagramPacket = new DatagramPacket(new byte[4096],
				4096);
		int i = 1;
		while (i <= paramInt)
			try {
				this.socket.send(paramDatagramPacket);
				System.out.println("!!! Packet sent !!!");
				System.out.println(paramDatagramPacket.toString());
				this.socket.receive(localDatagramPacket);
				return localDatagramPacket;
			} catch (IOException localIOException) {
				if (i == paramInt)
					throw new CoaException(localIOException.getMessage());
				i++;
			}
		return null;
	}


}
