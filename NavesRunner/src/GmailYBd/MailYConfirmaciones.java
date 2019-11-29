package GmailYBd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailYConfirmaciones{

	private static final String nomMail = "navesrunner";
	private static final String password = "12345naves";
	private static final String asuntoMail = "Bienvenido a NavesRunner. Nuestro primer runner ∞. ";
	private static final String cuerpoMail = "Bienvenido a NavesRunner. \n"
			+ "Tu usuario ha sido generado correctamente, prueba a logearte y empezar a disfrutar. \n"
			+ "Gracias por elegirnos. Iremos actualizando en funcion de vuestras sugerencias que recibamos en nuestro correo indicado al final del email.\n"
			+ "Un saludo y muchas gracias por su confianza. \n"
			+ "Atentamente, \n"
			+ "El staff de NavesRunner \n\n"
			+ "Contacto: navesrunner@gmail.com\n";
	
	public static void enviarMail(String destinatario)  {
		
		Properties prop = System.getProperties(); // Tenemos que asignar las propiedades y crear una sesion, con la sesion un mensaje y con el mensaje un transporte
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.user", nomMail);
		prop.put("mail.smtp.clave", password);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		
		Session aux = Session.getDefaultInstance(prop);
		MimeMessage mail = new MimeMessage(aux);
		
		try {
			mail.setFrom(new InternetAddress(nomMail));
			mail.addRecipients(Message.RecipientType.TO, destinatario);
			mail.setSubject(asuntoMail);
			mail.setText(cuerpoMail); // Tenemos creado el mensaje
			
			Transport envio = aux.getTransport("smtp");
			envio.connect("smtp.gmail.com", nomMail, password);
			envio.sendMessage(mail, mail.getAllRecipients());
			envio.close();
			
		} catch (MessagingException e) {
		} 
	}

	
}

