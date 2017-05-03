package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import session.ProduitRemote;

/**
 * Servlet implementation class ListerProduits
 */
@WebServlet("/ListerProduits")
public class ListerProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProduitRemote produitEJB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerProduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		
		// 2- traitements avec la couche service
		List<Produit> produits = produitEJB.findAllProduits();

		// 3- préparation envoi
		request.setAttribute("produits", produits);
		// 4- envoi
		request.getRequestDispatcher("/listeProduits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
