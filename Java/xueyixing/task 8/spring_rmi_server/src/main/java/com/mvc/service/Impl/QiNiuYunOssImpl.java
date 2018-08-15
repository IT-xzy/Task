package com.mvc.service.Impl;

import com.mvc.service.OssService;
import com.mvc.third_PartyUtil.QiNiuYunOssAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class QiNiuYunOssImpl implements OssService {
	@Autowired
	QiNiuYunOssAPI qiNiuYunOssAPI;
	@Override
	public String updatePhoto(byte[] bytes)throws Exception {
		InputStream input = new ByteArrayInputStream(bytes);
		return qiNiuYunOssAPI.updatePhoto(input);
	}
	@Override
	public String updatePhoto(byte[] bytes,String fileName)throws Exception {
		InputStream input = new ByteArrayInputStream(bytes);
		return qiNiuYunOssAPI.updatePhoto(input,fileName);
	}
	@Override
	public String updatePhoto(InputStream inputStream)throws Exception{
		return qiNiuYunOssAPI.updatePhoto(inputStream);
	}
	@Override
	public String updatePhoto(InputStream inputStream,String fileName)throws Exception{
		return qiNiuYunOssAPI.updatePhoto(inputStream,fileName);
	}
}
