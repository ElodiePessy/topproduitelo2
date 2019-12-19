package com.example.demo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.model.Produit;


@RestController
@RequestMapping("/produit")
public class Controller {


	private List<Produit> topProduit;
	
	public Controller() {
		topProduit = Api.obtenirListeTopProduits();
	}

	
	/**
	 * Methode qui renvoie la page d'accueil
	 * @return la page d'accueil
	 */
	@RequestMapping("/")
	public String affichePageAccueil() {
		return "static/index";
	}
	
	
	/**
	 * Méthode qui affiche le nom du site
	 * @return le nom du site
	 */
	@RequestMapping("/nom")
	@ResponseBody
	public String afficheNomDuProjet() {
		return "Top Produit";
	}
	
	
	/**
	 * méthode qui affiche la liste des produits
	 * @return la liste des produits
	 */
	@RequestMapping("/all")
	public List<Produit> obtenirListeProduit(){
		
		return topProduit;
	}
	
	
	/**
	 * méthode qui recherche un produit par son id 
	 * @param id
	 * @return le produit 
	 */
	@GetMapping("/get")
	public ResponseEntity<Produit> obtenirProduit(@RequestParam(value ="id")long id) {
		
		for (Produit produit : topProduit) {
			if(produit.getId()==id) {
				return ResponseEntity.ok(produit);
			}
		}
		return ResponseEntity.notFound().build(); 
	}

	
	/**
	 * methode qui permet d'ajouter un produit dans la liste
	 * @param id
	 * @param nom
	 * @param marque
	 * @param nutriscore
	 * @return le produit ajouté
	 */
	@RequestMapping("/ajout")
	public Produit ajoutProduit(@RequestParam(value="id") long id,
			@RequestParam(value = "nom") String nom,
			@RequestParam(value = "marque") String marque,
			@RequestParam(value = "nutriscore") char nutriscore) {
		
			Produit produit = new Produit(id, nom, marque, nutriscore) ;
			topProduit.add(produit);
			return produit;
		}

	
}
