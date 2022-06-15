package com.azienda.webapp.dao;

import java.util.List;


import com.azienda.webapp.entity.Sala;

public interface SalaDao {
	List<Sala> findAll();

	Sala findById(int id);

}
