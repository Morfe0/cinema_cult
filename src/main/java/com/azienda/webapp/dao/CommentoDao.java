package com.azienda.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.azienda.webapp.entity.Commento;

public interface CommentoDao {

	List<Commento> findAll() throws SQLException;

	Commento findCommentoById(int id);

	void save(Commento commento1);

}
