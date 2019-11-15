package test;

public class Question {
 private int id_Q;
 private String question;
 private int id_test;
public int getId_Q() {
	return id_Q;
}
public void setId_Q(int id_Q) {
	this.id_Q = id_Q;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getId_test() {
	return id_test;
}
public void setId_test(int id_test) {
	this.id_test = id_test;
}
public Question(int id_Q, String question, int id_test) {
	super();
	this.id_Q = id_Q;
	this.question = question;
	this.id_test = id_test;
}
 
}
