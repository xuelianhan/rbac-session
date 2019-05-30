package org.ict.rbac;

import java.security.Key;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class CipherHashTest {

	@Test
	public void testHash() {
		String password = "hello";
		
		int encrypTimes = 2;  
		String alogrithmName = "SHA-256"; // "md5" 
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		
		//original password with a random number
		String encodePassword = new SimpleHash(alogrithmName, password, salt, encrypTimes).toString();
		System.out.printf("original password:%s, salt:%s, operation times:%d, operation result:%s ",password,salt,encrypTimes,encodePassword);
	}
	
	@Test
	public void testCipher() {
		AesCipherService cipherService = new AesCipherService();
		cipherService.setKeySize(256);
		Key key = cipherService.generateNewKey();
		
		String plainStr = "hello";
		byte[] plainText = plainStr.getBytes();
		
		String encryptedText = cipherService.encrypt(plainText, key.getEncoded()).toHex();
		System.out.println("encrypted text:" + encryptedText);
		
		ByteSource decrypted = cipherService.decrypt(Hex.decode(encryptedText), key.getEncoded());
		String decryptedText = new String(decrypted.getBytes());
		System.out.println("decrypted text:" + decryptedText);
	}
}
