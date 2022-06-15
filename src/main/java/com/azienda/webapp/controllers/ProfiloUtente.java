package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
import com.azienda.webapp.dao.PrenotazioneDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.dao.UtenteDao;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Sala;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;

@WebServlet("/ProfiloUtente")
public class ProfiloUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utentex=(Utente)request.getSession().getAttribute("utente");
		UtenteDao utenteDao = DaoFactory.getFactory("jpa").getUtenteDao();
		Utente utente=utenteDao.findUtenteById(utentex.getId());
		List<Prenotazione>prenotazioni=utente.getPrenotazioni();
		List<Prenotazione>prenotazioniAttive = new ArrayList<Prenotazione>();
		for(Prenotazione prenotazione:prenotazioni) {
			if(prenotazione.getSpettacolo().getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
				if(prenotazione.getSpettacolo().getOra().compareTo(Time.valueOf(LocalTime.now()))>=0 ||prenotazione.getSpettacolo().getData().compareTo(Date.valueOf(LocalDate.now()))>0 ) {
					prenotazioniAttive.add(prenotazione);
				}
			}
		}
		request.setAttribute("prenotazioniAttive", prenotazioniAttive);




		request.getRequestDispatcher("WEB-INF/jsp/profiloUtente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_prenotazione"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		Prenotazione prenotazione = prenotazioneDao.findPrenotazioneById(id);
		Integer postiDaRipristinare = prenotazione.getPostiPrenotati();
		Spettacolo spettacolo = prenotazione.getSpettacolo();
		
		spettacolo.setPostiDisponibili(spettacolo.getPostiDisponibili()+postiDaRipristinare);
		
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		spettacoloDao.update(spettacolo);
		prenotazioneDao.remove(prenotazione);
		try {
			JavaMailSystem.inviaMailUtenteEliminaPrenotazione(prenotazione.getUtente().getEmail(), spettacolo);
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
		
		response.sendRedirect("ProfiloUtente");



	}

}






/*
public class ProfiloUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		List<Prenotazione>prenotazioniAttive = new ArrayList<Prenotazione>();
		if(!utente.getPrenotazioni().isEmpty()) {
		List<Prenotazione>prenotazioni=utente.getPrenotazioni();
		
		
		for(Prenotazione prenotazione:prenotazioni) {
			if(prenotazione.getSpettacolo().getData().compareTo(Date.valueOf(LocalDate.now()))>=0) {
				if(prenotazione.getSpettacolo().getOra().compareTo(Time.valueOf(LocalTime.now()))>=0) {
					prenotazioniAttive.add(prenotazione);
				}
			}
		}
		}
		
		request.setAttribute("prenotazioniAttive", prenotazioniAttive);




		request.getRequestDispatcher("WEB-INF/jsp/profiloUtente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_prenotazione"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		Prenotazione prenotazione = prenotazioneDao.findPrenotazioneById(id);
		Integer postiDaRipristinare = prenotazione.getPostiPrenotati();
		Spettacolo spettacolo = prenotazione.getSpettacolo();
		spettacolo.setPostiDisponibili(spettacolo.getPostiDisponibili()+postiDaRipristinare);
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		spettacoloDao.update(spettacolo);
		prenotazioneDao.remove(prenotazione);
		response.sendRedirect("ProfiloUtente");
		



	}

}
*/
