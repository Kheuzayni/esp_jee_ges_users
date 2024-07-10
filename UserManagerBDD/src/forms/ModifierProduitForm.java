package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Produit;
import beans.Utilisateur;
import dao.ProduitDao;
import dao.UtilisateurDao;

public class ModifierProduitForm {
	private static final String	DESIGNATION			= "designation";
	private static final String	PRIX		        = "prix";
	private static final String	QUANTITE			= "quantite";
	
	private Produit			produit;
	private HttpServletRequest	request;
	private Map<String, String>	erreurs;
	private String				statusMessage;

	public ModifierProduitForm(HttpServletRequest request)
	{
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}

	public boolean modifier()
	{
		String designation = getParameter(DESIGNATION);
		int prix = Integer.parseInt(getParameter(PRIX));
		int quantite = Integer.parseInt(getParameter(QUANTITE));
		Utilisateur utilisateur=(Utilisateur) request.getSession().getAttribute("utilisateur");
		int id = Integer.parseInt(getParameter("id"));
		int idpro=utilisateur.getId();
		System.out.println(idpro);

		validerChamps(DESIGNATION,PRIX, QUANTITE);

		

		if (erreurs.isEmpty())
		{
			produit = new Produit( id,designation,prix, quantite,idpro);
			System.out.println("isEmpty");

			if (ProduitDao.modifier(produit))
			{   
				System.out.println("im modifier");
				produit = null;
				statusMessage = "Ajout effectué avec succès !";

				return true;
			}
			else
			{
				statusMessage = "Une erreur inattendue s'est produite !";

				return false;
			}
		}
		else
		{
			produit = new Produit(designation, prix, quantite,idpro);
			statusMessage = "Echec de l'ajout";

			return false;
		}
	}

	private String getParameter(String champ)
	{
		String valeur = request.getParameter(champ);

		if (valeur == null || valeur.trim().isEmpty())
		{
			return null;
		}
		else
		{
			return valeur.trim();
		}
	}

	private void validerChamps(String... champs)
	{
		for (String champ : champs)
		{
			if (getParameter(champ) == null)
			{
				erreurs.put(champ, "Vous devez renseigner ce champ");
			}
		}
	}

	

	public Produit getProduit()
	{
		return produit;
	}

	public Map<String, String> getErreurs()
	{
		return erreurs;
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}
}


