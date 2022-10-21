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
import net.site.dao.LocataireDAO;
import net.site.model.LocataireModel;

/**
 * Servlet implementation class LocataireServlet
 */
@WebServlet("/LocataireServlet")
public class LocataireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Instanciation du DAO
	private LocataireDAO locataireDao;

    public LocataireServlet() {
        super();
        
        locataireDao= new LocataireDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		if(action == "/editerLocataire") {
			toUpdateLocataire(request, response);
		}
		else if(action == "/modifLocataire") {
			updateLocataire(request, response);
		}
		else if(action == "/supprLocataire") {
			deleteLocataire(request, response);
		}
		else if(action == "/ajouterLocataire") {
			addLocataire(request, response);
		}
		else if(action == "/listerLocataire") {
			listAllLocataires(request, response);
		}
		else if(action == "/listerLocataireRechercher") {
			rechercheLocataire(request, response);
		}
		else {
			listAllLocataires(request, response);
		}
		
	}
	
	private void listAllLocataires(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LocataireModel> locataires = locataireDao.getAllLocataireList();
		
		request.setAttribute("allLocataires", locataires);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/locataires.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void deleteLocataire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idLocataire"));
		
		locataireDao.deleteLocataire(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLocataire");
		
		dispatcher.forward(request, response);
		
	}
	
	private void toUpdateLocataire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idLocataire"));
		
		LocataireModel locataire = locataireDao.selectLocataireById(id);
		
		request.setAttribute("idLocataire", id);
		request.setAttribute("nom", locataire.getNom());
		request.setAttribute("adress", locataire.getAdress());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/modifLocataire.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void updateLocataire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idLocataire"));
		String nom = (String) request.getParameter("nom");
		String adress = (String) request.getParameter("adress");
		
		LocataireModel locataire = new LocataireModel();
		
		locataire.setNom(nom);
		locataire.setAdress(adress);
		
		locataireDao.updateLocataire(id, locataire);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLocataire");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addLocataire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = (String) request.getParameter("nom");
		String adress = (String) request.getParameter("adress");
		
		LocataireModel locataire = new LocataireModel();
		
		locataire.setNom(nom);
		locataire.setAdress(adress);
		
		locataireDao.addLocataire(locataire);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLocataire");
		
		dispatcher.forward(request, response);
		
	}

	private void rechercheLocataire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String val = request.getParameter("valeur");
		
		List<LocataireModel> listLocataireRecherche = locataireDao.findLocataire(val);

		if (listLocataireRecherche.size() <= 0) {
			String message = "La liste est vide ! ";
			request.setAttribute("message", message);
		}
		
		request.setAttribute("allLocataires", listLocataireRecherche);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/locataires.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
}
