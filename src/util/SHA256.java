package util;

import java.security.MessageDigest;

public class SHA256 {

	public static String getSHA256(String input) {
		
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] salt = "kim-hak-yoon".getBytes();
			digest.reset();
			digest.update(salt);
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			for (int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) result.append("0");
				result.append(hex);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
}
