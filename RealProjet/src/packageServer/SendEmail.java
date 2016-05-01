package packageServer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


// TODO: Auto-generated Javadoc
/**
 * The Class SendEmail.
 */
public class SendEmail {
	
	/** The Constant username. */
	public final static String username = "UltimateSocietyMessenger@gmail.com";
    
    /** The Constant password. */
    public final static String password = "DreamTeam";

    /**
     * User add mail.
     *
     * @param mailAddress the mail address
     * @param userName the user name
     * @param passWord the pass word
     * @param firstName the first name
     * @param lastName the last name
     */
    public static void userAddMail(final String mailAddress, final String userName, final String passWord, final String firstName, final String lastName) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("UltimateSocietyMessenger@gmail.com", "Ultimate Society Messenger"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(mailAddress));
            message.setSubject("This is not a spam!");
            message.setText("Dear "+firstName+" "+lastName+","
                + "\n\nUsername: "+userName+"\nPassword: "+passWord+""
            	+"\n\nPlease do not answer to this mail.");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}