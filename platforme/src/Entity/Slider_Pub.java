package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Slider_Pub {
	public 	ArrayList<slider> SelectSlider (int id)throws SQLException{
		Connection c = SingleConnection.getConnection();

		PreparedStatement st= c.prepareStatement("select * from slider WHERE id_slider=?");
		st.setInt(1, id);
		ResultSet rs= st.executeQuery();
		
		ArrayList<slider> l =new ArrayList<slider>();
		while(rs.next()){
slider			s=new slider( rs.getInt("id_slider"),rs.getString("name"),rs.getString("image"));
l.add(s);
			

		}
		return l;
			}	
public void  ajoutSlider(String name,String image) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `slider` (`id_slider`, `name`, `image`) VALUES (NULL,?,?)");	
	st.setString(1, name);
	st.setString(2, image);

	st.executeUpdate();
	
	
}
public void  DELETESlider(int idSlider) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `slider` WHERE id_slider=?");	
	st.setInt(1, idSlider);

	st.executeUpdate();
	
	
}
public void  DELETEAllSlider() throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `slider` ");	

	st.executeUpdate();
	
	
}
public void  UpdateSlider(String name,String image,int id_slider) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `slider` SET `name`=?,`image`=? WHERE id_slider=?");	
	st.setString(1, name);
	st.setString(2, image);
	st.setInt(3, id_slider);

	st.executeUpdate();
	
	
}
//Pub
public void  ajoutPub(String name,String image) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("INSERT INTO `pub` (`ID_Pub`, `nom`, `Image`)  VALUES (NULL,?,?)");	
	st.setString(1, name);
	st.setString(2, image);

	st.executeUpdate();
	
	
}
public void  UpdatePub(String name,String image,int id_slider) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("UPDATE `pub` SET `nom`=?,`Image`=? WHERE ID_Pub=?");	
	st.setString(1, name);
	st.setString(2, image);
	st.setInt(3, id_slider);

	st.executeUpdate();
	
	
}

	

public void  DELETEPub(int idSlider) throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE FROM `Pub` WHERE ID_Pub=?");	
	st.setInt(1, idSlider);

	st.executeUpdate();
	
	
}
public void  DELETEAllPub() throws SQLException{
	Connection c = SingleConnection.getConnection();

	PreparedStatement st= c.prepareStatement("DELETE  FROM `Pub` ");	

	st.executeUpdate();
	
	
}

}

