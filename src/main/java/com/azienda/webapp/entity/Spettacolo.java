package com.azienda.webapp.entity ;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Spettacolo.findAll", query = "SELECT u from Spettacolo u"),
				@NamedQuery(name = "Spettacolo.findById", query = "SELECT u from Spettacolo u WHERE u.id=:id")
				}
			)
public class Spettacolo {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private Date data;
private Time ora;
private int postiDisponibili;
@ManyToOne
@JoinColumn(name="fk_sala")
private Sala sala;
@ManyToOne
@JoinColumn(name="fk_film")
private Film film;

@OneToMany(mappedBy = "spettacolo")
private List<Prenotazione>prenotazioni;





public Spettacolo(Date data, Time ora, int postiDisponibili, Sala sala, Film film) {
	super();
	this.data = data;
	this.ora = ora;
	this.postiDisponibili = postiDisponibili;
	this.sala = sala;
	this.film = film;
}
public Spettacolo(Date data, Time ora, Sala sala, Film film, List<Prenotazione> prenotazioni) {
	super();
	this.data = data;
	this.ora = ora;
	this.sala = sala;
	this.film = film;
	this.prenotazioni = prenotazioni;
}
public Spettacolo() {}
public Spettacolo(int id, Date data, Time ora, Sala sala, Film film) {
	super();
	this.id = id;
	this.data = data;
	this.ora = ora;
	this.sala = sala;
	this.film = film;
}
public Spettacolo(Date data, Time ora, Sala sala, Film film) {
	super();
	this.data = data;
	this.ora = ora;
	this.sala = sala;
	this.film = film;
}



public int getPostiDisponibili() {
	return postiDisponibili;
}
public void setPostiDisponibili(int postiDisponibili) {
	this.postiDisponibili = postiDisponibili;
}
public List<Prenotazione> getPrenotazioni() {
	return prenotazioni;
}
public void setPrenotazioni(List<Prenotazione> prenotazioni) {
	this.prenotazioni = prenotazioni;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public Time getOra() {
	return ora;
}
public void setOra(Time ora) {
	this.ora = ora;
}
public Sala getSala() {
	return sala;
}
public void setSala(Sala sala) {
	this.sala = sala;
}
public Film getFilm() {
	return film;
}
public void setFilm(Film film) {
	this.film = film;
}
@Override
public String toString() {
	return "Spettacolo [id=" + id + ", data=" + data + ", ora=" + ora + "]";
}
@Override
public int hashCode() {
	return Objects.hash(data, id, ora);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Spettacolo other = (Spettacolo) obj;
	return Objects.equals(data, other.data) && id == other.id && Objects.equals(ora, other.ora);
}




}
