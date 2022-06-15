package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.azienda.webapp.dao.AttoreDao;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.RegistaDao;
import com.azienda.webapp.entity.Attore;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Regista;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;
import com.azienda.webapp.utility.Utilities;


@WebServlet("/InserisciFilm")
@MultipartConfig
public class InserisciFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/inserisciFilm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("titolo");
		int durata = Integer.parseInt(request.getParameter("durata"));
		String trama = request.getParameter("trama");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		/*LOCANDINA*/		
		final Part filePart = request.getPart("file");
		final String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\wtpwebapps\\cinema_cult\\res";
		String fileName = Utilities.scriviSuFile(filePart, path);
		/*REGISTA*/
		RegistaDao registaDao = DaoFactory.getFactory("jpa").getRegistaDao();
		Regista regista=new Regista();
		try {
			regista = registaDao.findByNomeCognome(request.getParameter("registaNome"),request.getParameter("registaCognome"));
		}catch(Exception ex) {
			regista.setNome(request.getParameter("registaNome"));
			regista.setCognome(request.getParameter("registaCognome"));
			registaDao.save(regista);
		}
		/*ATTORE*/
		List<Attore> attori = new ArrayList<Attore>();
		AttoreDao attoreDao = DaoFactory.getFactory("jpa").getAttoreDao();
		try {
		Attore attoreUno = attoreDao.findByNomeCognome(request.getParameter("attoreUnoNome"), request.getParameter("attoreUnoCognome"));
		attori.add(attoreUno);
		}catch(Exception ex){
			Attore attoreUno= new Attore(request.getParameter("attoreUnoNome"),request.getParameter("attoreUnoCognome"));
			attoreDao.save(attoreUno);
			attori.add(attoreUno);
		}
		try {
			Attore attoreDue = attoreDao.findByNomeCognome(request.getParameter("attoreDueNome"), request.getParameter("attoreDueCognome"));
			attori.add(attoreDue);
		}catch(Exception ex){
			Attore attoreDue = new Attore(request.getParameter("attoreDueNome"), request.getParameter("attoreDueCognome"));
			attoreDao.save(attoreDue);
			attori.add(attoreDue);
		}
		try {
		Attore attoreTre = attoreDao.findByNomeCognome(request.getParameter("attoreTreNome"), request.getParameter("attoreTreCognome"));
		attori.add(attoreTre);
		}catch(Exception ex){
			Attore attoreTre = new Attore(request.getParameter("attoreTreNome"), request.getParameter("attoreTreCognome"));
			attoreDao.save(attoreTre);
			attori.add(attoreTre);
		}
		FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
		


		if(fileName!=null && !fileName.isEmpty()) {
			Film film = new Film(titolo,durata,trama,fileName,prezzo,attori,regista);
			film.setAttori(attori);
			boolean f = filmDao.save(film);
			List<Utente> utenti = DaoFactory.getFactory("jpa").getUtenteDao().findAll();
			for(Utente utente : utenti) {
				try {
					JavaMailSystem.inviaMailInserimentoNuovoFilm(utente.getEmail(), utente, film);
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (AuthenticationFailedException e) {
					e.printStackTrace();
				} catch (SendFailedException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("f", f);
		}else {
			Film film = new Film(titolo,durata,trama,prezzo,attori,regista);
			film.setAttori(attori);
			List<Utente> utenti = DaoFactory.getFactory("jpa").getUtenteDao().findAll();
			boolean f = filmDao.save(film);
			for(Utente utente : utenti) {
				try {
					JavaMailSystem.inviaMailInserimentoNuovoFilm(utente.getEmail(), utente, film);
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (AuthenticationFailedException e) {
					e.printStackTrace();
				} catch (SendFailedException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("f", f);
		}
		response.sendRedirect("ProfiloAdmin");
	}
}
