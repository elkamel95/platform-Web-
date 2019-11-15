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
 * Servlet implementation class autoDiveMessage
 */
@WebServlet("/autoDiveMessage")
public class autoDiveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	modele modeleFront=new modele();
	ArrayList<Message> ListMessage=new ArrayList<Message>();
	int nbMessage;
	int NbInvite;	
	ArrayList<UserInfo> ListUserInfo=new ArrayList<UserInfo>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autoDiveMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("");
PrintWriter out =	response.getWriter();
try {
			ListMessage=modeleFront.MessageAdmin();
			ListUserInfo=modeleFront.UserValidation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
int s=(ListMessage.size()-1);
	out.println(ListMessage.get(s).getMessage());
		

		}	
@SuppressWarnings("null")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("");
PrintWriter out =	response.getWriter();
try {
		ListUserInfo=modeleFront.UserValidation();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
int s=(ListUserInfo.size()-1);
out.println(ListUserInfo.get(s).getEmail());
}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

