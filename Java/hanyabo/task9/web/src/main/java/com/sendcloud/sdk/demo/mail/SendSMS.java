package com.sendcloud.sdk.demo.mail;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.exception.SmsException;
import com.sendcloud.sdk.model.SendCloudSms;
import com.sendcloud.sdk.util.ResponseData;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class SendSMS {

	public static void send() throws ClientProtocolException, IOException, SmsException {
		SendCloudSms sms = new SendCloudSms();
		sms.setMsgType(0);
		sms.setTemplateId(948);
		sms.addPhone("12345678911,12345678910");
		sms.addVars("company", "爱发信");
		sms.addVars("date", "2016.04.02");

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendSms(sms);

		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}

	public static void main(String[] args) throws Throwable {
		send();
	}
}
