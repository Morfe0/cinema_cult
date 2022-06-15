package com.azienda.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.azienda.webapp.entity.Attore;

public interface AttoreDao {

	List<Attore> findAll() throws SQLException;
	Attore findByNomeCognome(String nome, String cognome);
	boolean save(Attore attore);

}
