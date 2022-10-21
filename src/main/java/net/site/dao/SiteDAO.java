package net.site.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.site.model.SiteModel;
import net.site.services.MysqlConnection;

public class SiteDAO {
	//lister tout les voitures
	public List<SiteModel> getAllSitesList(){
		
		String query = "SELECT * FROM site";
		
		List<SiteModel> listSites = new ArrayList<SiteModel>();
		
		SiteModel site = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				site = new SiteModel();
				
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setLieu(rs.getString("lieu"));
				site.setLoyer(rs.getInt("loyer"));
				
				listSites.add(site);
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return listSites;
		
	}
	
	
	//SELECT BY ID
	public SiteModel selectVoitureById(int id) {
		
		String query = "SELECT * FROM site WHERE id = ?";
		
		SiteModel site = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				site = new SiteModel();
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setLieu(rs.getString("lieu"));
				site.setLoyer(rs.getInt("loyer"));
			}
			
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return site;
		
	}
	
	//DELETE 
	public void deleteSite(int id) {
		
		String query = "DELETE FROM site WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	
	//UPDATE
	public void updateSite(int id, SiteModel site) {
		
		String query = "UPDATE site SET nom = ?, lieu = ?, loyer = ? WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, site.getNom());
			ps.setString(2, site.getLieu());
			ps.setLong(3, site.getLoyer());
			ps.setInt(4, id);

			System.out.println(site.getNom() + site.getLieu() + site.getLoyer());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//ADD 
	public void addSite(SiteModel voiture) {
		
		String query = "INSERT INTO site (id, nom, lieu, loyer) VALUES(NULL, ?, ?, ?)";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, voiture.getNom());
			ps.setString(2, voiture.getLieu());
			ps.setLong(3, voiture.getLoyer());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//SEARCH
	public List<SiteModel> find(String valeur) {
		String query = "SELECT * FROM site WHERE nom LIKE '%"+valeur+"%'";
		SiteModel site = null;
		List<SiteModel> listSite = new ArrayList<SiteModel>();
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				site = new SiteModel();
				
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setLieu(rs.getString("lieu"));
				site.setLoyer(rs.getInt("loyer"));
				
				listSite.add(site);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listSite;
	}
	

}
