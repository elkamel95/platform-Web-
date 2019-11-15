package Controleur;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import test.CategorieApprontissage;
import test.Categrie;
import test.Certificat;
import test.Cours;
import test.Formation;
import test.IdUser_IdRole;
import test.Job;
import test.Message;
import test.ModeleAdmin;
import test.Question;
import test.Reponce;
import test.Slider_Pub;
import test.SousCategrie;
import test.Test;
import test.UploadImageParametre;
import test.User;
import test.UserInfo;
import test.Video;
import test.modele;
import test.slider;

/**
 * Servlet implementation class Admit
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    String ImageName;
public String tab[];
int i=0;
ArrayList<Cours> ListCours=new ArrayList<Cours>();

ModeleAdmin m=new ModeleAdmin();
modele modeleFront=new modele();
Slider_Pub ModeleSliderPub =new Slider_Pub();
ArrayList<Formation> Formation1=new ArrayList<Formation>();
ArrayList<Categrie> FormationCat=new ArrayList<Categrie>();
ArrayList<SousCategrie> FormationSousCat=new ArrayList<SousCategrie>();
ArrayList<Test> ListTest=new ArrayList<Test>();
ArrayList<Question> ListQuestion=new ArrayList<Question>();
ArrayList<Reponce> ListReponce=new ArrayList<Reponce>();
ArrayList<CategorieApprontissage> listeCatCours =new ArrayList<CategorieApprontissage>();

ArrayList<slider>slider=new ArrayList<slider>();
ArrayList<slider> AllSlider=new ArrayList<slider>();
ArrayList<Job> ListJob=new ArrayList<Job>();
ArrayList<Video> ListCoursVideo=new ArrayList<Video>();
HttpSession session;
ArrayList<Message> ListMessage=new ArrayList<Message>();
ArrayList<User> ListUser=new ArrayList<User>();
ArrayList<UserInfo> ListUserInfo=new ArrayList<UserInfo>();
ArrayList<UserInfo> ListAgen=new ArrayList<UserInfo>();

int id_roleCAtegories;
int nbMessage;
String contextPath ;
int NbInvite;
public void init() throws ServletException{
	 id_roleCAtegories=1;

	try {
		FormationCat=modeleFront.SelectCategorie( id_roleCAtegories);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	ServletContext servletContext = getServletContext();

	contextPath = servletContext.getRealPath("");

		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
		
	}
	
@SuppressWarnings("deprecation")
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		ListMessage=modeleFront.MessageAdmin();
		 nbMessage = modeleFront.MessageAdminNB();
			ListUserInfo=modeleFront.UserValidation();
			 NbInvite=modeleFront.MessageInvitationNB();
			 ArrayList<Certificat> l =new ArrayList<Certificat>();
					l=modeleFront.SelectAllCertificat();
					request.setAttribute("listCertificat", l);

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	if(request.getParameter("Id_page")==null){
		session	 = request.getSession(true);
		if(session.getAttribute("login")==null||session.getAttribute("id_roleAdmin")==null){
			RequestDispatcher r =request.getRequestDispatcher("Login.jsp");
			r.forward(request, response);
			}else if((int)session.getAttribute("id_roleAdmin")==0){
				RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
				
					request.setAttribute("nbInvite",NbInvite);

					request.setAttribute("nb",nbMessage);
					request.setAttribute("ListUserInfo",ListUserInfo);

					request.setAttribute("ListMessage",ListMessage);

					r.forward(request, response);
				
				
			
				
			}else if((int)session.getAttribute("id_roleAdmin")!=0){
				System.out.println("sdf");
				RequestDispatcher r =request.getRequestDispatcher("Login.jsp");
				request.setAttribute("msg","D�sol�, nous ne reconnaissons pas cette adresse mail.Suivant");
				r.forward(request, response);	
			}
			
		
	}else if(request.getParameter("Id_page").equals("DELETETraining")){
		try {
			Formation1=	modeleFront.SelectFormation(Integer.parseInt(request.getParameter("id")));
			File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/products/"+Formation1.get(0).getImage());
f.delete();
			m.DELETETraining(Integer.parseInt(request.getParameter("id")));

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAll");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

}
	else  if(request.getParameter("Id_page").equals("ViewAllCategorieCours")){
		RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
		request.setAttribute("Id_page","ViewAllCategoriesCours");
		try {
			listeCatCours=modeleFront.SelectCategorieApp(Integer.parseInt(request.getParameter("IdRole")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ListeCatCours",listeCatCours);
		r.forward(request, response);
	}
	else  if(request.getParameter("Id_page").equals("message")){
		RequestDispatcher r =request.getRequestDispatcher("MessageAdmin.jsp");
		try {
			ListUserInfo=modeleFront.SelectUserId( Integer.parseInt(request.getParameter("id_user")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		request.setAttribute("email",ListUserInfo.get(0).getEmail());
		request.setAttribute("nom",ListUserInfo.get(0).getNomUser());

		request.setAttribute("id_user",request.getParameter("id_user"));
		request.setAttribute("msg",request.getParameter("msg"));
		r.forward(request, response);

	 }
	
	else  if(request.getParameter("Id_page").equals("Activation")){
		RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
		try {
			m.ValidationUser(Integer.parseInt(request.getParameter("id_user")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		r.forward(request, response);

	 }
	else  if(request.getParameter("Id_page").equals("Envoyermessage")){
		RequestDispatcher r =request.getRequestDispatcher("MessageAdmin.jsp");
		String msg;
		try {
			msg = m.MessageEnvoyer_User(request.getParameter("msg"), 1, Integer.parseInt(request.getParameter("id_user")));
			request.setAttribute("email",request.getParameter("email"));
			request.setAttribute("nom",request.getParameter("nom"));
			request.setAttribute("msg",msg);
			 request.setAttribute("id_user",request.getParameter("id_user"));
				request.setAttribute("nbInvite",NbInvite);

				request.setAttribute("nb",nbMessage);
				request.setAttribute("ListUserInfo",ListUserInfo);

				request.setAttribute("ListMessage",ListMessage);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.forward(request, response);

	 }
	else  if(request.getParameter("Id_page").equals("EnvoyermessageUser")){
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllUser");
		String msg;
		try {
			msg = m.MessageEnvoyer_User(request.getParameter("msg"), 1, Integer.parseInt(request.getParameter("id_user")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.forward(request, response);

	 }
	else if(request.getParameter("Id_page").equals("DELETEJob")){
		try {
			ListJob=	modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_offre")));
			
			String filePath = contextPath + File.separator + "themes"+File.separator +"images"+File.separator+"Job"+File.separator+ListJob.get(0).getImage();
			File f=new  File(filePath);
			f.delete();
			m.DELETEJobOffer(Integer.parseInt(request.getParameter("id_offre")));

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllJob");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

}

	
	else if(request.getParameter("Id_page").equals("DeleteAll")){
	try {
		Formation1=	modeleFront.SelectFormationUser(0);
		for(Formation Format:Formation1){
		File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/products/"+Format.getImage());
		f.delete();
		m.DELETEAllFormation(0);
		}
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAll");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("DeleteAllJob")){
		try {
ListJob=modeleFront.SelectAllJobUser(Integer.parseInt(request.getParameter("id_user")));	
for(Job job:ListJob){
	String filePath = contextPath + File.separator + "themes"+File.separator +"images"+File.separator+"Job"+File.separator+job.getImage();
	File f=new  File(filePath);
			f.delete();
			m.DELETEAllJobOffer(Integer.parseInt(request.getParameter("id_user")));;
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllJob");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

	}
	else if(request.getParameter("Id_page").equals("ViewAll")){
	modele M=new modele();

	ArrayList<Formation> AllFormation=new ArrayList<Formation>();

		try {
			AllFormation=M.SelectAllFormation();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listeformation",AllFormation);
	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
	request.setAttribute("listeformation",AllFormation);
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("Id_page","ViewAllFormation");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("ViewAllJob")){


		try {
		ListJob=	modeleFront.SelectAllJobUser(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listeJob",ListJob);
		request.setAttribute("Id_page","ViewAllJob");

	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("ViewAllCours")){

		RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");

		try {
			ListCours=modeleFront.SelectCours();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.setAttribute("Id_page", "TableCours");		
	 request.setAttribute("ListCours",ListCours);		
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
          r.forward(request, response);
								 

}
	else if(request.getParameter("Id_page").equals("ViewAllVideo")){

		RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
		try {
			ListCoursVideo=modeleFront.SelectVideo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.setAttribute("Id_page", "TableVideo");		
	 request.setAttribute("ListCours",ListCoursVideo);		
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
          r.forward(request, response);
								 

}
	else if(request.getParameter("Id_page").equals("DELETECours")){
		try {
			ListCours=modeleFront.SelectCoursId(Integer.parseInt(request.getParameter("id_cours")));
			
			String filePath = contextPath + File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getImage();
			File f=new  File(filePath);
			f.delete();
			String filePath2 = contextPath + File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getPdf();
			File f2=new  File(filePath2);
			f2.delete();
			m.DeleteCours(Integer.parseInt(request.getParameter("id_cours")));

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		try {
			ListCours=modeleFront.SelectCours();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.setAttribute("Id_page", "TableCours");		
	 request.setAttribute("ListCours",ListCours);		
          r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("DELETEQuestion")){
		try {
			
			
		
			m.DELETEAllReponseQuestion(Integer.parseInt(request.getParameter("id_Q")));
			m.DELETEQuestion(Integer.parseInt(request.getParameter("id_Q")));
			ListQuestion=modeleFront.SelectQuestion(Integer.parseInt(request.getParameter("id_Test")));
			RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
			request.setAttribute("Id_page", "ViewQuestion");		
			 request.setAttribute("ListQuestion",ListQuestion);
				request.setAttribute("nbInvite",NbInvite);

				request.setAttribute("nb",nbMessage);
				request.setAttribute("ListUserInfo",ListUserInfo);

				request.setAttribute("ListMessage",ListMessage);
		          r.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	else if(request.getParameter("Id_page").equals("DELETETest")){
		try {
			
			
		
			ListQuestion=modeleFront.SelectQuestion(Integer.parseInt(request.getParameter("id_Test")));
			m.DELETETest(Integer.parseInt(request.getParameter("id_Test")));
			m.DELETEQuestionIdTest(Integer.parseInt(request.getParameter("id_Test")));
			for(Question Itemid_Q:ListQuestion){
			m.DELETEAllReponseQuestion(Itemid_Q.getId_Q());
			}
			ListTest=modeleFront.SelectTest();

			RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
			request.setAttribute("nbInvite",NbInvite);

			request.setAttribute("nb",nbMessage);
			request.setAttribute("ListUserInfo",ListUserInfo);

			request.setAttribute("ListMessage",ListMessage);
			request.setAttribute("Id_page", "ViewTest");		
			 request.setAttribute("ListTest",ListTest);		
		          r.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	else if(request.getParameter("Id_page").equals("DELETECoursVideo")){
		try {
			ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(request.getParameter("id_cours")));
			
			String filePath = contextPath + File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getImage();
			System.out.println(filePath);
			File f=new  File(filePath);
			f.delete();
			String filePath2 = contextPath + File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getVideo();
			File f2=new  File(filePath2);
			System.out.println(filePath2);

			f2.delete();
			m.DELETECoursVideo (Integer.parseInt(request.getParameter("id_cours")));

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
		try {
			ListCoursVideo=modeleFront.SelectVideo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.setAttribute("Id_page", "TableVideo");		
	 request.setAttribute("ListCours",ListCoursVideo);		
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
          r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("InsertFormation")){
	try {
		FormationCat=modeleFront.SelectCategorie(1);
		FormationSousCat=modeleFront.SelectSousCategorie(1);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("SousCat",FormationSousCat);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);

	request.setAttribute("Id_page", "InsertFormation");

r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("InsertCour")){
		ArrayList<CategorieApprontissage> CatCours =new ArrayList<CategorieApprontissage>();

	try {
		CatCours=modeleFront.SelectCategorieApp(1);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
	request.setAttribute("Cat",CatCours);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Id_page", "InsertCour");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("InsertJobOffer")){
	try {
		FormationCat=modeleFront.SelectCategorie(2);
		FormationSousCat=modeleFront.SelectSousCategorie(2);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
	
	request.setAttribute("Id_page", "InsertJobOffer");
	request.setAttribute("nbInvite",NbInvite);
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("SousCat",FormationSousCat);
	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);

}


else if(request.getParameter("Id_page").equals("InsertSlider")){
	RequestDispatcher r =request.getRequestDispatcher("InsertSlider.jsp");
	request.setAttribute("Id_page", "InsertSlider");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

	
}
else if(request.getParameter("Id_page").equals("InsertPub")){
	RequestDispatcher r =request.getRequestDispatcher("InsertSlider.jsp");
	request.setAttribute("Id_page", "InsertPub");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

	
}
else if(request.getParameter("Id_page").equals("Mis_A_jour")){

	RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
try {
	Formation1=modeleFront.SelectFormation(Integer.parseInt(request.getParameter("id_formation")));
	FormationSousCat=modeleFront.SelectSousCategorie(1);

	request.setAttribute("formation",Formation1);
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("SousCat",FormationSousCat);
	request.setAttribute("Action","UpdateFormation");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
} catch (NumberFormatException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
r.forward(request, response);

}	
else if(request.getParameter("Id_page").equals("UpdateJobOffer")){

	RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
try {
	ListJob=modeleFront.SelectJob(Integer.parseInt(request.getParameter("id_Job")));
	try {
		Formation1=modeleFront.SelectFormation(Integer.parseInt(request.getParameter("id_Job")));
		FormationSousCat=modeleFront.SelectSousCategorie(2);



	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	request.setAttribute("formation",Formation1);
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("SousCat",FormationSousCat);

	request.setAttribute("listeJob",ListJob);
	request.setAttribute("Action","UpdateJobOffer");

} catch (NumberFormatException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewAllSlider")){
	modele M=new modele();


		try {
			AllSlider=M.SelectAllSlider();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("ViewSlider.jsp");
	request.setAttribute("AllSlider",AllSlider);
	request.setAttribute("Id_page","ViewSlider");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewAllTestQuestion")){


		try {
			ListQuestion=modeleFront.SelectQuestionIdTest(Integer.parseInt(request.getParameter("id_Test")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
    request.setAttribute("ListQuestion",ListQuestion);		
	request.setAttribute("Id_page","ViewQuestion");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("UpdateQuestion")){


	try {
		ListQuestion=modeleFront.SelectQuestionIdQuestion(Integer.parseInt(request.getParameter("id_Q")));
		ListReponce=modeleFront.SelectReponceId_Q(Integer.parseInt(request.getParameter("id_Q")));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
request.setAttribute("ListQuestion",ListQuestion);	
request.setAttribute("ListReponce",ListReponce);		

request.setAttribute("Action","UpdateQuestion");
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);
 r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewAllTest")){


	try {
		ListTest=modeleFront.SelectTest();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
request.setAttribute("ListTest",ListTest);		
request.setAttribute("Id_page","ViewTest");
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);
 r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("UpdateTest")){


	try {
		ListTest=modeleFront.SelectTestidTest(Integer.parseInt(request.getParameter("id_Test")));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
request.setAttribute("ListTest",ListTest);		
request.setAttribute("Action","UpdateTest");
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);
 r.forward(request, response);

}
	
else if(request.getParameter("Id_page").equals("ViewAllPub")){
	modele M=new modele();


		try {
			AllSlider=modeleFront.SelectAllPub();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("ViewSlider.jsp");
	request.setAttribute("AllSlider",AllSlider);
	request.setAttribute("Id_page","ViewPub");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("Mis_A_jourSlider")){

try {
	slider=ModeleSliderPub.SelectSlider(Integer.parseInt(request.getParameter("id_Slider")));

} catch (NumberFormatException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Slider.jsp");
request.setAttribute("slider",slider);
request.setAttribute("Id_page","UpdateSlider");
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("Mis_A_jourPub")){

try {
	slider=modeleFront.SelectPub(Integer.parseInt(request.getParameter("id_Pub")));

} catch (NumberFormatException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Slider.jsp");
request.setAttribute("slider",slider);
request.setAttribute("Id_page","UpdatePub");
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);

r.forward(request, response);

}

else
	if(request.getParameter("Id_page").equals("DELETESlider")){
		try {
slider= ModeleSliderPub.SelectSlider(Integer.parseInt(request.getParameter("id_Slider")));
File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/carousel/"+slider.get(0).getImage());
f.delete();
ModeleSliderPub.DELETESlider(Integer.parseInt(request.getParameter("id_Slider")));
} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllSlider");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);
	}
	else
		if(request.getParameter("Id_page").equals("Delletereponse")){
			try {
			m.DELETEReponse(Integer.parseInt(request.getParameter("id_rep")));
	
	} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				ListQuestion=modeleFront.SelectQuestionIdQuestion(Integer.parseInt(request.getParameter("id_Q")));
				ListReponce=modeleFront.SelectReponceId_Q(Integer.parseInt(request.getParameter("id_Q")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
		request.setAttribute("ListQuestion",ListQuestion);	
		request.setAttribute("ListReponce",ListReponce);		
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		request.setAttribute("Action","UpdateQuestion");

		 r.forward(request, response);
		}
	else
		if(request.getParameter("Id_page").equals("DELETEPub")){
			try {
	slider= modeleFront.SelectPub(Integer.parseInt(request.getParameter("id_Pub")));
	File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/Pub/"+slider.get(0).getImage());
	f.delete();
	ModeleSliderPub.DELETEPub(Integer.parseInt(request.getParameter("id_Pub")));
	} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllPub");
		r.forward(request, response);
		}
		else if(request.getParameter("Id_page").equals("DeleteAllPub")){
			try {
				slider= modeleFront.SelectAllPub();
				for(slider s:slider){
					System.out.println(s.getImage());
				File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/Pub/"+s.getImage());
				f.delete();
				

				}
				ModeleSliderPub.DELETEAllPub();

			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllPub");
			request.setAttribute("nbInvite",NbInvite);

			request.setAttribute("nb",nbMessage);
			request.setAttribute("ListUserInfo",ListUserInfo);

			request.setAttribute("ListMessage",ListMessage);
			r.forward(request, response);
		}

	
	else if(request.getParameter("Id_page").equals("DeleteAllSlider")){
		try {
			slider= modeleFront.SelectAllSlider();
			for(slider s:slider){
				System.out.println(s.getImage());
			File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/carousel/"+s.getImage());
			f.delete();
			

			}
			ModeleSliderPub.DELETEAllSlider();

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllSlider");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		r.forward(request, response);
	}
	else if(request.getParameter("Id_page").equals("ViewCategories")){
		modele M=new modele();
		if(request.getParameter("id_role")==null){
			id_roleCAtegories=1;
		}else{
			
			id_roleCAtegories=Integer.parseInt(request.getParameter("id_role"));

		}

		

			try {
				FormationCat=modeleFront.SelectCategorie(id_roleCAtegories);


			} catch (SQLException e) {
				e.printStackTrace();
			}
		RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
		request.setAttribute("AllCatAndSousCat",FormationCat);
		request.setAttribute("Id_page","ViewCategories");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	     r.forward(request, response);

	}
	else if(request.getParameter("Id_page").equals("ViewSousCategories")){
		modele M=new modele();

		if(request.getParameter("id_role")==null){
			id_roleCAtegories=1;
		}else{
			
			id_roleCAtegories=Integer.parseInt(request.getParameter("id_role"));

		}

		
			try {
				FormationCat=modeleFront.SelectCategorie(id_roleCAtegories);
			FormationSousCat=modeleFront.SelectSousCategorie(id_roleCAtegories);

				

			} catch (SQLException e) {
				e.printStackTrace();
			}
		RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
		request.setAttribute("AllCatAndSousCat",FormationSousCat);
		request.setAttribute("Cat",FormationCat);
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		request.setAttribute("Id_page","ViewSousCategories");

	     r.forward(request, response);

	}
	else if(request.getParameter("Id_page").equals("InsertCategories")){


	
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");

	request.setAttribute("Id_page","InsertCategories");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("InsertSousCategories")){


		try {
FormationCat=modeleFront.SelectCategorie(Integer.parseInt(request.getParameter("id_role")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("id_role",Integer.parseInt(request.getParameter("id_role")));
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Id_page","InsertSousCategories");

     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("AjoutCategories")){


		try {
m.AjoutCategori(request.getParameter("nomCategorie"),Integer.parseInt(request.getParameter("id_role")))  ;     
		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("Id_page","InsertCategories");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("AjoutSousCategories")){


		try {
m.AjoutSousCategori(request.getParameter("nomCategorie"),Integer.parseInt(request.getParameter("Categ")),Integer.parseInt(request.getParameter("id_role"))) ;
FormationCat=modeleFront.SelectCategorie(Integer.parseInt(request.getParameter("id_role")));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("Id_page","InsertSousCategories");
	request.setAttribute("Cat",FormationCat);
	request.setAttribute("id_role",Integer.parseInt(request.getParameter("id_role")));
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("DELETECategories")){
		try {
			m.DeleteCategories(Integer.parseInt(request.getParameter("id_Categorie")));
			FormationCat=modeleFront.SelectCategorie(Integer.parseInt(request.getParameter("id_role")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("AllCatAndSousCat",FormationCat);

	request.setAttribute("Id_page","ViewCategories");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("DELETESousCategorie")){
		try {
			m.DeleteSousCategories(Integer.parseInt(request.getParameter("id_SousCategorie")));
			FormationSousCat=modeleFront.SelectSousCategorie(Integer.parseInt(request.getParameter("id_role")));

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("AllCatAndSousCat",FormationSousCat);
	request.setAttribute("Cat",FormationCat);

	request.setAttribute("Id_page","ViewSousCategories");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);
	}
	else if(request.getParameter("Id_page").equals("Mis_A_jourCategories")){


			try {
				System.out.println(request.getParameter("nomCategorie"));
           m.UpdateCategori(Integer.parseInt(request.getParameter("id_Categorie")),request.getParameter("nomCategorie"));
           FormationCat=modeleFront.SelectCategorie(id_roleCAtegories);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
		request.setAttribute("AllCatAndSousCat",FormationCat);

		request.setAttribute("Id_page","ViewCategories");
System.out.println(id_roleCAtegories);
request.setAttribute("nbInvite",NbInvite);

request.setAttribute("nb",nbMessage);
request.setAttribute("ListUserInfo",ListUserInfo);

request.setAttribute("ListMessage",ListMessage);
	     r.forward(request, response);

	}
	else if(request.getParameter("Id_page").equals("Mis_A_jourSousCategories")){


		try {
       m.UpdateSousCategori(Integer.parseInt(request.getParameter("id_SousCategorie")),request.getParameter("nomSousCategorie"),Integer.parseInt(request.getParameter("Categ")));
       FormationSousCat=modeleFront.SelectSousCategorie();
       FormationCat=modeleFront.SelectCategorie(id_roleCAtegories);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	RequestDispatcher r =request.getRequestDispatcher("cat�gories.jsp");
	request.setAttribute("AllCatAndSousCat",FormationSousCat);
	request.setAttribute("Cat",FormationCat);

	request.setAttribute("Id_page","ViewSousCategories");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
     r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("inscription")){
		try {
m.inscrit(request.getParameter("nom"),request.getParameter("pren"), request.getParameter("MotPasse"), request.getParameter("email"), request.getParameter("Tel"), request.getParameter("Nom_de_lentreprise"),request.getParameter("Adresse") , request.getParameter("Ville"), request.getParameter("Pays"), request.getParameter("Registre_commerce"),Integer.parseInt(request.getParameter("id_role")),0);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher r =request.getRequestDispatcher("Admin?Id_page=ViewAllJob");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

}
	else if(request.getParameter("Id_page").equals("Mis_A_jourCatCours")){
		RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");
		request.setAttribute("Action","UpdateCatCours");
		try {
			listeCatCours=modeleFront.SelectCategorieAppID(Integer.parseInt(request.getParameter("id_Cat")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ListCatCours",listeCatCours);

		r.forward(request, response);
	}

	else if(request.getParameter("Id_page").equals("InsertCatCour")){
		RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
		request.setAttribute("Id_page", "InsertCategoriesCours");
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
		r.forward(request, response);

	
		}
		else if(request.getParameter("Id_page").equals("InsertVideo")){
			
		RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");

		ArrayList<CategorieApprontissage> CatCours =new ArrayList<CategorieApprontissage>();

			try {
				CatCours=modeleFront.SelectCategorieApp(2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.setAttribute("Id_page", "InsertVideo");
		request.setAttribute("Cat", CatCours);
		request.setAttribute("nbInvite",NbInvite);

		request.setAttribute("nb",nbMessage);
		request.setAttribute("ListUserInfo",ListUserInfo);

		request.setAttribute("ListMessage",ListMessage);
	r.forward(request, response);

	}
		else if(request.getParameter("Id_page").equals("InsertTest")){
			
			RequestDispatcher r =request.getRequestDispatcher("EditeTest.jsp");

			request.setAttribute("nbInvite",NbInvite);

			request.setAttribute("nb",nbMessage);
			request.setAttribute("ListUserInfo",ListUserInfo);

			request.setAttribute("ListMessage",ListMessage);
			request.setAttribute("Id_page", "InsertTest");

		r.forward(request, response);

		}
	

else if(request.getParameter("Id_page").equals("InsertQuestion")){
	
	RequestDispatcher r =request.getRequestDispatcher("EditeQuestion.jsp");

	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Id_page", "InsertQuestion");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("UpdateCours")){
	try {
		ListCours=modeleFront.SelectCoursId(Integer.parseInt(request.getParameter("id_cours")));
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");

	request.setAttribute("ListCours", ListCours);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Action", "UpdateCours");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("UpdateCoursVideo")){
	try {
		ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(request.getParameter("id_cours")));
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("Mis_A_jour_Formation.jsp");

	request.setAttribute("ListCours", ListCoursVideo);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Action", "UpdateCoursVideo");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewAllUser")){
	try {
		ListAgen=modeleFront. SelectAgen ();
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");

	request.setAttribute("ListUser", ListAgen);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Id_page", "ViewAllUser");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewUser")){
	try {
		ListUserInfo=modeleFront.SelectUserId(Integer.parseInt(request.getParameter("id_user")));
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("ListUserInfo", ListUserInfo);

	request.setAttribute("Id_page", "ViewUser");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("ViewAdmin")){
	System.out.println("dddddddd");
	try {
		ListUser=modeleFront.SelectIdUser(0);
		ListMessage=modeleFront.Message((int)session.getAttribute("id_admin"));
		 int nb=modeleFront.MessageNB((int)session.getAttribute("id_admin"));
			request.setAttribute("nb",nb);
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");


	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("ListUser", ListUser);

	request.setAttribute("Id_page", "ViewUserAdmin");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("mis_a_jourUser")){
 try {
	m.UpdatUser(0, request.getParameter("email"),request.getParameter("motPasse"));
m.UpdatUserAdmin(0, request.getParameter("email"),request.getParameter("motPasse"));	
ListUser=modeleFront.SelectIdUser(0);
request.setAttribute("ListUser", ListUser);

		ListMessage=modeleFront.Message(0);
		 int nb=modeleFront.MessageNB(0);
			request.setAttribute("nb",nb);
			
 } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");


	request.setAttribute("ListMessage",ListMessage);

	request.setAttribute("Id_page", "ViewUserAdmin");

r.forward(request, response);
}
else if(request.getParameter("Id_page").equals("DeleteUser")){
	try {
		m.DELETEUser(Integer.parseInt(request.getParameter("id_user")));
		
		ListUser=modeleFront.SelectUser();

	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");

	request.setAttribute("ListUser", ListUser);
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
	request.setAttribute("Id_page", "ViewAllUser");

r.forward(request, response);

}
else if(request.getParameter("Id_page").equals("DELETEUserV")){
	System.out.println("sssssssssssssssssssssssssssssssssss");
	RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");

	try {
		m.DELETEUser(Integer.parseInt(request.getParameter("id_user")));
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("nbInvite",NbInvite);

	request.setAttribute("nb",nbMessage);
	request.setAttribute("ListUserInfo",ListUserInfo);

	request.setAttribute("ListMessage",ListMessage);
r.forward(request, response);
}else 
	 if(request.getParameter("Id_page").equals("certificat")){
			RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");

		ArrayList<Certificat> l =new ArrayList<Certificat>();
		try {
			l=modeleFront.SelectAllCertificat();
			request.setAttribute("listCertificat", l);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.forward(request, response);
		 }
	 else 
		 if(request.getParameter("Id_page").equals("CertificaUser")){
				RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
				try {
					ArrayList<Certificat> l =new ArrayList<Certificat>();

				l=	modeleFront.SelectCertificatId(Integer.parseInt(request.getParameter("id_user")));
				ListUser=modeleFront.SelectIdUser(l.get(0).getId_user());
				ListTest=	modeleFront.SelectTestidTest(Integer.parseInt(request.getParameter("id_test")));
				System.out.println(ListTest.get(0).getTest());
				request.setAttribute("Adresse", l.get(0).getAdresse_poste());
				request.setAttribute("ListUser", ListUser.get(0).getNom());
				request.setAttribute("Test", ListTest.get(0).getTest());
				request.setAttribute("TestImage", ListTest.get(0).getImage());
				request.setAttribute("nom", l.get(0).getNom());


				request.setAttribute("Id_page", "CertficaUser");

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.forward(request, response);
		 }
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req=request;

		
		UploadImageParametre UploadImageParametre1=new UploadImageParametre(contextPath);
		ArrayList<String> l=UploadImageParametre1.uploadImage(request,uploader);


		 if(l.get(0).equals("InsertFormation")){
		try {
			
		int rep=	m.ajoutFormation(l.get(1),l.get(14),Float.parseFloat(l.get(4)),l.get(15),Integer.parseInt(l.get(2)),l.get(5),l.get(6),l.get(7),l.get(8),l.get(9),l.get(10),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(16)),l.get(12),Integer.parseInt(l.get(13)),l.get(11));
		   if(rep!=0){
				RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
				request.setAttribute("Cat",FormationCat);
				request.setAttribute("SousCat",FormationSousCat);
				request.setAttribute("Id_page","InsertFormation");

				
			r.forward(request, response);
		   }

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
	}else
		if(l.get(0).equals("InsertJobOffer")){
			try {
				
			int rep=	m.ajoutOffreEmploi(l.get(1),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7), l.get(10), Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));
			   if(rep!=0){
					RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
					request.setAttribute("Id_page", "InsertJobOffer");

				r.forward(request, response);
			   }

			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		}
		 
		 else 
		 if(l.get(0).equals("InsertSlider")){
				try {
					
					ModeleSliderPub.ajoutSlider(l.get(1), l.get(2));				
						RequestDispatcher r =request.getRequestDispatcher("InsertSlider.jsp");
						request.setAttribute("Id_page", "InsertSlider");

					r.forward(request, response);
				   

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			
			}
		 
		 else 
			 if(l.get(0).equals("InsertPub")){
					try {
						
						ModeleSliderPub.ajoutPub(l.get(1), l.get(2));				
							RequestDispatcher r =request.getRequestDispatcher("InsertSlider.jsp");
							request.setAttribute("Id_page", "InsertPub");

						r.forward(request, response);
					   

					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				
				}
		 
		 else if(l.get(0).equals("UpdateFormation")){
				try {
					Formation1=	modeleFront.SelectFormation(Integer.parseInt(l.get(10)));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				System.out.println(l.size());

			for(String s : l){
				//System.out.println(s);
			}
			if(l.size()==13){

				File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/products/"+Formation1.get(0).getImage());
				f.delete();
		try {
			System.out.println("idformation"+l.get(10));
			System.out.println("idUser"+l.get(10));

			int rep=	m.UPDATETraining(l.get(1),l.get(7),Float.parseFloat(l.get(4)),l.get(12) ,Integer.parseInt(l.get(2)),l.get(5),l.get(6),Integer.parseInt(l.get(10)),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(11)),l.get(8),Integer.parseInt(l.get(9)));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else{

				try {
		m.UPDATETraining(l.get(1),l.get(7),Float.parseFloat(l.get(4)),Formation1.get(0).getImage(),Integer.parseInt(l.get(2)),l.get(5),l.get(6),Integer.parseInt(l.get(10)),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(11)),l.get(8),Integer.parseInt(l.get(9)));
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}

				
			}
				RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
				request.setAttribute("Cat",FormationCat);
				request.setAttribute("SousCat",FormationSousCat);
				request.setAttribute("Id_page","UpdateFormation");

				
			r.forward(request, response);
		   

		

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
m.updateOffreEmploi(l.get(1),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7), l.get(12), Integer.parseInt(l.get(10)),Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));		
} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else{

				try {
					m.updateOffreEmploi(l.get(1),l.get(2), l.get(3), l.get(4),l.get(5), l.get(6), l.get(7),ListJob.get(0).getImage(), Integer.parseInt(l.get(10)),Integer.parseInt(l.get(11)),Integer.parseInt(l.get(8)),Integer.parseInt(l.get(9)));		

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
				RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
				request.setAttribute("Cat",FormationCat);
				request.setAttribute("SousCat",FormationSousCat);
				request.setAttribute("Id_page","UpdateJobOffer");

			r.forward(request, response);
		   

		

	}
	else if(l.get(0).equals("UpdateSlider")){
		 


		try {
			
			if(l.size()==4){
				slider= ModeleSliderPub.SelectSlider(Integer.parseInt(l.get(2)));
				File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/carousel/"+slider.get(0).getImage());
				f.delete();
				ModeleSliderPub.UpdateSlider(l.get(1),l.get(3),Integer.parseInt(l.get(2)) );
			}else{

				l.add(slider.get(0).getImage());
				ModeleSliderPub.UpdateSlider(l.get(1),l.get(3),Integer.parseInt(l.get(2)) );

				
			}
				RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
				request.setAttribute("AllSlider",AllSlider);

			r.forward(request, response);
		   

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	else if(l.get(0).equals("UpdatePub")){
		 


		try {
			
			if(l.size()==4){
				slider= modeleFront.SelectPub(Integer.parseInt(l.get(2)));
				File f=new File("C:/Users/pc/Desktop/BDExeamen/fohmi/test/WebContent/themes/images/Pub/"+slider.get(0).getImage());
				f.delete();
				ModeleSliderPub.UpdatePub(l.get(1),l.get(3),Integer.parseInt(l.get(2)) );
			}else{

				l.add(slider.get(0).getImage());
				ModeleSliderPub.UpdatePub(l.get(1),l.get(3),Integer.parseInt(l.get(2)) );

				
			}
				RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
				request.setAttribute("AllPub",AllSlider);

			r.forward(request, response);
		   

		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 else 
		 if(l.get(0).equals("InsertCour")){
				try {
					
                      m.insertCour(l.get(1),l.get(2),l.get(3),l.get(4),Integer.parseInt(l.get(5)),1);
					RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
						request.setAttribute("Id_page", "InsertCour");

					r.forward(request, response);
				   

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			
			}
		 else if(l.get(0).equals("UpdateCours")){
			 
			System.out.println( l.size());

					
					if(l.size()==4){
					try {

ListCours=modeleFront.SelectCoursId(Integer.parseInt(l.get(1)));
File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getImage());
File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getPdf());

fFimage.delete();
Fpdf.delete();

	m.updateCoursId(l.get(2),ListCours.get(0).getImage(),ListCours.get(0).getPdf(), l.get(3),Integer.parseInt(l.get(1)));
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
					}else if(l.size()==6){
						System.out.println(("fsdfsd"));

					 if(l.get(4).equals("image")){
						
							try {

		ListCours=modeleFront.SelectCoursId(Integer.parseInt(l.get(1)));
		File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getImage());

		fFimage.delete();
		System.out.println(fFimage);

			m.updateCoursId(l.get(2),l.get(5),ListCours.get(0).getPdf(), l.get(3),Integer.parseInt(l.get(1)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						 
					} else if(l.get(4).equals("pdf")){
					
						try {

							ListCours=modeleFront.SelectCoursId(Integer.parseInt(l.get(1)));
							File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getPdf());

							Fpdf.delete();
							System.out.println(l.get(5));

								m.updateCoursId(l.get(2),ListCours.get(0).getImage(),l.get(5), l.get(3),Integer.parseInt(l.get(1)));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					}else{
						
						try {

							ListCours=modeleFront.SelectCoursId(Integer.parseInt(l.get(1)));
							File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getImage());
							File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Cours"+File.separator +ListCours.get(0).getPdf());

							fFimage.delete();
							Fpdf.delete();
							System.out.println(l.get(5));

								m.updateCoursId(l.get(2),l.get(6),l.get(7), l.get(3),Integer.parseInt(l.get(1)));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						
					}
	
						
					
						RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
						request.setAttribute("AllPub",AllSlider);

					r.forward(request, response);
				   

			

		 }
		 else if(l.get(0).equals("UpdateCoursVideo")){
			 
				System.out.println( l.size());

						
						if(l.size()==3){
						try {

	ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(l.get(1)));
	File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getImage());
	File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getVideo());

	fFimage.delete();
	Fpdf.delete();

m.updateCoursVideo( l.get(2),ListCoursVideo.get(0).getImage(),ListCoursVideo.get(0).getVideo(),Integer.parseInt(l.get(1)))	;
} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
						}else if(l.size()==5){

						 if(l.get(3).equals("image")){
							
								try {

			ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(l.get(1)));
			File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getImage());

			fFimage.delete();

			m.updateCoursVideo( l.get(2),l.get(4),ListCoursVideo.get(0).getVideo(),Integer.parseInt(l.get(1)))	;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							 
						} else if(l.get(3).equals("pdf")){
						
							try {

								ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(l.get(1)));
								File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getVideo());

								Fpdf.delete();

								m.updateCoursVideo( l.get(2),ListCoursVideo.get(0).getImage(),l.get(4),Integer.parseInt(l.get(1)))	;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
						}else{
							
							try {
								System.out.println( l.get(1));

								ListCoursVideo=modeleFront.SelectVideoId(Integer.parseInt(l.get(1)));
								File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getImage());
								File Fpdf=new File(contextPath+File.separator + "themes"+File.separator +"Video"+File.separator +ListCoursVideo.get(0).getVideo());

								fFimage.delete();
								Fpdf.delete();
								System.out.println(l.get(5));

								m.updateCoursVideo( l.get(2),l.get(5),l.get(6),Integer.parseInt(l.get(1)))	;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
							
						}
		
							
						
							RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
							request.setAttribute("AllPub",AllSlider);

						r.forward(request, response);
					   

				

				}
			 
		 
		 else 
			 if(l.get(0).equals("InsertVideo")){
					try {
						
	                      m.insertVideo(l.get(1), l.get(2), l.get(3),Integer.parseInt(l.get(4)));
						RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
							request.setAttribute("Id_page", "InsertVideo");

						r.forward(request, response);
					   

					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				
				}
			 else 
				 if(l.get(0).equals("InsertTest")){
						try {
							
							RequestDispatcher r =request.getRequestDispatcher("EditeQuestion.jsp");
								request.setAttribute("Id_page", "InsertQuestion");
                                m.insertTest(l.get(2), l.get(3),l.get(4));
                            int id_test=    modeleFront.SelectTestid(l.get(1),l.get(3));
							request.setAttribute("id_test",id_test);

							r.forward(request, response);
						   

						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


					
					}
				 else 
					 if(l.get(0).equals("InsertQuestion")){
							try {
								int i=0;

								String rep = null;
								
								String result = null;
								RequestDispatcher r =request.getRequestDispatcher("EditeQuestion.jsp");
									request.setAttribute("Id_page", "InsertQuestion");
	                                m.InsertQuestion( l.get(1), Integer.parseInt(l.get(2)));
	                            int id_q=     modeleFront	.SelectQuestionId(l.get(1), Integer.parseInt(l.get(2)))     ;                     
	                                for(String ListRep :l){
	                                	
if(i>=3){
	if(ListRep.equals("false")){
	result ="0";
	
	
		
	}else if (ListRep.equals("true")){
		result ="1";
	
	}else{
		rep=	ListRep;
		
	}
	System.out.println(result);

	}
if(result!=null&&rep!=null){
	//System.out.println(result);
    m.InsertReply( rep, result, id_q);
    result=null;
    rep=null;
}
i++;
	}
	
	    							request.setAttribute("id_test",Integer.parseInt(l.get(2)));

	                     
	    							request.setAttribute("Id_page","InsertQuestion");
   
								r.forward(request, response);
							   

							} catch (NumberFormatException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}


						
						}
					 else 
						 if(l.get(0).equals("InsertCategoriApp")){
								try {
									
									RequestDispatcher r =request.getRequestDispatcher("InsertionFormation.jsp");
										request.setAttribute("Id_page", "InsertCategoriesCours");
		                                m.AjoutCategoriAppp(l.get(1), l.get(2),Integer.parseInt(l.get(3)));
		                           

									r.forward(request, response);
								   

								} catch (NumberFormatException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}


							
							}
		 if(l.get(0).equals("Mis_A_jourCatCours")){
				try {
					listeCatCours=modeleFront.SelectCategorieAppID(Integer.parseInt(l.get(3)));
					File fFimage=new File(contextPath+File.separator + "themes"+File.separator +"e_learning"+File.separator +listeCatCours.get(0).getImage());

					fFimage.delete();
					RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
					try {
						listeCatCours=modeleFront.SelectCategorieApp(1);
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("ListCatCours",listeCatCours);
						request.setAttribute("Id_page", "ViewAllCategoriesCours");
                     m.updateCatCours(l.get(1), l.get(2),Integer.parseInt(l.get(3)));
                

					r.forward(request, response);
				   

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			
			}
						 else 
							 if(l.get(0).equals("UpdateTest")){
										

									   
			                              
			                        			
			                        			if(l.size()==5){
			                        				  try {
ListTest=modeleFront.SelectTestidTest(Integer.parseInt(l.get(1)))	;

File f=new File(contextPath+File.separator + "themes"+File.separator +"Test"+File.separator +ListTest.get(0).getImage());
			                        				f.delete();
	m.updateTest(l.get(2), l.get(3), l.get(4),Integer.parseInt(l.get(1)))	;		                        				

} catch (NumberFormatException | SQLException e) {
	e.printStackTrace();
}
			                        			

								
								}else{
					try {
						m.updateTest(l.get(2), l.get(3), ListTest.get(0).getImage(),Integer.parseInt(l.get(1)))	;
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		                        			
	                        			
	
									
								}
			 RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");

			try {
				ListTest=modeleFront.SelectTest();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 request.setAttribute("ListTest",ListTest);	
			request.setAttribute("Id_page","ViewTest");

		r.forward(request, response);
		 
}	
							 else 
								 if(l.get(0).equals("UpdateQuestion")){
										try {
											int i=0;
											int idRpe = 0;
											String rep = null;
											
											String result = null;
											 RequestDispatcher r =request.getRequestDispatcher("ViewTableFormation.jsp");
												request.setAttribute("Id_page", "InsertQuestion");
												m.UpdateQuestion(l.get(2),Integer.parseInt(l.get(1)));
				                            int id_q=Integer.parseInt(l.get(1))   ;                     
				                                for(String ListRep :l){
				                                	
			if(i>=3){
				if(ListRep.equals("false")){
				result ="0";
				
				
					
				}else if (ListRep.equals("true")){
					result ="1";
				
				}else{
					 try{
				 idRpe=Integer.parseInt(ListRep);
					    }catch(Exception e ){
					    	rep=	ListRep;
					    }
					
					
				}

				}
			if(result!=null&&rep!=null&&idRpe!=0){
		

m.updateReponse(rep, result, id_q,idRpe);			    
result=null;
rep=null;
idRpe=0;
			}
			i++;
				}
				
				    							//request.setAttribute("id_test",Integer.parseInt(l.get(2)));

				                     
				    							request.setAttribute("Id_page","InsertQuestion");
			   
											r.forward(request, response);
										   

										} catch (NumberFormatException | SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}


									
									}
								 else
										
										if(l.get(0).equals("verification_compte")){
											System.out.println(l.get(1));
											try {
												String login=l.get(1);
												String pass=l.get(2);
												ArrayList<IdUser_IdRole> ListeId = new ArrayList<IdUser_IdRole>();
											 ListeId=	modeleFront.loginUser(login,pass);
											 if(!ListeId.isEmpty() ){
												 if(Integer.parseInt(ListeId.get(0).getId_role())==0){
						int id_User=ListeId.get(0).getId_user();
						int id_Role=Integer.parseInt(ListeId.get(0).getId_role());

												session	 = request.getSession(false);
										session.setAttribute("id_admin", id_User);
										session.setAttribute("id_roleAdmin", id_Role);
										session.setAttribute("login",modeleFront.SelectUserId(id_User));
										RequestDispatcher r =request.getRequestDispatcher("indexAdmin.jsp");
										
                                        r.forward(request, response);
												 }else{
													 
													 
														RequestDispatcher r =request.getRequestDispatcher("Login.jsp");
														request.setAttribute("msg","D�sol�, nous ne reconnaissons pas cette adresse mail.Suivant");
													  
														r.forward(request, response);	 
												 }
											 }else{
												 
												 
													RequestDispatcher r =request.getRequestDispatcher("Login.jsp");
													request.setAttribute("msg","incorrect");
												  
													r.forward(request, response);	 
											 }
								
							
												

												

											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}	

										}
										else if(l.get(0).equals("deconnexion")){
											session.invalidate();
								RequestDispatcher r =request.getRequestDispatcher("Login.jsp");
											

											r.forward(request, response);
											}
		 
	}

}