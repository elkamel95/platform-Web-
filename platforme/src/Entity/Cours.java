package test;

public class Cours {
	private int id_cours;
	private String nom;
	private String image;
	private String pdf;
	private String desc;
	private int id_catCours;
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getId_catCours() {
		return id_catCours;
	}
	public void setId_catCours(int id_catCours) {
		this.id_catCours = id_catCours;
	}
	public Cours(int id_cours, String nom, String image, String pdf, String desc, int id_catCours) {
		super();
		this.id_cours = id_cours;
		this.nom = nom;
		this.image = image;
		this.pdf = pdf;
		this.desc = desc;
		this.id_catCours = id_catCours;
	}
	
}