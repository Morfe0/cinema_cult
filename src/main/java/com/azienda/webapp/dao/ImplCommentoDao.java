package com.azienda.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Commento;


public class ImplCommentoDao implements CommentoDao {
	
	private static ImplCommentoDao instance;
	private ImplCommentoDao () {}
	public static ImplCommentoDao getInstance() {
		if(instance==null) {
			instance = new ImplCommentoDao();
		}
		return instance;
	}
	@Override
	public List<Commento> findAll() throws SQLException {
		EntityManager manager= FactoryJpa.getEntityManager();
		List<Commento> commenti =manager.createNamedQuery("Commento.findAll", Commento.class).getResultList();
		return commenti;
	}
	@Override
	public Commento findCommentoById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Commento.findById", Commento.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public void save(Commento commento1) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(commento1);
		manager.getTransaction().commit();
		
	}
	

}
