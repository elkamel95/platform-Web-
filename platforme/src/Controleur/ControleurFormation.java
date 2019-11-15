

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Entity.CV;
import Entity.CategorieApprontissage;
import Entity.Categrie;
import Entity.Certificat;
import Entity.Cours;
import Entity.Formation;
import Entity.IdUser_IdRole;
import Entity.Job;
import Entity.Message;
import Entity.ModeleAdmin;
import Entity.Question;
import Entity.Reponce;
import Entity.Resultat;
import Entity.SousCategrie;
import Entity.Test;
import Entity.UploadImageParametre;
import Entity.User;
import Entity.UserInfo;
import Entity.Video;
import Entity.modele;
import Entity.slider;

/**
 * Servlet implementation class ControleurFormation
 */
@WebServlet("/ControleurFormation")
public class ControleurFormation extends HttpServlet {
	 int i;
int nbq=0;
	modele modeleFront=new modele();
    private ServletFileUpload uploader = null;
    ModeleAdmin ModeleBack=new ModeleAdmin();
ArrayList<Job> AllJob=new ArrayList<Job> ();
ArrayList<User> ListUser=new ArrayList<User>();
ArrayList<UserInfo> ListUserInfo=new ArrayList<UserInfo>();

	ArrayList<Formation> AllFormation=new ArrayList<Formation>();
	ArrayList<slider> AllSlider=new ArrayList<slider>();
	ArrayList<slider> AllPub=new ArrayList<slider>();
	ArrayList<Categrie> FormationCat=new ArrayList<Categrie>();
	ArrayList<SousCategrie> FormationSousCat=new ArrayList<SousCategrie>();
	ArrayList<Categrie> RecrutementCat=new ArrayList<Categrie>();
	ArrayList<SousCategrie> RecrutementSousCat=new ArrayList<SousCategrie>();
	HttpSession session;
	ArrayList<Job> ListJob=new ArrayList<Job>();
	ArrayList<Resultat> ListResultat;
	ArrayList<Cours> ListCours=new ArrayList<Cours>();
	ArrayList<Message> ListMessage=new ArrayList<Message>();

String resultat;
	private static final long serialVersionUID = 1L;
     
