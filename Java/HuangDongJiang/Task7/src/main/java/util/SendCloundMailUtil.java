package util;

import com.sun.mail.smtp.SMTPTransport;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SendCloundMailUtil {
	private static final Log log = LogFactory.getLog(ALiMassageUtil.class);
	private static final String SENDCLOUD_SMTP_HOST = "smtp.sendcloud.net";
	private static final int SENDCLOUD_SMTP_PORT = 25;

	private static String getMessage(String reply) {
		String[] arr = reply.split("#");

		String messageId = null;

		if (arr[0].equalsIgnoreCase("250 ")) {
			messageId = arr[1];
		}

		return messageId;
	}

	public static void send( String to, String replyTo, Xsmtpapi xsmtpapi, String fileDir) throws MessagingException,
			IOException {

		// 配置javamail
		final Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", SENDCLOUD_SMTP_HOST);
		props.put("mail.smtp.port", SENDCLOUD_SMTP_PORT);
		props.setProperty("mail.smtp.auth", "true");
		props.put("mail.smtp.connectiontimeout", 1800);
		props.put("mail.smtp.timeout", 6000);
		props.setProperty("mail.mime.encodefilename", "true");

		//加入配置文件信息
		InputStream inputStream = SendCloundMailUtil.class.getClassLoader().getResourceAsStream(
				"sendClound_mail.properties");
		props.load(inputStream);

		Session mailSession = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("sendClound.apiUser"),
						props.getProperty("sendClound.apiKey"));
			}
		});

		SMTPTransport transport = (SMTPTransport) mailSession.getTransport("smtp");

		MimeMessage message = new MimeMessage(mailSession);
		// 发信人
		message.setFrom(new InternetAddress("from@sendcloud.org", "fromname", "UTF-8"));
		// 收件人地址
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// 邮件主题
		message.setSubject("SendCloud java smtp xsmtpapi example", "UTF-8");

		// 设置邮件回复
		message.setReplyTo(new Address[] { new InternetAddress(replyTo) });

		// 设置 xsmtpapi
		log.info(xsmtpapi.toString());
		message.setHeader("X-SMTPAPI", new String(Base64.encodeBase64(xsmtpapi.toString().getBytes())));

		Multipart multipart = new MimeMultipart("alternative");

		// 添加html形式的邮件正文
		String html = "<html><head></head><body>" + "<p>欢迎使用<a href='http://sendcloud.sohu.com'>SendCloud!</a> %email%  %name%</p>" + "</body></html> ";
		BodyPart contentPart = new MimeBodyPart();
		contentPart.setHeader("Content-Type", "text/html;charset=UTF-8");
		contentPart.setHeader("Content-Transfer-Encoding", "base64");
		contentPart.setContent(html, "text/html;charset=UTF-8");
		multipart.addBodyPart(contentPart);

		// 添加附件 ( smtp 方式没法使用文件流 ),fileDir为附件的地址
//		File file = new File(fileDir);
//		BodyPart attachmentBodyPart = new MimeBodyPart();
//		DataSource source = new FileDataSource(file);
//		attachmentBodyPart.setDataHandler(new DataHandler(source));
//		attachmentBodyPart.setFileName(MimeUtility.encodeWord(file.getName()));
//		multipart.addBodyPart(attachmentBodyPart);

		message.setContent(multipart);

		// 连接sendcloud服务器，发送邮件
		transport.connect();
		log.info("建立了连接。。。");
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

		String messageId = getMessage(transport.getLastServerResponse());
		String emailId = messageId + "0$" + to;
		log.info("messageId:" + messageId);
		log.info("emailId:" + emailId);
		transport.close();
	}
}

