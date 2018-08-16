package com.mvc.service.Impl;

import com.mvc.service.SendService;
import com.mvc.third_PartyUtil.SendEmail;
import com.mvc.third_PartyUtil.SendPhone;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;

public class SendImpl implements SendService {

	@Autowired
	SendEmail sendEmail;
	@Autowired
	SendPhone sendPhone;

	@Override
	public HashMap<String, Object> setPhone(String phoneNumber, String verification_code) {
		return sendPhone.setPhone(phoneNumber,verification_code);
	}

	@Override
	public HttpResponse sendEmail(String A, String B, String C) throws IOException{
		return sendEmail.sendEmail(A, B, C);
	}
}
