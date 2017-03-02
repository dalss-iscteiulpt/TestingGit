import java.util.*;
	import javax.mail.*;
	import javax.mail.internet.*;
	import javax.activation.*;
public class Send {
	
	public static void main(String [] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("java.game.email@gmail.com","lisonco20");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("java.game.email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("diogo.alex260@gmail.com"));
			message.setSubject("BDO Notification");
			message.setText("Expected Item Ready");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
