package test;

public class User {
private int id_user;
private String nom;
private String Motpasse;
private String id_role;
public User(int id_user, String nom, String motpasse, String id_role) {
	super();
	this.id_user = id_user;
	this.nom = nom;
	Motpasse = motpasse;
	this.id_role = id_role;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMotpasse() {
	return Motpasse;
}
public void setMotpasse(String motpasse) {
	Motpasse = motpasse;
}
public String getId_role() {
	return id_role;
}
public void setId_role(String id_role) {
	this.id_role = id_role;
}

}
