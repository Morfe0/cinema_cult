package com.azienda.webapp.controllers;

import java.io.IOException;

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
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;

@WebServlet("/PasswordDimenticata")
public class PasswordDimenticata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/passwordDimenticata.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Utente utente = new Utente();
		try {
			utente = DaoFactory.getFactory("jpa").getUtenteDao().findUtenteByEmail(email);
		}catch(Exception ex) {
			request.setAttribute("errore", true);
			request.getRequestDispatcher("WEB-INF/jsp/passwordDimenticata.jsp").forward(request, response);
		}
		try {
			JavaMailSystem.inviaMailDimenticaPassoword(email, utente);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (SendFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Login");
	}
}