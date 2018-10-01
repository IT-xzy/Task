package com.mvc.service;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;

public interface SendService {
	HashMap<String, Object> setPhone(String phoneNumber, String verification_code);
	HttpResponse sendEmail(String A, String B, String C) throws IOException;
}
