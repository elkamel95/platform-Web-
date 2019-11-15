package test;

public class Message {
private int messageA;
private String message;
private String notification;
private int id_user;
public int getMessageA() {
	return messageA;
}
public void setMessageA(int messageA) {
	this.messageA = messageA;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getNotification() {
	return notification;
}
public void setNotification(String notification) {
	this.notification = notification;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public Message(int messageA, String message, String notification, int id_user) {
	super();
	this.messageA = messageA;
	this.message = message;
	this.notification = notification;
	this.id_user = id_user;
}

}