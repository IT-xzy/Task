package test;

import org.junit.Test;
import util.ALiOssToQiNiuOssUtil;
import util.QiNiuOssToALiOssUtil;

public class TestDemo {
	//测试从阿里云OSS迁移到七牛云
	@Test
	public void testAliOssToQiNiuOss(){
		ALiOssToQiNiuOssUtil aLiOssToQiNiuOssUtil = new ALiOssToQiNiuOssUtil();
		aLiOssToQiNiuOssUtil.moveFile();
	}
	//测试从七牛云迁移到阿里云
	@Test
    public void testQiNiuOssToAliOss(){
		QiNiuOssToALiOssUtil qiNiuOssToALiOssUtil = new QiNiuOssToALiOssUtil();
	    //迁移图片并且把原来OSS的图片删掉
		qiNiuOssToALiOssUtil.moveFile();
	}
}

