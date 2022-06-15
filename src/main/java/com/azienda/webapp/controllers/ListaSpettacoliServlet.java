package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Spettacolo;


@WebServlet("/ListaSpettacoli")
public class ListaSpettacoliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		List <Spettacolo> spettacoli = spettacoloDao.findAll();
		request.setAttribute("listaSpettacoli", spettacoli);
		request.getRequestDispatcher("WEB-INF/jsp/listaSpettacoli.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
