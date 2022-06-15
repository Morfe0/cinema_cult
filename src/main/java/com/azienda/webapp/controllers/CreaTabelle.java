package com.azienda.webapp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.webapp.dao.AttoreDao;
import com.azienda.webapp.dao.DaoFactory;
import com.azienda.webapp.entity.Attore;


@WebServlet("/CreaTabelle")
public class CreaTabelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	DaoFactory factory = DaoFactory.getFactory("jpa");
	AttoreDao attoreDao = factory.getAttoreDao();
	attoreDao=DaoFactory.getFactory("jpa").getAttoreDao();
	try {
		List<Attore>attori=attoreDao.findAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
