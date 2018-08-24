package com.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface OssService {

	String updatePhoto(byte[] bytes)throws Exception;
	String updatePhoto(byte[] bytes,String fileName)throws Exception;
	String updatePhoto(InputStream inputStream)throws Exception;
	String updatePhoto(InputStream inputStream,String fileName)throws Exception;
}
