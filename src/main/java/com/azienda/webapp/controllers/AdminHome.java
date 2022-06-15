package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Utente;

@WebServlet("/ProfiloAdmin")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDao utenteDao = DaoFactory.getFactory("jpa").getUtenteDao();
		List<Utente>utenti=	utenteDao.findAll();
		request.setAttribute("utenti", utenti);
		
		FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
		List<Film>films=filmDao.findAll();
		request.setAttribute("listafilm", films);
		
		request.getRequestDispatcher("WEB-INF/jsp/profiloAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
