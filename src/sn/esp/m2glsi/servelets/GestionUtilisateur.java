package sn.esp.m2glsi.servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.esp.m2glsi.beans.Utilisateurs;

/**
 * Servlet implementation class GestionUtilisateur
 */
@WebServlet({ "/users/add", "/users/list", "/users/delete","/users/update"})
public class GestionUtilisateur extends HttpServlet
{
	private static final long					serialVersionUID		= 1L;

	private static final String					VUE_AJOUT_UTILISATEUR	= "/WEB-INF/ajouterUtilisateur.jsp";
	private static final String					VUE_LISTE_UTILISATEUR	= "/WEB-INF/listerUtilisateur.jsp";
	private static final String					VUE_MODIF_UTILISATEUR	= "/WEB-INF/modifierUtilisateur.jsp";
	public static final ArrayList<Utilisateurs>	listeUtilisateurs		= new ArrayList<Utilisateurs>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String vue = null;
		System.out.println(request.getServletPath());


		String requestedUrl = request.getServletPath();

		if (requestedUrl.equals("/users/add"))
		{
			vue = VUE_AJOUT_UTILISATEUR;
		}
		else if (requestedUrl.equals("/users/delete"))
		{
			try
			{
				int id = Integer.parseInt(request.getParameter("id"));

				for (Utilisateurs utilisateur : listeUtilisateurs)
				{
					if (utilisateur.getId() == id)
					{
						listeUtilisateurs.remove(utilisateur);
						// break;
					}
				}
			}
			catch (Exception e)
			{
			}
			vue = VUE_LISTE_UTILISATEUR;
			request.setAttribute("utilisateurs", listeUtilisateurs);
		}
		else if (requestedUrl.equals("/users/update")) 
		{
			try
			{
				int id = Integer.parseInt(request.getParameter("id"));
				for (Utilisateurs utilisateur : listeUtilisateurs)
				{
					if (utilisateur.getId() == id)
					{
					request.setAttribute("user", utilisateur);
					}
				}
			}	
				catch (Exception e)
				{
				}
			vue= VUE_MODIF_UTILISATEUR;

		}else
		{
			request.setAttribute("utilisateurs", listeUtilisateurs);
			vue = VUE_LISTE_UTILISATEUR;

		}

		getServletContext().getRequestDispatcher(vue).forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
					
			String requestedUrl = request.getServletPath();

			if (requestedUrl.equals("/users/update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				for (Utilisateurs utilisateur : listeUtilisateurs)
				{
					if (utilisateur.getId() == id)
					{
						utilisateur.setLogin(login);
						utilisateur.setNom(nom);
						utilisateur.setPrenom(prenom);
						utilisateur.setPassword(password);
					}
				}
				
				response.sendRedirect("list");
				
			}else {
		

			Utilisateurs utilisateur = new Utilisateurs(nom, prenom, login, password);
			listeUtilisateurs.add(utilisateur);
			
			response.sendRedirect("add");
			}
		}

		
		

		
	}
