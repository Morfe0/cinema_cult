package com.azienda.webapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Utente;

@WebServlet("/AbilitaDisabilita")
public class AbilitaDisabilitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AdminHome");


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_utente"));
		UtenteDao utenteDao = DaoFactory.getFactory("jpa").getUtenteDao();
		Utente utente = utenteDao.findUtenteById(id);
		Boolean stato =	Boolean.valueOf(request.getParameter("stato"));

		if(stato) {
			utente.setAbilitato(false);
		}else {
			utente.setAbilitato(true);
		}

		utenteDao.updateRuoloUtente(utente);	
		
		response.sendRedirect("ProfiloAdmin");
	}

}
