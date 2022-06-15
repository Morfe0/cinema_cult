package com.azienda.webapp.dao;

import java.util.List;

import com.azienda.webapp.entity.Spettacolo;

public interface SpettacoloDao {
	List<Spettacolo> findAll();

	Spettacolo findById(int id);

	boolean save(Spettacolo spettacolo);

	void update(Spettacolo spettacolo);


	boolean removeById(int id);
}
