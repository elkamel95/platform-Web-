package test;

public class Formation {
	private int id_formation;
	private String nom;
	private String descrription;
	private float prix;
	private String image ;
	private int id_cat;
	private String Date_Debut;
	private String Date_Fin;
	private int id_Souscat;
	private int id_user;
	private String adresse;
	private int Tel;
	private String Ville;

	public int getId_formation() {
		return id_formation;
	}
	public void setId_formation(int id_formation) {
		this.id_formation = id_formation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescrription() {
		return descrription;
	}
	public void setDescrription(String descrription) {
		this.descrription = descrription;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getDate_Debut() {
		return Date_Debut;
	}
	public void setDate_Debut(String date_Debut) {
		Date_Debut = date_Debut;
	}
	public String getDate_Fin() {
		return Date_Fin;
	}
	public void setDate_Fin(String date_Fin) {
		Date_Fin = date_Fin;
	}
	public int getId_Souscat() {
		return id_Souscat;
	}
	public void setId_Souscat(int id_Souscat) {
		this.id_Souscat = id_Souscat;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public Formation(int id_formation, String nom, String descrription, float prix, String image, int id_cat,
			String date_Debut, String date_Fin, int id_Souscat, int id_user, String adresse, int tel, String ville) {
		super();
		this.id_formation = id_formation;
		this.nom = nom;
		this.descrription = descrription;
		this.prix = prix;
		this.image = image;
		this.id_cat = id_cat;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
		this.id_Souscat = id_Souscat;
		this.id_user = id_user;
		this.adresse = adresse;
		Tel = tel;
		Ville = ville;
	}


	


}
