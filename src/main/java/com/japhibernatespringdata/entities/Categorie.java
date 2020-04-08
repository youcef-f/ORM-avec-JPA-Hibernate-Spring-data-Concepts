package com.japhibernatespringdata.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String nomCategorie;

	// FetchType.LAZY ne remonte les informations que si c'est demandé
	// categorie contient plusieurs produits. mappedBy fait reference à l'attribut
	// categ dans la class Produit.
	@OneToMany(mappedBy = "categ", fetch = FetchType.LAZY)
	private Collection<Produit> produits;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

}