    public static final Charset UTF_8 = Charset.forName("UTF-8");

	
	String contextPath ;
	public void init() throws ServletException{
		
		String s = "é";
	
			System.out.println(s);

			// TODO Auto-generated catch block
		
		ServletContext servletContext = getServletContext();

		contextPath = servletContext.getRealPath("");
		System.out.println(contextPath);
		String absoluteDiskPath = getServletContext().getRealPath("/products");

			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
			File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
			fileFactory.setRepository(filesDir);
			this.uploader = new ServletFileUpload(fileFactory);
			
		}
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurFormation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("page")==null){
			request.setCharacterEncoding("UTF-8");

			session	 = request.getSession();
	try {
		FormationCat=modeleFront.SelectCategorie(1);
		FormationSousCat=modeleFront.SelectSousCategorie(1);
		AllFormation=modeleFront.SelectAllFormation();
		
		AllSlider=modeleFront.SelectAllSlider();
		AllPub=modeleFront.SelectAllPub();


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(session.getAttribute("id_user")==null){
		
	RequestDispatcher r =request.getRequestDispatcher("index.jsp");
	try {
		FormationCat=modeleFront.SelectCategorie(1);
		FormationSousCat=modeleFront.SelectSousCategorie(1);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("listeformation",AllFormation);
	request.setAttribute("listeSlider",AllSlider);
	request.setAttribute("listePub",AllPub);
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("SousCat",FormationSousCat);
	request.setCharacterEncoding("UTF-8");

	r.forward(request, response);

	}else{
		if(	session.getAttribute("id_role").toString().equals("2")){
			int nbCv=0;

		try {

				RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
				ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
				request.setAttribute("ListMessage",ListMessage);

				nbCv=modeleFront.SelectNbCV((int)session.getAttribute("id_user"));
				ListJob	=modeleFront.SelectAllJobUser((int)session.getAttribute("id_user"));
				request.setAttribute("listJob",ListJob);
				request.setAttribute("listePub ",AllPub);
		        request.setAttribute("nbCv",nbCv);
		        int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
				request.setAttribute("nb",nb);
				request.setCharacterEncoding("UTF-8");

				r.forward(request, response);


			}
	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

		else if(	session.getAttribute("id_role").toString().equals("1")){
		RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
		try {
			AllFormation=modeleFront.SelectFormationUser((int)session.getAttribute("id_user"));
			ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
			request.setAttribute("ListMessage",ListMessage);
			int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
			request.setAttribute("nb",nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("listeformation",AllFormation);
        request.setAttribute("listePub",AllPub);
		request.setAttribute("ListMessage ",ListMessage);
		request.setCharacterEncoding("UTF-8");

       r.forward(request, response);

	}else{
		RequestDispatcher r =request.getRequestDispatcher("index.jsp");
	try {
		AllFormation=modeleFront.SelectAllFormation();
		AllSlider=modeleFront.SelectAllSlider();
		AllPub=modeleFront.SelectAllPub();
		FormationCat=modeleFront.SelectCategorie(1);
		FormationSousCat=modeleFront.SelectSousCategorie(1);
		request.setAttribute("listeformation",AllFormation);
		request.setAttribute("listeSlider",AllSlider);
		request.setAttribute("listePub",AllPub);
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("SousCat",FormationSousCat);
		r.forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	
	}
	}
	}else if(request.getParameter("page").equals("Recrutement")){
		RequestDispatcher r =request.getRequestDispatcher("Recrutement.jsp");
try {
	AllJob=modeleFront.SelectAllJob();
	RecrutementCat=modeleFront.SelectCategorie(2);
	RecrutementSousCat=modeleFront.SelectSousCategorie(2);
	AllPub=modeleFront.SelectAllPub();
	AllSlider=modeleFront.SelectAllSlider();
	request.setAttribute("listeSlider",AllSlider);


} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		request.setAttribute("listeJob",AllJob);
		request.setAttribute("listePub",AllPub);

		request.setAttribute("Cat",RecrutementCat);
		request.setAttribute("SousCat",RecrutementSousCat);

		request.setAttribute("listeSlider",AllSlider);	
		r.forward(request, response);

	}
		
	else if(request.getParameter("page").equals("View")){
		try {
			String[] tab = new String[20];
			int i=0;
			ArrayList<Formation> Formation=new ArrayList<Formation>();
int id_formation=Integer.parseInt(request.getParameter("id"));
			Formation=modeleFront.SelectFormation(id_formation);
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(1);
			FormationSousCat=modeleFront.SelectSousCategorie(1);
			request.setAttribute("listePub",AllPub);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);
	

			request.setAttribute("nom",Formation.get(0).getNom());
			request.setAttribute("Descrription",Formation.get(0).getDescrription());
			request.setAttribute("image",Formation.get(0).getImage());
			request.setAttribute("prix",Formation.get(0).getPrix());
			request.setAttribute("Date_Debut",Formation.get(0).getDate_Debut());
			request.setAttribute("Date_Fin",Formation.get(0).getDate_Fin());
			request.setAttribute("Adresse",Formation.get(0).getAdresse());
			request.setAttribute("ville",Formation.get(0).getVille());

			request.setAttribute("Tel",Formation.get(0).getTel());
			request.setAttribute("IdFormateur",Formation.get(0).getId_user());

			String str = Formation.get(0).getDate_Fin();
			StringTokenizer st = new StringTokenizer(str,"/");
			while (st.hasMoreElements()) {
		 tab[i]=		st.nextElement().toString();
				System.out.println(Integer.parseInt(tab[i]));
				i++;
			}
			
			   Date dNow = new Date( );
				 SimpleDateFormat ftyyy = 
					      new SimpleDateFormat ("yyyy");
				 SimpleDateFormat ftdd = 
					      new SimpleDateFormat ("dd");
				 SimpleDateFormat ftmm = 
					      new SimpleDateFormat ("MM");
				 
				 int day=Integer.parseInt(ftdd.format(dNow))-Integer.parseInt(tab[0]);
				 int yyy=Integer.parseInt(ftyyy.format(dNow))-Integer.parseInt(tab[2]);
				 int mm=Integer.parseInt(ftmm.format(dNow))-Integer.parseInt(tab[1]);
if((Integer.parseInt(ftdd.format(dNow))<Integer.parseInt(tab[0]))||(Integer.parseInt(ftyyy.format(dNow))<Integer.parseInt(tab[2]))||(Integer.parseInt(ftmm.format(dNow))<Integer.parseInt(tab[1]))){
int jour=Math.abs(day)+(Math.abs(yyy)*360)+(Math.abs(mm)*30);
					request.setAttribute("date",jour);
}else{
						request.setAttribute("date","0");
	 
}
				 
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("product_details.jsp");
		session	 = request.getSession();

		if(session.getAttribute("id_user")!=null){

		try {

			ListUser=	modeleFront.SelectIdUser((int)session.getAttribute("id_user"));

			request.setAttribute("emailUser", ListUser.get(0).getNom());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		r.forward(request, response);

		
	}
	else if(request.getParameter("page").equals("FormationSousCat")){
		RequestDispatcher r =request.getRequestDispatcher("index.jsp");
		try {
			AllFormation=modeleFront.SelectFormationSousCat(Integer.parseInt(request.getParameter("id_cat")));
			AllSlider=modeleFront.SelectAllSlider();
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(1);
			FormationSousCat=modeleFront.SelectSousCategorie(1);
			request.setAttribute("listeformation",AllFormation);
			request.setAttribute("listeSlider",AllSlider);
			request.setAttribute("listePub",AllPub);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);
			r.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		}
	else if(request.getParameter("page").equals("FormationVille")){
		RequestDispatcher r =request.getRequestDispatcher("index.jsp");
		try {
			AllFormation=modeleFront.RechercheFormationVille(request.getParameter("Ville"));
			AllSlider=modeleFront.SelectAllSlider();
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(1);
			FormationSousCat=modeleFront.SelectSousCategorie(1);
			request.setAttribute("listeformation",AllFormation);
			request.setAttribute("listeSlider",AllSlider);
			request.setAttribute("listePub",AllPub);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);
			r.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		}
	else if(request.getParameter("page").equals("JobSousCat")){
		RequestDispatcher r =request.getRequestDispatcher("Recrutement.jsp");
		try {
			AllJob=modeleFront.SelectSousCatJobUser(Integer.parseInt(request.getParameter("id_cat")));
			AllSlider=modeleFront.SelectAllSlider();
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(2);
			FormationSousCat=modeleFront.SelectSousCategorie(2);
			request.setAttribute("listeSlider",AllSlider);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);

			request.setAttribute("listeJob",AllJob);
			request.setAttribute("listePub",AllPub);

			

			r.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		}
	else if(request.getParameter("page").equals("JobVille")){
		RequestDispatcher r =request.getRequestDispatcher("Recrutement.jsp");
		try {
			AllJob=modeleFront.SelectJobWithcity(request.getParameter("Ville"));
			AllSlider=modeleFront.SelectAllSlider();
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(2);
			FormationSousCat=modeleFront.SelectSousCategorie(2);
			request.setAttribute("listeSlider",AllSlider);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);

			request.setAttribute("listeJob",AllJob);
			request.setAttribute("listePub",AllPub);

			

			r.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		}
		
	else if(request.getParameter("page").equals("RecrutementSousCat")){
		RequestDispatcher r =request.getRequestDispatcher("index.jsp");
		try {
			AllFormation=modeleFront.SelectFormationSousCat(Integer.parseInt(request.getParameter("id_cat")));
			AllSlider=modeleFront.SelectAllSlider();
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(1);
			FormationSousCat=modeleFront.SelectSousCategorie(1);
			request.setAttribute("listeformation",AllFormation);
			request.setAttribute("listeSlider",AllSlider);
			request.setAttribute("listePub",AllPub);
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);
			r.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		}
	else if(request.getParameter("page").equals("InsertFormation")){

		RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
		request.setAttribute("Action", "InsertFormation");
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("Sous","f");

		request.setAttribute("SousCat",FormationSousCat);
		try {
			ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
			 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
				request.setAttribute("nb",nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ListMessage",ListMessage);
		r.forward(request, response);	
	}
	else if(request.getParameter("page").equals("InsertJobOffer")){


		RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
		
		request.setAttribute("Action", "InsertJobOffer");
		try {
			ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
			 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
			 FormationCat=modeleFront.SelectCategorie(2);
				FormationSousCat=modeleFront.SelectSousCategorie(2);
			
				request.setAttribute("Cat",FormationCat);
				request.setAttribute("SousCat",FormationSousCat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

	}
	else if(request.getParameter("page").equals("UpdateJobOfferView")){
		
	}
	else if(request.getParameter("page").equals("UpdateJobOffer")){

		RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
	try {
		ListJob=modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_Job")));
		ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
		 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
			request.setAttribute("nb",nb);
		request.setAttribute("ListMessage",ListMessage);
		 FormationCat=modeleFront.SelectCategorie(2);
			FormationSousCat=modeleFront.SelectSousCategorie(2);
		
			request.setAttribute("Cat",FormationCat);
			request.setAttribute("SousCat",FormationSousCat);
		request.setAttribute("listeJob",ListJob);
		request.setAttribute("Action","UpdateJobOffer");

	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	r.forward(request, response);

	}
		
	else if(request.getParameter("page").equals("index")){
try {
	AllFormation=modeleFront.SelectAllFormation();
	AllSlider=modeleFront.SelectAllSlider();
	AllPub=modeleFront.SelectAllPub();
	FormationCat=modeleFront.SelectCategorie(1);
	FormationSousCat=modeleFront.SelectSousCategorie(1);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	
		RequestDispatcher r =request.getRequestDispatcher("index.jsp");
		request.setAttribute("listeformation",AllFormation);
		request.setAttribute("listeSlider",AllSlider);
		request.setAttribute("listePub",AllPub);
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("SousCat",FormationSousCat);
		r.forward(request, response);

	}
	else if(request.getParameter("page").equals("DeleteAllFormationUser")){
		try {
			AllFormation=	modeleFront.SelectFormationUser((int)session.getAttribute("id_user"));
			for(Formation Format:AllFormation){
			File f=new File("../WebContent/themes/images/products/"+Format.getImage());
			f.delete();
			ModeleBack.DELETEAllFormation((int)session.getAttribute("id_user"));
				ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
				 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
					request.setAttribute("nb",nb);
			request.setAttribute("ListMessage",ListMessage);
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
	r.forward(request, response);

	}
	else if(request.getParameter("page").equals("DeleteAllJob")){
		try {
ListJob=modeleFront.SelectAllJobUser((int)session.getAttribute("id_user"));
for(Job job:ListJob){
	String filePath = contextPath + File.separator + "themes"+File.separator +"images"+File.separator+"Job"+File.separator+job.getImage();
	File f=new  File(filePath);
			f.delete();
			ModeleBack.DELETEAllJobOffer((int)session.getAttribute("id_user"));
				ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
				 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
					request.setAttribute("nb",nb);
			request.setAttribute("ListMessage",ListMessage);
}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
	r.forward(request, response);

	}
	else if(request.getParameter("page").equals("CompteUser")){
			if(	session.getAttribute("id_role").toString().equals("2")){


						RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");

						try {
							ListJob	=modeleFront.SelectAllJobUser((int)session.getAttribute("id_user"));
							ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
							 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
								request.setAttribute("nb",nb);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.setAttribute("listJob",ListJob);
						request.setAttribute("listePub ",AllPub);
						request.setAttribute("ListMessage ",ListMessage);

						r.forward(request, response);

					
					
			
				
			
			}else{
				RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");

					try {
						AllFormation=modeleFront.SelectFormationUser((int)session.getAttribute("id_user"));
						ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
						 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
							request.setAttribute("nb",nb);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// TODO Auto-generated catch block
					
				request.setAttribute("listeformation",AllFormation);
		        request.setAttribute("listePub",AllPub);
				request.setAttribute("ListMessage ",ListMessage);

		       r.forward(request, response);

			}
			
	}
			
			

	
	else if(request.getParameter("page").equals("DELETETraining")){
		try {
			AllFormation=	modeleFront.SelectFormation(Integer.parseInt(request.getParameter("id_formation")));
			File f=new File("../WebContent/themes/images/products/"+AllFormation.get(0).getImage());
f.delete();
			ModeleBack.DELETETraining(Integer.parseInt(request.getParameter("id_formation")));
			RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
r.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}

		
	else 
		if(request.getParameter("page").equals("Mis_A_jourFormationUser")){

		RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
	try {
		AllFormation=modeleFront.SelectFormation(Integer.parseInt(request.getParameter("id_formation")));
		FormationSousCat=modeleFront.SelectSousCategorie();
		request.setAttribute("formation",AllFormation);
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("SousCat",FormationSousCat);
		request.setAttribute("Action", "Mis_A_jourFormationUser");
			ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
			 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
				request.setAttribute("nb",nb);
		request.setAttribute("ListMessage",ListMessage);
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	r.forward(request, response);

	}
	else if(request.getParameter("page").equals("deconnexion")){
			session.invalidate();
RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=index");
			

			r.forward(request, response);
			}
		
	else if(request.getParameter("page").equals("inscription")){

		RequestDispatcher r =request.getRequestDispatcher("inscription.jsp");
		try {
			AllPub=modeleFront.SelectAllPub();
			FormationCat=modeleFront.SelectCategorie(1);
			FormationSousCat=modeleFront.SelectSousCategorie(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listePub",AllPub);
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("SousCat",FormationSousCat);
	request.setAttribute("id_role", request.getParameter("id_role"));	
	r.forward(request, response);

	}

	
	else if(request.getParameter("page").equals("inscriptionUser")){
		ArrayList<IdUser_IdRole> ListeId = new ArrayList<IdUser_IdRole>();

		try {
		    Random randomGenerator = new Random();
		      int id_userRandom = randomGenerator.nextInt(100000);
				if(	Integer.parseInt(request.getParameter("id_role"))==3){

		      ModeleBack.inscritUser(id_userRandom, request.getParameter("email"), request.getParameter("MotPasse"), Integer.parseInt(request.getParameter("id_role")));
			
				}else{
					 ModeleBack.inscritUser(id_userRandom, request.getParameter("email"), request.getParameter("MotPasse"), Integer.parseInt(request.getParameter("id_role")));
						ModeleBack.inscrit(request.getParameter("nom"),request.getParameter("pren"), request.getParameter("MotPasse"), request.getParameter("email"), request.getParameter("Tel"), request.getParameter("Nom_de_lentreprise"),request.getParameter("Adresse") , request.getParameter("Ville"), request.getParameter("Pays"),request.getParameter("Registre_commerce"),id_userRandom,0);	
				
				}
		} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		try {
		 ListeId=	modeleFront.loginUser(request.getParameter("email"),request.getParameter("MotPasse"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id_User=ListeId.get(0).getId_user();
		String id_Role=ListeId.get(0).getId_role();
			session	 = request.getSession();
			session.setAttribute("id_user", id_User);
			session.setAttribute("id_role", id_Role);

		
		

		if(	id_Role.equals("2")){
			RequestDispatcher r1 =request.getRequestDispatcher("CompteUser.jsp");

			try {


					ListJob	=modeleFront.SelectAllJobUser(id_User);
					AllPub=modeleFront.SelectAllPub();

					request.setAttribute("listJob",ListJob);
					request.setAttribute("listePub ",AllPub);
				       r1.forward(request, response);

				
				}
		
			 catch (SQLException e) {
			
				 e.printStackTrace();
			}
		}else if(id_Role.equals("1")){
			RequestDispatcher r1 =request.getRequestDispatcher("CompteUser.jsp");

			try {
				AllFormation=modeleFront.SelectFormationUser(id_User);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("listeformation",AllFormation);
	        request.setAttribute("listePub",AllPub);
		       r1.forward(request, response);

		}else{
			RequestDispatcher r1 =request.getRequestDispatcher("ControleurFormation?page=index");
			r1.forward(request, response);
			
		}

		}
	else if(request.getParameter("page").equals("DELETEJob")){
		try {
			ListJob=	modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_offre")));
			String filePath = contextPath + File.separator + "themes"+File.separator +"images"+File.separator+"Job"+File.separator+ListJob.get(0).getImage();
			
	
			File f=new  File(filePath);
f.delete();
			ModeleBack.DELETEJobOffer(Integer.parseInt(request.getParameter("id_offre")));

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=CompteUser");
	r.forward(request, response);

}
	else if(request.getParameter("page").equals("Recrutement_details")){
		
		try {
		ListJob=modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_Job")));
		RecrutementCat=modeleFront.SelectCategorie(2);
		RecrutementSousCat=modeleFront.SelectSousCategorie(2);
		AllPub=modeleFront.SelectAllPub();
		} catch (NumberFormatException | SQLException e) {


e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Recrutement_details.jsp");
		request.setAttribute("listePub",AllPub);

		request.setAttribute("Cat",RecrutementCat);
		request.setAttribute("SousCat",RecrutementSousCat);
		request.setAttribute("listJob", ListJob);		
		r.forward(request, response);
	}else
		 if(request.getParameter("page").equals("UploadCV")){
			 
			 RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
				ArrayList<CV> ListCV =new ArrayList<CV> ();
				int nbCv=0;
				try {
					ListCV=modeleFront.SelectCV((int)session.getAttribute("id_user"));
						ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
						nbCv=modeleFront.SelectNbCV((int)session.getAttribute("id_user"));
						 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
							request.setAttribute("nb",nb);
					request.setAttribute("ListMessage",ListMessage);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("nbCv",nbCv);		
				request.setAttribute("listCV", ListCV);		

				request.setAttribute("RepCV", "CV");		

				r.forward(request, response);
		 }
		 else
			 if(request.getParameter("page").equals("reservation")){
				 
				 RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
				 String msg="";
					try {
						ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
						 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
							ArrayList<Message> ListRéservation =new ArrayList<Message>();

							ListRéservation=	 modeleFront.MessageId(Integer.parseInt(request.getParameter("idMessage")));						request.setAttribute("nb",nb);
					request.setAttribute("ListMessage",ListMessage);
						request.setAttribute("msg",msg);
						request.setAttribute("ListRéservation",ListRéservation.get(0).getMessage());

						 request.setAttribute("id_user",request.getParameter("id_user"));

						 request.setAttribute("Action","R");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					


					r.forward(request, response);
			 }
		
		 else
			 if(request.getParameter("page").equals("messageRecu")){
				 
				 RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
				 String msg="";
					try {
						ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
						 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
							request.setAttribute("nb",nb);
					request.setAttribute("ListMessage",ListMessage);
						request.setAttribute("msg",msg);
						 request.setAttribute("id_user",request.getParameter("id_user"));
						 request.setAttribute("Action","message");

						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					

					request.setAttribute("RepCV", "CV");		

					r.forward(request, response);
			 }
		
			 
		 else if(request.getParameter("page").equals("Recrutement_details")){
				
				try {
				ListJob=modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_Job")));
				} catch (NumberFormatException | SQLException e) {


		e.printStackTrace();
				}
				RequestDispatcher r =request.getRequestDispatcher("Recrutement_details.jsp");

				request.setAttribute("listJob", ListJob);		
				r.forward(request, response);
			}else
				 if(request.getParameter("page").equals("Delete_CV")){
					 RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=UploadCV");
						try {
							String filePath = contextPath + File.separator + "themes"+File.separator +"CV";
						File	file=new File(filePath);
						file.delete();
							ModeleBack.DeleteCv(Integer.parseInt(request.getParameter("ID_CV")));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					//	request.setAttribute("listCV", ListCV);		
						
						request.setAttribute("RepCV", "CV");		

						r.forward(request, response);
				 }
		
				 else
					 if(request.getParameter("page").equals("cours")){
							
						 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");
									
							request.setAttribute("Id_page", "cours");	
							r.forward(request, response);

						 }
					 
					 else
						 if(request.getParameter("page").equals("Catcours")){
							 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");		
								ArrayList<CategorieApprontissage> CatCours =new ArrayList<CategorieApprontissage>();
try {
	CatCours=modeleFront.SelectCategorieApp(1);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}								request.setAttribute("Id_page", "CategorieCours");		
                                 request.setAttribute("CatCours",CatCours);		
                     	        request.setAttribute("listePub",AllPub);

								r.forward(request, response);
						 }
				
						 else
							 if(request.getParameter("page").equals("Viewcours")){
								 session	 = request.getSession();

								 if(session.getAttribute("id_user")==null){
									 request.setAttribute("Id_page", "cours");	
									 RequestDispatcher r =request.getRequestDispatcher("loginUser.jsp");

										r.forward(request, response);
								 
								 
								 }else{
								 
								 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");		
	ArrayList<Cours> ListCours=new ArrayList<Cours>();
	try {
		ListCours=modeleFront.SelectCoursIdCat(Integer.parseInt(request.getParameter("id_Cat")));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}								request.setAttribute("Id_page", "TableCours");		
	                                 request.setAttribute("ListCours",ListCours);		
	                     	        request.setAttribute("listePub",AllPub);

									r.forward(request, response);
							 }
		
							 }
							
									 else
										 if(request.getParameter("page").equals("video")){
											 session	 = request.getSession();

											 if(session.getAttribute("id_user")==null){
												 request.setAttribute("Id_page", "cours");	
												 RequestDispatcher r =request.getRequestDispatcher("loginUser.jsp");

													r.forward(request, response);
											 
											 
											 }else{
											 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");		
				ArrayList<Video> ListVideo=new ArrayList<Video>();
				try {
					ListVideo=modeleFront.SelectVideoIdCat(Integer.parseInt(request.getParameter("id_Cat")));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}								request.setAttribute("Id_page", "Tablevideo");		
				                                 request.setAttribute("ListVideo",ListVideo);		
				                     	        request.setAttribute("listePub",AllPub);
												r.forward(request, response);

										 }}
										 else
											 if(request.getParameter("page").equals("Catvideo")){
												 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");		
													ArrayList<CategorieApprontissage> CatVideo =new ArrayList<CategorieApprontissage>();
					try {
						CatVideo=modeleFront.SelectCategorieApp(2);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}								
					request.setAttribute("CatVideo", CatVideo);		

					request.setAttribute("Id_page", "CatVideo");		
					                     	        request.setAttribute("listePub",AllPub);

													r.forward(request, response);
											 }
										 else
											 if(request.getParameter("page").equals("ViewVideo")){
												 RequestDispatcher r =request.getRequestDispatcher("e_learning.jsp");		
					ArrayList<Video> ListVideo=new ArrayList<Video>();
					ArrayList<Video> Video=new ArrayList<Video>();

					try {
						ListVideo=modeleFront.SelectVideoIdCat(Integer.parseInt(request.getParameter("id_Cat")));
						Video=modeleFront.SelectVideoId(Integer.parseInt(request.getParameter("id_video")));

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}								request.setAttribute("Id_page", "ViewVideo");		
					                                 request.setAttribute("Video",Video.get(0).getVideo());	
					                                 request.setAttribute("image",Video.get(0).getImage());	
					                                 request.setAttribute("Title",Video.get(0).getTitre());	

					                                 request.setAttribute("ListVideo",ListVideo);		

					                     	        request.setAttribute("listePub",AllPub);

													r.forward(request, response);
											 }
											 else
												 if(request.getParameter("page").equals("Test")){
													 session	 = request.getSession();

													 if(session.getAttribute("id_user")==null){
														 request.setAttribute("Id_page", "cours");	
														 RequestDispatcher r =request.getRequestDispatcher("loginUser.jsp");

															r.forward(request, response);
													 
													 
													 }else{
										 RequestDispatcher r =request.getRequestDispatcher("Test.jsp");		
										ArrayList<Test> ListTest=new ArrayList<Test>();
														
						try {
				
					ListTest=modeleFront.SelectTest();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}								request.setAttribute("Id_page", "Test");		
						                         

						                                 request.setAttribute("ListTest",ListTest);		

						                     	        request.setAttribute("listePub",AllPub);

														r.forward(request, response);
												 }
												 }
												 else
													 if(request.getParameter("page").equals("message")){
														 try {
															 RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");	

														String msg=	ModeleBack.MessageEnvoyer_Admin(request.getParameter("msg"), 1, (int)session.getAttribute("id_user"));
														 request.setAttribute("msg",msg);
														 ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
														 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
															request.setAttribute("nb",nb);
													request.setAttribute("ListMessage",ListMessage);
															r.forward(request, response);

														 } catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}

														 
													 }									
													 else
														 if(request.getParameter("page").equals("TestFinal")){
															 try {
																 RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=Test");	
																 System.out.println(request.getParameter("id_test")+request.getParameter("id_user"));
																ModeleBack.insertcertificat(request.getParameter("Registre_commerce"),Integer.parseInt(request.getParameter("id_test")),Integer.parseInt(request.getParameter("id_user")),request.getParameter("nom"),1);
																 r.forward(request, response);

															 } catch (NumberFormatException | SQLException e) {
																e.printStackTrace();

															}

														 }
						 else if(request.getParameter("page").equals("Reserver")){
							 RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");	

								String msg;
								try {
									msg = ModeleBack.MessageEnvoyer_User(request.getParameter("Reservation"), 3, Integer.parseInt(request.getParameter("id_User")));
							
								 request.setAttribute("msg",msg);

								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							request.setAttribute("ListMessage",ListMessage);
									r.forward(request, response);
		 }
						 else if(request.getParameter("page").equals("ViewUser")){
								try {
									ListUserInfo=modeleFront.SelectUserId((int)session.getAttribute("id_user"));
									ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
									 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
										request.setAttribute("nb",nb);
								} catch (NumberFormatException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");


								request.setAttribute("ListMessage",ListMessage);
								request.setAttribute("ListUserInfo", ListUserInfo);

								request.setAttribute("Action", "ViewUser");

							r.forward(request, response);

							}
						 else if(request.getParameter("page").equals("mis_a_jourUser")){
							 try {
								ModeleBack.UpdatUser((int)session.getAttribute("id_user"), request.getParameter("email"),request.getParameter("motPasse"));
								 ModeleBack.UpdatUserAgen(request.getParameter("nom"), request.getParameter("pren"), request.getParameter("motPasse"), request.getParameter("email"), Integer.parseInt(request.getParameter("tel")),request.getParameter("Nom_de_lentreprise"),request.getParameter("Adresse") , (int)session.getAttribute("id_user"));
								 ListUserInfo=modeleFront.SelectUserId((int)session.getAttribute("id_user"));
									ListMessage=modeleFront.Message((int)session.getAttribute("id_user"));
									 int nb=modeleFront.MessageNB((int)session.getAttribute("id_user"));
										request.setAttribute("nb",nb);
										
							 } catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");


								request.setAttribute("ListMessage",ListMessage);
								request.setAttribute("ListUserInfo", ListUserInfo);

								request.setAttribute("Action", "ViewUser");

							r.forward(request, response);
						 }
	
		
		}
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int reponce=0;
	

		UploadImageParametre UploadImageParametre1=new UploadImageParametre(contextPath);
		ArrayList<String> l=UploadImageParametre1.uploadImage(request,uploader);
		 if(l.get(0).equals("UploadCV")){
			 
					try {
						ModeleBack.deposit(l.get(1),Integer.parseInt(l.get(2)));
						RequestDispatcher r =request.getRequestDispatcher("Recrutement_details.jsp");
						request.setAttribute("rep","votre cv a envoyer avec succès");

r.forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		 }else

		 if(l.get(0).equals("InsertFormation")){
		try {
			System.out.println(l.get(1).replace("Ã©", "é"));
		int rep=	ModeleBack.ajoutFormation(l.get(1),l.get(14),Float.parseFloat(l.get(4)),l.get(15),Integer.parseInt(l.get(2)),l.get(5),l.get(6),l.get(7),l.get(8),l.get(9),l.get(10),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(16)),l.get(12),Integer.parseInt(l.get(13)),l.get(11));
		   if(rep!=0){
				RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
				
				request.setAttribute("Action", "InsertFormation");
				request.setAttribute("Cat",FormationCat);
				request.setAttribute("SousCat",FormationSousCat);
				request.setAttribute("msg","Inseration avec Sucsse");

				r.forward(request, response);
		   }else {
			   
			   
				request.setAttribute("msg","Operation non valider");
   
		   }

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
	}
		 else
				
				if(l.get(0).equals("verification_compte")){
					try {
						String Email=l.get(1);
						String pass=l.get(2);
						ArrayList<IdUser_IdRole> ListeId = new ArrayList<IdUser_IdRole>();
					 ListeId=	modeleFront.loginUser(Email,pass);
					 System.out.println(ListeId.isEmpty());
					 if(!(ListeId.isEmpty())){
						 System.out.println("dsfsdf");
 
int id_User=ListeId.get(0).getId_user();
int id_Role=Integer.parseInt(ListeId.get(0).getId_role());

					if(id_Role !=0){
						session	 = request.getSession();
				session.setAttribute("id_user", id_User);
				session.setAttribute("id_role", id_Role);
				ListUserInfo= modeleFront.SelectUserId(id_User);
				ListUserInfo.get(0).getValidation();
				session.setAttribute("validation", ListUserInfo.get(0).getValidation());

				doGet(request,response);
	
						}else{
							request.setAttribute("rep","Incorrect login or mot passe");
							try {
								AllFormation=modeleFront.SelectAllFormation();
								AllSlider=modeleFront.SelectAllSlider();
								AllPub=modeleFront.SelectAllPub();
								FormationCat=modeleFront.SelectCategorie(1);
								FormationSousCat=modeleFront.SelectSousCategorie(1);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
									
								
									RequestDispatcher r =request.getRequestDispatcher("index.jsp");
									request.setAttribute("listeformation",AllFormation);
									request.setAttribute("listeSlider",AllSlider);
									request.setAttribute("listePub",AllPub);
									request.setAttribute("Cat",FormationCat);
									request.setAttribute("SousCat",FormationSousCat);
									r.forward(request, response);


						}
					 }else{
							request.setAttribute("rep","Incorrect login or mot passe");
							try {
								AllFormation=modeleFront.SelectAllFormation();
								AllSlider=modeleFront.SelectAllSlider();
								AllPub=modeleFront.SelectAllPub();
								FormationCat=modeleFront.SelectCategorie(1);
								FormationSousCat=modeleFront.SelectSousCategorie(1);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
									
								
									RequestDispatcher r =request.getRequestDispatcher("index.jsp");
									request.setAttribute("listeformation",AllFormation);
									request.setAttribute("listeSlider",AllSlider);
									request.setAttribute("listePub",AllPub);
									request.setAttribute("Cat",FormationCat);
									request.setAttribute("SousCat",FormationSousCat);
									r.forward(request, response);

					 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	

				}

				 else if(l.get(0).equals("UpdateFormation")){
						try {
							System.out.println(l.get(1).replace("Ã", "é").replace("©", ""));
String nom=l.get(1).replace("Ã", "é").replace("©", "");
							AllFormation=	modeleFront.SelectFormation(Integer.parseInt(l.get(10)));
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(l.get(8));

						System.out.println(l.size());

for(String s: l){

	System.out.println(s);
}				

if(l.size()==13){

	File f=new File("WebContent/themes/images/products/"+AllFormation.get(0).getImage());
	f.delete();
try {
	Character ch = Character.MIN_VALUE;

System.out.println("idformation"+l.get(10));
System.out.println("idUser"+l.get(10));
String nom=l.get(1).replace("Ã", "é").replace('©', '\u0000');

int rep=	ModeleBack.UPDATETraining(l.get(1),l.get(9),Float.parseFloat(l.get(4)),l.get(12) ,Integer.parseInt(l.get(2)),l.get(5),l.get(6),Integer.parseInt(l.get(10)),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(11)),l.get(7),Integer.parseInt(l.get(8)));
} catch (NumberFormatException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}else{

	try {
		ModeleBack.UPDATETraining(l.get(1),l.get(9),Float.parseFloat(l.get(4)),AllFormation.get(0).getImage(),Integer.parseInt(l.get(2)),l.get(5),l.get(6),Integer.parseInt(l.get(10)),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(11)),l.get(7),Integer.parseInt(l.get(8)));
	} catch (NumberFormatException | SQLException e) {
		e.printStackTrace();
	}

	
}
					doGet(request,response);


				   

				

			}
				 else
						if(l.get(0).equals("InsertJobOffer")){
							try {
								System.out.println(l.get(1));
							int rep=	ModeleBack.ajoutOffreEmploi(l.get(1).getBytes("US-ASCII").toString(),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7), l.get(10), Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));
							   if(rep!=0){
									RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");
									request.setAttribute("Action", "InsertJobOffer");

								r.forward(request, response);
							   }

							} catch (NumberFormatException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}


						
						}
		 
						else if(l.get(0).equals("UpdateJobOffer")){
							try {
								ListJob=	modeleFront.SelectJob( Integer.parseInt(l.get(11)));
							} catch (NumberFormatException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}



						if(l.size()==13){
							String filePath = contextPath + File.separator + "themes"+File.separator +"images"+File.separator+"Job"+File.separator+ListJob.get(0).getImage();
														File f=new  File(filePath);
							f.delete();
					try {
						ModeleBack.updateOffreEmploi(l.get(1),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7), l.get(12), Integer.parseInt(l.get(10)),Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));	
			} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						}else{

							try {
								ModeleBack.updateOffreEmploi(l.get(1),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7),ListJob.get(0).getImage(), Integer.parseInt(l.get(10)),Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));		

							} catch (NumberFormatException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							
						}
						RequestDispatcher r =request.getRequestDispatcher("CompteUser.jsp");

					r.forward(request, response);


					

				}
						else if(l.get(0).equals("test")){
							reponce=1;
							int verife=0;
							int reponseValider = 0;
							int resultateValider=0;

							for (String S:l){
try {
	if(! S.equals("test")){
		System.out.println(S);
		verife++;
	resultat=modeleFront.SelectReponceId(Integer.parseInt(S));

 reponseValider=modeleFront.SelectReponceVAlidId( modeleFront.IdQ(Integer.parseInt(S)));
	reponce=(reponce*Integer.parseInt(resultat) );
	resultateValider=resultateValider+reponce;
	System.out.println(reponseValider);
	}
} catch (NumberFormatException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}							}
							System.out.println("reponcefinale"+reponce);

							nbq++;
if(reponseValider!=resultateValider){
	
	reponce=0;	

	
}	
	if(verife==0){
		reponce=0;	
	}

							if(reponce==1){
							Resultat e=new Resultat(reponce,"True");
							ListResultat.add(e);
							}else{
							Resultat e=new Resultat(reponce,"False");
							ListResultat.add(e);
								
							}	
int id=(int)session.getAttribute("id_test");
System.out.println("i="+i);	
int nbquestion = 0;
try {
	nbquestion = modeleFront.SelectNbQuestion(id);
	System.out.println("nbquestion="+nbquestion);	

} catch (NumberFormatException | SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
									
									if(nbquestion-1>=i){

										 RequestDispatcher r =request.getRequestDispatcher("Test.jsp");		
											ArrayList<Test> ListTest=new ArrayList<Test>();
											ArrayList<Question> ListQuestion=new ArrayList<Question>();
											ArrayList<Reponce> ListReponce=new ArrayList<Reponce>();
	
					try {
				ListTest=modeleFront.SelectTest();
			    ListQuestion=modeleFront.SelectQuestion(id)	;
				ListReponce=modeleFront.SelectReponceId_Q(ListQuestion.get(i).getId_Q());
					} catch (SQLException e) {
						e.printStackTrace();
					}						
					
					request.setAttribute("Id_page", "ViewTest");		
					                       
					                                 request.setAttribute("ListTest",ListTest.get(0));		
					                                 request.setAttribute("ListQuestion",ListQuestion.get(i).getQuestion());	

					                                 request.setAttribute("ListReponce",ListReponce);		

					                     	        request.setAttribute("listePub",AllPub);
													i++;

					                     			r.forward(request, response);							


							
						}else{
							 RequestDispatcher r =request.getRequestDispatcher("CertificatTest.jsp");	
	                  	        request.setAttribute("ListResultat",ListResultat);
	                  	        int s=0;
for (Resultat res :ListResultat){
	s=s+res.getRes();
	
}
double resultpourcentage=s*100/nbquestion;
if(resultpourcentage>=70){
	  request.setAttribute("resultmsg","votre test a été réalisé avec succès");
	  request.setAttribute("adresse","AdresseTrue");
}else{
	  request.setAttribute("resultmsg"," test échoué");
	
	
}
  request.setAttribute("resultpourcentage",resultpourcentage);
  request.setAttribute("adresse","AdresseFalse");

								 
	                 			r.forward(request, response);							

								
								
							}
									
						}
						 else
							 if(l.get(0).equals("ViewTest")){
					 RequestDispatcher r =request.getRequestDispatcher("Test.jsp");		
					ArrayList<Test> ListTest=new ArrayList<Test>();
					ArrayList<Question> ListQuestion=new ArrayList<Question>();
					ArrayList<Reponce> ListReponce=new ArrayList<Reponce>();

	try {

ListTest=modeleFront.SelectTest();
ListQuestion=modeleFront.SelectQuestion(Integer.parseInt(l.get(1)))	;
ListReponce=modeleFront.SelectReponceId_Q(ListQuestion.get(0).getId_Q());
	} catch (SQLException e) {
		e.printStackTrace();
	}						
	session	 = request.getSession();

	session.setAttribute("id_test",Integer.parseInt(l.get(1)));
	request.setAttribute("Id_page", "ViewTest");		
	                       
	                                 request.setAttribute("ListTest",ListTest.get(0));		
	                                 request.setAttribute("ListQuestion",ListQuestion.get(0).getQuestion());	
	                                 request.setAttribute("id_Q",ListQuestion.get(0).getId_Q());		

	                                 request.setAttribute("ListReponce",ListReponce);		
	                                 ListResultat =new ArrayList<Resultat>();

	                     	        request.setAttribute("listePub",AllPub);
i=1;
									r.forward(request, response);
							 }
								else
									if(l.get(0).equals("deconnexion")){
									session.invalidate();
						RequestDispatcher r =request.getRequestDispatcher("ControleurFormation?page=index");
									

									r.forward(request, response);
									}


	}
	


}
