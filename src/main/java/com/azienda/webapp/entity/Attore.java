package com.azienda.webapp.entity;

import java.util.List;  

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		value = { 
		@NamedQuery(name = "Attore.findAll", query = "SELECT u from Attore u"),
		@NamedQuery(name = "Attore.findById", query = "SELECT u from Attore u WHERE u.id=:id")
		
		})
public class Attore {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
private String nome;
private String cognome;
@ManyToMany(mappedBy = "attori")
private List<Film> films;

public Attore() {}

public Attore(String nome, String cognome, List<Film> films) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.films = films;
}
public Attore(int id, String nome, String cognome, List<Film> films) {
	super();
	this.id = id;
	this.nome = nome;
	this.cognome = cognome;
	this.films = films;
}

public Attore(String nome, String cognome) {
	super();
	this.nome = nome;
	this.cognome = cognome;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public List<Film> getFilms() {
	return films;
}
public void setFilms(List<Film> films) {
	this.films = films;
}




}
