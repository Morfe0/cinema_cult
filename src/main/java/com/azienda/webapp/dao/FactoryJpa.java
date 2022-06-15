package com.azienda.webapp.dao;

import javax.persistence.EntityManager;  
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryJpa extends DaoFactory {
	public static EntityManager getEntityManager() {
		try {	Class.forName("com.mysql.jdbc.Driver");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cinema_cult");
		factory.getCache().evictAll();
		EntityManager manager =factory.createEntityManager();
		return manager;
	}

	@Override
	public UtenteDao getUtenteDao() {
		// TODO Auto-generated method stub
		return ImplUtenteDao.getInstance();
	}

	@Override
	public SpettacoloDao getSpettacoloDao() {
		// TODO Auto-generated method stub
		return ImplSpettacoloDao.getInstance();
	}

	@Override
	public SalaDao getSalaDao() {
		// TODO Auto-generated method stub
		return ImplSalaDao.getInstance();
	}

	@Override
	public RuoloDao getRuoloDao() {
		// TODO Auto-generated method stub
		return ImplRuoloDao.getInstance();
	}

	@Override
	public RegistaDao getRegistaDao() {
		// TODO Auto-generated method stub
		return ImplRegistaDao.getInstance();
	}

	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		// TODO Auto-generated method stub
		return ImplPrenotazioneDao.getInstance();
	}

	@Override
	public FilmDao getFilmDao() {
		// TODO Auto-generated method stub
		return ImplFilmDao.getInstance();
	}

	@Override
	public AttoreDao getAttoreDao() {
		// TODO Auto-generated method stub
		return ImplAttoreDao.getInstance();
	}

	@Override
	public CommentoDao getCommentoDao() {
		// TODO Auto-generated method stub
		return ImplCommentoDao.getInstance();
	}

}
