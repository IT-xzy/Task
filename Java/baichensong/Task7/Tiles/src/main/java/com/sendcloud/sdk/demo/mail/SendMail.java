package com.sendcloud.sdk.demo.mail;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.*;
import com.sendcloud.sdk.model.TextContent.ScContentType;
import com.sendcloud.sdk.util.ResponseData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendMail {
	private String cc;
	private String bcc;
	private String from;
	private String fromName;
	private String replyTo;
	private String subject;

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	//普通邮件发送 ---------修改
	public  void send_common(String email,String st) throws Throwable {
		MailAddressReceiver receiver = new MailAddressReceiver();
		// 添加收件人
		receiver.addTo(email);
		// 添加抄送
		receiver.addCc(cc);
		// 添加密送
		receiver.addBcc(bcc);

		MailBody body = new MailBody();
		// 设置 From
		body.setFrom(from);
		// 设置 FromName
		body.setFromName(fromName);
		// 设置 ReplyTo
		body.setReplyTo(replyTo);
		// 设置标题
		body.setSubject(subject);
		// 创建文件附件
		body.addAttachments(new File("D:/linyuner.png"));
//		body.addAttachments(new File("D:/2.png"));
		//// 创建流附件
		// body.addAttachments(new FileInputStream(new File("D:/ff.png")));

		TextContent content = new TextContent();
		content.setContent_type(ScContentType.html);
		content.setText(st);

		SendCloudMail mail = new SendCloudMail();
		mail.setTo(receiver);
		mail.setBody(body);
		mail.setContent(content);

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendMail(mail);
		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}



	public static void send_common_advanced() throws Throwable {
		MailAddressReceiver receiver = new MailAddressReceiver();
		// 添加收件人
		receiver.addTo("a@ifaxin.com");
		// 添加抄送
		receiver.addCc("b@ifaxin.com");
		// 添加密送
		receiver.addBcc("c@ifaxin.com");

		MailBody body = new MailBody();
		// 设置 From
		body.setFrom("sendcloud@sendcloud.org");
		// 设置 FromName
		body.setFromName("SendCloud");
		// 设置 ReplyTo
		body.setReplyTo("reply@sendcloud.org");
		// 设置标题
		body.setSubject("来自 SendCloud SDK 的邮件");
		// 创建文件附件
		body.addAttachments(new File("D:/linyuner.png"));

		// 配置 Xsmtpapi 扩展字段
		List<String> toList = new ArrayList<String>();
		toList.add("d@ifaxin.com");
		toList.add("e@ifaxin.com");
		List<String> moneyList = new ArrayList<String>();
		moneyList.add("1000");
		moneyList.add("2000");
		List<String> nameList = new ArrayList<String>();
		nameList.add("a");
		nameList.add("b");
		Map<String, List<String>> sub = new HashMap<String, List<String>>();
		sub.put("%name%", nameList);
		sub.put("%money%", moneyList);
		// 此时, receiver 中添加的 to, cc, bcc 均会失效
		body.addXsmtpapi("to", toList);
		body.addXsmtpapi("sub", sub);
		body.addHeader("SC-Custom-test_key1", "test1");
		body.addHeader("NO-SC-Custom-test_key1", "test2");

		TextContent content = new TextContent();
		content.setContent_type(ScContentType.html);
		content.setText("<html><p>亲爱的 %name%: </p> 您本月的支出为: %money% 元.</p></html>");

		SendCloudMail mail = new SendCloudMail();
		mail.setTo(receiver);
		mail.setBody(body);
		mail.setContent(content);

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendMail(mail);
		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}



	public static void send_template() throws Throwable {
		MailBody body = new MailBody();
		// 设置 From
		body.setFrom("sendcloud@sendcloud.org");
		// 设置 FromName
		body.setFromName("SendCloud");
		// 设置 ReplyTo
		body.setReplyTo("reply@sendcloud.org");
		// 设置标题
		body.setSubject("来自 SendCloud SDK 的邮件");
		// 创建文件附件
		body.addAttachments(new File("D:/linyuner.png"));

		List<String> toList = new ArrayList<String>();
		toList.add("1350356294@qq.com");
//		toList.add("baichensong@outlook.com");
		List<String> moneyList = new ArrayList<String>();
		moneyList.add("1000");
//		moneyList.add("3000");
		List<String> nameList = new ArrayList<String>();
		nameList.add("a");
//		nameList.add("b");
		Map<String, List<String>> sub = new HashMap<String, List<String>>();
		sub.put("%name%", nameList);
//		sub.put("%code%", moneyList);
		// 此时, receiver 中添加的 to, cc, bcc 均会失效
		body.addXsmtpapi("to", toList);
		body.addXsmtpapi("sub", sub);
		body.addHeader("SC-Custom-test_key1", "test1");
		body.addHeader("NO-SC-Custom-test_key1", "test2");

		// 使用邮件模板
		TemplateContent content = new TemplateContent();
		content.setTemplateInvokeName("test_template_active");

		SendCloudMail mail = new SendCloudMail();
		// 模板发送时, 必须使用 Xsmtpapi 来指明收件人; mail.setTo();
		mail.setBody(body);
		mail.setContent(content);

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendMail(mail);
		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}





	public static void send_with_addresslist() throws Throwable {
		AddressListReceiver receiver = new AddressListReceiver();
		// 设置地址列表
		receiver.addTo("liubidatest@maillist.sendcloud.org");

		MailBody body = new MailBody();
		// 设置 From
		body.setFrom("sendcloud@sendcloud.org");
		// 设置 FromName
		body.setFromName("SendCloud");
		// 设置 ReplyTo
		body.setReplyTo("reply@sendcloud.org");
		// 设置标题
		body.setSubject("来自 SendCloud SDK 的邮件");
		// 创建文件附件
		body.addAttachments(new File("D:/1.png"));

		// 使用邮件模板
		TemplateContent content = new TemplateContent();
		content.setTemplateInvokeName("sendcloud_account_bind");

		SendCloudMail mail = new SendCloudMail();
		mail.setTo(receiver);
		mail.setBody(body);
		mail.setContent(content);

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendMail(mail);
		System.out.println(res);
	}

	public static void main(String[] args) throws Throwable {
//	send_common("1350356294@qq.com","123");
		// send_common_advanced();
		 send_template();
		// send_with_addresslist();
	}
}
