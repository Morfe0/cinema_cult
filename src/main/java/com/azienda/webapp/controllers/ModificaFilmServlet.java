package com.azienda.webapp.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.entity.Film;
import com.azienda.webapp.utility.Utilities;
import com.azienda.webapp.dao.FilmDao;

@WebServlet("/ModificaFilm")
@MultipartConfig
public class ModificaFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao FilmDao = factory.getFilmDao();
		Film film = FilmDao.findById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("film", film);
		request.getRequestDispatcher("WEB-INF/jsp/modificaFilm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory("jpa");
		FilmDao filmDao = factory.getFilmDao();
		/*Parametri*/
		String titolo = request.getParameter("titolo");
		int idFilm = Integer.parseInt(request.getParameter("id"));
		Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		final Part filePart = request.getPart("file");
		final String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\wtpwebapps\\cinema_cult\\res";
		String fileName = Utilities.scriviSuFile(filePart, path);
		/*-----*/
		Film film = filmDao.findById(idFilm);
		if(prezzo!=null) {
		film.setPrezzo(prezzo);
		}
		if (!titolo.isBlank()) {
		film.setTitolo(titolo);
		}
		if(fileName!=null) {
			film.setLocandina(fileName);
		}
		filmDao.update(film);
		request.setAttribute("update", "Aggiornamento completato!");
		request.setAttribute("film", film);
		request.getRequestDispatcher("WEB-INF/jsp/modificaFilm.jsp").forward(request, response);
	}
}