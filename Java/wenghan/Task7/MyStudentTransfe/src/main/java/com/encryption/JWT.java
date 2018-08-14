package com.encryption;

import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Student;

public class JWT {
    //密钥
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
    //有效时间
    private static final String EXP = "exp";
    //荷载
    private static final String PAYLOAD = "payload";

    /**
     * get jwt String of object
     * @param object
     *            the POJO object
     * @param maxAge
     *            the milliseconds of life time
     * @return the jwt token
     */
    //生成JWT
    //公有 静态 返回值：String sign:签名 （形参：1：泛型，2：long）
    public static <T> String sign(T object, long maxAge) {
        try {
            //设置密钥
            final JWTSigner signer = new JWTSigner(SECRET);
            //Map集合(字符串：形参1：泛型)
            final Map<String, Object> claims = new HashMap<String, Object>();
            //JSON和对象的转换类
            ObjectMapper mapper = new ObjectMapper();
            //将参数1：泛型，转换为字符串JSON形式
            String jsonString = mapper.writeValueAsString(object);
            //Map集合添加元素：荷载,参数1的泛型
            claims.put(PAYLOAD, jsonString);
            //Map集合添加元素：有效时间,当前时间戳+形参2：有效时间
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            //返回加密后的密钥
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }


    /**
     * get the object of jwt if not expired
     * @param jwt
     * @return POJO object
     */
    //解析JWT，验证JWT，验证成功获得荷载
    //公有 静态 解密钥 参数（参数1：字符串jwt,参数2：泛型类）
    public static<T> T unsign(String jwt, Class<T> classT) {
        //常量：设置密钥
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        final JWTSigner signer = new JWTSigner(SECRET);
        try {
            //常量：Map<字符串：Object> 参数1.解密
            final Map<String,Object> claims= verifier.verify(jwt);
            //如果Map集合中有"EXP"和"PAYLOAD"的键值对
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                //获得当时的时间戳+有效时间
                long exp = (Long)claims.get(EXP);
                //获得当前时间戳
                long currentTimeMillis = System.currentTimeMillis();
                //判断时效是否有效
                if (exp > currentTimeMillis) {
                    //有效的话，获得荷载中的内容
                    String json = (String)claims.get(PAYLOAD);
                    if(signer.sign(claims).equals(jwt)){
                        //对象与JSON转换类
                        ObjectMapper objectMapper = new ObjectMapper();
                        //将荷载中的JSON数据转为形参2：泛型
                        return objectMapper.readValue(json, classT);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Student student=new Student();
        student.setName("希尔瓦娜斯");
        student.setId(1);
        student.setOid(0);

        //将学员对象作为荷载，有效时间30分钟
        String jwt=JWT.sign(student,1000L*60*30);
        //输出jwt
        System.out.println("JWT: "+jwt);

        //解析jwt获得荷载中的对象
        Student s=JWT.unsign(jwt,Student.class);
        //输出对象
        System.out.println("荷载: "+s);
    }
}

