package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
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
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Sala;
import com.azienda.webapp.entity.Spettacolo;
import com.azienda.webapp.entity.Utente;
import com.azienda.webapp.utility.JavaMailSystem;


@WebServlet("/ModificaSpettacolo")
public class ModificaSpettacolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_spettacolo"));
		SpettacoloDao spettacoloDao = DaoFactory.getFactory("jpa").getSpettacoloDao();
		Spettacolo spettacolo = spettacoloDao.findById(id);
		request.setAttribute("spettacolo", spettacolo);
		request.getRequestDispatcher("WEB-INF/jsp/modificaSpettacolo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date dataSpettacolo = Date.valueOf(request.getParameter("dataSpettacolo"));
		LocalTime oraLocalTime =LocalTime.parse(request.getParameter("oraSpettacolo"));
		Time ora = Time.valueOf(oraLocalTime);
		int id = Integer.parseInt(request.getParameter("id_spettacolo"));
		Spettacolo spettacolo = DaoFactory.getFactory("jpa").getSpettacoloDao().findById(id);
		spettacolo.setData(dataSpettacolo);
		spettacolo.setOra(ora);
		SpettacoloDao spettacoloDao=DaoFactory.getFactory("jpa").getSpettacoloDao();
		spettacoloDao.update(spettacolo);
		List<Prenotazione>prenotazioni= spettacolo.getPrenotazioni();
		List<Utente>utenti=new ArrayList<Utente>();
		for(Prenotazione prenotazione:prenotazioni) {
			utenti.add(prenotazione.getUtente());
		}
		for(Utente utente:utenti) {
			try {
				JavaMailSystem.inviaMailSpettacoloModificato(utente.getEmail(), spettacolo);
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
		}
		
		response.sendRedirect("ListaSpettacoli");
	}

}
