package com.example.mailService.mailController;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Service
public class MailServiceImpl implements MailServiceInt{
 
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private HttpSession session;
	
	private static final Logger logger=LoggerFactory.getLogger(MailServiceImpl.class);
	
	
	@Override
	public void sendMail(String to, String sub, String messg) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(messg);
		message.setFrom("notifymegulshan@gmail.com");
		mailSender.send(message);
		logger.info("Mail Send Succeffuly");
	}

	@Override
	public void sendMail(String[] to, String sub, String messg) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(messg);
		message.setFrom("notifymegulshan@gmail.com");
		mailSender.send(message);
		logger.info("Mail Send Succeffuly");
	}

	@Override
	public void sendMailWithHtml(String to, String sub, String htmlMessg) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(htmlMessg, true);
			helper.setFrom("notifymegulshan@gmail.com");
			mailSender.send(mimeMessage);
			logger.info("Mail Send Succeffuly");
			System.out.println("Please enter OTP");
			Scanner scanner=new Scanner(System.in);
			String userotp = scanner.nextLine();
			
			Object attribute = session.getAttribute("OTP");
			String string = attribute.toString();
			
			if(string.equalsIgnoreCase(userotp)) {
				System.out.println("Verification Completed:");
				session.removeAttribute("OTP");
			}else {
				System.out.println("Verification Failed:");
			}
			
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

	}

	@Override
	public void sendMailWithFile(String to, String sub, String messg, String path) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setFrom("notifymegulshan@gmail.com");
			helper.setText(messg);
			FileSystemResource file=new FileSystemResource(new File(path));
			helper.addAttachment(file.getFilename(), file);
			mailSender.send(mimeMessage);
			logger.info("Mail Send Succeffuly");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		}

		
		
		
		
		
	}
 
	
}
