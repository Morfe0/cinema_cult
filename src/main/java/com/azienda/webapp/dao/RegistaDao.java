package com.azienda.webapp.dao;

import com.azienda.webapp.entity.Regista;

public interface RegistaDao {

	void save(Regista regista);

	Regista findByNomeCognome(String nome, String cognome);

}
