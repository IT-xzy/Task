package com.util.sendcloud.sdk.demo.mail;

import com.util.sendcloud.sdk.builder.SendCloudBuilder;
import com.util.sendcloud.sdk.core.SendCloud;
import com.util.sendcloud.sdk.model.*;
import com.util.sendcloud.sdk.model.TextContent.ScContentType;
import com.util.sendcloud.sdk.util.ResponseData;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendMail {

    //普通邮件
	public static void send_common() throws Throwable {
	    //接收器
		MailAddressReceiver receiver = new MailAddressReceiver();
		// 添加收件人
		receiver.addTo("304584817@qq.com");
		// 添加抄送
		//receiver.addCc("304584817@qq.com");
		// 添加密送
		//receiver.addBcc("304584817@qq.com");

		//邮件体
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
		//body.addAttachments(new File("D:/1.png"));
		//body.addAttachments(new File("D:/2.png"));
		//// 创建流附件
        //body.addAttachments(new FileInputStream(new File("D:/ff.png")));

        //邮件内容
		TextContent content = new TextContent();
		content.setContent_type(ScContentType.html);
		content.setText("<html><p>一封</p></html>");


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

	//高级普通邮件
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
		body.addAttachments(new File("D:/1.png"));

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

	//使用模板邮件
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
		//body.addAttachments(new File("D:/1.png"));


		List<String> toList = new ArrayList<String>();
		toList.add("a@ifaxin.com");
		toList.add("b@ifaxin.com");
		List<String> moneyList = new ArrayList<String>();
		moneyList.add("1000");
		moneyList.add("3000");
		List<String> nameList = new ArrayList<String>();
		nameList.add("a");
		nameList.add("b");
		Map<String, List<String>> sub = new HashMap<String, List<String>>();
		sub.put("%name%", nameList);
		sub.put("%code%", moneyList);
		// 此时, receiver 中添加的 to, cc, bcc 均会失效
		body.addXsmtpapi("to", toList);
		body.addXsmtpapi("sub", sub);
		body.addHeader("SC-Custom-test_key1", "test1");
		body.addHeader("NO-SC-Custom-test_key1", "test2");

		// 使用邮件模板
		TemplateContent content = new TemplateContent();
		content.setTemplateInvokeName("sendcloud_account_bind");

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

	//发送地址
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
		send_common();
		// send_common_advanced();
		// send_template();
		// send_with_addresslist();
	}
}
