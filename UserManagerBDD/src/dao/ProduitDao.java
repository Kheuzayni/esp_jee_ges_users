package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Produit;
import beans.Utilisateur;

public class ProduitDao {

	private static final ArrayList<Produit>	produits		= new ArrayList<Produit>();

	private static final String					SELECT_ALL_PROD_SQL	= "SELECT * FROM Produit";
	private static final String					INSERT_PROD_PSQL		= "INSERT INTO Produit VALUES(0, ?, ?, ?,?)";
	private static final String					DELETE_PROD_SQL		= "DELETE FROM Produit WHERE id=?";
	private static final String					MODIFIER_PROD_SQL		= "UPDATE Produit SET designation=?,prix=?,quantite=? WHERE id=?";
	private static final String					SELECT_ONE_PROD_BYID	= "SELECT * FROM Produit where id=?";
	private static final String					SELECT_ALL_PROD_ONE_USER_SQL	= "SELECT * FROM Produit where idpro=?";

	public static boolean ajouter(Produit produit)
	{
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try
		{
			statement = connection.prepareStatement(INSERT_PROD_PSQL);
			
			statement.setString(1, produit.getDesignation());
			statement.setInt(2, produit.getPrix());
			statement.setInt(3, produit.getQuantite());
			statement.setInt(4, produit.getIdpro());
			System.out.println(produit.getQuantite());
			System.out.println(produit.getIdpro());
			
			int status = statement.executeUpdate();

			if (status == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Erreur durant l'insertion du produit : "
					+ e.getMessage());
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return false;
	}

					
	

	public static boolean supprimer(int id)
	{
	
	Connection connection = ConnexionManager.getInstance();
	PreparedStatement statement = null;

	try {

	statement = connection.prepareStatement(DELETE_PROD_SQL);
	
	statement.setInt(1,id);

   int status = statement.executeUpdate();

	if (status == 1)
	{
		return true;
	}
	else
	{
		return false;
	}
}
catch (SQLException e)
{
	System.out.println("Erreur durant la delete de l'utilisateur : "
			+ e.getMessage());
}
finally
{
	try
	{
		if (statement != null)
		{
			statement.close();
		}
	}
	catch (SQLException e)
	{
	}

	try
	{
		if (connection != null)
		{
			connection.close();
		}
	}
	catch (SQLException e)
	{
	}
}

return false;
}

	
	public static boolean modifier(Produit produit)
	{
		Connection connection = ConnexionManager.getInstance();
		PreparedStatement statement = null;

		try
		{
			statement = connection.prepareStatement(MODIFIER_PROD_SQL);
			
			statement.setString(1, produit.getDesignation());
			statement.setInt(2, produit.getPrix());
			statement.setInt(3, produit.getQuantite());
			statement.setInt(4, produit.getId());
			System.out.println(produit.getId());
			
			int status = statement.executeUpdate();

			if (status == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Erreur durant l'insertion du produit : "
					+ e.getMessage());
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return false;
	}

	

	public static ArrayList<Produit> getProdForUserList(int id)
	{
		Connection connection = ConnexionManager.getInstance();

		PreparedStatement statement = null;
		ResultSet reponse = null;

		ArrayList<Produit> produits = new ArrayList<Produit>();

		try
		{
			
			statement = connection.prepareStatement(SELECT_ALL_PROD_ONE_USER_SQL);
			statement.setInt(1, id);
			reponse = statement.executeQuery();

			int prix,quantite,idpro;
			String designation;
			

			while (reponse.next())
			{
				id = reponse.getInt("id");
				designation = reponse.getString("designation");
				prix = reponse.getInt("prix");
				quantite = reponse.getInt("quantite");
				idpro = reponse.getInt("idpro");
				

				produits
				.add(new Produit(id, designation, prix, quantite,idpro));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reponse != null)
				{
					reponse.close();
				}
			}
			catch (SQLException e)
			{
			}
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return produits;
	}
	public static ArrayList<Produit> getList()
	{
		Connection connection = ConnexionManager.getInstance();

		Statement statement = null;
		ResultSet reponse = null;

		ArrayList<Produit> produits = new ArrayList<Produit>();

		try
		{
			statement = connection.createStatement();
			reponse = statement.executeQuery(SELECT_ALL_PROD_SQL);

			int id,prix,quantite,idpro;
			String designation;
			

			while (reponse.next())
			{
				id = reponse.getInt("id");
				designation = reponse.getString("designation");
				prix = reponse.getInt("prix");
				quantite = reponse.getInt("quantite");
				idpro = reponse.getInt("idpro");
				

				produits
				.add(new Produit(id, designation, prix, quantite,idpro));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reponse != null)
				{
					reponse.close();
				}
			}
			catch (SQLException e)
			{
			}
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return produits;
	}

	public static Produit getById(int id)
	{
		Connection connection = ConnexionManager.getInstance();

		PreparedStatement statement = null;
		ResultSet reponse = null;
		Produit produit=null;


		try
		{
			statement = connection.prepareStatement(SELECT_ONE_PROD_BYID);
			statement.setInt(1, id);
			reponse = statement.executeQuery();

			
			String designation;
			int prix;
			int quantite,idpro;

			while (reponse.next())
			{
				id = reponse.getInt("id");
				designation = reponse.getString("designation");
				prix = reponse.getInt("prix");
				quantite = reponse.getInt("quantite");
				idpro = reponse.getInt("idpro");

				produit =new Produit(id, designation, prix, quantite,idpro);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (reponse != null)
				{
					reponse.close();
				}
			}
			catch (SQLException e)
			{
			}
			try
			{
				if (statement != null)
				{
					statement.close();
				}
			}
			catch (SQLException e)
			{
			}

			try
			{
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
			}
		}

		return produit;
	}

	public static Produit getByLogin(String login)
	{
		for (Produit produit : produits)
		{
			
		}

		return null;
	}
}


