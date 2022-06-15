package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Ruolo;



public class ImplRuoloDao implements RuoloDao {
	private static ImplRuoloDao instance;
	private ImplRuoloDao () {}
	public static ImplRuoloDao getInstance() {
		if(instance==null) {
			instance = new ImplRuoloDao();
		}
		return instance;
	}
	@Override
	public Ruolo findRuoloById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Ruolo.findById", Ruolo.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Ruolo> findAll(){
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Ruolo.findAll", Ruolo.class).getResultList();
	}

}
