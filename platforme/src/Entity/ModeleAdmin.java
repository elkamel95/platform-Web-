package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ModeleAdmin {
	
public String Name;
public String description;
public float prix;
public String image;

public int id_cat;

public 	void DELETEAll ()throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM formation ");
	 st.executeUpdate();

		}
public 	void DELETEUser (int id)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `user` WHERE  `id_User`=?");
	PreparedStatement st2= c.prepareStatement("DELETE FROM `agen_commercial` WHERE  `id_User`=?");

	st.setInt(1, id);
	st2.setInt(1, id);
	 st2.executeUpdate();

	 st.executeUpdate();

		}
public 	void DELETEAllFormation (int id_user)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM formation where id_User=?");
	st.setInt(1, id_user);
	 st.executeUpdate();

		}
public 	void DELETETraining (int id)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM formation where id_formation=?");
	st.setInt(1, id);

	 st.executeUpdate();

		}
public 	void DELETECours (int id)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `cours` WHERE `id_cours` =?");
	st.setInt(1, id);

	 st.executeUpdate();

		}
public 	void DELETEReponse (int id)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `reponce` WHERE `id_rep` =?");
	st.setInt(1, id);

	 st.executeUpdate();

		}
public 	void DELETEAllReponseQuestion (int id_Q)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `question` WHERE `id_Q` =?");
	st.setInt(1, id_Q);

	 st.executeUpdate();

		}
public 	void DELETETest (int id_Test)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `test` WHERE `id_test` =?");
	st.setInt(1, id_Test);

	 st.executeUpdate();

		}
public 	void DELETEQuestionIdTest (int id_Test)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `question` WHERE`id_test` =?");
	st.setInt(1, id_Test);

	 st.executeUpdate();

		}
public 	void DELETEQuestion (int id_Q)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `reponce` WHERE `id_Q` =?");
	st.setInt(1, id_Q);

	 st.executeUpdate();

		}
public 	void DELETECoursVideo (int id)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `video` WHERE `id_video` =?");
	st.setInt(1, id);

	 st.executeUpdate();

		}
public 	int UPDATETraining (String Name,String description,float prix,String image,int id_cat,String Date_Debut,String Date_Fin,int id_formation,int idSousCategori ,int id_User,String adresse,int Tel)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `formation` SET `nom`=?, `description`=?, `prix`=?, `image`=?, `id_cat`=?,`Date_Debut`=?,`Date_Fin`=?,`id_SousCat` =?,`adresse` =?,`Tel` =? where id_formation=? and id_User=? ");
	st.setString(1,Name.replaceAll("Ã©", "é").replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setString(2,description.replaceAll("Ã©", "é").replace("Ã", "é").replace('©', '\u0000').replace('©', '\u0000'));
	st.setFloat(3, prix);
	st.setString(4,image );
	st.setInt(5,id_cat );
	st.setString(6,Date_Debut);
	st.setString(7,Date_Fin);
	st.setInt(8, idSousCategori);
	st.setString(9,adresse.replace("Ã", "é").replace('©', '\u0000'));
	st.setInt(10,Tel );
	st.setInt(11,id_formation );
	st.setInt(12,id_User );

	
	 st.executeUpdate();

		return st.executeUpdate();

		}
	public int ajoutFormation(String Name,String description,float prix,String image,int id_cat,String dd,String mmm,String yyyy,String ddFin,String mmmFin,String yyyyFin,int idSousCat,int idUser,String adresse,int Tel ,String Ville) throws SQLException{
		
		Connection c = SingleConnection.getConnection();

		PreparedStatement st= c.prepareStatement("INSERT INTO `formation` (`id_formation`, `nom`, `description`, `prix`, `image`, `id_cat`, `Date_Debut`, `Date_Fin`,`id_SousCat`,`id_User`,`adresse`,`Tel`,Ville) VALUES (NULL,?, ?, ?,?, ?,?,?,?,?,?,?,?)");
		st.setString(1,Name.replace("Ã", "é").replace('©', '\u0000') );
		st.setString(2,description.replace("Ã", "é").replace('©', '\u0000'));
		st.setFloat(3, prix);
		st.setString(4,image );
		st.setInt(5,id_cat);
		String Date_Debut=dd+"/"+mmm+"/"+yyyy;

		String Date_Fin=ddFin+"/"+mmmFin+"/"+yyyyFin;

		st.setString(6,Date_Debut);
		st.setString(7,Date_Fin);
		st.setInt(8,idSousCat);
		st.setInt(9,idUser);
		st.setString(10,adresse);
		st.setInt(11,Tel );
		st.setString(12,Ville .replace("Ã", "é").replace('©', '\u0000'));


		return st.executeUpdate();
	}

