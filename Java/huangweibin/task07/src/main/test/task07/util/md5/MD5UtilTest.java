package task07.util.md5;

public class MD5UtilTest {
    // 测试主函数
    public static void main(String args[]) {
        // 原文
        String plaintext = "DingSai";
//        plaintext = "HIHJIJJIJ";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));
        // 获取加盐后的MD5值
        String ciphertext = MD5Util.generate(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, ciphertext));

//          其中任意一次DingSai（加盐之后）字符串的MD5值
        String[] tempSalt = {"163474350557815048611345d7fa4800b95bf5a429943f93",
                "57937ee52c8bc4e45fc7c263788757623740996315e8e40d",
                "61a718e4c15d914504a41d95230087a51816632183732b5a"};
        for (String temp : tempSalt) {
            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
        }
    }
}