package com.bt.mtom.ws;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "com.bt.mtom.ws.ImageServer")
public class ImageServerImpl implements ImageServer{

	@Override
	public Image downloadImage(String name) {
		
		try {
			
			File image = new File("e:/" + name);
			return ImageIO.read(image);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return null; 
			
		}
		
	}

	@Override
	public String uploadImage(Image data) {

		if(data!=null){
			try {
				ImageIO.write((RenderedImage) data, "jpg", new File("e:/uploadedImage.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "Upload Successful";
		}
		
		throw new WebServiceException("Upload Failed!");
		
	}

}