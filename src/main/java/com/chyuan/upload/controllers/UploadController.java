package com.chyuan.upload.controllers;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.chyuan.upload.utils.UploadUtil;
import com.chyuan.utils.Constants;


@Path("/admin/upload")
public class UploadController {
	@Autowired
	private InvocationLocal inv ;

	/**
	 * 图片上传
	 * @param filedata
	 * @return
	 */
	@Post("/img")
	public Object uploadImg(@Param("filedata") MultipartFile filedata){
		JSONObject json = new JSONObject();
		String msg = "";
		String err = "";
		
		//文件为空
		if(UploadUtil.validateFileEmpty(filedata)){
			err = Constants.MSG_FILE_EMPTY;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		//文件大小
		if(UploadUtil.validateFileSize(filedata, Constants.MAX_IMG_SIZE)){
			err = Constants.MSG_IMG_SIZE;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		try {
			String sufixx = filedata.getOriginalFilename().substring(filedata.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + "." + sufixx;
			UploadUtil.saveFile(filedata, Constants.UPLOAD_IMG_PATH, fileName);
			ServletContext context = inv.getServletContext();
			String filePath = context.getAttribute("domain") + Constants.CONTEXT_IMG_PATH + "/" + fileName;
			msg = filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return UploadUtil.putJSONInfo(msg, err, json);
	}
	
	/**
	 * flash上传
	 * @param filedata
	 * @return
	 */
	@Post("/flash")
	public Object uploadFlash(@Param("filedata") MultipartFile filedata){
		JSONObject json = new JSONObject();
		String msg = "";
		String err = "";
		
		//文件为空
		if(UploadUtil.validateFileEmpty(filedata)){
			err = Constants.MSG_FILE_EMPTY;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		//文件大小
		if(UploadUtil.validateFileSize(filedata, Constants.MAX_FLASH_SIZE)){
			err = Constants.MSG_FLASH_SIZE;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		try {
			String sufixx = filedata.getOriginalFilename().substring(filedata.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + "." + sufixx;
			UploadUtil.saveFile(filedata, Constants.UPLOAD_FLASH_PATH, fileName);
			ServletContext context = inv.getServletContext();
			String filePath = context.getAttribute("domain") + Constants.CONTEXT_FLASH_PATH + "/" + fileName;
			msg = filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return UploadUtil.putJSONInfo(msg, err, json);
	}
	
	/**
	 * media上传
	 * @param filedata
	 * @return
	 */
	@Post("/media")
	public Object uploadMedia(@Param("filedata") MultipartFile filedata){
		JSONObject json = new JSONObject();
		String msg = "";
		String err = "";
		
		//文件为空
		if(UploadUtil.validateFileEmpty(filedata)){
			err = Constants.MSG_FILE_EMPTY;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		//文件大小
		if(UploadUtil.validateFileSize(filedata, Constants.MAX_MEDIA_SIZE)){
			err = Constants.MSG_MEDIA_SIZE;
			return UploadUtil.putJSONInfo(msg, err, json);
		}
		
		try {
			String sufixx = filedata.getOriginalFilename().substring(filedata.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + "." + sufixx;
			UploadUtil.saveFile(filedata, Constants.UPLOAD_MEDIA_PATH, fileName);
			ServletContext context = inv.getServletContext();
			String filePath = context.getAttribute("domain") + Constants.CONTEXT_MEDIA_PATH + "/" + fileName;
			msg = filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return UploadUtil.putJSONInfo(msg, err, json);
	}
}
