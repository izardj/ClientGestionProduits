package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import session.ProduitRemote;

/**
 * Servlet implementation class ModifierProduit
 */
@WebServlet("/ModifierProduit")
public class ModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitRemote produitEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		int idProduit = Integer.parseInt(request.getParameter("id"));
		
		// 2- traitements avec la couche service
		Produit p = produitEJB.getProduit(idProduit);
		// 3- préparation envoi
		request.setAttribute("produit", p);
		// 4- envoi
		request.getRequestDispatcher("/modifierProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1- récupérer les paramètres
		int idProduit = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		double prix = Double.parseDouble(request.getParameter("prix"));
		
		// 2- traitements avec la couche service
		Produit p = new Produit();
		p.setId(idProduit);
		p.setNom(nom);
		p.setPrix(prix);
		p.setQuantite(quantite);
		produitEJB.modifierProduit(p);
		// 3- préparation envoi
		// 4- envoi
		request.getRequestDispatcher("ListerProduits").forward(request, response);
	}

}
