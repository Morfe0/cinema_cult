package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Film;
import com.azienda.webapp.entity.Spettacolo;

public class ImplFilmDao implements FilmDao {
	private static ImplFilmDao instance;
	private ImplFilmDao () {}
	public static ImplFilmDao getInstance() {
		if(instance==null) {
			instance = new ImplFilmDao();
		}
		return instance;
	}
	
	@Override
	public List<Film> findAll() {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Film.findAll", Film.class).getResultList();
	}
	
	@Override
	public Film findById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Film.findById",Film.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public boolean save(Film film) {
		EntityManager manager = FactoryJpa.getEntityManager();
		try {
			manager.getTransaction().begin(); 
			manager.persist(film); 
			manager.getTransaction().commit(); 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	return true;

	}
	@Override
	public boolean update(Film film) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(film);
		manager.getTransaction().commit();
		return true;
	}
	@Override
	public boolean removeById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
        Film film = findById(id);
        manager.getTransaction().begin();
        if(!manager.contains(film)) {
           film = manager.merge(film);
        }
        manager.remove(film);
        manager.getTransaction().commit();
        return true;
	}




}
