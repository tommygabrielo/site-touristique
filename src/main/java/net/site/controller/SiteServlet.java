package net.site.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.rmi.ServerException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.site.dao.SiteDAO;
import net.site.model.SiteModel;


public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SiteDAO siteDao;
  
    public SiteServlet() {
        super();
        
        siteDao = new SiteDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
		if(action == "/editerSite") {
			toUpdateSite(request, response);
		}
		else if(action == "/modifSite") {
			updateSite(request, response);
		}
		else if(action == "/supprSite") {
			deleteSite(request, response);
		}
		else if(action == "/ajouterSite") {
			addSite(request, response);
		}
		else if(action == "/listerSite") {
			listAllSite(request, response);
		}
		else if(action == "/listerRechercher") {
			rechercheSite(request, response);
		}
		else {
			listAllSite(request, response);
		}
	}

	private void listAllSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SiteModel> sites = siteDao.getAllSitesList();
		
		request.setAttribute("allSite", sites);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sites.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	

	private void deleteSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		siteDao.deleteSite(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerSite");
		
		dispatcher.forward(request, response);
		
	}
	
	private void toUpdateSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		SiteModel site = siteDao.selectVoitureById(id);
		
		
		request.setAttribute("id", id);
		request.setAttribute("nom", site.getNom());
		request.setAttribute("lieu", site.getLieu());
		request.setAttribute("loyer", site.getLoyer());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/modifSite.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void updateSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = (String) request.getParameter("nom");
		String lieu = (String) request.getParameter("lieu");
		int loyer = Integer.parseInt(request.getParameter("loyer"));
		
		
		SiteModel site = new SiteModel();
		
		site.setNom(nom);
		site.setLieu(lieu);
		site.setLoyer(loyer);
		
		siteDao.updateSite(id, site);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerSite");
		dispatcher.forward(request, response);
		
	}
	
	private void addSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = (String) request.getParameter("nom");
		String lieu = (String) request.getParameter("lieu");
		int loyer = Integer.parseInt(request.getParameter("loyer"));
		
		SiteModel site = new SiteModel();
		
		site.setNom(nom);
		site.setLieu(lieu);
		site.setLoyer(loyer);
		
		siteDao.addSite(site);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerSite");
		dispatcher.forward(request, response);
	}
	
	private void rechercheSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String val = request.getParameter("valeur");
		
		List<SiteModel> listRecherche = siteDao.find(val);

		request.setAttribute("allSite", listRecherche);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sites.jsp");
		
		dispatcher.forward(request, response);
	}

}
