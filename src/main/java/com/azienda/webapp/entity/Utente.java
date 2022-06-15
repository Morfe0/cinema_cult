package com.azienda.webapp.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.Column;

@Entity
@NamedQueries(
		value = { 
				@NamedQuery(name = "Utente.findAll", query = "SELECT u from Utente u"),
				@NamedQuery(name = "Utente.findById", query = "SELECT u from Utente u WHERE u.id=:id")
				}
			)
public class Utente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	@Column(unique=true)
	private String email;
	private String password;
	private Date dataNascita;
	private String citta;
	private boolean abilitato;
	@ManyToOne
	@JoinColumn(name="fk_ruolo")
	private Ruolo ruolo;
	@OneToMany(mappedBy="utente")
	private List<Prenotazione> prenotazioni;
	
	@OneToMany(mappedBy="utente")
	private List<Commento>commenti;
	
	public Utente() {}
	
	
	
	public Utente(String nome, String cognome, String email, String password, Date dataNascita, String citta,
			boolean abilitato, Ruolo ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.dataNascita = dataNascita;
		this.citta = citta;
		this.abilitato = abilitato;
		this.ruolo = ruolo;
	}
	
	



	public Utente(String nome, String cognome, String email, String password, Date dataNascita, String citta,
			boolean abilitato, Ruolo ruolo, List<Prenotazione> prenotazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.dataNascita = dataNascita;
		this.citta = citta;
		this.abilitato = abilitato;
		this.ruolo = ruolo;
		this.prenotazioni = prenotazioni;
	}

	

	public boolean isAbilitato() {
		return abilitato;
	}



	public void setAbilitato(boolean abilitato) {
		this.abilitato = abilitato;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + ", dataNascita=" + dataNascita + ", citta=" + citta + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(citta, cognome, dataNascita, email, id, nome, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(citta, other.citta) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataNascita, other.dataNascita) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(nome, other.nome) && Objects.equals(password, other.password);
	}



	public List<Commento> getCommenti() {
		return commenti;
	}



	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}
	
	
	
	
	

}
