package com.azienda.webapp.dao;

import java.util.List;

import com.azienda.webapp.entity.Prenotazione;

public interface PrenotazioneDao {

	boolean save(Prenotazione prenotazione);

	List<Prenotazione> findAll();

	Prenotazione findPrenotazioneById(int id);

	boolean update(Prenotazione prenotazione);

	boolean remove(Prenotazione prenotazione);

}
