package test;

public class Certificat {
private String Adresse_poste ;
private int id_test;
private int id_user;
private int id;
private String nom;
private String notification;
public String getAdresse_poste() {
	return Adresse_poste;
}
public void setAdresse_poste(String adresse_poste) {
	Adresse_poste = adresse_poste;
}
public int getId_test() {
	return id_test;
}
public void setId_test(int id_test) {
	this.id_test = id_test;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
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
public String getNotification() {
	return notification;
}
public void setNotification(String notification) {
	this.notification = notification;
}
public Certificat(String adresse_poste, int id_test, int id_user, int id, String nom, String notification) {
	super();
	Adresse_poste = adresse_poste;
	this.id_test = id_test;
	this.id_user = id_user;
	this.id = id;
	this.nom = nom;
	this.notification = notification;
}


}
