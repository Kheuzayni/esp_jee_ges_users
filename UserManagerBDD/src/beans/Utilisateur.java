package beans;

public class Utilisateur
{
	private int		id;
	private String	nom, prenom, login, password,privilege;

	public Utilisateur()
	{
	}

	public Utilisateur(String nom, String prenom, String login, String privilege,String password)
	{
		this(0, nom, prenom, login, privilege, password);
	}

	public Utilisateur(int id, String nom, String prenom, String login,
			 String privilege,String password)
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.privilege = privilege;
		this.password = password;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
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
				+ ", login=" + login + ", privilege=" + privilege +", password=" + password + "]";
	}

}