public int UpdateCategori(int id ,String Name) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `catégorie` SET `nom`=? where id_cat=?");
	st.setString(1,Name );
st.setInt(2, id);
	
	

	return st.executeUpdate();
}
public int AjoutSousCategori(String Name,int id_cat,int id_catFormation) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `souscatégorie` (`id_SousCat`, `nom`, `id_cat`,`id_catFormation`) VALUES (NULL,?,?,?)");
	st.setString(1,Name.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setInt(2, id_cat);
	st.setInt(3, id_catFormation);


	return st.executeUpdate();
}
public int AjoutCategori(String Name,int Role) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `catégorie` (`id_cat`, `nom`,`id_catFormation`) VALUES (NULL,?,?)");
	st.setString(1,Name.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setInt(2, Role);

	return st.executeUpdate();
}
public void AjoutCategoriAppp(String Title,String image,int idRoleCat) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `categoricours`(`id_catCours`, `Title`, `image`,`idRoleCat`)  VALUES (NULL,?,?,?)");
	st.setString(1,Title.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,image );
	st.setInt(3,idRoleCat );

	st.executeUpdate();
	

}
public int UpdateSousCategori(int id ,String Name,int IdCat) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `souscatégorie` SET `nom`=?,`id_cat`=? where id_SousCat=?");
	st.setString(1,Name.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setInt(2, IdCat);

st.setInt(3, id);
	
	

	return st.executeUpdate();
}
public int ajoutOffreEmploi(String Title,String nom_Sociter,String description_détaillée,String Exigences,String Secteur_activité,String Lieu,String Expire,String image,int id_User,int id_Cat,int id_SousCat) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `offre_emploi`(`id_offre`, `Title`, `nom_Sociter`, `description_détaillée`, `Exigences`, `Secteur_activité`, `Lieu`, `Expire`, `image`,`id_User`,	id_cat,	id_SousCat) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)");
	st.setString(1,Title.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setString(2,nom_Sociter.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(3, description_détaillée.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(4,Exigences.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	

	st.setString(5,Secteur_activité.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(6,Lieu.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(7,Expire.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(8,image);

	st.setInt(9, id_User);
	st.setInt(10, id_Cat);
	st.setInt(11, id_SousCat);


	return st.executeUpdate();
}

public int updateOffreEmploi(String Title,String nom_Sociter,String description_détaillée,String Exigences,String Secteur_activité,String Lieu,String Expire,String image,int id_User,int id_offre , int id_Cat,int id_SousCat) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `offre_emploi` SET `Title`=?,`nom_Sociter`=?,`description_détaillée`=?,`Exigences`=?,`Secteur_activité`=?,`Lieu`=?,`Expire`=?,`image`=? ,`id_cat`=? ,`id_SousCat`=? where `id_User`=? and `id_offre`=?" );
	st.setString(1,Title.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setString(2,nom_Sociter.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(3, description_détaillée.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(4,Exigences.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	

	st.setString(5,Secteur_activité.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(6,Lieu.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(7,Expire);
	st.setString(8,image);
	st.setInt(9, id_Cat);
	st.setInt(10, id_SousCat);

st.setInt(11, id_User);
st.setInt(12, id_offre);


	return st.executeUpdate();
}
public 	void DELETEAllJobOffer ()throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `offre_emploi` ");
	 st.executeUpdate();

		}
public 	void DELETEAllJobOffer (int id_user)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `offre_emploi` where id_User=?");
	st.setInt(1, id_user);
	 st.executeUpdate();

		}
public 	void DELETEJobOffer (int id_offre)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `offre_emploi` where `id_offre`=?");
	st.setInt(1, id_offre);

	 st.executeUpdate();

		}
public 	void DeleteCv (int id_CV)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `cv` WHERE `id_cv`=?");
	st.setInt(1, id_CV);

	 st.executeUpdate();

		}
public void inscrit(String nom,String pren ,String MotPasse,String email,String Tel,String Nom_de_lentreprise,String Adresse,String Ville,String Pays,String Registre_commerce,int id_User,int Validation) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `agen_commercial`(`id_agen`, `nom`, `pren`, `motPasse`, `email`, `Tel`, `Nom_de_lentreprise`, `Adresse`, `Ville`, `Pays`, `Registre_commerce`, `id_User`,Validation) VALUES (Null,?,?,?,?,?,?,?,?,?,?,?,?)");
	
st.setString(1, nom.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(2, pren.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(3, MotPasse);
st.setString(4, email);
st.setString(5, Tel);
st.setString(6, Nom_de_lentreprise.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(7, Adresse);
st.setString(8, Ville);
st.setString(9, Pays);
st.setString(10, Registre_commerce);
st.setInt(11, id_User);
st.setInt(12, Validation);

st.executeUpdate();
	
}
public void ValidationUser(int User) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `agen_commercial` SET `Validation`=1 WHERE id_User=?");
	
st.setInt(1, User);


st.executeUpdate();
	
}
public void UpdatUser(int User,String email,String motPasse) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `user` SET `email`=?,`motPasse`=?  WHERE id_User=?");
	
st.setString(1, email);
st.setString(2, motPasse);
st.setInt(3, User);


st.executeUpdate();
}
public void UpdatUserAdmin(int User,String email,String motPasse) throws SQLException{
	Connection c = SingleConnection.getConnection();
	PreparedStatement st= c.prepareStatement("UPDATE `user` SET `email`=?,`motPasse`=?  WHERE id_User=?");
	st.setString(1, email);
	st.setString(2, motPasse);
	st.setInt(3, User);
	PreparedStatement st2= c.prepareStatement("UPDATE `admin` SET `id_admin`=[value-1],`nom`=?,`motpass`=? WHERE `id_User`=?");
	
st2.setString(1, email);
st2.setString(2, motPasse);
st2.setInt(3, User);


st.executeUpdate();
}
public void UpdatUserAgen(String nom,String pren,String motPasse,String email,int tel ,String Nom_de_lentreprise,String Adresse,int id_user) throws SQLException{
	Connection c = SingleConnection.getConnection();

PreparedStatement st2= c.prepareStatement("UPDATE `agen_commercial` SET `nom`=?,`pren`=?,`motPasse`=?,`email`=?,`Tel`=?,`Nom_de_lentreprise`=?,`Adresse`=? WHERE `id_User`=?");

st2.setString(1, nom.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st2.setString(2, pren.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st2.setString(3, motPasse);
st2.setString(4, email);

st2.setInt(5, tel);
st2.setString(6,Nom_de_lentreprise.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st2.setString(7,Adresse.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st2.setInt(8,id_user);
st2.executeUpdate();

	
}
public void inscritAdmin(String nom,String pren ,String MotPasse,int id_User) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `admin`(`id_admin`, `nom`, `pren`, `motpass`, `id_User`) VALUES (Null,?,?,?,?)");
	
st.setString(1, nom);
st.setString(2, pren);
st.setString(3, MotPasse);

st.setInt(4, id_User);
st.executeUpdate();
	
}
public void inscritUser(int id_User,String email,String MotPasse,int id_role) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `user`(`id_User`, `email`, `motPasse`, `id_role`) VALUES (?,?,?,?)");
	st.setInt(1, id_User);
	
st.setString(2, email);
st.setString(3, MotPasse);
st.setInt(4, id_role);

st.executeUpdate();
	
}
public void deposit(String CV,int id_user) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `Cv` (`id_cv`, `CV`,`id_User`) VALUES (NULL,?,?)");
	
st.setString(1, CV.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setInt(2, id_user);
st.executeUpdate();
	
}
public void insertCour(String name,String image,String pdf,String Desc,int Cat,int idRoleCat) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `cours`(`id_cours`, `name`, `image`, `pdf`,`Description`,`id_catCours`) VALUES (NULL,?,?,?,?,?)");
	
st.setString(1, name.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(2, image);
st.setString(3, pdf);
st.setString(4, Desc.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setInt(5, Cat);

st.executeUpdate();
	
}
public 	void DeleteCours (int id_cours)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `cours` WHERE `id_cours`=?");
	st.setInt(1, id_cours);

	 st.executeUpdate();

		}
public 	void DeleteCategories(int id_cat)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `catégorie` WHERE  `id_cat`=?");
	st.setInt(1, id_cat);

	 st.executeUpdate();

		}
public 	void DeleteSousCategories(int id_Souscat)throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `souscatégorie`  WHERE `id_SousCat`=?");
	st.setInt(1, id_Souscat);

	 st.executeUpdate();

		}
public int updateCours(String name,String image,String pdf,String Desc) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `cours` SET `name`=?,`image`=?,`pdf`=?,`Description`=? WHERE 1" );
	st.setString(1,name .replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,image);
	st.setString(3,pdf);
	st.setString(4,Desc.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	


	return st.executeUpdate();
}
public int updateCoursVideo(String name,String image,String Video,int id_Video) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `video` SET `titre`=?,`image`=?,`video`=? where `id_video`=?" );
	st.setString(1,name .replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,image);
	st.setString(3,Video);
	st.setInt(4,id_Video);



	return st.executeUpdate();
}
public int updateCoursId(String name,String image,String pdf,String Desc,int id) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `cours` SET `name`=?,`image`=?,`pdf`=?,`Description`=? WHERE id_cours= ?" );
	st.setString(1,name .replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,image);
	st.setString(3,pdf);
	st.setString(4,Desc.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setInt(5,id);



	return st.executeUpdate();
}
public int updateCatCours(String Title,String image ,int id) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `categoricours` SET `Title`=?,`image`=?  WHERE id_catCours= ?" );
	st.setString(1,Title.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setString(2,image);
	st.setInt(3, id);



	return st.executeUpdate();
}
public int updateReponse(String rep,String result,int id_Q,int id_Rep) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `reponce` SET `rep`=?,`resultat`=? WHERE `id_Q`=? and id_rep=?" );
	st.setString(1,rep .replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,result);
	st.setInt(3,id_Q);
	st.setInt(4,id_Rep);




	return st.executeUpdate();
}
public int updateTest(String test,String desc,String image,int id) throws SQLException{
	
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `test` SET `test`=?,`Description`=?,`image`=? WHERE `id_test`=? " );
	st.setString(1,test.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(2,desc.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
	st.setString(3,image);
	st.setInt(4,id);



	return st.executeUpdate();
}
public void insertVideo(String titre,String image,String video,int id_catCours) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `Video`(`id_video`, `titre`, `image`, `video`,`id_catCours`) VALUES (NULL,?,?,?,?)");
	
st.setString(1, titre.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(2, image);
st.setString(3, video);
st.setInt(4, id_catCours);


st.executeUpdate();
	
}
public void insertTest(String test,String Description,String image) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `test`(`id_test`, `test`, `Description`, `image`)  VALUES (NULL,?,?,?)");
	
st.setString(1, test.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(2, Description.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(3, image);


st.executeUpdate();
	
}
public void insertcertificat(String adresse_postale,int id_test,int id_User,String nom,int notification) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `certificat`(`id`, `adresse_postale`, `id_test`, `id_User`,`nom_pren`,notification) VALUES (NULL,?,?,?,?,1)");
	
st.setString(1, adresse_postale.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setInt(2, id_test);
st.setInt(3, id_User);
st.setString(4, nom.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));


st.executeUpdate();
	
}
public void InsertQuestion(String question,int id_test) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `question`(`id_Q`, `question`, `id_test`) VALUES (NULL,?,?)");
	
st.setString(1, question.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setInt(2,id_test);



st.executeUpdate();
	
}
public void UpdateQuestion(String question ,int id_Question) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `question` SET `question`=?  WHERE `id_Q`=?  ");
	st.setString(1, question);
st.setInt(2,id_Question);



st.executeUpdate();
	
}
public void InsertReply(String rep,String resultat,int id_Q) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `reponce`(`id_rep`, `rep`, `resultat`, `id_Q`) VALUES (NULL,?,?,?)");
	
st.setString(1,rep.replace("Ã", "é").replace("©", "").replace('©', '\u0000'));
st.setString(2,resultat);
st.setInt(3,id_Q);



st.executeUpdate();
	
}
public String MessageEnvoyer_User(String msg,int Notif,int id_user) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `message_admin`(`id_messgA`, `message`, `notification`, `id_User`) VALUES (Null,?,?,?)");
	st.setString(1,msg.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setInt(2,Notif );
	st.setInt(3,id_user );

	st.executeUpdate();

	return "votre message a été envoyé avec succès";
	
	
	
	
	
	
}
public String MessageEnvoyer_Admin(String msg,int Notif,int id_user) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `message_user`(`id_messg`, `message`, `notification`, `id_User`) VALUES (Null,?,?,?)");
	st.setString(1,msg.replace("Ã", "é").replace("©", "").replace('©', '\u0000') );
	st.setInt(2,Notif );
	st.setInt(3,id_user );

	st.executeUpdate();

	return "votre message a été envoyé avec succès";
	
	
	
	
	
	
}
}
