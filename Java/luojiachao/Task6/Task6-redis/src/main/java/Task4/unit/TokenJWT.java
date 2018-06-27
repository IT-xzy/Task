package Task4.unit;

import Task4.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenJWT {
    /**
     *  公用密钥，保存在服务器端，客户端是不会知道密钥的，以防被攻击
     */
    public static String SECRET = "LJCZB";


    /**
     * 生成token
     * @param
     * @return
     * @throws Exception
     */
    public static String createToken(User user) throws Exception{
        //签发时间
        Date date = new Date();

        //过期时间 30分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        //声明类型，这里是jwt
        map.put("typ","JWT");
        //声明加密的算法 通常直接使用 HMAC SHA256
        map.put("alg","HS256");
        //创建一个token
        String token = JWT.create()
                .withHeader(map)
                .withClaim("id",Integer.toString(user.getId()))//用户ID
                .withExpiresAt(expireDate)//过期时间
                .withIssuedAt(date)//签发时间
                .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
    }
    /**
     * 解密token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String,Claim> verifyToken(String token) throws Exception{
        //验证 verifier
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录凭证已经失效，请重新登录！");
        }
        return jwt.getClaims();
    }


}

