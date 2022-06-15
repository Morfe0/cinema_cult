package com.azienda.webapp.entity;

import java.util.Objects;

import javax.persistence.Column;
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
				@NamedQuery(name = "Commento.findAll", query = "SELECT u from Commento u"),
				@NamedQuery(name = "Commento.findById", query = "SELECT u from Commento u WHERE u.id=:id")
				}
			)
public class Commento {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition="text")
	private String testo;
	
	@ManyToOne
	@JoinColumn(name="fk_utente")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="fk_film")
	private Film film;

	public Commento() {}

	public Commento(String testo, Utente utente, Film film) {
		super();
		this.testo = testo;
		this.utente = utente;
		this.film = film;
	}

	public Commento(String testo) {
		super();
		this.testo = testo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "Commento [id=" + id + ", testo=" + testo + ", utente=" + utente + ", film=" + film + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(film, id, testo, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commento other = (Commento) obj;
		return Objects.equals(film, other.film) && id == other.id && Objects.equals(testo, other.testo)
				&& Objects.equals(utente, other.utente);
	}
	
	
	
	
	

}
