package com.ptteng.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.ptteng.pojo.exception.UnavailableException;
import com.ptteng.pojo.exception.ForbiddenException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    //加密，传入一个对象和有效期
    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch (Exception e) {
            UnavailableException e1 = new UnavailableException("JWT加密失败");
            e1.initCause(e);
            throw e1;
        }
    }

    //解密，传入一个加密后的token字符串和解密后的类型
    public static <T> T unsign(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        final Map<String, Object> claims;
        try {
            claims = verifier.verify(jwt);
        } catch (Exception e) {
            throw new ForbiddenException("非法Token");
        }
        if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
            long exp = (Long) claims.get(EXP);
            long currentTimeMillis = System.currentTimeMillis();
            if (exp > currentTimeMillis) {
                String json = (String) claims.get(PAYLOAD);
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    return objectMapper.readValue(json, classT);
                } catch (IOException e) {
                    throw new UnavailableException("转化为实体类失败：" + classT.getSimpleName());
                }
            }
            throw new ForbiddenException("过期的token信息");
        }
        throw new ForbiddenException("非法token");
    }
}

