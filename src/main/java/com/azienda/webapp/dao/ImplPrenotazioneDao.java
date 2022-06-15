package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Prenotazione;
import com.azienda.webapp.entity.Spettacolo;

public class ImplPrenotazioneDao implements PrenotazioneDao{
	private static ImplPrenotazioneDao instance;
	private ImplPrenotazioneDao () {}
	public static ImplPrenotazioneDao getInstance() {
		if(instance==null) {
			instance = new ImplPrenotazioneDao();
		}
		return instance;
	}
	@Override
	public boolean save(Prenotazione prenotazione) {
		EntityManager manager = FactoryJpa.getEntityManager();
		try {
			manager.getTransaction().begin(); 
			manager.persist(prenotazione); 
			manager.getTransaction().commit(); 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	return true;
	}
	@Override
	public List<Prenotazione> findAll() {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Prenotazione.findAll", Prenotazione.class).getResultList();
	}
	@Override
	public Prenotazione findPrenotazioneById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Prenotazione.findById",Prenotazione.class).setParameter("id",id).getSingleResult();
	}
	
	@Override
	public boolean update(Prenotazione prenotazione) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(prenotazione);
		manager.getTransaction().commit();
		return true;
	}

	 @Override
	    public boolean remove(Prenotazione prenotazione) {
	        EntityManager manager = FactoryJpa.getEntityManager();
	       
	        manager.getTransaction().begin();
	        if(!manager.contains(prenotazione)) {
	            prenotazione = manager.merge(prenotazione);
	        }
	        manager.remove(prenotazione);
	        manager.getTransaction().commit();
	        return true;
	    }


	

	

}
