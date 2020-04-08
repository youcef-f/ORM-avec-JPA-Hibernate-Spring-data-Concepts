package com.japhibernatespringdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.japhibernatespringdata.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {

	// Pas besoin de faire une implementation des methodes de base spring car elles sont faite par spring.
	
	// Ajouter nos propres interface qui sont specifiques n'existant parmis les methode bases dans spring/
	@Query("select p from Produit p where p.designation like :x")
	public List<Produit> findByDesignation(@Param("x")String mc);
	
}
