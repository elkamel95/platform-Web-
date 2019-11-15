package test;

public class UserInfo {
private int 	id_agen;
private String nomUser;
private String 	pren;
private String motPasse;
private String email;
private String Tel;
private String 	Nom_de_lentreprise;
private String Adresse;
private String Ville;
private String Pays;
private String Registre_commerce;
private int 	id_User;
private int Validation;
public int getId_agen() {
	return id_agen;
}
public void setId_agen(int id_agen) {
	this.id_agen = id_agen;
}
public String getNomUser() {
	return nomUser;
}
public void setNomUser(String nomUser) {
	this.nomUser = nomUser;
}
public String getPren() {
	return pren;
}
public void setPren(String pren) {
	this.pren = pren;
}
public String getMotPasse() {
	return motPasse;
}
public void setMotPasse(String motPasse) {
	this.motPasse = motPasse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTel() {
	return Tel;
}
public void setTel(String tel) {
	Tel = tel;
}
public String getNom_de_lentreprise() {
	return Nom_de_lentreprise;
}
public void setNom_de_lentreprise(String nom_de_lentreprise) {
	Nom_de_lentreprise = nom_de_lentreprise;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}
public String getVille() {
	return Ville;
}
public void setVille(String ville) {
	Ville = ville;
}
public String getPays() {
	return Pays;
}
public void setPays(String pays) {
	Pays = pays;
}
public String getRegistre_commerce() {
	return Registre_commerce;
}
public void setRegistre_commerce(String registre_commerce) {
	Registre_commerce = registre_commerce;
}
public int getId_User() {
	return id_User;
}
public void setId_User(int id_User) {
	this.id_User = id_User;
}
public int getValidation() {
	return Validation;
}
public void setValidation(int validation) {
	Validation = validation;
}
public UserInfo(int id_agen, String nomUser, String pren, String motPasse, String email, String tel,
		String nom_de_lentreprise, String adresse, String ville, String pays, String registre_commerce, int id_User,
		int validation) {
	super();
	this.id_agen = id_agen;
	this.nomUser = nomUser;
	this.pren = pren;
	this.motPasse = motPasse;
	this.email = email;
	Tel = tel;
	Nom_de_lentreprise = nom_de_lentreprise;
	Adresse = adresse;
	Ville = ville;
	Pays = pays;
	Registre_commerce = registre_commerce;
	this.id_User = id_User;
	Validation = validation;
}

}
