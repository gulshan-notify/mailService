package com.example.mailService;

import java.security.SecureRandom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mailService.mailController.MailServiceInt;

import jakarta.servlet.http.HttpSession;

@SpringBootTest
class MailServiceApplicationTests {
	
	@Autowired
	private MailServiceInt mailService;
	
	@Value("${pdf.file.path}")
	private String path;
	
	@Autowired
	private HttpSession session;
	
	
	@Test
	void contextLoads() {
		System.out.println("TESTING..........");
		String[] recipients = {"notifymegulshan@gmail.com", "yogeshduhan7890@gmail.com"};
		String html="<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>New Year Sale</title>\n"
				+ "    <style>\n"
				+ "        body {\n"
				+ "            margin: 0;\n"
				+ "            font-family: 'Arial', sans-serif;\n"
				+ "            background-color: #f8f9fa;\n"
				+ "        }\n"
				+ "        header {\n"
				+ "            background: linear-gradient(45deg, #ff3e3e, #ff8000);\n"
				+ "            color: #fff;\n"
				+ "            padding: 20px 0;\n"
				+ "            text-align: center;\n"
				+ "        }\n"
				+ "        header h1 {\n"
				+ "            margin: 0;\n"
				+ "            font-size: 2.5rem;\n"
				+ "            text-transform: uppercase;\n"
				+ "            letter-spacing: 3px;\n"
				+ "        }\n"
				+ "        header p {\n"
				+ "            margin: 10px 0 0;\n"
				+ "            font-size: 1.2rem;\n"
				+ "        }\n"
				+ "        .sale-banner {\n"
				+ "            text-align: center;\n"
				+ "            background-color: #fff;\n"
				+ "            padding: 50px 20px;\n"
				+ "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n"
				+ "            margin: 20px;\n"
				+ "        }\n"
				+ "        .sale-banner h2 {\n"
				+ "            color: #ff3e3e;\n"
				+ "            font-size: 3rem;\n"
				+ "            margin: 0;\n"
				+ "        }\n"
				+ "        .sale-banner p {\n"
				+ "            color: #666;\n"
				+ "            margin: 10px 0 20px;\n"
				+ "            font-size: 1.2rem;\n"
				+ "        }\n"
				+ "        .sale-banner a {\n"
				+ "            background: #ff3e3e;\n"
				+ "            color: #fff;\n"
				+ "            text-decoration: none;\n"
				+ "            padding: 15px 30px;\n"
				+ "            font-size: 1.1rem;\n"
				+ "            border-radius: 5px;\n"
				+ "            transition: background 0.3s ease;\n"
				+ "        }\n"
				+ "        .sale-banner a:hover {\n"
				+ "            background: #ff8000;\n"
				+ "        }\n"
				+ "        .products {\n"
				+ "            display: flex;\n"
				+ "            flex-wrap: wrap;\n"
				+ "            gap: 20px;\n"
				+ "            justify-content: center;\n"
				+ "            padding: 20px;\n"
				+ "        }\n"
				+ "        .product-card {\n"
				+ "            background-color: #fff;\n"
				+ "            width: 300px;\n"
				+ "            border-radius: 10px;\n"
				+ "            overflow: hidden;\n"
				+ "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n"
				+ "            text-align: center;\n"
				+ "        }\n"
				+ "        .product-card img {\n"
				+ "            width: 100%;\n"
				+ "            height: auto;\n"
				+ "        }\n"
				+ "        .product-card h3 {\n"
				+ "            margin: 15px 0;\n"
				+ "            font-size: 1.5rem;\n"
				+ "            color: #333;\n"
				+ "        }\n"
				+ "        .product-card p {\n"
				+ "            color: #666;\n"
				+ "            font-size: 1rem;\n"
				+ "            margin: 10px 0;\n"
				+ "        }\n"
				+ "        .product-card .price {\n"
				+ "            font-size: 1.2rem;\n"
				+ "            color: #ff3e3e;\n"
				+ "            font-weight: bold;\n"
				+ "        }\n"
				+ "        footer {\n"
				+ "            text-align: center;\n"
				+ "            padding: 20px;\n"
				+ "            background-color: #333;\n"
				+ "            color: #fff;\n"
				+ "        }\n"
				+ "        footer p {\n"
				+ "            margin: 0;\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <header>\n"
				+ "        <h1>New Year Mega Sale!</h1>\n"
				+ "        <p>Don't miss out on the biggest discounts of the year!</p>\n"
				+ "    </header>\n"
				+ "    <div class=\"sale-banner\">\n"
				+ "        <h2>Flat 50% Off</h2>\n"
				+ "        <p>Shop now and save big on all your favorite items!</p>\n"
				+ "        <a href=\"#products\">Shop Now</a>\n"
				+ "    </div>\n"
				+ "    <section id=\"products\" class=\"products\">\n"
				+ "        <div class=\"product-card\">\n"
				+ "            <img src=\"https://via.placeholder.com/300x200\" alt=\"Product 1\">\n"
				+ "            <h3>Product 1</h3>\n"
				+ "            <p>Amazing description of Product 1</p>\n"
				+ "            <p class=\"price\">$25.00</p>\n"
				+ "        </div>\n"
				+ "        <div class=\"product-card\">\n"
				+ "            <img src=\"https://via.placeholder.com/300x200\" alt=\"Product 2\">\n"
				+ "            <h3>Product 2</h3>\n"
				+ "            <p>Amazing description of Product 2</p>\n"
				+ "            <p class=\"price\">$30.00</p>\n"
				+ "        </div>\n"
				+ "        <div class=\"product-card\">\n"
				+ "            <img src=\"https://via.placeholder.com/300x200\" alt=\"Product 3\">\n"
				+ "            <h3>Product 3</h3>\n"
				+ "            <p>Amazing description of Product 3</p>\n"
				+ "            <p class=\"price\">$15.00</p>\n"
				+ "        </div>\n"
				+ "        <div class=\"product-card\">\n"
				+ "            <img src=\"https://via.placeholder.com/300x200\" alt=\"Product 4\">\n"
				+ "            <h3>Product 4</h3>\n"
				+ "            <p>Amazing description of Product 4</p>\n"
				+ "            <p class=\"price\">$20.00</p>\n"
				+ "        </div>\n"
				+ "    </section>\n"
				+ "    <footer>\n"
				+ "        <p>&copy; 2024 New Year Sale. All Rights Reserved.</p>\n"
				+ "    </footer>\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "";
		
		
		SecureRandom random=new SecureRandom();
		StringBuilder otp=new StringBuilder();
		
		for(int i=0;i<6;i++) {
			otp.append(random.nextInt(10));
		}
		
		String OTP=otp.toString();
		
		
		// HTML template with proper string formatting
		String otpHtml = "<!DOCTYPE html>\n"
		        + "<html lang=\"en\">\n"
		        + "<head>\n"
		        + "    <meta charset=\"UTF-8\">\n"
		        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
		        + "    <title>Your OTP Code</title>\n"
		        + "    <style>\n"
		        + "        body {\n"
		        + "            font-family: Arial, sans-serif;\n"
		        + "            background-color: #f7f7f7;\n"
		        + "            margin: 0;\n"
		        + "            padding: 0;\n"
		        + "        }\n"
		        + "        .container {\n"
		        + "            max-width: 600px;\n"
		        + "            margin: 0 auto;\n"
		        + "            background-color: #ffffff;\n"
		        + "            border-radius: 8px;\n"
		        + "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n"
		        + "            padding: 30px;\n"
		        + "        }\n"
		        + "        .header {\n"
		        + "            text-align: center;\n"
		        + "            color: #4CAF50;\n"
		        + "            margin-bottom: 20px;\n"
		        + "        }\n"
		        + "        .otp {\n"
		        + "            font-size: 36px;\n"
		        + "            font-weight: bold;\n"
		        + "            color: #333;\n"
		        + "            text-align: center;\n"
		        + "            padding: 15px;\n"
		        + "            background-color: #f1f1f1;\n"
		        + "            border-radius: 8px;\n"
		        + "            letter-spacing: 5px;\n"
		        + "        }\n"
		        + "        .content {\n"
		        + "            font-size: 16px;\n"
		        + "            color: #555;\n"
		        + "            line-height: 1.6;\n"
		        + "            text-align: center;\n"
		        + "        }\n"
		        + "        .footer {\n"
		        + "            text-align: center;\n"
		        + "            margin-top: 30px;\n"
		        + "            font-size: 12px;\n"
		        + "            color: #888;\n"
		        + "        }\n"
		        + "        .footer a {\n"
		        + "            color: #4CAF50;\n"
		        + "            text-decoration: none;\n"
		        + "        }\n"
		        + "    </style>\n"
		        + "</head>\n"
		        + "<body>\n"
		        + "    <div class=\"container\">\n"
		        + "        <div class=\"header\">\n"
		        + "            <h2>Your One-Time Password (OTP)</h2>\n"
		        + "        </div>\n"
		        + "        <div class=\"content\">\n"
		        + "            <p>Hello,</p>\n"
		        + "            <p>Use the following OTP to complete your verification:</p>\n"
		        + "            <div class=\"otp\">\n"
		        + "                123456\n" // Placeholder for OTP
		        + "            </div>\n"
		        + "            <p>The OTP is valid for the next 5 minutes. Please do not share it with anyone.</p>\n"
		        + "        </div>\n"
		        + "        <div class=\"footer\">\n"
		        + "            <p>If you didn't request this, please ignore this email.</p>\n"
		        + "            <p>Thank you for using our service!</p>\n"
		        + "        </div>\n"
		        + "    </div>\n"
		        + "</body>\n"
		        + "</html>\n";

		otpHtml = otpHtml.replace("123456", OTP);
		
		session.setAttribute("OTP", OTP);

		
	//	mailService.sendMailWithFile("notifymegulshan@gmail.com", "Attach File", OTP+ "Do not share this one time password ",path);
		//mailService.sendMail(recipients, "THIS MAIL IS JUST FOR TESTING", "Scientists have poured cold water on the idea that Venus could once have supported life. The disappointing revelation emerged from the fact it appears water oceans could never have existed on the surface of our neighboring planet.");
		mailService.sendMailWithHtml("yogeshduhan7890@gmail.com", "OTP", otpHtml);		
		
		
		
	}

}
