package com.japhibernatespringdata.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {

	// attention pour la clé primaire il faut que le type soit un Objet (Long) et
	// non un type primitif (long)
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 70) // defaut varch=255
	private String designation;

	private double prix;
	private int quantite;

	@ManyToOne // un produit appartient à une categorie
	@JoinColumn(name = "foreign_key_id_categorie") // foreign_key_id_categorie = creer une column clé étrangere
	private Categorie categ;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCateg() {
		return categ;
	}

	public void setCateg(Categorie categ) {
		this.categ = categ;
	}

	public Produit(String designation, double prix, int quantite, Categorie categ) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.categ = categ;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
