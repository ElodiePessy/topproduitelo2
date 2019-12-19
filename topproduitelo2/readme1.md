# TOP PRODUITS
-----
### DESCRIPTIF

L'objectif principal du site est de permettre de consulter le nutriscore d'un produit parmi le TOP des produits préférés des français afin de mieux contrôler son alimentation. L'utilisateur pourra également ajouter un des ses produits préférés.

## DIAGRAMME DE L'APPLICATION
---
---

![application](application.png)


## ENDPOINTS
---
---

* ````/nom```` -- affiche le nom du site

Exemple de requete
````java
http://localhost:8080/produit/nom
````
Réponse
````java
Top Produit
````

---


* ````/all```` -- GET obtenir la liste des produits

Exemple de requete

````java
http://localhost:8080/produit/all
````


Réponse

````Json

  {
    "id": 3274080005003,
    "nom": "eau de source",
    "marque": "Cristaline",
    "nutriscore": "A"
  },
  {
    "id": 7622210449283,
    "nom": "prince: goût chocolat au blé complet",
    "marque": "LU,Mondelez",
    "nutriscore": "D"
  },
  {
    "id": 5449000000996,
    "nom": "coca-cola",
    "marque": "Coca-Cola",
    "nutriscore": "E"
  },
  {
    "id": 3017620422003,
    "nom": "nutella",
    "marque": "Ferrero,nutella",
    "nutriscore": "E"
  },
  ...
````

---

* ````/get```` -- GET obtenir un produit grâce à son id

Exemple de requete

````java
http://localhost:8080/produit/get?id=10576403
````

Réponse

````json
// 20191218161400
// http://localhost:8080/produit/get?id=10576403

{
  "id": 10576403,
  "nom": "volic citron",
  "marque": "Volvic",
  "nutriscore": "C"
}
````
---

* ````/post````-- POST ajoute un produit dans la liste 

Exemple de requete
````java
http://localhost:8080/produit/ajout?id=1&nom=bonbon&marque=Haribo&nutriscore=E
````
Réponse
````json

// 20191218163211
// http://localhost:8080/produit/ajout?id=1&nom=bonbon&marque=Haribo&nutriscore=E

{
  "id": 1,
  "nom": "bonbon",
  "marque": "Haribo",
  "nutriscore": "E"
}
````

## APERCU DE L'APPLICATION
---
---

![apercu](apercu1.png)

![apercu](apercu2.png)
