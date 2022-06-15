package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.dao.FilmDao;
import com.azienda.webapp.dao.SalaDao;
import com.azienda.webapp.dao.SpettacoloDao;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Sala;
import com.azienda.webapp.entity.Spettacolo;

@WebServlet("/InserisciSpettacolo")
public class InserisciSpettacolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_film"));
		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao filmDao = DaoFactory.getFactory("jpa").getFilmDao();
		Film film = filmDao.findById(id);
		Spettacolo spettacolo = new Spettacolo();
		spettacolo.setFilm(film);
		SalaDao salaDao=factory.getSalaDao();
		List<Sala> sale = salaDao.findAll();
		request.setAttribute("sale", sale);
		request.setAttribute("spettacolo", spettacolo);
		request.getRequestDispatcher("WEB-INF/jsp/inserisciSpettacolo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFilm = Integer.parseInt(request.getParameter("id_film"));
		Date dataSpettacolo = Date.valueOf(request.getParameter("data"));
		LocalTime oraLocal =LocalTime.parse(request.getParameter("ora"));
		Time ora = Time.valueOf(oraLocal);
		Sala sala = DaoFactory.getFactory("jpa").getSalaDao().findById(Integer.parseInt(request.getParameter("idSala")));
		Film film = DaoFactory.getFactory("jpa").getFilmDao().findById(idFilm);
		int postiDisponibili = sala.getPosti();
		if(InserisciSpettacolo.controllaPossoInserireSpettacolo(ora, film.getDurata(), dataSpettacolo, sala)) {
			Spettacolo spettacolo = new Spettacolo (dataSpettacolo,ora,postiDisponibili,sala,film);
			SpettacoloDao spettacoloDao=DaoFactory.getFactory("jpa").getSpettacoloDao();
			spettacoloDao.save(spettacolo);
			response.sendRedirect("ProfiloAdmin");
		}else {
			DaoFactory factory = DaoFactory.getFactory("jpa");
			Spettacolo spettacolo = new Spettacolo();
			spettacolo.setFilm(film);
			SalaDao salaDao=factory.getSalaDao();
			List<Sala> sale = salaDao.findAll();
			request.setAttribute("errore", false);
			request.setAttribute("sale", sale);
			request.setAttribute("spettacolo", spettacolo);
			request.getRequestDispatcher("WEB-INF/jsp/inserisciSpettacolo.jsp").forward(request, response);
		}

	}

	private static Boolean controllaPossoInserireSpettacolo(Time ora,int durata,Date dataSpettacolo,Sala sala) {
		LocalTime operazioneOra=ora.toLocalTime();
		Time inizioSpettacolo = Time.valueOf(operazioneOra);
		Time aperturaCinema;
		aperturaCinema = Time.valueOf("14:00:00");
		durata=100;
		Long d = (long) durata;
		LocalTime fs = operazioneOra.plusMinutes(d);
		Time fineSpettacolo = Time.valueOf(fs);
		List<Spettacolo>spettacoli = DaoFactory.getFactory("jpa").getSpettacoloDao().findAll();
		for(Spettacolo spettacolo:spettacoli) {
			LocalTime iniz = spettacolo.getOra().toLocalTime();
			Time inizioSpettacoloComparato = Time.valueOf(iniz);
			Long dur = (long) spettacolo.getFilm().getDurata();
			LocalTime fine = iniz.plusMinutes(dur);
			Time fineSpettacoloComparato = Time.valueOf(fine);

			if(dataSpettacolo.compareTo(spettacolo.getData())==0) {
				if(inizioSpettacolo.compareTo(inizioSpettacoloComparato)>=0 && inizioSpettacolo.compareTo(fineSpettacoloComparato)<0) {
					if(sala.equals(spettacolo.getSala())) {
						return false;
					}
				}

				if(inizioSpettacolo.compareTo(inizioSpettacoloComparato)<0 && fineSpettacolo.compareTo(fineSpettacoloComparato)>=0 && fineSpettacoloComparato.compareTo(aperturaCinema)>0) {
					if(sala.equals(spettacolo.getSala())) {
						return false;
					}
				}

				if(inizioSpettacolo.compareTo(inizioSpettacoloComparato)<0 && fineSpettacolo.compareTo(inizioSpettacoloComparato)>0 ) {
					if(sala.equals(spettacolo.getSala())) {
						return false;
					}
				}
				if(inizioSpettacolo.compareTo(inizioSpettacoloComparato)<0 && fineSpettacolo.compareTo(fineSpettacoloComparato)<0 && fineSpettacolo.compareTo(inizioSpettacoloComparato)>0) {
					if(sala.equals(spettacolo.getSala())){
						return false;
					}
				}


				


			}

		}
		return true;
	}
}

