package test;

public class Job {
	private int id_offre;
	private String Title;
	private String nom_Sociter;
	private String description_d�taill�e;
	private String Exigences;
	private String Secteur_activit�;
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
	public String getDescription_d�taill�e() {
		return description_d�taill�e;
	}
	public void setDescription_d�taill�e(String description_d�taill�e) {
		this.description_d�taill�e = description_d�taill�e;
	}
	public String getExigences() {
		return Exigences;
	}
	public void setExigences(String exigences) {
		Exigences = exigences;
	}
	public String getSecteur_activit�() {
		return Secteur_activit�;
	}
	public void setSecteur_activit�(String secteur_activit�) {
		Secteur_activit� = secteur_activit�;
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
	public Job(int id_offre, String title, String nom_Sociter, String description_d�taill�e, String exigences,
			String secteur_activit�, String lieu, String expire, String image, int id_User, int id_cat,
			int id_sousCat) {
		super();
		this.id_offre = id_offre;
		Title = title;
		this.nom_Sociter = nom_Sociter;
		this.description_d�taill�e = description_d�taill�e;
		Exigences = exigences;
		Secteur_activit� = secteur_activit�;
		Lieu = lieu;
		Expire = expire;
		this.image = image;
		this.id_User = id_User;
		this.id_cat = id_cat;
		this.id_sousCat = id_sousCat;
	}
	
}
