package com.example.mailService.mailController;

import java.io.File;

public interface MailServiceInt {
	
	public void sendMail(String to,String sub,String messg);
	public void sendMail(String[] to,String sub,String messg);
	public void sendMailWithHtml(String to,String sub,String htmlMessg);
	public void sendMailWithFile(String to,String sub,String messg,String path);
	

}
