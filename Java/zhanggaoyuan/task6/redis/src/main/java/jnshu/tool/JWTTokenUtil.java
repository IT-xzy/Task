//package jnshu.tool;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.util.StringUtils;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class JWTTokenUtil {
////    自定义jwt过期时间
//    private static final long ttlMillis=24*60*60*1000;//一天的时间，单位是时间戳的单位毫秒
//
////    自定义秘钥
//    private static final String secretKey="zgyisagoodman";
//
////    自定义签发人
//    private static final String subjectPrefix="zgy";
//    /**
//     * 用户登录成功后生成Jwt
//     * 使用Hs256算法  私匙使用自定义
//     *    @param name 登录名字
//     *    @param id 登录角色的id
//     * @return
//     */
//    public static String createJWT(String name,long id) {
//        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.;
//
//        //生成JWT的时间
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
//        Map<String, Object> claims = new HashMap<String, Object> ();
////        isEmpty  判断某字符串是否为空，为空的标准是 str==null或 str.length()==0，注意在 StringUtils 中空格作非空处理
//        if(!StringUtils.isEmpty(id)){
//            claims.put("userId", id);
//        }
//        if(!StringUtils.isEmpty(name)){
//            claims.put("userName", name);
//        }
//
//        //生成签名的时候使用的秘钥secret，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
//        String key = secretKey;
//
//        //生成签发人
//        String subject = subjectPrefix;
//
//
//
//        //下面就是在为payload添加各种标准声明和私有声明了
//        //这里其实就是new一个JwtBuilder，设置jwt的body
//        JwtBuilder builder = Jwts.builder()
//                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
//                .setClaims(claims)
//                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
//                .setId(UUID.randomUUID().toString())
//                //iat: jwt的签发时间
//                .setIssuedAt(now)
//                //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为用户的唯一标志。
//                .setSubject(subject)
//                //设置签名使用的签名算法和签名使用的秘钥
//                .signWith(signatureAlgorithm, key);
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            //设置过期时间
//            builder.setExpiration(exp);
//        }
//        return builder.compact();//加密？
//    }
//
//
//    /**
//     * Token的解密
//     * @param token 加密后的token
//     * @return
//     */
//    public static Claims parseJWT(String token) {
//        //签名秘钥，和生成的签名的秘钥一模一样
//        String key = secretKey;
//
//        //得到DefaultJwtParser
//        Claims claims = Jwts.parser()
//                //设置签名的秘钥
//                .setSigningKey(key)//把秘钥存进去
//                //设置需要解析的jwt
//                .parseClaimsJws(token).getBody();//取出token中秘钥相比较？
//        return claims;
//    }
//
//
//    /**
//     * 校验token
//     * 在这里可以使用官方的校验，我这里校验的是token中携带的密码于数据库一致的话就校验通过(这里有问题)
//     * @param token 返回的加密过的token
//     * @return
//     */
//    public static Boolean isVerify(String token) {
//        //签名秘钥，要和生成的签名的秘钥一模一样
//        String key = secretKey;
//        String subject =subjectPrefix;
//
//        //得到DefaultJwtParser
//        Claims claims = Jwts.parser()
//                //设置签名的秘钥
//                .setSigningKey(key)
//                //设置需要解析的jwt
//                .parseClaimsJws(token).getBody();
//
//        if (claims.getSubject().equals(subject)) {
//            return true;
//        }
//
//        return false;
//    }
//
////    测试
//    public static void main(String[] args) {
//       String r1= createJWT ("张三",2 );//生成token
//        System.out.println (r1);
//
//        String r2=parseJWT (r1).toString ();//解密token
//        System.out.println (r2);
//
//        Boolean r3 = isVerify (r1);
//        System.out.println (r3);
//
//
//    }
//
//}