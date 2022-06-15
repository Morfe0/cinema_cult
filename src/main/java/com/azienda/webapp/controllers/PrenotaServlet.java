package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.PrenotazioneDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Sala;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;



@WebServlet("/Prenota")
public class PrenotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao filmDao = factory.getFilmDao();
		int idFilm = Integer.parseInt(request.getParameter("id_film"));
		Film film = filmDao.findById(idFilm);
		List<Spettacolo>spettacoliAttivi=PrenotaServlet.spettacoliAttivi(film);
		request.setAttribute("film", film);
		request.setAttribute("spettacoliPrenotabili", spettacoliAttivi);
		request.getRequestDispatcher("WEB-INF/jsp/prenotazione.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory("jpa");
		SpettacoloDao spettacoloDao = factory.getSpettacoloDao();
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		UtenteDao utenteDao = factory.getUtenteDao();
		int idSpettacolo  = Integer.parseInt(request.getParameter("id_spettacolo"));
		Spettacolo spettacolo = spettacoloDao.findById(idSpettacolo);
		int postiPrenotati = Integer.parseInt(request.getParameter("postiPrenotati"));
		int idUtente =  Integer.parseInt(request.getParameter("id_utente"));
		Utente utente = utenteDao.findUtenteById(idUtente);
		Date dataPrenotazione = Date.valueOf(LocalDate.now());
		
		int postiDisponibili = spettacolo.getPostiDisponibili();
		double prezzoUni = spettacolo.getFilm().getPrezzo();
		double prezzoTot = (prezzoUni*postiPrenotati);
		if( postiDisponibili >= postiPrenotati ) {
			//spettacoloDao.update(spettacolo);
			Prenotazione prenotazione = new Prenotazione(utente,spettacolo,dataPrenotazione,postiPrenotati);
			//prenotazioneDao.save(prenotazione);
			//request.setAttribute("esito", "Prenotazione completata!");
			request.setAttribute("prenotazione", prenotazione );
			request.setAttribute("totale", prezzoTot);
			request.getRequestDispatcher("WEB-INF/jsp/paga.jsp").forward(request, response);
		}else {
			String error = "Posti Esauriti!";
			request.setAttribute("error", error);

			request.setAttribute("film",spettacolo.getFilm());
			request.setAttribute("spettacoliPrenotabili",PrenotaServlet.spettacoliAttivi(spettacolo.getFilm()));

			request.getRequestDispatcher("WEB-INF/jsp/prenotazione.jsp").forward(request, response);
		}
	}
	static List<Spettacolo> spettacoliAttivi(Film film){
		List<Spettacolo>spettacoli=film.getSpettacoli();
		List<Spettacolo>spettacoliAttivi=new ArrayList<Spettacolo>();
		for(Spettacolo spettacolo:spettacoli) {
			if(spettacolo.getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
				if(spettacolo.getOra().compareTo(Time.valueOf(LocalTime.now()))>=0||spettacolo.getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
					spettacoliAttivi.add(spettacolo);
				}
			}
		}
		return spettacoliAttivi;
	}
}
