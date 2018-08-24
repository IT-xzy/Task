package test;

import com.aliyuncs.exceptions.ClientException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Task7Junit {

	@Autowired
	private ALiMassageUtil aLiMassageUtil;

	@Autowired
	private ALiOssToQiNiuOssUtil aLiOssToQiNiuOssUtil;

	@Autowired
	private QiNiuOssToALiOssUtil qiNiuOssToALiOssUtil;

	//测试邮箱
	@Test
    public void testMail() throws IOException, MessagingException {

		List<String> toList = new ArrayList<>();
		toList.add("543043294@qq.com");
		toList.add("827316877@qq.com");

		Map<String, List<String>> subMap = new HashMap<>();
		subMap.put("%email%", toList);
		subMap.put("%name%", new ArrayList<>(Arrays.asList("黄东江 %num1%", "chengxiaoyin %num2%")));

		Map<String, String> sectionMap = new HashMap<>();
		sectionMap.put("%num1%", "哈哈哈哈");
		sectionMap.put("%num2%", "嘻嘻嘻嘻");

		Xsmtpapi xsmtpapi = new Xsmtpapi(toList, subMap, sectionMap);

		String replyTo = "827316877@qq.com";
		SendCloundMailUtil.send( toList.get(0), replyTo, xsmtpapi,"");
	}
	//测试验证码
	@Test
	public void testMassage() throws ClientException {
		aLiMassageUtil.sendMessage("13631781137");
	}
	@Test
	public void testAliMail(){
		ALiMailUtil.sendMail("CH0918@gmail.com");
	}
	//测试阿里云迁移到七牛云
	@Test
	public void testAliOssToQiNiuOss(){
		aLiOssToQiNiuOssUtil.moveFile();
	}
	//测试七牛云迁移到阿里云
	@Test
	public void testQiNiuOssToAliOss(){
	    qiNiuOssToALiOssUtil.moveFile();
	}
}
