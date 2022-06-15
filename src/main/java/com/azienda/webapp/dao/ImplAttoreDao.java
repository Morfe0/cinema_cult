package com.azienda.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.azienda.webapp.entity.Attore;
import com.azienda.webapp.entity.Utente;


public class ImplAttoreDao implements AttoreDao{
	private static ImplAttoreDao instance;
	private ImplAttoreDao () {}
	public static ImplAttoreDao getInstance() {
		if(instance==null) {
			instance = new ImplAttoreDao();
		}
		return instance;
	}
	@Override
	public List<Attore> findAll() throws SQLException {
		EntityManager manager= FactoryJpa.getEntityManager();
		List<Attore> attori =manager.createNamedQuery("Attore.findAll", Attore.class).getResultList();
		return attori;
	}
	@Override
	public Attore findByNomeCognome(String nome, String cognome) {
		EntityManager manager = FactoryJpa.getEntityManager();
		Query query = manager.createQuery("SELECT u from Attore u WHERE u.nome=:x AND u.cognome=:y", Attore.class);
		query.setParameter("x",nome);
		query.setParameter("y",cognome);
		Attore attore = (Attore) query.getSingleResult();
		return attore;

	}
	@Override
	public boolean save(Attore attore){
		EntityManager manager = FactoryJpa.getEntityManager();
		
			manager.getTransaction().begin(); 
			manager.persist(attore); 
			manager.getTransaction().commit(); 
		
		return true;	
	}

}
