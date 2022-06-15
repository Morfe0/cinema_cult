package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Spettacolo;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao filmDao = factory.getFilmDao();
		List<Film> films = filmDao.findAll();
		List<Film> filmAttivi = new ArrayList<Film>();
		for(Film film:films) {
			List<Spettacolo>spettacoliControllo=PrenotaServlet.spettacoliAttivi(film);
			if(!spettacoliControllo.isEmpty()) {
				filmAttivi.add(film);
			}
		}
		request.setAttribute("listaFilm",films);
		request.setAttribute("listaFilmAttivi", filmAttivi);
		
		request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
