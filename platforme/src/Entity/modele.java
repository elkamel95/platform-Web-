package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class modele {



	
	

		public modele() {
		super();
	}
		public 	ArrayList<User> SelectUser ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `user`  ");
			ResultSet rs= st.executeQuery();
			ArrayList<User> l =new ArrayList<User>();
			while(rs.next()){
				User		user =new User(rs.getInt("id_User"),rs.getString("email"),rs.getString("motPasse"),rs.getString("id_role"))	;	
               l.add(user);
			}
			return l;}
		public 	ArrayList<User> SelectIdUser (int id )throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `user` where id_User= ?  ");
			st.setInt(1, id);

			ResultSet rs= st.executeQuery();
			ArrayList<User> l =new ArrayList<User>();
			while(rs.next()){
				User		user =new User(rs.getInt("id_User"),rs.getString("email"),rs.getString("motPasse"),rs.getString("id_role"))	;	
               l.add(user);
			}
			return l;}
		public 	ArrayList<UserInfo> SelectUserId (int id_User)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `agen_commercial` where id_User= ? ");
			st.setInt(1, id_User);

			ResultSet rs= st.executeQuery();
			ArrayList<UserInfo> l =new ArrayList<UserInfo>();
			while(rs.next()){
				UserInfo		user =new UserInfo(rs.getInt("id_agen"),rs.getString("nom"),rs.getString("pren"),rs.getString("motPasse"),rs.getString("email"),rs.getString("Tel"),rs.getString("Nom_de_lentreprise"),rs.getString("Adresse"),rs.getString("Ville"),rs.getString("Pays"),rs.getString("Registre_commerce"),rs.getInt("id_User"),rs.getInt("Validation"))	;	
               l.add(user);
			}
			return l;}
		public 	ArrayList<UserInfo> SelectAgen ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `agen_commercial`  ");

			ResultSet rs= st.executeQuery();
			ArrayList<UserInfo> l =new ArrayList<UserInfo>();
			while(rs.next()){
				UserInfo		user =new UserInfo(rs.getInt("id_agen"),rs.getString("nom"),rs.getString("pren"),rs.getString("motPasse"),rs.getString("email"),rs.getString("Tel"),rs.getString("Nom_de_lentreprise"),rs.getString("Adresse"),rs.getString("Ville"),rs.getString("Pays"),rs.getString("Registre_commerce"),rs.getInt("id_User"),rs.getInt("Validation"))	;	
               l.add(user);
			}
			return l;}
		
