package com.azienda.webapp.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.DateFormatter;

import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;

public class JavaMailSystem {
	
	public static void inviaMail(String destinatario, String mittente, String ogg, String text) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setText(text);
		message.setContent(message, text);
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect(mittente, "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	public static void inviaMailConferma(String destinatario, Utente utente) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		String ogg = "Benvenut* su Premiere Cinema Cult!";
		String text = "Benvenut* " + utente.getNome() + " " + utente.getCognome() + " sul portale Premiere Cinema Cult!<br>"
				+ "Il tuo account è confermato!<br>"
				+ "<br>"
				+ "<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	public static void inviaMailConfermaPrenotazione(String destinatario, Spettacolo spettacolo, Utente utente, Prenotazione prenotazione) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		DateFormat df=new SimpleDateFormat("H:mm");
		String myDateStr=df.format(spettacolo.getOra());
		DateFormat dataf= new SimpleDateFormat("dd/MM/yyyy");
		String dataFormattata = dataf.format(spettacolo.getData());
		String ogg = "Conferma di prenotazione per il film "+spettacolo.getFilm().getTitolo();
		String text = "<head>\r\n"
				+ " <meta charset=\"ISO-8859-1\"> \r\n"
				+ " <style type=\"text/css\">\r\n"
				+ "   .card-biglietto {\r\n"
				+ "    background: linear-gradient(to bottom, rgb(30, 31, 46)0%, #2B2D42 26%, #dee2e6\r\n"
				+ "\r\n"
				+ " 26%, #dee2e6\r\n"
				+ "\r\n"
				+ " 100%);\r\n"
				+ "    float: left;\r\n"
				+ "    height: 235px;\r\n"
				+ "    position: relative;\r\n"
				+ "    padding: 1em;\r\n"
				+ "}\r\n"
				+ ".cardLeft {\r\n"
				+ "    height: 235px;\r\n"
				+ "    width: 300px;\r\n"
				+ "    border-top-left-radius: 8px;\r\n"
				+ "    border-bottom-left-radius: 8px;\r\n"
				+ "}\r\n"
				+ ".cardRight {\r\n"
				+ "    border-left: 0.18em dashed #EDF2F4;\r\n"
				+ "    border-top-right-radius: 8px;\r\n"
				+ "    border-bottom-right-radius: 8px;\r\n"
				+ "}\r\n"
				+ ".cardRight:before, .cardRight:after {\r\n"
				+ "    content: \"\";\r\n"
				+ "    position: absolute;\r\n"
				+ "    display: block;\r\n"
				+ "    width: 0.9em;\r\n"
				+ "    height: 0.9em;\r\n"
				+ "    background:#EDF2F4;\r\n"
				+ "    border-radius: 50%;\r\n"
				+ "    left: -0.5em;\r\n"
				+ "}\r\n"
				+ ".cardRight:before {\r\n"
				+ "    top: -0.4em;\r\n"
				+ "}\r\n"
				+ ".cardRight:after {\r\n"
				+ "    bottom: -0.4em;\r\n"
				+ "}\r\n"
				+ "h1 {\r\n"
				+ "    font-size: 22px;\r\n"
				+ "    margin-top: 0;\r\n"
				+ "}\r\n"
				+ "h1 span {\r\n"
				+ "    font-weight: normal;\r\n"
				+ "}\r\n"
				+ ".title, .name, .seat, .time {\r\n"
				+ "    text-transform: uppercase;\r\n"
				+ "    font-weight: normal;\r\n"
				+ "}\r\n"
				+ ".title h2, .name h2, .seat h2, .time h2 {\r\n"
				+ "    font-size: 15px;\r\n"
				+ "    color: rgba(0, 0, 0, 0.87);\r\n"
				+ "    margin: 0;\r\n"
				+ "}\r\n"
				+ ".title span, .name span, .seat span, .time span {\r\n"
				+ "    font-size: 12px;\r\n"
				+ "    color: rgba(0, 0, 0, 0.54);\r\n"
				+ "}\r\n"
				+ ".title {\r\n"
				+ "    margin: 2em 0 0 0;\r\n"
				+ "}\r\n"
				+ ".name, .seat {\r\n"
				+ "    margin: 0.7em 0 0 0;\r\n"
				+ "}\r\n"
				+ ".time {\r\n"
				+ "    margin: 0.7em 0 0 1em;\r\n"
				+ "}\r\n"
				+ ".seat, .time {\r\n"
				+ "    float: left;\r\n"
				+ "}\r\n"
				+ ".eye{\r\n"
				+ "    display: grid;\r\n"
				+ "    justify-items: center;\r\n"
				+ "}\r\n"
				+ ".eye .logo__image{\r\n"
				+ "    position: relative;\r\n"
				+ "    width: 50px;\r\n"
				+ "    z-index: 1;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".number {\r\n"
				+ "    text-align: center;\r\n"
				+ "    text-transform: uppercase;\r\n"
				+ "    padding-bottom: 30px;\r\n"
				+ "}\r\n"
				+ ".number h3 {\r\n"
				+ "    color: #D90429;\r\n"
				+ "    margin: 0.9em 0 0 0;\r\n"
				+ "    font-size: 36px;\r\n"
				+ "}\r\n"
				+ ".number span {\r\n"
				+ "    display: block;\r\n"
				+ "    color: rgba(0, 0, 0, 0.54);\r\n"
				+ "}  \r\n"
				+ "\r\n"
				+ " </style>  \r\n"
				+ "</head>\r\n"
				+ "<body>   \r\n"
				+ "<p>La tua prenotazione è avvenuta con successo!</p>"
				+ "<p>Di seguito troverai il biglietto da presentare in biglietteria per poter accedere in sala.</p>"
				+ "<p></p>"
				+ "<p>Buona visione!</p>"
				+ "<p></p>"
				+ "<div class=\"cardContainer\">\r\n"
				+ "            <div class=\"card-biglietto cardLeft\">\r\n"
				+ "            <h1 style='color: #fff'>Premiere Cinema Cult</h1>\r\n"
				+ "            <div class=\"title\">\r\n"
				+ "                <h2>"+spettacolo.getFilm().getTitolo()+"</h2>\r\n"
				+ "                <span>Titolo</span>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"name\">\r\n"
				+ "                <h2>"+spettacolo.getSala().getNome()+"</h2>\r\n"
				+ "                <span>sala</span>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"seat\">\r\n"
				+ "                <h2>"+dataFormattata+"</h2>\r\n"
				+ "                <span>Data</span>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"time\">\r\n"
				+ "                <h2>"+myDateStr+"</h2>\r\n"
				+ "                <span>Ora</span>\r\n"
				+ "            </div>\r\n"
				+ "            \r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"card-biglietto cardRight\">\r\n"
				+ "            <div class=\"eye\">\r\n"
				+ "                <img src=\"https://raw.githubusercontent.com/Morfe0/cssbiglietto/3bc946c8bfb83a719887f4e28ea5d2d768f62d42/FaviconGruppo4.png\" alt=\"Logo\" class=\"logo__image\">\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"number\">\r\n"
				+ "                <h3>"+prenotazione.getId()+"</h3>\r\n"
				+ "                <span>Codice Prenotazione</span>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "        </body>";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	public static void inviaMailSpettacoloEliminato(String destinatario, Spettacolo spettacolo) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		DateFormat df=new SimpleDateFormat("H:mm");
		String myDateStr=df.format(spettacolo.getOra());
		DateFormat dataf= new SimpleDateFormat("dd/MM/yyyy");
		String dataFormattata = dataf.format(spettacolo.getData());
		String ogg = "Premiere Cinema Cult - Prenotazione eliminata";
		String text = "A causa della cancellazione dello spettacolo delle ore: "+ myDateStr + " del "+dataFormattata+",<br>"
				+ "la sua prenotazione è stata cancellata, ci scusiamo per il disagio.<br>"
				+ "Sarà rimborsat* entro 3 giorni lavorativi sul metodo di pagamento utilizzato durante l'acquisto.<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	public static void inviaMailSpettacoloModificato(String destinatario, Spettacolo spettacolo) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		DateFormat df=new SimpleDateFormat("H:mm");
		String myDateStr=df.format(spettacolo.getOra());
		DateFormat dataf= new SimpleDateFormat("dd/MM/yyyy");
		String dataFormattata = dataf.format(spettacolo.getData());
		String ogg = "Premiere Cinema Cult - Avviso modifica dello spettacolo";
		String text = "La avvisiamo che lo spettacolo da lei prenotato è stato modificato,<br> "
				+ "di seguito troverà tutti i dettagli aggiornati:<br> "
				+ "Il film "+spettacolo.getFilm().getTitolo() + " verrà trasmesso nella sala "+spettacolo.getSala().getNome()+",<br>"
				+ "in data "+dataFormattata + " alle ore "+myDateStr +".<br>"
				+ "Ci scusiamo per il disiagio, se non dovesse più essere interessat*, può sempre annullare la prenotazione sul nostro sito.<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	public static void inviaMailUtenteEliminaPrenotazione(String destinatario, Spettacolo spettacolo) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		DateFormat df=new SimpleDateFormat("H:mm");
		String myDateStr=df.format(spettacolo.getOra());
		String ogg = "Conferma di cancellazione della prenotazione per il film "+spettacolo.getFilm().getTitolo();
		String text = "Le confermiamo l'avvenuta cancellazione della prenotazione.<br>"
				+ "Il rimborso avverrà entro 3 giorni lavorativi sul metodo di pagamento utilizzato al momento della prenotazione.<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	public static void inviaMailInserimentoNuovoFilm(String destinatario, Utente utente, Film film) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		String ogg = "E' disponibile un nuovo Film nelle nostre Sale!";
		String text = "Buongiorno "+utente.getNome()+"!<br>"
				+ "Da oggi è disponibile nelle nostre sale " + film.getTitolo() + "!<br>"
				+ "Per maggiori informazioni consulta il nostro sito,<br>"
				+ "Ti aspettiamo presto nelle nostre sale.<br>"
				+ "<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	public static void inviaMailDimenticaPassoword(String destinatario, Utente utente) throws AddressException, AuthenticationFailedException, SendFailedException, MessagingException{
		String ogg = "Password account Premiere Cinema Cult";
		String text = "Buongiorno "+utente.getNome()+"!<br>"
				+ "La sua password è: " + utente.getPassword() + "<br>"
				+ "<br>"
				+ "Cordiali saluti, <br>"
				+ "<br>"
				+ "Premiere Cinema Cult";
		String mittente = "premierecinemacult@gmail.com";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", true);
		Session session = Session.getDefaultInstance(props);
		Message message = new MimeMessage(session);
		message.setSubject(ogg);
		message.setContent(text, "text/html"); // permette di utilizzare codice HTML all'iterno della mail
		Address from = new InternetAddress(mittente);
		Address to = new InternetAddress(destinatario);
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.TO, to);
		Transport transport = session.getTransport();
		transport.connect("premierecinemacult@gmail.com", "CinemaCult01!");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	
	
	
	
	
	
	
}
