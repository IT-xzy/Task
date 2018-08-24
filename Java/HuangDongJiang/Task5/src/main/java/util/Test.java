package util;

public class Test {
	public static void main(String[] args) {
		try {
			DesUtil desUtil = new DesUtil("JAVAhaha");
			String src = "这是要加密的字符串";
			String src1 = desUtil.encrypt(src);
			String src2 = desUtil.decrypt(src1);
			System.out.println("加密后的数据："+ src1);
			System.out.println("解密后的数据：" + src2);
			System.out.println("DES加密长度：" + src1.length());
//			String md5 = Md5Util.getSaltMD5("haha",null);
//			System.out.println("md5加盐后：" + md5);
//			System.out.println("Md5加密长度：" + md5.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
