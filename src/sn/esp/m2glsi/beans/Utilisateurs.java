package sn.esp.m2glsi.beans;

public class Utilisateurs {
	private static int	lastId	= 0;

	private int			id;
	private String		nom, prenom, login, password;

	public Utilisateurs()
	{
		this.id = ++lastId;
	}

	public Utilisateurs(String nom, String prenom, String login, String password)
	{
		this.id = ++lastId;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", login=" + login + ", password=" + password + "]";
	}

}
