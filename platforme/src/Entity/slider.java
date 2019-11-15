package test;

public class slider {
	private int id_Slider;
	private String nom;
	private String image;
public slider(int id_Slider, String nom, String image) {
		super();
		this.id_Slider = id_Slider;
		this.nom = nom;
		this.image = image;
	}
public int getId_Slider() {
	return id_Slider;
}
public void setId_Slider(int id_Slider) {
	this.id_Slider = id_Slider;
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


}
