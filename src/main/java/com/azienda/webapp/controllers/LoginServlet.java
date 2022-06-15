package com.azienda.webapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Utente;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DaoFactory factory = DaoFactory.getFactory("jpa");
		UtenteDao utenteDao = factory.getUtenteDao();
		boolean verifica = utenteDao.findByEmailAndPassword(email,password);
		
		if(verifica) {
			Utente utente = utenteDao.findUtenteByEmail(email);
			utente.setPassword(null);
			boolean abilitato=utente.isAbilitato();
			if(abilitato==false) {
				request.setAttribute("abilitato", abilitato);
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
				
			}
			session.setAttribute("utente", utente);
			response.sendRedirect("Home");
		}else{
			request.setAttribute("verifica", verifica);
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
		}
	}

}
