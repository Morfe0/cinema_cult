package com.azienda.webapp.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Regista.findAll", query = "SELECT u from Regista u"),
				@NamedQuery(name = "Regista.findById", query = "SELECT u from Regista u WHERE u.id=:id")
				}
			)

public class Regista {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
private String nome;
private String cognome;
@OneToMany(mappedBy = "regista")
private List<Film> films;


public Regista() {}
public Regista(String nome, String cognome, List<Film> films) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.films = films;
}
public Regista(int id, String nome, String cognome, List<Film> films) {
	super();
	this.id = id;
	this.nome = nome;
	this.cognome = cognome;
	this.films = films;
}


public Regista(String nome, String cognome) {
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
@Override
public String toString() {
	return "Regista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", films=" + films + "]";
}
@Override
public int hashCode() {
	return Objects.hash(cognome, films, id, nome);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Regista other = (Regista) obj;
	return Objects.equals(cognome, other.cognome) && Objects.equals(films, other.films) && id == other.id
			&& Objects.equals(nome, other.nome);
}


}
