package com.task.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JWTHelper {
    //创建固定的密钥
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";

    /**
     * 创建JWT
     * @param object 需要加密的对象
     * @param maxAge
     * @param <T>
     * @return
     */
    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);//将传进来的对象转化为json类型数据
            claims.put(PAYLOAD, jsonString);//将json类型数据存进payload载荷中
            claims.put(EXP, System.currentTimeMillis() + maxAge);//设置过期时间
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
        }

    /**
     * 解密JWT
     * @param jwt cookie中的token
     * @param classT 解密后得到的类
     * @param <T>
     * @return
     */
    public static<T> T unsign(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String, Object> claims = verifier.verify(jwt);
            //判断解密后是否包含exp和payload字段的数据
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long) claims.get(EXP);//将exp字段取出来
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) { //计算是否过期，过期就返回null
                    String json = (String) claims.get(PAYLOAD);//把载荷中的数据取出来
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);//将json赋值为对象返回,注意调用时需要输入实体类.class当作形参
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
