package com.leo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JavaWebToken {
	
	private static final Logger logger = LogManager.getLogger("mylog");
	
	// 指定签署jwt的算法名
	private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	// 密钥长度要求至少256位，这里使用固定密钥
	private static byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("MyJwtSecret_7786df7fc3a34e26a61c034d5ec8245do3");
	// 转换为密钥对象
	private static Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
	
	// 签发token
	public static String createJWT(Map<String,Object> claims, long ttMillis){
		
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		logger.debug("这里2222222");
		JwtBuilder builder = Jwts.builder()
				.setClaims(claims)  // 设置私有声明
				.setIssuedAt(now)   // 签发时间
				.setIssuer("leo")   // 签发者
				.signWith(signingKey,signatureAlgorithm);
		
		// 设置过期时间（ttMillis为过期时间长度）
		if (ttMillis >= 0){
			long expMillis = nowMillis + ttMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		logger.debug("token签发完毕");
		// 压缩为xxx.xxx.xxx字符串返回
		return builder.compact();
	}
	
	// 解析token
	public static Map<String,Object> parseJWT(String jwt){
		Claims claims = null;
		try {
			// 设置签名密钥，需解析token
			claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody();
		} catch (ExpiredJwtException e) {
			logger.info("token已过期");
			return null;
		} catch (UnsupportedJwtException e) {
			logger.info("不支持此JWT");
			return null;
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			logger.info("签名出现问题");
			return null;
		} catch (IllegalArgumentException e) {
			logger.info("密钥错误");
			return null;
		}
		
		// Claims继承了Map,使用Map可以方便地将我们私有声明内容取出来。当然也可以返回Claims,使用此类可以得到标准声明部分(前提取出的是body,而不是head),要取出私有声明内容可以使用get("key",String.class) 如果value是String类型那个。
		return claims;
	}
	
/*	public static void main(String[] args) {
		// 编写私有声明
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("id", "123");
		claims.put("username", "sunleo");
		String jwt = createJWT(claims, 3000);
		System.out.println(jwt);
		
		Map<String, Object> map = parseJWT(jwt);
		System.out.println(map.get("id") + "  " + map.get("username"));
	}*/

		/*  输出结果（jwt内部已经帮我们将头部和实体进行了base64编码，并且将编码后的二者使用我们指定的散列算法生成了签名，签名放在最后）
			19:14:19.737 DEBUG mylog - token签发完毕
			eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEyMyIsInVzZXJuYW1lIjoic3VubGVvIiwiaWF0IjoxNTM1ODAwNDU5LCJpc3MiOiJsZW8iLCJleHAiOjE1MzU4MDA0NjJ9.xpPUn_npAXK7MGR7OwlQk4XR16Q3lg8OfSGGvJVROqs
			123  sunleo
		*/
}
