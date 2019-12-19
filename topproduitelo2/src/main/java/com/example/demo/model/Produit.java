package com.example.demo.model;

import java.io.Serializable;

/**
 * Classe qui represente un produit
 * 
 */
	public class Produit implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private long id;
		private String nom;
		private String marque;
		private char nutriscore;
		
		
		public Produit(){
			
		}
		
		public Produit(long id, String nom, String marque, char nutriscore) {
			
			this.id = id;
			this.nom = nom;
			this.marque = marque;
			this.nutriscore = nutriscore;
			
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getMarque() {
			return marque;
		}

		public void setMarque(String marque) {
			this.marque = marque;
		}

		public char getNutriscore() {
			return nutriscore;
		}

		public void setNutriscore(char nutriscore) {
			this.nutriscore = nutriscore;
		}
		
		@Override
		public String toString() {
			return "\n" + nom.toUpperCase() + "\n- id: " + id + "\n- marque: " + marque + "\n- nutriscore: " + nutriscore + "";
		}
		
		
	}






