package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		String mailID = "haguni17@gmail.com";
		String mailPassword = "계정비밀번호";
		return new PasswordAuthentication(mailID, mailPassword);
	}
	
}
