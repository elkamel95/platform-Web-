package test;

public class Test {
private int id_test;
private String  test;
private String 	Description;
private String image;
public int getId_test() {
	return id_test;
}
public void setId_test(int id_test) {
	this.id_test = id_test;
}
public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Test(int id_test, String test, String description, String image) {
	super();
	this.id_test = id_test;
	this.test = test;
	Description = description;
	this.image = image;
}

}