package com.right.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


public class UploadAction {
	private File uploadImage;
	private String uploadImageContentType;
	private String uploadImageFileName;
	public File getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}
	public String getUploadImageContentType() {
		return uploadImageContentType;
	}
	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}
	public String getUploadImageFileName() {
		return uploadImageFileName;
	}
	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	public UploadAction() {
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception {
		
			String realpath = ServletActionContext.getServletContext().getRealPath("/images");
//		System.out.println("realpath  "+realpath);
			File file = new File(realpath);
			if(!file.exists()) file.mkdirs();
			UUID uuid = java.util.UUID.randomUUID();
			FileUtils.copyFile(uploadImage, new File(file,uuid.toString()+".png"));
			return "success";
		
		
		
	}

}
