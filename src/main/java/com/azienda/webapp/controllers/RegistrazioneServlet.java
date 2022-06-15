package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Ruolo;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/registrazione.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String citta =request.getParameter("citta");
		String password = request.getParameter("password");
		Date dataNascita = Date.valueOf(request.getParameter("dataNascita"));
		Ruolo ruolo = new Ruolo(3, "user");
		boolean abilitato = true;
		Utente utente = new Utente(nome,cognome,email,password,dataNascita,citta,abilitato,ruolo);
		UtenteDao utenteDao = DaoFactory.getFactory("jpa").getUtenteDao();
		boolean verifica = utenteDao.save(utente);
if(verifica) {
		try {
			JavaMailSystem.inviaMailConferma(email, utente);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SendFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Login");
}else {
		request.setAttribute("verifica", verifica);
		request.getRequestDispatcher("WEB-INF/jsp/registrazione.jsp").forward(request, response);
}
	}
}
