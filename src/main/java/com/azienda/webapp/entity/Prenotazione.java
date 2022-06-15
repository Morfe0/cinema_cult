package com.azienda.webapp.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Prenotazione.findAll", query = "SELECT u from Prenotazione u"),
				@NamedQuery(name = "Prenotazione.findById", query = "SELECT u from Prenotazione u WHERE u.id=:id")
				}
			)
public class Prenotazione {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
@ManyToOne
@JoinColumn(name="fk_Utente")
private Utente utente;
@ManyToOne
@JoinColumn(name="fk_Spettacolo")
private Spettacolo spettacolo;
private Date dataPrenotazione;
private int postiPrenotati;

public Prenotazione() {}



public Prenotazione(Utente utente, Spettacolo spettacolo, Date dataPrenotazione, int postiPrenotati) {
	super();
	this.utente = utente;
	this.spettacolo = spettacolo;
	this.dataPrenotazione = dataPrenotazione;
	this.postiPrenotati = postiPrenotati;
}



public Prenotazione(Utente utente, Spettacolo spettacolo, Date dataPrenotazione) {
	super();
	this.utente = utente;
	this.spettacolo = spettacolo;
	this.dataPrenotazione = dataPrenotazione;
}

public Prenotazione(int id, Utente utente, Spettacolo spettacolo, Date dataPrenotazione) {
	super();
	this.id = id;
	this.utente = utente;
	this.spettacolo = spettacolo;
	this.dataPrenotazione = dataPrenotazione;
}




public Prenotazione(int id, Utente utente, Spettacolo spettacolo, Date dataPrenotazione, int postiPrenotati) {
	super();
	this.id = id;
	this.utente = utente;
	this.spettacolo = spettacolo;
	this.dataPrenotazione = dataPrenotazione;
	this.postiPrenotati = postiPrenotati;
}



public int getPostiPrenotati() {
	return postiPrenotati;
}



public void setPostiPrenotati(int postiPrenotati) {
	this.postiPrenotati = postiPrenotati;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Utente getUtente() {
	return utente;
}
public void setUtente(Utente utente) {
	this.utente = utente;
}
public Spettacolo getSpettacolo() {
	return spettacolo;
}
public void setSpettacolo(Spettacolo spettacolo) {
	this.spettacolo = spettacolo;
}
public Date getDataPrenotazione() {
	return dataPrenotazione;
}
public void setDataPrenotazione(Date dataPrenotazione) {
	this.dataPrenotazione = dataPrenotazione;
}

@Override
public String toString() {
	return "Prenotazione [id=" + id + ", utente=" + utente + ", dataPrenotazione=" + dataPrenotazione + "]";
}

@Override
public int hashCode() {
	return Objects.hash(dataPrenotazione, id, utente);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Prenotazione other = (Prenotazione) obj;
	return Objects.equals(dataPrenotazione, other.dataPrenotazione) && id == other.id
			&& Objects.equals(utente, other.utente);
}

}
