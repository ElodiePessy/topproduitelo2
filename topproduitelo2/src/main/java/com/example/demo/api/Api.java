package com.example.demo.api;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.demo.model.Produit;


public class Api {
	
	/**
	 * Obtenir la liste des produits le plus populaires depuis L'API
	 * @return Une ArrayList d'objets Produit
	 */
	public static List<Produit> obtenirListeTopProduits() {

		JSONArray produitsJsonArray = null;

		try {
			URL url = new URL(
					"https://fr.openfoodfacts.org/cgi/search.pl?search_simple=1&action=process&json=1&page_size=1000&sort_by=unique_scans_n");
			String produitsString = IOUtils.toString(url, StandardCharsets.UTF_8);
			produitsJsonArray = new JSONObject(produitsString).getJSONArray("products");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible d'obtenir la liste de produits depuis l'API.");
		}

		
		
		return extraireListeProduits(produitsJsonArray, new ArrayList<Produit>());

	}
	
	
	/**
	 * Convertir un JSONObject en un objet produit
	 * @param produitJsonObject Le JSONObject � convertir
	 * @return Un Objet Produit
	 */
	public static Produit extraireProduit(JSONObject produitJsonObject) {
		
		Produit produit = null;

		long id = produitJsonObject.getLong("_id");
		
		String nom = "";
		if(produitJsonObject.has("product_name_fr")) {
			nom = produitJsonObject.getString("product_name_fr").trim().toLowerCase();
		}
		
		String marque = "";
		if(produitJsonObject.has("brands")) {
			marque = produitJsonObject.getString("brands");
		}

		Character nutriscore = null;
		if (produitJsonObject.has("nutriscore_grade")) {
			nutriscore = produitJsonObject.getString("nutriscore_grade").toUpperCase().charAt(0);
		}

		if (!nom.isEmpty() && nutriscore != null && !marque.isEmpty()) {
			produit = new Produit(id, nom, marque, nutriscore);
		}
		return produit;

	}
	
	/**
	 * Convertir un JSONArray en une liste de produits
	 * @param produitsJsonArray Le JSONArray à convertir
	 * @param produitsDejaPresent La liste des produits déjà présent dans la base de donnée
	 * @return Une ArrayList d' objets Produit
	 */
	public static List<Produit> extraireListeProduits(JSONArray produitsJsonArray, List<Produit> produitsDejaPresent) {
		
		 List<Produit> produits = new ArrayList<>(); 
		
		for (Object produitObject : produitsJsonArray) {
			JSONObject produitJsonObject = (JSONObject) produitObject;

			Produit produit = extraireProduit(produitJsonObject);

			if (!produits.contains(produit) && produit != null && !produitsDejaPresent.contains(produit)) {
					produits.add(produit);				
			}
		}
		
		return produits;
	}
	
	
}
