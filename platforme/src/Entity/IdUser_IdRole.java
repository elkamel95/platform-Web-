package test;

public class IdUser_IdRole {
private int id_user;
private String id_role ;
public IdUser_IdRole(int id_user, String id_role) {
	super();
	this.id_user = id_user;
	this.id_role = id_role;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getId_role() {
	return id_role;
}
public void setId_role(String id_role) {
	this.id_role = id_role;
}

}
