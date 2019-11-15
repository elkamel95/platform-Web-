package test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;

public class UploadImage {
public String Name;
public String Type;
public File NameFile;
public FileItem image ;

public String uploadImage(String Name,String Type,File NameFile,org.apache.commons.fileupload.FileItem fileItem ) throws Exception{
	File F= File.createTempFile(Name,"."+Type,NameFile);
	
	fileItem.write(F);	
	
	
	return F.getName();
}
}
