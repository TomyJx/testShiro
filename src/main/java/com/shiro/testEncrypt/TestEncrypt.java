package com.shiro.testEncrypt;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * Created by 42070 on 2017/2/17.
 */
public class TestEncrypt {
	@Test
	public void testEncode(){
		String s1 = "hello";
//		String s2 = Base64.encodeToString(s1.getBytes());
//		System.out.println(s2);
//		String s3 = Base64.decodeToString(s2.getBytes());
//		System.out.println(s3);
//		String s4 = Hex.encodeToString(s1.getBytes());
//		System.out.println(s4);
//		String s5 = new String(Hex.decode(s4.getBytes()));
//		System.out.println(s5);
		String s6 = "123";
		String s7 = new Md5Hash(s1,s6,5).toString();
		System.out.println(s7);
	}
}
