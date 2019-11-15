package test;

public class CategorieApprontissage {
private int idCours;
private String Title;
private String image;
public int getIdCours() {
	return idCours;
}
public void setIdCours(int idCours) {
	this.idCours = idCours;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public CategorieApprontissage(int idCours, String title, String image) {
	super();
	this.idCours = idCours;
	Title = title;
	this.image = image;
}

}
