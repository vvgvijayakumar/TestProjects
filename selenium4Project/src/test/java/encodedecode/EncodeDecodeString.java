package encodedecode;

import org.apache.commons.codec.binary.Base64;

public class EncodeDecodeString {

	public static void main(String[] args) {

		String str = "test123";

		// Encoding String
		byte[] encdString = Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded String: " + new String(encdString));

		// Decoding String
		byte[] decdString = Base64.decodeBase64(encdString);
		System.out.println("Decoded String: " + new String(decdString));

	}

}
