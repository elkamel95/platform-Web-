package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class UploadImageParametre {
	public HttpServletRequest request1;
	String ImageName;
	public String Path;
	File file;
	public String Type;
	public UploadImageParametre(String path) {
		super();
		Path = path;

	}

	public ArrayList<String> uploadImage(HttpServletRequest request,ServletFileUpload uploader) throws ServletException{
	ArrayList<String> l =new ArrayList<String>();

	UploadImage U=new UploadImage();
	try {
		System.setProperty( "file.encoding", "UTF-8" );
		String s = "é";
		
		System.out.println(s);
		List<FileItem> fileItemsList = uploader.parseRequest(request);
		Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();

		while(fileItemsIterator.hasNext()){
			FileItem fileItem = fileItemsIterator.next();
			if((fileItem.getString().equals("InsertFormation"))||((fileItem.getString().equals("UpdateFormation")))){
	String filePath = Path + File.separator + "themes"+File.separator +"images"+File.separator+"products";

				file=new File(filePath);
				Type="jpeg";
			}else if ((fileItem.getString().equals("InsertSlider"))||((fileItem.getString().equals("UpdateSlider")))){
	String filePath = Path + File.separator + "themes"+File.separator +"images"+File.separator+"carousel";
	Type="jpeg";

				file=new File(filePath);
			}else if ((fileItem.getString().equals("InsertPub"))||((fileItem.getString().equals("UpdatePub")))){
	String filePath = Path + File.separator + "themes"+File.separator +"images"+File.separator+"Pub";
	Type="jpeg";

				file=new File(filePath);
			}else if ((fileItem.getString().equals("InsertJobOffer"))||((fileItem.getString().equals("UpdateJobOffer")))){
				String filePath = Path + File.separator + "themes"+File.separator +"images"+File.separator+"Job";
				Type="jpeg";

				file=new File(filePath);

			}else			if((fileItem.getString().equals("UploadCV"))){
				String filePath = Path + File.separator + "themes"+File.separator +"CV";
				file=new File(filePath);
				Type="pdf";

			}
			else if ((fileItem.getString().equals("InsertCour"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Cours";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("UpdateCours"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Cours";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("UpdateCoursVideo"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Video";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("InsertVideo"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Video";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("UpdateTest"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Test";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("InsertTest"))){
				String filePath = Path + File.separator + "themes"+File.separator +"Test";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("InsertCategoriApp"))){
				String filePath = Path + File.separator + "themes"+File.separator +"e_learning";

				file=new File(filePath);

			}
			else if ((fileItem.getString().equals("Mis_A_jourCatCours"))){
				String filePath = Path + File.separator + "themes"+File.separator +"e_learning";

				file=new File(filePath);

			}
			if(fileItem.getName()!=null){
				if(fileItem.getContentType().toString().equals("image/bmp")||fileItem.getContentType().toString().equals("image/jpeg")||fileItem.getContentType().toString().equals("image/png")){
					Type="jpeg";

				}else
		if(fileItem.getContentType().toString().equals("application/pdf")){
			Type="pdf";

		}else{
			Type="mp4";

			
		}
			}
			if(fileItem.getName()!=null){

			 ImageName=	U.uploadImage(fileItem.getName(),Type, file,fileItem);	
				l.add(ImageName);

			}else{
				System.setProperty( "file.encoding", "UTF-8" );

					String ItemValue=fileItem.getString();
					ItemValue.replace("Ã", "é");
					ItemValue.replace("©", "");
System.out.println(ItemValue);
				
					l.add(ItemValue);
			}
}

	} catch (FileUploadException e) {
		System.out.println(e);
	} catch (Exception e) {
		System.out.println(e);
	}
	return l;
}}


