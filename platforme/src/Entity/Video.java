package test;

public class Video {
private int id_video;
private String titre;
private String image ;
private String Video;
private int id_Cat;
public int getId_video() {
	return id_video;
}
public void setId_video(int id_video) {
	this.id_video = id_video;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getVideo() {
	return Video;
}
public void setVideo(String video) {
	Video = video;
}
public int getId_Cat() {
	return id_Cat;
}
public void setId_Cat(int id_Cat) {
	this.id_Cat = id_Cat;
}
public Video(int id_video, String titre, String image, String video, int id_Cat) {
	super();
	this.id_video = id_video;
	this.titre = titre;
	this.image = image;
	Video = video;
	this.id_Cat = id_Cat;
}

}
