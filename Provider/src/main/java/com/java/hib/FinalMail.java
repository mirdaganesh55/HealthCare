package com.java.hib;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class FinalMail {
	public void sendEmail(Provider provider) {
		System.out.println("Preparing to send message ...");
		String subject = "Activation Confirmation: Provider Details Successfully Activated";
		String to = provider.getEmail();
		String from = "professional.ganesh237@gmail.com";
		String imagePath = "C:\\Users\\ganeshmi\\Downloads\\providerImage.jpg"; // Replace with the actual path to your image file
		
		String body = "<html>" +
				"<head>"+
				"<style>" +
				"body {" +
				"font-family: 'Helvetica', 'Arial', sans-serif;" +
				"line-height: 1.6;" +
				"margin: 0;" +
				"padding: 0;" +
				"background-color: #f9f9f9;" +
				"}" +
				".container {" +
				"max-width: 600px;" +
				"margin: 20px auto;" +
				"padding: 30px;" +
				"background-color: #ffffff;" +
				"box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);" +
				"border-radius: 10px;" +
				"}" +
				"h1 {" +
				"color: #333333;" +
				"font-size: 24px;" +
				"}" +
				"p {" +
				"color: #555555;" +
				"font-size: 16px;" +
				"margin-bottom: 20px;" +
				"}" +
				"</style>" +
				"</head>" +
				"<body>" +
				"<div class='container'>" +
				"<img src='cid:image' style='max-width: 100%; height: auto; display: block; margin-top: 20px;' alt='Image'/>" +
				"<h1>Dear <span style='color: #FAFA14;'>" + provider.getFirstName() + " " + provider.getLastName() + "</span></h1>" +
				"<p>Welcome...</p>" +
				"<p>"+
				"We are pleased to inform you that the activation process for your provider details has been successfully completed." +
				"Your information is now active and ready to be utilized for the intended purposes. That applied on " +
				"<span style='color: #FAFA14;'>" + provider.getEnrollmentDate() + "</span> date." +
				"</p>" +
				"<p>Your Provider ID is <span style='color: #FAFA14;'>" + provider.getProviderId() + "</span></p>"+
				"<p>Thank you for your prompt attention to this matter. We appreciate your cooperation and look forward to a seamless collaboration.</p>" +
				"<p>Best regards,</p>" +
				"<p style=\"color: #09EAC8;\"> HEALTH CARE </p>"+
				"</div>" +
				"</body>" +
				"</html>";
		sendEmail(subject, to, from, imagePath, body);
	}

	private void sendEmail(String subject, String to, String from, String imagePath, String body) {
		String host = "smtp.gmail.com";

		// Get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// Setting important information to properties object

		// Host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: Get the session object
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("professional.ganesh237@gmail.com", "yicauyiftohuphuw");
			}
		});

		session.setDebug(true);

		// Step 2: Compose the message [text, multimedia]
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			// Set the from email
			mimeMessage.setFrom(new InternetAddress(from));

			// Add recipient to the message
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Add subject to the message
			mimeMessage.setSubject(subject);

			// Create MimeMultipart for mixed content
			MimeMultipart mixedMultipart = new MimeMultipart("mixed");

			// Create MimeMultipart for related content (HTML + Image)
			MimeMultipart relatedMultipart = new MimeMultipart("related");

			// Create MimeBodyPart for the HTML content
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, "text/html");
			relatedMultipart.addBodyPart(htmlPart);

			// Create MimeBodyPart for the image
			MimeBodyPart imagePart = new MimeBodyPart();
			DataSource fds = new FileDataSource(imagePath);
			imagePart.setDataHandler(new DataHandler(fds));
			imagePart.setHeader("Content-ID", "<image>");
			relatedMultipart.addBodyPart(imagePart);

			// Create MimeBodyPart for the related content
			MimeBodyPart relatedBodyPart = new MimeBodyPart();
			relatedBodyPart.setContent(relatedMultipart);

			// Add relatedBodyPart to mixedMultipart
			mixedMultipart.addBodyPart(relatedBodyPart);

			// Set the content of the message
			mimeMessage.setContent(mixedMultipart);

			// Step 3: Send the message using Transport class
			Transport.send(mimeMessage);

			System.out.println("Sent successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		}
	}

