package net.site.model;

public class LouerModel {
	
	private int idLouer;
	private int id_locataire;
	private int id_voiture;
	private int nbJour;
	private String date;
	private String nom_locataire;
	private String num_voiture;
	private int loyer;
	private int montant;
	private int id_visiteur;
	
	public int getId_voiture() {
		return id_voiture;
	}
	public void setId_voiture(int id_voiture) {
		this.id_voiture = id_voiture;
	}
	public String getNum_voiture() {
		return num_voiture;
	}
	public void setNum_voiture(String num_voiture) {
		this.num_voiture = num_voiture;
	}
	public int getId_visiteur() {
		return id_visiteur;
	}
	public void setId_visiteur(int id_visiteur) {
		this.id_visiteur = id_visiteur;
	}
	public int getLoyer() {
		return loyer;
	}
	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getIdLouer() {
		return idLouer;
	}
	public void setIdLouer(int idLouer) {
		this.idLouer = idLouer;
	}
	public int getId_locataire() {
		return id_locataire;
	}
	public void setId_locataire(int id_locataire) {
		this.id_locataire = id_locataire;
	}
	public int getNbJour() {
		return nbJour;
	}
	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNom_locataire() {
		return nom_locataire;
	}
	public void setNom_locataire(String nom_locataire) {
		this.nom_locataire = nom_locataire;
	}
	
}
