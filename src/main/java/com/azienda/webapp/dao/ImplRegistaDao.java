package com.azienda.webapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.azienda.webapp.entity.Attore;
import com.azienda.webapp.entity.Regista;

public class ImplRegistaDao implements RegistaDao{
	private static ImplRegistaDao instance;
	private ImplRegistaDao () {}
	public static ImplRegistaDao getInstance() {
		if(instance==null) {
			instance = new ImplRegistaDao();
		}
		return instance;
	}
	@Override
	public void save(Regista regista) {
		EntityManager manager = FactoryJpa.getEntityManager();
		try {
			manager.getTransaction().begin(); 
			manager.persist(regista); 
			manager.getTransaction().commit(); 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public Regista findByNomeCognome(String nome, String cognome) {
		EntityManager manager = FactoryJpa.getEntityManager();
		Query query = manager.createQuery("SELECT u from Regista u WHERE u.nome =:x AND u.cognome =:y", Attore.class);
		query.setParameter("x",nome);
		query.setParameter("y",cognome);
		Regista regista = (Regista) query.getSingleResult();
		return regista;
	}



}
