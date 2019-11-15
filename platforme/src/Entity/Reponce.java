package test;

public class Reponce {
private int id_rep;
private String rep;
private String resultat;
private int id_Q;
public int getId_rep() {
	return id_rep;
}
public void setId_rep(int id_rep) {
	this.id_rep = id_rep;
}
public String getRep() {
	return rep;
}
public void setRep(String rep) {
	this.rep = rep;
}
public String getResultat() {
	return resultat;
}
public void setResultat(String resultat) {
	this.resultat = resultat;
}
public int getId_Q() {
	return id_Q;
}
public void setId_Q(int id_Q) {
	this.id_Q = id_Q;
}
public Reponce(int id_rep, String rep, String resultat, int id_Q) {
	super();
	this.id_rep = id_rep;
	this.rep = rep;
	this.resultat = resultat;
	this.id_Q = id_Q;
}


}
