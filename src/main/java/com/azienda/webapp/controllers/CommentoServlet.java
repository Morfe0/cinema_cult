package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.CommentoDao;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.ImplCommentoDao;
import com.azienda.webapp.dao.RegistaDao;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Commento;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Utente;


@WebServlet("/Commento")
public class CommentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
		try {
			List<Commento> commenti= DaoFactory.getFactory("jpa").getCommentoDao().findAll();
			request.setAttribute("commenti", commenti);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Film>films=filmDao.findAll();
		request.setAttribute("films", films);
		request.getRequestDispatcher("WEB-INF/jsp/commento.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	DaoFactory factory = DaoFactory.getFactory("jpa");
	String commento = request.getParameter("commento");
	FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
	Film film = filmDao.findById(Integer.parseInt(request.getParameter("Id_Film")));
    UtenteDao utenteDao = DaoFactory.getFactory("jpa").getUtenteDao();
	Utente utente = utenteDao.findUtenteById(Integer.parseInt(request.getParameter("utenteLoggato")));
	Commento commento1 = new Commento(commento, utente, film);
	CommentoDao commentoDao = DaoFactory.getFactory("jpa").getCommentoDao();
	commentoDao.save(commento1);
	try {
		List<Commento> commenti = commentoDao.findAll();
		request.setAttribute("commenti", commenti);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<Film>films=filmDao.findAll();
	request.setAttribute("films", films);
	request.getRequestDispatcher("WEB-INF/jsp/commento.jsp").forward(request, response);
	
	}

}
