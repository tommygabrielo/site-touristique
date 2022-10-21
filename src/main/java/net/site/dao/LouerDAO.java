package net.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.site.model.LouerModel;
import net.site.services.MysqlConnection;

public class LouerDAO {

	//lister tout les louer
	public List<LouerModel> getAllLouerList() {
		
		String query = "SELECT visiter.id, visiteur.id, visiteur.nom, loyer, nbJour, "
				+ "(nbJour*loyer) as montant, "
				+ "DATE_FORMAT(date, '%d-%m-%Y') "
				+ "FROM site,visiter,visiteur "
				+ "WHERE visiter.idSite=site.id AND visiter.idCli=visiteur.id ";
		
		List<LouerModel> listLouer = new ArrayList<LouerModel>();
		
		LouerModel louer = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				louer = new LouerModel();
				
				louer.setIdLouer(rs.getInt("id"));
				louer.setId_locataire(rs.getInt("visiteur.id"));
				louer.setNom_locataire(rs.getString("visiteur.nom"));
				louer.setDate(rs.getString("DATE_FORMAT(date, '%d-%m-%Y')"));
				louer.setLoyer(rs.getInt("loyer"));
				louer.setNbJour(rs.getInt("nbJour"));
				louer.setMontant(rs.getInt("montant"));
				
				listLouer.add(louer);
			}

			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return listLouer;
		
	}


	//*************
	public List<LouerModel> listSite() {
		
		String queryE = "SELECT id,nom FROM site";
		
		List<LouerModel> listE = new ArrayList<LouerModel>();
		
		LouerModel e = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(queryE);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				e = new LouerModel();
				
				e.setId_locataire(rs.getInt("id"));
				e.setNom_locataire(rs.getString("nom"));
				
				listE.add(e);
			}

			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return listE;
		
	}

	//************
	public List<LouerModel> listVisiteur() {
		
		String queryE = "SELECT id,nom FROM visiteur";
		
		List<LouerModel> listE = new ArrayList<LouerModel>();
		
		LouerModel e = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(queryE);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				e = new LouerModel();
				
				e.setId_voiture(rs.getInt("id"));
				e.setNum_voiture(rs.getString("nom"));
				
				listE.add(e);
			}

			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return listE;
		
	}
	//SELECT BY ID
	public LouerModel selectLouerById (int id) {
		
		String query = "SELECT * FROM visiter WHERE id = ?";
		
		LouerModel louer = null;
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				louer = new LouerModel();
				
				louer.setIdLouer(rs.getInt("id"));
				louer.setId_locataire(rs.getInt("idSite"));
				louer.setId_visiteur(rs.getInt("idCli"));
				louer.setNbJour(rs.getInt("nbJour"));
				louer.setDate(rs.getString("date"));
				
			}
			
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return louer;
		
	}
	
	//DELETE 
	public void deleteLouer (int id) {
		
		String query = "DELETE FROM visiter WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	//UPDATE
	public void updateLouer (int id, LouerModel louer) {
		
		String query = "UPDATE visiter SET nbJour = ? WHERE id = ?";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, louer.getNbJour());
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	//ADD 
	public void addLouer (LouerModel louer) {
		
		String query = "INSERT INTO visiter "
				+ "(id, idSite, idCli, nbJour, date) "
				+ "VALUES(NULL, ?, ?, ?, ?)";
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, louer.getId_locataire());
			ps.setInt(2, louer.getId_visiteur());
			ps.setInt(3, louer.getNbJour());
			ps.setString(4, louer.getDate());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	//SEARCH
	public List<LouerModel> findLouer (String valeur) {
		
		String query = "SELECT visiter.id, visiteur.id, visiteur.nom, site.loyer, visiter.nbJour, "
			+ "(visiter.nbJour*site.loyer) as montant, "
			+ "DATE_FORMAT(date, '%d-%m-%Y') "
			+ "FROM site,visiter,visiteur "
			+ "WHERE visiter.idSite = site.id AND visiter.idCli=visiteur.id AND "
			+ "visiteur.nom LIKE '%"+valeur+"%' GROUP BY visiter.id  ORDER BY visiter.id DESC";
		
		
		LouerModel louer = null;
		List<LouerModel> listLouers = new ArrayList<LouerModel>();
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				louer = new LouerModel();

				louer.setIdLouer(rs.getInt("id"));
				louer.setId_locataire(rs.getInt("visiteur.id"));
				louer.setNom_locataire(rs.getString("visiteur.nom"));
				louer.setDate(rs.getString("DATE_FORMAT(date, '%d-%m-%Y')"));
				louer.setLoyer(rs.getInt("site.loyer"));
				louer.setNbJour(rs.getInt("nbJour"));
				louer.setMontant(rs.getInt("montant"));
				
				listLouers.add(louer);
			}

			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listLouers;
		
	}
	

	//SEARCH BETWEEN DATES
	public List<LouerModel> findLouerEntreDeuxDates (String dateUn, String dateDeux) {
	
		String query= " SELECT visiter.id, visiteur.id, visiteur.nom, site.loyer, visiter.nbJour,(visiter.nbJour*site.loyer) as montant,DATE_FORMAT(date, '%d-%m-%Y') FROM site,visiter,visiteur WHERE visiter.idSite = site.id AND visiter.idCli=visiteur.id AND date BETWEEN '"+dateUn+"' AND '"+dateDeux+"' "; 

		
		LouerModel louer = null;
		List<LouerModel> listLouers = new ArrayList<LouerModel>();
		
		try {
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				louer = new LouerModel();

				louer.setIdLouer(rs.getInt("id"));
				louer.setId_locataire(rs.getInt("visiteur.id"));
				louer.setNom_locataire(rs.getString("visiteur.nom"));
				louer.setDate(rs.getString("DATE_FORMAT(date, '%d-%m-%Y')"));
				louer.setLoyer(rs.getInt("site.loyer"));
				louer.setNbJour(rs.getInt("nbJour"));
				louer.setMontant(rs.getInt("montant"));
				
				listLouers.add(louer);
			}

			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listLouers;
		
	}

}
