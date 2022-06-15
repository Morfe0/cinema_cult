package com.azienda.webapp.dao;

import java.util.List;

import com.azienda.webapp.entity.Ruolo;
import com.azienda.webapp.entity.Utente;

public interface UtenteDao {
	boolean findByEmailAndPassword(String email, String password);
	List<Utente> findAll();
	boolean save(Utente utente);
	Utente findRuoloByEmail(String Email);
	void updateRuoloUtente(Utente utente);
	Utente findUtenteById(int id);
	Utente findUtenteByEmail(String Email);
	void updateEmail(Utente email);
	void updatePassword(Utente utente);
	List<Utente> findUtenteByRuolo(Ruolo ruolo);
	boolean removeById(int id);
	boolean remove(Utente utente);
}
