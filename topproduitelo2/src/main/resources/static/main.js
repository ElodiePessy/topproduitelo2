
/**
 * méthode qui charge la liste des produits dans un tableau 
 * et définit les events
 * @returns 
 */
$(document).ready(function() {
	var table = $('#tableProduits').DataTable({
		"sAjaxSource" : "/produit/all",
		"sAjaxDataProp" : "",
		"responsive" : true,
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "id"
		}, {
			"mData" : "nom"
		}, {
			"mData" : "marque"
		}, ]

	});

	$("#submit").click(function(event) {
		ajouterProduit();
	});

	table.on('click', 'tr', function() {
		var data = table.row(this).data();
		afficherNutriscore(data.nutriscore);
	});

});


/**
 * methode qui ajoute un produit saisi grace au formulaire 
 * dans la liste des produits 
 * @returns le produit dans la liste 
 */
function ajouterProduit(){

	$.post("/produit/ajout", {
		id : $("#inputId").val(),
		nom : $("#inputNom").val(),
		marque : $("#inputMarque").val(),
		nutriscore : $("#inputNutriscore").val()
	});

}


/**
 * methode qui affiche la card Nutri-score après un click 
 * sur un produit du tableau
 * @param data
 * @returns la card qui affiche le nutriscore du produit
 */
function afficherNutriscore(data) {

	document.querySelector(".card-body").innerHTML = "";
	document.querySelector(".card-body").classList.remove('d-none');

	if (data === "A") {
		remplirCardBody(
				"./nutri/a.png",
				"Nutri-score A", "C'est très bon");
	} else if (data === "B") {
		remplirCardBody(
				"./nutri/b.png",
				"Nutri-score B", "C'est très bon");
	} else if (data === "C") {
		remplirCardBody(
				"./nutri/c.png",
				"Nutri-score C", "C'est bon");
	} else if (data === "D") {
		remplirCardBody(
				"./nutri/d.png",
				"Nutri-score D",
				"A consommer en petite quantité ou peu fréquemment");
	} else if (data === "E") {
		remplirCardBody(
				"./nutri/e.png",
				"Nutri-score E",
				"A consommer en petite quantité ou peu fréquemment");
	} else if (data === '') {
		remplirCardBody("Rien", "Rien");
	} else {
		remplirCardBody("ca marche pas", "ca marche pas");
	}

}


/**
 * methode qui définit la structure et les elements de la card Nutri-Score 
 * @param urlImage
 * @param titre
 * @param descriptif
 * @returns
 */
function remplirCardBody(urlImage, titre, descriptif) {

	const imageNutri = document.createElement("img");
	imageNutri.src = urlImage;
	
	const titreNutri = document.createElement("h5");
	titreNutri.className = "card-title text-center";
	titreNutri.innerText = titre;

	const descriptifNutri = document.createElement("p");
	descriptifNutri.className = "card-text";
	descriptifNutri.innerText = descriptif;

	document.querySelector(".card-body").appendChild(imageNutri);
	document.querySelector(".card-body").appendChild(titreNutri);
	document.querySelector(".card-body").appendChild(descriptifNutri);

}
