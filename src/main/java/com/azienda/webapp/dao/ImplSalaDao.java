package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Sala;

public class ImplSalaDao implements SalaDao{
	private static ImplSalaDao instance;
	private ImplSalaDao () {}
	public static ImplSalaDao getInstance() {
		if(instance==null) {
			instance = new ImplSalaDao();
		}
		return instance;
	}
	@Override
	public List<Sala> findAll() {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Sala.findAll", Sala.class).getResultList();
	}
	@Override
	public Sala findById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Sala.findById",Sala.class).setParameter("id", id).getSingleResult();
	}
	
	


}
