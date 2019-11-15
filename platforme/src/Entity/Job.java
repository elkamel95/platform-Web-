package test;

public class Job {
	private int id_offre;
	private String Title;
	private String nom_Sociter;
	private String description_détaillée;
	private String Exigences;
	private String Secteur_activité;
	private String Lieu;
	private String Expire;
	private String image;
	private int id_User;
	private int id_cat;
	private int id_sousCat;
	public int getId_offre() {
		return id_offre;
	}
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getNom_Sociter() {
		return nom_Sociter;
	}
	public void setNom_Sociter(String nom_Sociter) {
		this.nom_Sociter = nom_Sociter;
	}
	public String getDescription_détaillée() {
		return description_détaillée;
	}
	public void setDescription_détaillée(String description_détaillée) {
		this.description_détaillée = description_détaillée;
	}
	public String getExigences() {
		return Exigences;
	}
	public void setExigences(String exigences) {
		Exigences = exigences;
	}
	public String getSecteur_activité() {
		return Secteur_activité;
	}
	public void setSecteur_activité(String secteur_activité) {
		Secteur_activité = secteur_activité;
	}
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public String getExpire() {
		return Expire;
	}
	public void setExpire(String expire) {
		Expire = expire;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_User() {
		return id_User;
	}
	public void setId_User(int id_User) {
		this.id_User = id_User;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public int getId_sousCat() {
		return id_sousCat;
	}
	public void setId_sousCat(int id_sousCat) {
		this.id_sousCat = id_sousCat;
	}
	public Job(int id_offre, String title, String nom_Sociter, String description_détaillée, String exigences,
			String secteur_activité, String lieu, String expire, String image, int id_User, int id_cat,
			int id_sousCat) {
		super();
		this.id_offre = id_offre;
		Title = title;
		this.nom_Sociter = nom_Sociter;
		this.description_détaillée = description_détaillée;
		Exigences = exigences;
		Secteur_activité = secteur_activité;
		Lieu = lieu;
		Expire = expire;
		this.image = image;
		this.id_User = id_User;
		this.id_cat = id_cat;
		this.id_sousCat = id_sousCat;
	}
	
}
