package test;

public class SousCategrie {
	private int id;
	private String nom;
	private int idCat;
	public SousCategrie(int id, String nom, int idCat) {
		super();
		this.id = id;
		this.nom = nom;
		this.idCat = idCat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}



}
