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
import net.site.dao.LouerDAO;
import net.site.model.LouerModel;


@WebServlet("/LouerServlet")
public class LouerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LouerDAO louerDao;

    public LouerServlet() {
    	super();
    	louerDao = new LouerDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		System.out.println(action);
		
		if(action == "/editerLouer") {
			toUpdateLouer(request, response);
		}
		else if(action == "/modifLouer") {
			updateLouer(request, response);
		}
		else if(action == "/supprLouer") {
			deleteLouer(request, response);
		}
		else if(action == "/ajouterLouer") {
			addLouer(request, response);
		}
		else if(action == "/listerLouer") {
			listAllLouers(request, response);
		}
		else if(action == "/listerLouerRechercher") {
			rechercheLouer(request, response);
		}
		else if(action == "/listerLouerRechercherEntreDeuxDates") {
			rechercheLouerEntreDeuxDates(request, response);
		}
		else {
			listAllLouers(request, response);
		}
		

	}

	private void listAllLouers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LouerModel> louers = louerDao.getAllLouerList();
		List<LouerModel> e = louerDao.listSite();
		List<LouerModel> m = louerDao.listVisiteur();
		
		request.setAttribute("allLouers", louers);
		request.setAttribute("listS", e);
		request.setAttribute("listV", m);
		
		request.setAttribute("allLouers", louers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/louer.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void deleteLouer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idLouer"));
		
		louerDao.deleteLouer(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLouer");
		
		dispatcher.forward(request, response);
		
	}
	
	private void toUpdateLouer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idLouer"));
		
		LouerModel louer = louerDao.selectLouerById(id);
		
		request.setAttribute("idLouer", id);
		request.setAttribute("nbJour", louer.getNbJour());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/modifLouer.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void updateLouer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idLouer"));
		int nbJour = Integer.parseInt(request.getParameter("nbJour"));
		
		
		LouerModel louer = new LouerModel();
		
		louer.setNbJour(nbJour);
		
		louerDao.updateLouer(id, louer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLouer");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addLouer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_locataire = Integer.parseInt(request.getParameter("id_locataire"));
		int id_visiteur = Integer.parseInt(request.getParameter("id_visiteur"));
		int nbJour = Integer.parseInt(request.getParameter("nbJour"));
		String date = (String) request.getParameter("date");
		
		LouerModel louer = new LouerModel();

		louer.setId_locataire(id_locataire);
		louer.setId_visiteur(id_visiteur);
		louer.setNbJour(nbJour);
		louer.setDate(date);
		
		louerDao.addLouer(louer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listerLouer");
		
		dispatcher.forward(request, response);
		
	}

	private void rechercheLouer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String val = request.getParameter("valeur");
		
		List<LouerModel> listLouerRecherche = louerDao.findLouer(val);

		if (listLouerRecherche.size() <= 0) {
			String message = "La liste est vide ! ";
			request.setAttribute("message", message);
		}
		
		request.setAttribute("allLouers", listLouerRecherche);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/louer.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void rechercheLouerEntreDeuxDates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		
		List<LouerModel> listLouerRechercheEntreDeuxDates = louerDao.findLouerEntreDeuxDates(date1, date2);
		
		if (listLouerRechercheEntreDeuxDates.size() <= 0) {
			String message = "La liste est vide ! ";
			request.setAttribute("message", message);
		}

		request.setAttribute("allLouers", listLouerRechercheEntreDeuxDates);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/louer.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
