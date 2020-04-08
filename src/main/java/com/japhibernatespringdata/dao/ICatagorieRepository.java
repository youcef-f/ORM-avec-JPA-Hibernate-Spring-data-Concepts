package com.japhibernatespringdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.japhibernatespringdata.entities.Categorie;

public interface ICatagorieRepository extends JpaRepository<Categorie, Long> {

}
