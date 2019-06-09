package org.sid.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Cantactt implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue 
	private Long id ;
	private String nom ;
	private String prenom ;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance ;
	private long tel;
	
	
	public Cantactt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cantactt(String nom, String prenom, Date dateNaissance, Long tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}

}
