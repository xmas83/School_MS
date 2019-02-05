package sample.SystemUsers;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class Storage {


    public static void sendTranscript(String from, String pass, String to, String subject, String body,String pdfFile) throws javax.mail.MessagingException{
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            new InternetAddress();
            InternetAddress toAddress;
            toAddress=new InternetAddress(to);
            message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(body);
            MimeBodyPart mimeBodyPart=new MimeBodyPart();
            mimeBodyPart.setText("Your School Transcript...");
            MimeBodyPart attachment=new MimeBodyPart();
            FileDataSource dataSource=new FileDataSource(new File(pdfFile));
            attachment.setDataHandler(new DataHandler(dataSource));
            attachment.setFileName("TRANSCRIPT.pdf");
            attachment.setDisposition(MimeBodyPart.ATTACHMENT);
            Multipart multipart=new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachment);
            message.setContent(multipart);

            javax.mail.Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
    }


    public static void sendMailToGroupParticipant(String from, String pass, String[] to, String subject, String body) throws javax.mail.MessagingException{
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject(subject);
            message.setText(body);

            javax.mail.Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
    }
    public static void sendmail(String subj, String text, String recipient,String c) throws URISyntaxException // sending a mail from desktop.
    {
        String subject=subj;
        String body=text;
        String cc=c;
        String receiver=recipient;

        try {
            Desktop.getDesktop().mail( new URI( "mailto:"+receiver+"?subject="+subject+"&cc="+cc+"&body="+body) );
        }
        catch ( IOException ex )
        {
        }
    }
}
