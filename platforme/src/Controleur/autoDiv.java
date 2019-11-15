
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Entity.Message;
import Entity.ModeleAdmin;
import Entity.User;
import Entity.UserInfo;
import Entity.modele;

/**
 * Servlet implementation class autoDiv
 */

@WebServlet("/autoDiv")
public class autoDiv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	modele modeleFront=new modele();
	ArrayList<Message> ListMessage=new ArrayList<Message>();
	int nbMessage;
	int NbInvite;	
	ArrayList<UserInfo> ListUserInfo=new ArrayList<UserInfo>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autoDiv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("");
PrintWriter out =	response.getWriter();
try {
			nbMessage = modeleFront.MessageAdminNB();
			 NbInvite=modeleFront.MessageInvitationNB();
			 modeleFront. CertificaNB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
int res=0;
switch (request.getParameter("type")) {
case "1":
	res=NbInvite;
	out.println(res);
		
break;
case "2":
	res=nbMessage;
	out.println(res);
	break;
case "3":
	try {
		res= modeleFront. CertificaNB();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
;
	out.println(res);
	break;
}}

}
