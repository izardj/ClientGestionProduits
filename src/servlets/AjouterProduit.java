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
 * Servlet implementation class AjouterProduit
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ProduitRemote produitEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		double prix = Double.parseDouble(request.getParameter("prix"));
		
		// 2- traitements avec la couche service
		Produit p = new Produit();
		p.setNom(nom);
		p.setQuantite(quantite);
		p.setPrix(prix);
		
		produitEJB.ajouterProduit(p);

		// 3- préparation envoi

		// 4- envoi
		request.getRequestDispatcher("ListerProduits").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
