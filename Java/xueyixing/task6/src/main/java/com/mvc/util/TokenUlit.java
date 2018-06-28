/*package com.mvc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.tools.ant.types.selectors.modifiedselector.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUlit {
	public static String getToken(String username) throws IllegalArgumentException,JWTCreationException{
		String token = null;
		//JWT的 header
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		try {
			Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
			token = JWT.create()
					.withHeader(map)                       // Header
					.withIssuer("bai")                     //签发者
					.withClaim("username", username) //payload
					.withExpiresAt(expiresAt)              // 时间戳
					.sign(Algorithm());    //sign  secret是用来加密数字签名的密钥。 私有秘钥     使用了HMAC256加密算法。
		} catch (JWTCreationException exception) {
			//Invalid Signing configuration / Couldn't convert Claims.
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return token;
	}

    *//**
     * 先验证token是否被伪造，然后解码token。
     * @param token 字符串token
	 * @return 解密后的DecodedJWT对象，可以读取token中的数据。*//*

	public DecodedJWT deToken(final String token) {
		DecodedJWT jwt = null;
			// 使用了HMAC256加密算法。
			// mysecret是用来加密数字签名的密钥。
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
					//.withIssuer("auth0")
					.build(); //      Reusable verifier instance
			jwt = verifier.verify(token);
		return jwt;
	}
}*/
