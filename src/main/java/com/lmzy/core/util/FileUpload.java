package com.lmzy.core.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class FileUpload {
	@Value("${uploadUrl}")
	String uploadUrl;
	public String upLoad(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
		List items = upload.parseRequest(request);
		Iterator itr = items.iterator();
		 while (itr.hasNext()) {
			    FileItem item = (FileItem) itr.next();
			    if (item.isFormField()) {
			     System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
			    } else {
			     if (item.getName() != null && !item.getName().equals("")) {
			      System.out.println("上传文件的大小:" + item.getSize());
			      System.out.println("上传文件的类型:" + item.getContentType());
			      // item.getName()返回上传文件在客户端的完整路径名称
			      System.out.println("上传文件的名称:" + item.getName());

			      File tempFile = new File(item.getName());
			      System.out.println(item.getName());

			 //上传文件的保存路径
			      File file = new File(uploadUrl, tempFile.getName());
			      item.write(file);
			      return "0";//上传文件成功！
//			      request.setAttribute("upload.message", "上传文件成功！");
			     }else{
			    	 return "1";//没有选择上传文件
//			      request.setAttribute("upload.message", "没有选择上传文件！");
			     }
			    }
			   }
		 return "";
		 }catch(FileUploadException e){
			e.printStackTrace();
			return "3";//失败
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("upload.message", "上传文件失败！");
			return "3";//失败
		}
	}

}
