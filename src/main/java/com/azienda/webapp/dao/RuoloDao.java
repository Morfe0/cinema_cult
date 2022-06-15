package com.azienda.webapp.dao;

import java.util.List;

import com.azienda.webapp.entity.Ruolo;

public interface RuoloDao {

	Ruolo findRuoloById(int id);

	List<Ruolo> findAll();

}
