package net.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.site.model.LocataireModel;
import net.site.services.MysqlConnection;

public class LocataireDAO {
	
	//lister les locataires
	public List<LocataireModel> getAllLocataireList(){
		
		String query = "SELECT * FROM visiteur ORDER BY id DESC";
		
		List<LocataireModel> listLocataire = new ArrayList<LocataireModel>();
		
		LocataireModel locataire = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				locataire = new LocataireModel();
				
				locataire.setIdLocataire(rs.getInt("id"));
				locataire.setNom(rs.getString("nom"));
				locataire.setAdress(rs.getString("adress"));
				
				listLocataire.add(locataire);
				
			}

			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listLocataire;
		
	}
	

	//SELECT BY ID
	public LocataireModel selectLocataireById(int id) {
		
		String query = "SELECT * FROM visiteur WHERE id = ?";
		
		LocataireModel locataire = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				locataire = new LocataireModel();
				
				locataire.setIdLocataire(rs.getInt("id"));
				locataire.setNom(rs.getString("nom"));
				locataire.setAdress(rs.getString("adress"));

			}
			
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return locataire;
		
	}
	
	//DELETE 
	public void deleteLocataire (int id) {
		
		String query = "DELETE FROM visiteur WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//UPDATE
	public void updateLocataire (int id, LocataireModel locataire) {
		
		String query = "UPDATE visiteur SET nom=?, Adress=? WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, locataire.getNom());
			ps.setString(2, locataire.getAdress());
			ps.setInt(3, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//ADD
	public void addLocataire (LocataireModel locataire) {
		
		String query = "INSERT INTO visiteur (id,nom,adress) VALUES(NULL,?,?)";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, locataire.getNom());
			ps.setString(2, locataire.getAdress());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//SEARCH
	public List<LocataireModel> findLocataire (String valeur) {
		
		String query = "SELECT * FROM visiteur WHERE nom LIKE '%"+valeur+"%' ORDER BY id DESC";
		
		LocataireModel locataire = null;
		List<LocataireModel> listLocataires = new ArrayList<LocataireModel>();
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				locataire = new LocataireModel();
				
				locataire.setIdLocataire(rs.getInt("id"));
				locataire.setNom(rs.getString("nom"));
				locataire.setAdress(rs.getString("adress"));

				listLocataires.add(locataire);
				System.out.println(listLocataires);
			}

			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listLocataires;
		
	}
	
}
