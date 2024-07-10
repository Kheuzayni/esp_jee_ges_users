package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Produit;
import beans.Utilisateur;
import dao.ProduitDao;
import dao.UtilisateurDao;
import forms.AjoutProduit;
import forms.AjoutUtilisateurForm;
import forms.ModifierProduitForm;
import forms.ModifierUtilisateurForm;

/**
 * Servlet implementation class GestionProduit
 */
@WebServlet({"/produits/add","/produits/list","/produits/update","/produits/delete"})
public class GestionProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_PRODUIT="/WEB-INF/ajouterproduit.jsp";
	private static final String VUE_LIST_PRODUIT="/WEB-INF/listerproduit.jsp";
	private static final String VUE_UPDATE_PRODUIT="/WEB-INF/modifierproduit.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String path = request.getServletPath();

		switch (path)
		{
			case "/produits/add":
				getServletContext().getRequestDispatcher(VUE_AJOUT_PRODUIT)
						.forward(request, response);
				break;
			case "/produits/list":
				 Utilisateur utilisateursession=(Utilisateur) request.getSession().getAttribute("utilisateur");
			        ArrayList<Produit> produits=null;
			        if(utilisateursession.getPrivilege().equals("utilisateur")) {
			        	produits=ProduitDao.getProdForUserList(utilisateursession.getId());
			        }else {	
			        	produits=ProduitDao.getList();
			        }
				request.setAttribute("produits", produits);
				getServletContext().getRequestDispatcher(VUE_LIST_PRODUIT)
						.forward(request, response);
				break;
			case "/produits/delete":
				ProduitDao.supprimer(Integer.parseInt(request.getParameter("id")));
				request.getRequestDispatcher("/produits/list").forward(request, response);
				break;
			case "/produits/update":
				Produit produit=ProduitDao.getById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("produit", produit);
				getServletContext().getRequestDispatcher(VUE_UPDATE_PRODUIT)
				.forward(request, response);
				break;	
				
		
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getServletPath();

		switch (path)
		{
			case "/produits/add":
			AjoutProduit form = new AjoutProduit(request);
			form.ajouter();
			request.setAttribute("form", form);
			getServletContext().getRequestDispatcher(VUE_AJOUT_PRODUIT)
					.forward(request, response);
		break;
			case "/produits/update":
				System.out.println("akakka");
				ModifierProduitForm forme = new ModifierProduitForm(request);
				forme.modifier();
				request.setAttribute("forme", forme);
				getServletContext().getRequestDispatcher(VUE_UPDATE_PRODUIT)
						.forward(request, response);
				break;	
				
	}

}
}
