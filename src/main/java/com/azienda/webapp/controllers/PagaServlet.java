package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Sala;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;


@WebServlet("/paga")
public class PagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/paga.jsp").forward(request, response);
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
		/*String numeroCarta = request.getParameter("numeroCarta");
		String cvv = request.getParameter("cvv");
		Date scadenza = Date.valueOf(request.getParameter("scadenza"));
		boolean numeroCartaOk = Utilities.controlloNumCarta(numeroCarta);
		boolean cvvOk = Utilities.controlloCvv(cvv);
		boolean scadenzaOk = Utilities.controlloScadenza(scadenza);*/
		Date dataPrenotazione = Date.valueOf(LocalDate.now());
		int postiDisponibili = spettacolo.getPostiDisponibili();
		if( postiDisponibili >= postiPrenotati ) {
			spettacolo.setPostiDisponibili(postiDisponibili-postiPrenotati);
			spettacoloDao.update(spettacolo);
			Prenotazione prenotazione = new Prenotazione(utente,spettacolo,dataPrenotazione,postiPrenotati);
			prenotazioneDao.save(prenotazione);
			try {
				JavaMailSystem.inviaMailConfermaPrenotazione(utente.getEmail(), spettacolo, utente, prenotazione);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AuthenticationFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SendFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Home");;
		}else {
			FilmDao filmDao = factory.getFilmDao();
			int idFilm = Integer.parseInt(request.getParameter("id_film"));
			Film film = filmDao.findById(idFilm);
			List<Spettacolo>spettacoliAttivi=PrenotaServlet.spettacoliAttivi(film);
			request.setAttribute("film", film);
			request.setAttribute("spettacoliPrenotabili", spettacoliAttivi);
			String error = "Posti Esauriti!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("WEB-INF/jsp/prenotazione.jsp").forward(request, response);
		}
	}

}
