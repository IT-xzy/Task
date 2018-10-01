package com.mvc.third_PartyUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;

public class SendEmail {
	private String url;
	private String apiUser;
	private String apiKey;
	private String templateInvokeName;
	private String from;
	private String fromName;

	public SendEmail(String url,String apiUser,String apiKey,String templateInvokeName,String from,String fromName){
		this.url = url;
		this.apiUser = apiUser;
		this.apiKey = apiKey;
		this.templateInvokeName = templateInvokeName;
		this.from = from;
		this.fromName = fromName;
	}

	public HttpResponse sendEmail(String A, String B, String C) throws IOException {

		List<String> toList = new ArrayList<String>();
		toList.add(A);

		Map<String, List<String>> subMap = new HashMap<String, List<String>>();
		subMap.put("%url%", new ArrayList<String>(Arrays.asList(B)));
		subMap.put("%name%", new ArrayList<String>(Arrays.asList(C)));

		Xsmtpapi xsmt = new Xsmtpapi(toList, subMap);


		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();

		List params = new ArrayList();
		// 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
		params.add(new BasicNameValuePair("apiUser", apiUser));
		params.add(new BasicNameValuePair("apiKey", apiKey));
		params.add(new BasicNameValuePair("templateInvokeName", templateInvokeName));
		params.add(new BasicNameValuePair("from", from));
		params.add(new BasicNameValuePair("fromName", fromName));
		params.add(new BasicNameValuePair("xsmtpapi", String.valueOf(xsmt)));
		/*params.add(new BasicNameValuePair("to", "xueyixing@jnshu.com"));*/
		/*params.add(new BasicNameValuePair("html", "你太棒了！加油吧！猪猪猪！"));*/

		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		// 请求
		HttpResponse response = httpClient.execute(httpPost);
		// 处理响应
		/*if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
			// 读取xml文档
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		} else {
			System.err.println("error");
		}*/
		/*httpPost.releaseConnection();*/
		return response;
	}
}

class Xsmtpapi {

	List<String> toList;

	Map<String, List<String>> subMap;

	Map<String, String> sectionMap;

	JSONObject x = new JSONObject();

	public Xsmtpapi(List<String> toList) {
		this.toList = toList;
		x.put("to", toList);
	}

	public Xsmtpapi(Map<String, List<String>> subMap) {
		this.subMap = subMap;
		x.put("sub", subMap);
	}

	public Xsmtpapi(List<String> toList, Map<String, List<String>> subMap) {
		this.toList = toList;
		this.subMap = subMap;
		x.put("to", toList);
		x.put("sub", subMap);
	}

	public Xsmtpapi(List<String> toList, Map<String, List<String>> subMap, Map<String, String> sectionMap) {
		this.toList = toList;
		this.subMap = subMap;
		this.sectionMap = sectionMap;
		x.put("to", toList);
		x.put("sub", subMap);
		x.put("section", sectionMap);
	}

	@Override
	public String toString() {
		return x.toString();
	}
}
