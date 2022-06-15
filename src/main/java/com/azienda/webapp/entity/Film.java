package com.azienda.webapp.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Film.findAll", query = "SELECT u from Film u"),
				@NamedQuery(name = "Film.findById", query = "SELECT u from Film u WHERE u.id=:id")
				}
			)
public class Film {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(unique=true)
private String titolo;
private int durata;
@Column(columnDefinition="text")
private String trama;
private String locandina;
private Double prezzo;
@ManyToMany
@JoinTable( name="attore_film",
			joinColumns =  @JoinColumn(name="fk_attore"),
			inverseJoinColumns = @JoinColumn(name="fk_film")
		)
private List<Attore> attori;
@ManyToOne
@JoinColumn(name="fk_regista")
private Regista regista;


@OneToMany(mappedBy = "film")
private List<Spettacolo>spettacoli;

@OneToMany(mappedBy="film")
private List<Commento>commenti;


public Film() {}









public List<Commento> getCommenti() {
	return commenti;
}









public void setCommenti(List<Commento> commenti) {
	this.commenti = commenti;
}









public Film(String titolo, int durata, String trama, String locandina, Double prezzo, List<Attore> attori,
		Regista regista, List<Spettacolo> spettacoli) {
	super();
	this.titolo = titolo;
	this.durata = durata;
	this.trama = trama;
	this.locandina = locandina;
	this.prezzo = prezzo;
	this.attori = attori;
	this.regista = regista;
	this.spettacoli = spettacoli;
}









public Film(String titolo, int durata, String trama, Double prezzo, List<Attore> attori, Regista regista) {
	super();
	this.titolo = titolo;
	this.durata = durata;
	this.trama = trama;
	this.prezzo = prezzo;
	this.attori = attori;
	this.regista = regista;
}









public Film(String titolo, int durata, String trama, String locandina, Double prezzo, List<Attore> attori,
		Regista regista) {
	super();
	this.titolo = titolo;
	this.durata = durata;
	this.trama = trama;
	this.locandina = locandina;
	this.prezzo = prezzo;
	this.attori = attori;
	this.regista = regista;
}









public Film(int id, String titolo, int durata, String trama, String locandina, Double prezzo, List<Attore> attori,
		Regista regista, List<Spettacolo> spettacoli) {
	super();
	this.id = id;
	this.titolo = titolo;
	this.durata = durata;
	this.trama = trama;
	this.locandina = locandina;
	this.prezzo = prezzo;
	this.attori = attori;
	this.regista = regista;
	this.spettacoli = spettacoli;
}









public List<Spettacolo> getSpettacoli() {
	return spettacoli;
}



public void setSpettacoli(List<Spettacolo> spettacoli) {
	this.spettacoli = spettacoli;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public int getDurata() {
	return durata;
}
public void setDurata(int durata) {
	this.durata = durata;
}
public String getTrama() {
	return trama;
}
public void setTrama(String trama) {
	this.trama = trama;
}
public String getLocandina() {
	return locandina;
}
public void setLocandina(String locandina) {
	this.locandina = locandina;
}
public Double getPrezzo() {
	return prezzo;
}
public void setPrezzo(Double prezzo) {
	this.prezzo = prezzo;
}
public List<Attore> getAttori() {
	return attori;
}
public void setAttori(List<Attore> attori) {
	this.attori = attori;
}
public Regista getRegista() {
	return regista;
}
public void setRegista(Regista regista) {
	this.regista = regista;
}


@Override
public int hashCode() {
	return Objects.hash(durata, id, locandina, prezzo, titolo, trama);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Film other = (Film) obj;
	return durata == other.durata && id == other.id && Objects.equals(locandina, other.locandina)
			&& Objects.equals(prezzo, other.prezzo) && Objects.equals(titolo, other.titolo)
			&& Objects.equals(trama, other.trama);
}


@Override
public String toString() {
	return "Film [id=" + id + ", titolo=" + titolo + ", durata=" + durata + ", trama=" + trama + ", locandina="
			+ locandina + ", prezzo=" + prezzo + "]";
}



}
