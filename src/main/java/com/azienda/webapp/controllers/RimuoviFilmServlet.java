package com.azienda.webapp.controllers;

import java.io.IOException;
import java.util.List;

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
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.PrenotazioneDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.utility.JavaMailSystem;


@WebServlet("/RimuoviFilm")
public class RimuoviFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ProfiloAdmin");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		PrenotazioneDao prenotazioneDao = DaoFactory.getFactory("jpa").getPrenotazioneDao();
		FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
		int id = Integer.parseInt(request.getParameter("id_film"));
		Film film =filmDao.findById(id);
		List<Spettacolo>spettacoli=film.getSpettacoli();
		for(Spettacolo spettacolo : spettacoli) {
			List<Prenotazione>prenotazioni=spettacolo.getPrenotazioni();
			int idSpettacolo = spettacolo.getId();
			for(Prenotazione prenotazione:prenotazioni) {
				try {
					JavaMailSystem.inviaMailSpettacoloEliminato(prenotazione.getUtente().getEmail(),spettacolo);
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (AuthenticationFailedException e) {
					e.printStackTrace();
				} catch (SendFailedException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				prenotazioneDao.remove(prenotazione);
			}
			spettacoloDao.removeById(idSpettacolo);
		}
		filmDao.removeById(id);
		response.sendRedirect("ProfiloAdmin");
	}
}