package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    Logger logger = Logger.getLogger(JWTUtil.class);


    /**
     * token秘钥
     */
    private static final String SECRET = "helloworld";
    /**
     * token 过期时间: 10天
     */
    private static final int calendarField = Calendar.DATE;
    private static final int calendarInterval = 10;

    /**
     * @return token
     * @Description 生成Token
     * @Param string
     **/
    public static String createToken(Integer stuID,Long loginTime ) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();
        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map) // header
                .withClaim("stuID",stuID.toString())
                .withClaim("loginTime",loginTime.toString())
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }

    /**
     * @return
     * @Description 解密token
     * @Param token
     **/
   private static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }

    /**
     * @return stuID
     * @Description 获取用户ID
     * @Param token
     **/
    public static Integer getStuID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get("stuID");
        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        return Integer.valueOf(user_id_claim.asString());
    }



    /**
     * @return string类型的loginTime
     * @Description 获取登陆时间
     * @Param
     **/
    public static Long getLogintime(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim logintime_claim = claims.get("loginTime");
        if (null == logintime_claim || StringUtils.isEmpty(logintime_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        return Long.valueOf(logintime_claim.asString());
    }

}
