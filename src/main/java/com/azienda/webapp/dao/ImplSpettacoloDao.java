package com.azienda.webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.webapp.entity.Spettacolo;



public class ImplSpettacoloDao implements SpettacoloDao {
	private static ImplSpettacoloDao instance;
	private ImplSpettacoloDao () {}
	public static ImplSpettacoloDao getInstance() {
		if(instance==null) {
			instance = new ImplSpettacoloDao();
		}
		return instance;
	}
	
	@Override
	public boolean save(Spettacolo spettacolo){
		EntityManager manager = FactoryJpa.getEntityManager();
		
			manager.getTransaction().begin(); 
			manager.persist(spettacolo); 
			manager.getTransaction().commit(); 
		
		return true;	
	}
	
	@Override
	public List<Spettacolo> findAll() {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Spettacolo.findAll", Spettacolo.class).getResultList();
	}
	@Override
	public Spettacolo findById(int id) {
		EntityManager manager = FactoryJpa.getEntityManager();
		return manager.createNamedQuery("Spettacolo.findById",Spettacolo.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public void update(Spettacolo spettacolo) {
		EntityManager manager = FactoryJpa.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(spettacolo);
		manager.getTransaction().commit();
		
	}
	  @Override
	    public boolean removeById(int id) {
	        EntityManager manager = FactoryJpa.getEntityManager();
	        Spettacolo spettacolo = findById(id);
	        manager.getTransaction().begin();
	        if(!manager.contains(spettacolo)) {
	            spettacolo = manager.merge(spettacolo);
	        }
	        manager.remove(spettacolo);
	        manager.getTransaction().commit();
	        return true;
	    }



}
