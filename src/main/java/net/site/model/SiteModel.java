package net.site.model;

public class SiteModel {

	private int id;
	private String nom;
	private String lieu;
	private long loyer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public long getLoyer() {
		return loyer;
	}
	public void setLoyer(long loyer) {
		this.loyer = loyer;
	}
	
}
