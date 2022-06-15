package com.azienda.webapp.dao;

import java.util.List;

import com.azienda.webapp.entity.Film;

public interface FilmDao {

	List<Film> findAll();

	Film findById(int id);
	
	boolean save(Film film);

	boolean update(Film film);

	boolean removeById(int id);
	
	

}
