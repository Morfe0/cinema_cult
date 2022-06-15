package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.azienda.webapp.entity.Ruolo;
import com.azienda.webapp.entity.Utente;

public class ImplUtenteDao implements UtenteDao {
	private static ImplUtenteDao instance;
	private ImplUtenteDao () {}
	public static ImplUtenteDao getInstance() {
		if(instance==null) {
			instance = new ImplUtenteDao();
		}
		return instance;
	}
	
	@Override
	public boolean findByEmailAndPassword(String email, String password) {
		EntityManager manager = FactoryJpa.getEntityManager();
		List<Utente> utenti = manager.createNamedQuery("Utente.findAll", Utente.class).getResultList();
		for(Utente utente : utenti) {
			if(utente.getEmail().equalsIgnoreCase(email) && utente.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Utente> findAll() {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Utente.findAll", Utente.class).getResultList();
	}

	@Override
	public boolean save(Utente utente){
		EntityManager manager = FactoryJpa.getEntityManager();
		
			manager.getTransaction().begin(); 
			manager.persist(utente); 
			manager.getTransaction().commit(); 
		
		return true;	
	}

	@Override
	public Utente findRuoloByEmail(String email) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createQuery("select u.Ruolo from Utente u where u.email=:email", Utente.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public void updateRuoloUtente(Utente utente) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();
	}

	@Override
	public Utente findUtenteById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createQuery("select u from Utente u where u.id=:id", Utente.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Utente findUtenteByEmail(String email) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createQuery("select u from Utente u where u.email=:email", Utente.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public void updateEmail(Utente utente) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();		
	}

	@Override
	public void updatePassword(Utente utente) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();
	}

	@Override
	public List<Utente> findUtenteByRuolo(Ruolo ruolo) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createQuery("select u from Utente u where u.ruolo=:ruolo",Utente.class).setParameter("ruolo", ruolo).getResultList();
	}
	
	@Override
	public boolean removeById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("DELETE from Utente u WHERE u.id=:x", Utente.class);
		
		query.setParameter("x",id).executeUpdate();
		manager.getTransaction().commit();
		
		return true;
	}
	@Override
	public boolean remove(Utente utente) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		if(!manager.contains(utente)) {
			utente = manager.merge(utente);
		}
		manager.remove(utente);
		manager.getTransaction().commit();
		return true;
	}

	

}
