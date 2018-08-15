package com.mvc.service.Impl;

import com.mvc.service.OssService;
import com.mvc.third_PartyUtil.ALiYunOssAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AliYunOssImpl implements OssService {
	@Autowired
	ALiYunOssAPI aliYunOssAPI;
	@Override
	public String updatePhoto(byte[] bytes)throws Exception {
		InputStream input = new ByteArrayInputStream(bytes);
		return aliYunOssAPI.updatePhoto(input);
	}
	@Override
	public String updatePhoto(byte[] bytes,String fileName)throws Exception {
		InputStream input = new ByteArrayInputStream(bytes);
		return aliYunOssAPI.updatePhoto(input,fileName);
	}
	@Override
	public String updatePhoto(InputStream inputStream)throws Exception{
		return aliYunOssAPI.updatePhoto(inputStream);
	}
	@Override
	public String updatePhoto(InputStream inputStream,String fileName)throws Exception{
		return aliYunOssAPI.updatePhoto(inputStream,fileName);
	}
}
