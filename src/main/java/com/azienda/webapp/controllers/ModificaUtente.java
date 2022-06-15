package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.RuoloDao;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Ruolo;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.Utilities;

@WebServlet("/ModificaUtente")
public class ModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_utente"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		UtenteDao utenteDao = factory.getUtenteDao();
		Utente utente = utenteDao.findUtenteById(id);

		RuoloDao ruoloDao= factory.getRuoloDao();
		List<Ruolo> ruoli = ruoloDao.findAll();
		request.setAttribute("ruoli", ruoli);


		request.setAttribute("utente", utente);
		request.getRequestDispatcher("WEB-INF/jsp/modificaUtente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_utente"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		UtenteDao utenteDao = factory.getUtenteDao();
		Utente utente = utenteDao.findUtenteById(id);
		int idRuolo;
		try{ 
			idRuolo = Integer.parseInt(request.getParameter("ruolo"));
		}catch(IllegalArgumentException e){
			idRuolo=utente.getRuolo().getId();
		}

		String emailModificata = request.getParameter("email");
		String passwordModificata = request.getParameter("password");





		RuoloDao ruoloDao = factory.getRuoloDao();
		Ruolo ruolo = ruoloDao.findRuoloById(idRuolo);

		utente.setRuolo(ruolo);
		if(ruolo.getId()!=1&&ruolo.getId()!=2) {
			if(emailModificata.isBlank()) {
			utente.setEmail(utente.getEmail());
			}
			if(passwordModificata.isBlank()) {
			utente.setPassword(utente.getPassword());
			}
			if(!emailModificata.isBlank()) {
				utente.setEmail(emailModificata);
			}
			if(!passwordModificata.isBlank()) {
				utente.setPassword(passwordModificata);
			}
		}

		if(ruolo.getId()==2||ruolo.getId()==1) {
			String email = Utilities.creaEmailStaffAdmin(utente);
			String password = Utilities.creaPasswordStaffAdmin(utente);
			utente.setEmail(email);
			utente.setPassword(password);
		}
		utenteDao.updateRuoloUtente(utente);
		response.sendRedirect("ProfiloAdmin");
	}

}
