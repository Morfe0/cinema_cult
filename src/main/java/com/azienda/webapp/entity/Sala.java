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
				@NamedQuery(name = "Sala.findAll", query = "SELECT u from Sala u"),
				@NamedQuery(name = "Sala.findById", query = "SELECT u from Sala u WHERE u.id=:id")
				}
			)
public class Sala {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private int posti;
@OneToMany(mappedBy = "sala")
private List<Spettacolo> spettacoli;
private String nome;


public Sala() {}
public Sala(int posti, List<Spettacolo> spettacoli, String nome) {
	super();
	this.posti = posti;
	this.spettacoli = spettacoli;
	this.nome = nome;
}
public Sala(int id, int posti, List<Spettacolo> spettacoli, String nome) {
	super();
	this.id = id;
	this.posti = posti;
	this.spettacoli = spettacoli;
	this.nome = nome;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPosti() {
	return posti;
}
public void setPosti(int posti) {
	this.posti = posti;
}
public List<Spettacolo> getSpettacoli() {
	return spettacoli;
}
public void setSpettacoli(List<Spettacolo> spettacoli) {
	this.spettacoli = spettacoli;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
@Override
public String toString() {
	return "Sala [id=" + id + ", posti=" + posti + ", spettacoli=" + spettacoli + ", nome=" + nome + "]";
}
@Override
public int hashCode() {
	return Objects.hash(id, nome, posti, spettacoli);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Sala other = (Sala) obj;
	return id == other.id && Objects.equals(nome, other.nome) && posti == other.posti
			&& Objects.equals(spettacoli, other.spettacoli);
}


}
