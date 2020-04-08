package com.japhibernatespringdata;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.japhibernatespringdata.dao.ICatagorieRepository;
import com.japhibernatespringdata.dao.IProduitRepository;
import com.japhibernatespringdata.entities.Categorie;
import com.japhibernatespringdata.entities.Produit;

@SpringBootApplication
public class OrmAvecJpaHibernateSpringDataConceptsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrmAvecJpaHibernateSpringDataConceptsApplication.class, args);

		// -------------------------------------------------------------------
		ICatagorieRepository categorieDao = ctx.getBean(ICatagorieRepository.class); // renvoi une instance de
																						// ICatagorieRepository
		Categorie categ1 = new Categorie("Ordinateur");
		Categorie categ2 = new Categorie("imprimante");
		Categorie categ3 = new Categorie("Scanner");

		categorieDao.save(categ1);
		categorieDao.save(categ2);
		categorieDao.save(categ3);

		// -------------------------------------------------------------------

		IProduitRepository produitDao = ctx.getBean(IProduitRepository.class); // renvoi une instance de
																				// IProduitRepository
		produitDao.save(new Produit("Ordinateur LX567", 7000, 7, categ1));
		produitDao.save(new Produit("Ordinateur HP pavillon 645", 5000, 8, categ1));
		produitDao.save(new Produit("Imprimante lastjet HP 785", 2000, 6, categ2));
		produitDao.save(new Produit("Imprimante lastjet HP 8794", 2000, 6, categ2));
		produitDao.save(new Produit("Scan canon DXdffd", 2000, 6, categ3));

		List<Produit> produits = produitDao.findAll();
		for (Produit p : produits) {
			System.out.println("Des:" + p.getDesignation() + " prix: " + p.getPrix() + " quantité: " + p.getQuantite()
					+ " categorie: " + p.getCateg().getNomCategorie());
		}

		List<Produit> produits1 = produitDao.findByDesignation("%H%");
		for (Produit p : produits1) {
			System.out.println("Des:" + p.getDesignation() + " prix: " + p.getPrix() + " quantité: " + p.getQuantite()
					+ " categorie: " + p.getCateg().getNomCategorie());
		}

	}

}
