package beans;

public class Produit {
	private int id,prix,idpro;
	private String designation;
	private int quantite;
	public Produit() {
		
	}
	public Produit(String designation, int prix, int quantite,int idpro)
	{
		this(0, designation, prix, quantite,idpro);
	}

	public Produit(int id, String designation,int prix,  int quantite,int idpro) {
		
		this.id = id;
		this.prix = prix;
		this.designation = designation;
		this.quantite = quantite;
		this.idpro = idpro;
	}
	
	public int getIdpro() {
		return idpro;
	}
	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
