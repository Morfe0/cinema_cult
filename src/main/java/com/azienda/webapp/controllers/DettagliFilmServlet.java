package com.azienda.webapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.entity.Film;


@WebServlet("/DettagliFilm")
public class DettagliFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao filmDao = factory.getFilmDao();
		Film film = filmDao.findById(id);
		request.setAttribute("film", film);
		request.getRequestDispatcher("WEB-INF/jsp/dettagliFilm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