// 
		public 	ArrayList<Categrie> SelectCategorie (int id_role)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `catégorie` WHERE `id_catFormation` =?");
			st.setInt(1, id_role);
			ResultSet rs= st.executeQuery();
			ArrayList<Categrie> l =new ArrayList<Categrie>();
			while(rs.next()){
				Categrie		C =new Categrie(rs.getInt("id_cat"),rs.getString("nom"))	;	
l.add(C);
			}
			return l;
				}
		public 	ArrayList<CategorieApprontissage> SelectCategorieApp (int idRoleCat)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `categoricours` where idRoleCat =?");
			st.setInt(1, idRoleCat);
			ResultSet rs= st.executeQuery();
			ArrayList<CategorieApprontissage> l =new ArrayList<CategorieApprontissage>();
			while(rs.next()){
				CategorieApprontissage		C =new CategorieApprontissage(rs.getInt("id_catCours"),rs.getString("Title"),rs.getString("image"))	;	
l.add(C);
			}
			return l;
				}
		public 	ArrayList<CategorieApprontissage> SelectCategorieAppID (int id)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `categoricours` where id_catCours =?");
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			ArrayList<CategorieApprontissage> l =new ArrayList<CategorieApprontissage>();
			while(rs.next()){
				CategorieApprontissage		C =new CategorieApprontissage(rs.getInt("id_catCours"),rs.getString("Title"),rs.getString("image"))	;	
l.add(C);
			}
			return l;
				}
		public 	ArrayList<SousCategrie> SelectSousCategorie ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from `souscatégorie`");
			ResultSet rs= st.executeQuery();
			ArrayList<SousCategrie> l =new ArrayList<SousCategrie>();
			while(rs.next()){
				SousCategrie		C =new SousCategrie(rs.getInt("id_SousCat"),rs.getString("nom"),rs.getInt("id_cat"))	;	
l.add(C);
			}
			return l;
				}
		public 	ArrayList<SousCategrie> SelectSousCategorie (int id )throws SQLException{
			Connection c = SingleConnection.getConnection();
			PreparedStatement st= c.prepareStatement("SELECT * FROM `souscatégorie` WHERE `id_catFormation`=?");
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			ArrayList<SousCategrie> l =new ArrayList<SousCategrie>();
			while(rs.next()){
				SousCategrie		C =new SousCategrie(rs.getInt("id_SousCat"),rs.getString("nom"),rs.getInt("id_cat"))	;	
l.add(C);
			}
			return l;
				}
		public 	ArrayList<Formation> SelectAllFormation ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from formation ORDER BY `id_formation` DESC");
			ResultSet rs= st.executeQuery();
			
			ArrayList<Formation> l =new ArrayList<Formation>();
			while(rs.next()){
				Formation f=new Formation(rs.getInt("id_formation"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getString("image"),rs.getInt("id_cat"),rs.getString("Date_Debut"),rs.getString("Date_Fin"),rs.getInt("id_SousCat"),rs.getInt("id_User"),rs.getString("adresse"),rs.getInt("Tel"),rs.getString("Ville"));
				l.add(f);
				

			}
			return l;
				}			
		
		public 	ArrayList<Formation> SelectFormation (int id)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from formation where id_formation=?");
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Formation> l =new ArrayList<Formation>();
			while(rs.next()){
				Formation f=new Formation(rs.getInt("id_formation"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getString("image"),rs.getInt("id_cat"),rs.getString("Date_Debut"),rs.getString("Date_Fin"),rs.getInt("id_SousCat"),rs.getInt("id_User"),rs.getString("adresse"),rs.getInt("Tel"),rs.getString("Ville"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Formation> SelectFormationSousCat (int idSousCat)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from formation where id_SousCat=?");
			st.setInt(1, idSousCat);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Formation> l =new ArrayList<Formation>();
			while(rs.next()){
				Formation f=new Formation(rs.getInt("id_formation"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getString("image"),rs.getInt("id_cat"),rs.getString("Date_Debut"),rs.getString("Date_Fin"),rs.getInt("id_SousCat"),rs.getInt("id_User"),rs.getString("adresse"),rs.getInt("Tel"),rs.getString("Ville"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Certificat> SelectAllCertificat ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `certificat` ");
			ResultSet rs= st.executeQuery();
			
			ArrayList<Certificat> l =new ArrayList<Certificat>();
			while(rs.next()){
				Certificat f=new Certificat(rs.getString("adresse_postale"),rs.getInt("id_test"),rs.getInt("id_User"),rs.getInt("id"),rs.getString("nom_pren"),rs.getString("notification"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Certificat> SelectCertificatId (int id_user)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `certificat`Where id_User=?  ");
			st.setInt(1, id_user);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Certificat> l =new ArrayList<Certificat>();
			while(rs.next()){
				Certificat f=new Certificat(rs.getString("adresse_postale"),rs.getInt("id_test"),rs.getInt("id_User"),rs.getInt("id"),rs.getString("nom_pren"),rs.getString("notification"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Job> SelectJob (int id)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `offre_emploi` where `id_offre`=?");
			st.setInt(1, id);
	ResultSet rs= st.executeQuery();
			
			ArrayList<Job> l =new ArrayList<Job>();
			while(rs.next()){
				Job f=new Job(rs.getInt("id_offre"), rs.getString("Title"), rs.getString("nom_Sociter"), rs.getString("description_détaillée"), rs.getString("Exigences"), rs.getString("Secteur_activité"), rs.getString("Lieu"), rs.getString("Expire"), rs.getString("image"), rs.getInt("id_User"),rs.getInt("id_cat"),rs.getInt("id_SousCat"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Job> SelectJobWithcity (String Ville)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `offre_emploi` where `Lieu` LIKE ?");
		st.setString(1, Ville+'%');
	ResultSet rs= st.executeQuery();
			
			ArrayList<Job> l =new ArrayList<Job>();
			while(rs.next()){
				Job f=new Job(rs.getInt("id_offre"), rs.getString("Title"), rs.getString("nom_Sociter"), rs.getString("description_détaillée"), rs.getString("Exigences"), rs.getString("Secteur_activité"), rs.getString("Lieu"), rs.getString("Expire"), rs.getString("image"), rs.getInt("id_User"),rs.getInt("id_cat"),rs.getInt("id_SousCat"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Job> SelectAllJobUser (int id_user)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `offre_emploi` where id_User=?");
			st.setInt(1, id_user);
	ResultSet rs= st.executeQuery();
			
			ArrayList<Job> l =new ArrayList<Job>();
			while(rs.next()){
				Job f=new Job(rs.getInt("id_offre"), rs.getString("Title"), rs.getString("nom_Sociter"), rs.getString("description_détaillée"), rs.getString("Exigences"), rs.getString("Secteur_activité"), rs.getString("Lieu"), rs.getString("Expire"), rs.getString("image"), rs.getInt("id_User"),rs.getInt("id_cat"),rs.getInt("id_SousCat"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Job> SelectSousCatJobUser (int id_SousCat)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `offre_emploi` where id_SousCat=?");
			st.setInt(1, id_SousCat);
	ResultSet rs= st.executeQuery();
			
			ArrayList<Job> l =new ArrayList<Job>();
			while(rs.next()){
				Job f=new Job(rs.getInt("id_offre"), rs.getString("Title"), rs.getString("nom_Sociter"), rs.getString("description_détaillée"), rs.getString("Exigences"), rs.getString("Secteur_activité"), rs.getString("Lieu"), rs.getString("Expire"), rs.getString("image"), rs.getInt("id_User"),rs.getInt("id_cat"),rs.getInt("id_SousCat"));
				l.add(f);
				

			}
			return l;
				}
		
		public 	ArrayList<Job> SelectAllJob ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `offre_emploi` ORDER BY `id_offre` DESC");
			ResultSet rs= st.executeQuery();
			
			ArrayList<Job> l =new ArrayList<Job>();
			while(rs.next()){
				Job f=new Job(rs.getInt("id_offre"), rs.getString("Title"), rs.getString("nom_Sociter"), rs.getString("description_détaillée"), rs.getString("Exigences"), rs.getString("Secteur_activité"), rs.getString("Lieu"), rs.getString("Expire"), rs.getString("image"), rs.getInt("id_User"),rs.getInt("id_cat"),rs.getInt("id_SousCat"));
				l.add(f);
				

			}
			return l;
				}
	public ArrayList<Message> MessageId(int id) throws SQLException{
			
			Connection c = SingleConnection.getConnection();
			PreparedStatement st= c.prepareStatement("SELECT * FROM `message_admin` WHERE `id_messgA` = ?");	
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			ArrayList<Message> ListMessage =new ArrayList<Message>();
			while(rs.next()){
				Message List=new Message(rs.getInt("id_messgA"),rs.getString("message"),rs.getString("notification"),rs.getInt("id_User"));
				ListMessage.add(List);
			}
			return ListMessage;
		}
	public ArrayList<Message> Message(int id_user) throws SQLException{
			
			Connection c = SingleConnection.getConnection();
			PreparedStatement st= c.prepareStatement("SELECT * FROM `message_admin` WHERE `id_User` = ?");	
			st.setInt(1, id_user);
			ResultSet rs= st.executeQuery();
			ArrayList<Message> ListMessage =new ArrayList<Message>();
			while(rs.next()){
				Message List=new Message(rs.getInt("id_messgA"),rs.getString("message"),rs.getString("notification"),rs.getInt("id_User"));
				ListMessage.add(List);
			}
			return ListMessage;
		}
	public int MessageNB(int id_user) throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT 	count(`notification`) FROM `message_admin` WHERE `id_User` = ? and (notification=1 or notification=3 )");	
		st.setInt(1, id_user);
		int s=0;

		ResultSet rs= st.executeQuery();
		while(rs.next()){
			s=rs.getInt(1);
		}return s;
		}
public int CertificaNB() throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT 	count(`notification`) FROM certificat WHERE notification=1");	
		int s=0;

		ResultSet rs= st.executeQuery();
		while(rs.next()){
			s=rs.getInt(1);
		}return s;
		}
	public int MessageAdminNB() throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT 	count(`notification`) FROM `message_user`  WHERE notification=1 ");	
		int s=0;

		ResultSet rs= st.executeQuery();
		while(rs.next()){
			s=rs.getInt(1);
		}return s;
		}
	public int MessageInvitationNB() throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT count(`Validation`) FROM `agen_commercial` WHERE `Validation`=0 ");	
		int s=0;

		ResultSet rs= st.executeQuery();
		while(rs.next()){
			s=rs.getInt(1);
		}return s;
		}
	public ArrayList<UserInfo> UserValidation() throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT * FROM `agen_commercial` WHERE `Validation`=0 ");	
		


		ResultSet rs= st.executeQuery();
		ArrayList<UserInfo> l =new ArrayList<UserInfo>();
		while(rs.next()){
			UserInfo		user =new UserInfo(rs.getInt("id_agen"),rs.getString("nom"),rs.getString("pren"),rs.getString("motPasse"),rs.getString("email"),rs.getString("Tel"),rs.getString("Nom_de_lentreprise"),rs.getString("Adresse"),rs.getString("Ville"),rs.getString("Pays"),rs.getString("Registre_commerce"),rs.getInt("id_User"),rs.getInt("Validation"))	;	
           l.add(user);
		}
		return l;}
	
		
	public ArrayList<Message> MessageAdmin() throws SQLException{
		
		Connection c = SingleConnection.getConnection();
		PreparedStatement st= c.prepareStatement("SELECT * FROM `message_user` ");	
		ResultSet rs= st.executeQuery();
		ArrayList<Message> ListMessage =new ArrayList<Message>();
		while(rs.next()){
			Message List=new Message(rs.getInt("id_messg"),rs.getString("message"),rs.getString("notification"),rs.getInt("id_User"));
			ListMessage.add(List);
		}
		return ListMessage;
	}

	
		public ArrayList<IdUser_IdRole> loginUser(String Login ,String MotPasse) throws SQLException{
			
			Connection c = SingleConnection.getConnection();
			PreparedStatement st= c.prepareStatement("SELECT * FROM `user` where motPasse=? and email=?");	
			st.setString(1, MotPasse);
			st.setString(2,Login);
			ResultSet rs= st.executeQuery();
			ArrayList<IdUser_IdRole> ListId =new ArrayList<IdUser_IdRole>();
			while(rs.next()){
				IdUser_IdRole IdUserRole=new IdUser_IdRole(rs.getInt("id_User"),rs.getString("id_role"));
				ListId .add(IdUserRole);
			}
			return ListId;
		}
		public 	ArrayList<Formation>RechercheFormationVille (String Vile)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from formation where Ville=?");
			st.setString(1, Vile);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Formation> l =new ArrayList<Formation>();
			while(rs.next()){
				Formation f=new Formation(rs.getInt("id_formation"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getString("image"),rs.getInt("id_cat"),rs.getString("Date_Debut"),rs.getString("Date_Fin"),rs.getInt("id_SousCat"),rs.getInt("id_User"),rs.getString("adresse"),rs.getInt("Tel"),rs.getString("Ville"));
				l.add(f);
				

			}
			return l;
				}
		public 	ArrayList<Formation> SelectFormationUser (int id_user)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from formation where id_User=?");
			st.setInt(1, id_user);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Formation> l =new ArrayList<Formation>();
			while(rs.next()){
				Formation f=new Formation(rs.getInt("id_formation"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getString("image"),rs.getInt("id_cat"),rs.getString("Date_Debut"),rs.getString("Date_Fin"),rs.getInt("id_SousCat"),rs.getInt("id_User"),rs.getString("adresse"),rs.getInt("Tel"),rs.getString("Ville"));
				l.add(f);
				

			}
			return l;
				}
			
		public 	ArrayList<slider> SelectAllSlider ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from slider");
			ResultSet rs= st.executeQuery();
			
			ArrayList<slider> l =new ArrayList<slider>();
			while(rs.next()){
slider			s=new slider( rs.getInt("id_slider"),rs.getString("name"),rs.getString("image"));
l.add(s);
				

			}
			return l;
				}	
		public 	ArrayList<slider> SelectPub (int id)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from Pub WHERE ID_Pub=?");
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			
			ArrayList<slider> l =new ArrayList<slider>();
			while(rs.next()){
		slider			s=new slider( rs.getInt("ID_Pub"),rs.getString("nom"),rs.getString("Image"));
		l.add(s);
				

			}
			return l;
				}
		
		public 	ArrayList<slider> SelectAllPub ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("select * from Pub");
			ResultSet rs= st.executeQuery();
			
			ArrayList<slider> l =new ArrayList<slider>();
			while(rs.next()){
		slider			s=new slider( rs.getInt("ID_Pub"),rs.getString("nom"),rs.getString("Image"));
		l.add(s);
				

			}
			return l;
				}
		public 	ArrayList<CV> SelectCV (int id_employeur)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `cv` WHERE `id_User`=? ");
			st.setInt(1, id_employeur);

			ResultSet rs= st.executeQuery();
			ArrayList<CV> ListCV =new ArrayList<CV> ();
			while(rs.next()){
				CV cv =new CV(Integer.parseInt(rs.getString("id_cv")),rs.getString("CV"));
				ListCV.add(cv);
			}
			return ListCV;
				}
		public 	ArrayList<Cours> SelectCours ()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `cours`");
			ResultSet rs= st.executeQuery();
			ArrayList<Cours> ListCours =new ArrayList<Cours>();
			while(rs.next()){
			Cours cours =new Cours(rs.getInt("id_cours"),rs.getString("name"),rs.getString("image"),rs.getString("pdf"),rs.getString("Description"),rs.getInt("id_catCours"));
			ListCours.add(cours);
			}return ListCours;
			}
		public 	ArrayList<Cours> SelectCoursId (int id)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `cours` Where id_cours=? ");
			st.setInt(1,id);

			ResultSet rs= st.executeQuery();
			ArrayList<Cours> ListCours =new ArrayList<Cours>();
			while(rs.next()){
				Cours cours =new Cours(rs.getInt("id_cours"),rs.getString("name"),rs.getString("image"),rs.getString("pdf"),rs.getString("Description"),rs.getInt("id_catCours"));
;
			ListCours.add(cours);
			}return ListCours;
			
			}
		public 	ArrayList<Cours> SelectCoursIdCat (int idCat)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `cours` Where`id_catCours`=? ");
			st.setInt(1,idCat);

			ResultSet rs= st.executeQuery();
			ArrayList<Cours> ListCours =new ArrayList<Cours>();
			while(rs.next()){
				Cours cours =new Cours(rs.getInt("id_cours"),rs.getString("name"),rs.getString("image"),rs.getString("pdf"),rs.getString("Description"),rs.getInt("id_catCours"));
			ListCours.add(cours);
			}return ListCours;
			}
		public 	ArrayList<Video> SelectVideo()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `Video` ");

			ResultSet rs= st.executeQuery();
			ArrayList<Video> ListVideo =new ArrayList<Video>();
			while(rs.next()){
				Video video =new Video(rs.getInt("id_video"),rs.getString("titre"),rs.getString("image"),rs.getString("video"),rs.getInt("id_catCours"));
			ListVideo.add(video);
			}return ListVideo;
			}
		public 	ArrayList<Video> SelectVideoId(int id_video)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `Video` Where `id_video`=?  ");
st.setInt(1, id_video);
			ResultSet rs= st.executeQuery();
			ArrayList<Video> ListVideo =new ArrayList<Video>();
			while(rs.next()){
				Video video =new Video(rs.getInt("id_video"),rs.getString("titre"),rs.getString("image"),rs.getString("video"),rs.getInt("id_catCours"));
			ListVideo.add(video);
			}return ListVideo;
			}
		public 	ArrayList<Video> SelectVideoIdCat(int id_video)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT *FROM `Video` Where `id_catCours`=?  ");
st.setInt(1, id_video);
			ResultSet rs= st.executeQuery();
			ArrayList<Video> ListVideo =new ArrayList<Video>();
			while(rs.next()){
			Video video =new Video(rs.getInt("id_video"),rs.getString("titre"),rs.getString("image"),rs.getString("video"),rs.getInt("id_catCours"));
			ListVideo.add(video);
			}return ListVideo;
			}

		public 	ArrayList<Reponce> SelectReponceId_Q(int id_Q)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT `id_rep`, `rep`, `resultat`, `id_Q` FROM `reponce`  Where `id_Q`=?  ");
st.setInt(1, id_Q);
			ResultSet rs= st.executeQuery();
			ArrayList<Reponce> ListReponce=new ArrayList<Reponce>();
			while(rs.next()){
				Reponce reponce =new Reponce(rs.getInt("id_rep"),rs.getString("rep"),rs.getString("resultat"),rs.getInt("id_Q"));
				ListReponce.add(reponce);
			}return ListReponce;
			}
		public 	String SelectReponceId(int id)throws SQLException{
			String rep = null ;

			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT `id_rep`, `rep`, `resultat`, `id_Q` FROM `reponce`  Where `id_rep`=?  ");
            st.setInt(1,id);
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				rep= rs.getString("resultat");

			}			return rep;

			}
		public 	int IdQ(int id)throws SQLException{
			String rep = null ;
int s=0;
int id_q=0;
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT `id_Q` FROM `reponce`  Where `id_rep`=?  ");
            st.setInt(1,id);
				ResultSet rs= st.executeQuery();
				while(rs.next()){
				id_q=rs.getInt("id_Q");
				}return id_q;
				}
		public 	int SelectReponceVAlidId(int id)throws SQLException{
			String rep = null ;
int s=0;
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT count(`resultat`) FROM `reponce`  Where `id_Q`=? and resultat=1  ");
            st.setInt(1,id);
				ResultSet rs= st.executeQuery();
				while(rs.next()){
					s=rs.getInt(1);
				}return s;
				}
			
		public 	ArrayList<Question> SelectQuestion(int id_test)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT `id_Q`, `question`, `id_test` FROM `question` WHERE `id_test`=?  ");
st.setInt(1, id_test);
			ResultSet rs= st.executeQuery();
			ArrayList<Question> ListQuestion=new ArrayList<Question>();
			while(rs.next()){
				Question question =new Question(rs.getInt("id_Q"),rs.getString("question"),rs.getInt("id_test"));
				ListQuestion.add(question);
			}return ListQuestion;
			}
		public 	ArrayList<Question> SelectQuestionIdTest(int id_test)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `question` WHERE `id_test`=?  ");
st.setInt(1, id_test);
			ResultSet rs= st.executeQuery();
			ArrayList<Question> ListQuestion=new ArrayList<Question>();
			while(rs.next()){
				Question question =new Question(rs.getInt("id_Q"),rs.getString("question"),rs.getInt("id_test"));
				ListQuestion.add(question);
			}return ListQuestion;
			}
		public 	ArrayList<Question> SelectQuestionIdQuestion(int id_Q)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `question` WHERE `id_Q`=?  ");
st.setInt(1, id_Q);
			ResultSet rs= st.executeQuery();
			ArrayList<Question> ListQuestion=new ArrayList<Question>();
			while(rs.next()){
				Question question =new Question(rs.getInt("id_Q"),rs.getString("question"),rs.getInt("id_test"));
				ListQuestion.add(question);
			}return ListQuestion;
			}
		public 	int SelectQuestionId(String  question,int id_test)throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT `id_Q`, `question`, `id_test` FROM `question` WHERE  `question`=? and `id_test`=?  ");
st.setString(1,question);
st.setInt(2, id_test);
int S=0;
			ResultSet rs= st.executeQuery();
			ArrayList<Question> ListQuestion=new ArrayList<Question>();
			while(rs.next()){
			S	=rs.getInt("id_Q");
			}return S;
			}
		public 	 int  SelectNbQuestion(int id_test)throws SQLException{
			Connection c = SingleConnection.getConnection();
int s=0;
			PreparedStatement st= c.prepareStatement("SELECT count(`id_Q`) FROM `question` WHERE `id_test`=?  ");
st.setInt(1, id_test);
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				s=rs.getInt(1);
			}return s;
			}
		public 	 int  SelectNbCV(int id_User)throws SQLException{
			Connection c = SingleConnection.getConnection();
int s=0;
			PreparedStatement st= c.prepareStatement("SELECT count(*) FROM `cv` WHERE `id_User`=?  ");
st.setInt(1, id_User);
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				s=rs.getInt(1);
			}return s;
			}
		public 	int SelectTestid(String test, String image)throws SQLException{
			Connection c = SingleConnection.getConnection();
			int S=0;
			PreparedStatement st= c.prepareStatement("SELECT * FROM `test` WHERE  test=? and image=? ");
			st.setString(1,test);
			st.setString(2,image);
			ResultSet rs= st.executeQuery();
			
			while(rs.next()){
				S=rs.getInt("id_test");
			}return S;
			}
		public 	ArrayList<Test> SelectTestidTest(int id)throws SQLException{
			Connection c = SingleConnection.getConnection();
			int S=0;
			PreparedStatement st= c.prepareStatement("SELECT * FROM `test` WHERE id_test=?  ");
			st.setInt(1,id);
			ResultSet rs= st.executeQuery();
			
			ArrayList<Test> ListTest=new ArrayList<Test>();
			while(rs.next()){
				Test Test =new Test(rs.getInt("id_test"),rs.getString("test"),rs.getString("Description"),rs.getString("image"));
				ListTest.add(Test);
			}return ListTest;
			}
		public 	ArrayList<Test> SelectTest()throws SQLException{
			Connection c = SingleConnection.getConnection();

			PreparedStatement st= c.prepareStatement("SELECT * FROM `test`  ");
			ResultSet rs= st.executeQuery();
			ArrayList<Test> ListTest=new ArrayList<Test>();
			while(rs.next()){
				Test Test =new Test(rs.getInt("id_test"),rs.getString("test"),rs.getString("Description"),rs.getString("image"));
				ListTest.add(Test);
			}return ListTest;
			}
		
		
}