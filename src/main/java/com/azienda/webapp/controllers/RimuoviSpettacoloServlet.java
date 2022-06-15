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
import com.azienda.webapp.dao.PrenotazioneDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.utility.JavaMailSystem;


@WebServlet("/RimuoviSpettacolo")
public class RimuoviSpettacoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ListaSpettacoli");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		int id = Integer.parseInt(request.getParameter("id_spettacolo"));
		PrenotazioneDao prenotazioneDao = DaoFactory.getFactory("jpa").getPrenotazioneDao();
		Spettacolo spettacolo=spettacoloDao.findById(id);
		List<Prenotazione>prenotazioni=spettacolo.getPrenotazioni();
		for(Prenotazione prenotazione:prenotazioni) {
			try {
				JavaMailSystem.inviaMailSpettacoloEliminato(prenotazione.getUtente().getEmail(),spettacolo);
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
			prenotazioneDao.remove(prenotazione);
		}
		spettacoloDao.removeById(id);
		response.sendRedirect("ListaSpettacoli");
	}
	

}
