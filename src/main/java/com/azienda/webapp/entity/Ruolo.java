package com.azienda.webapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Ruolo.findAll", query = "SELECT u from Ruolo u"),
				@NamedQuery(name = "Ruolo.findById", query = "SELECT u from Ruolo u WHERE u.id=:id")
				}
			)
public class Ruolo {
	@Id
	private int id;
	private String ruolo;
	@OneToMany(mappedBy = "ruolo")
	private List<Utente> utenti;
	
	public Ruolo() {}
	
	
	
	public Ruolo(int id, String ruolo) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		
	}



	public Ruolo(String ruolo, List<Utente> utenti) {
		super();
		this.ruolo = ruolo;
		this.utenti = utenti;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public List<Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
	

}
