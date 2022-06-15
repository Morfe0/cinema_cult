package com.azienda.webapp.dao;

public abstract class DaoFactory {
	public abstract UtenteDao getUtenteDao();
	public abstract SpettacoloDao getSpettacoloDao();
	public abstract SalaDao getSalaDao();
	public abstract RuoloDao getRuoloDao();
	public abstract RegistaDao getRegistaDao();
	public abstract PrenotazioneDao getPrenotazioneDao();
	public abstract FilmDao getFilmDao();
	public abstract AttoreDao getAttoreDao();
	public abstract CommentoDao getCommentoDao();
	
	public static DaoFactory  getFactory(String s) {
		
		switch(s) {
		//case"jdbc":
			//return new FactoryMysqlJDBC();
		case"jpa":
			return new FactoryJpa();
			default:
				return new FactoryJpa();
		}
	}

}
