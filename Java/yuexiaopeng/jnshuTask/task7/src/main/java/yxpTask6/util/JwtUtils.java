package yxpTask6.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Login;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils
{
    @Autowired
    private JavaDES javaDES;
    //创建token，将加密后的账户密码传进cookie中；
    public  String creatToken(Login login)
    {
        String token=null;
        try
        {
            //使用HMAC256加密算法并提供密钥
            Algorithm algorithm = Algorithm.HMAC256("secretkey");
            //将header头信息放入map中；
            Map<String, Object> map = Maps.newHashMap();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            //对账号进行des加密
            String encryptAccount=javaDES.encryptDes(login.getLoginAccount());
            //token的生成；
            token = JWT.create()
                    .withHeader(map) //header的生成，没有header可省略
                    //.withClaim("loginPassword", loginPassword) 不在载荷中放入密码，只放入时间
                    // payload的内容生成
                    .withClaim("loginAccount",encryptAccount)
                    .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*3))//过期时间设置为3天；
                    //.withNotBefore(new Date(System.currentTimeMillis()+6))//token被接受的时间，
                    .sign(algorithm); //加密密码的生成
        }
        //多层catch，缩小错误原因；
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return token;
    }
    /*
    * 返回值为包含账户信息的login；
    * 1.准确情况：loginAccount有值且不为null；
    * 2.错误情况：login不为空，但是loginAccount的值为null；
    * 3.使用时用loginAccount作为判断条件；
    * */
    //解密token
    public  Login verifyToken(String token) {
        Login login=new Login();
        String loginAccount=null;
        DecodedJWT decodedJWT = null;
        /*判断token值是不是标准token,使用.去分割token，
        判断分割后的字符数组长度来判断是不是token；*/
        String args []=token.split("\\.");
        if(args.length==3)
        {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secretkey");
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                //需要判断下token的值是不是三段式，是的话解密，不是的话直接返回null值；
                decodedJWT = jwtVerifier.verify(token);
                //从解密后的token中读取加密后的账户名；
                //loginPassword=decodedJWT.getClaims().get("loginPassword").asString();
                String encryptAccount = decodedJWT.getClaims().get("loginAccount").asString();
                //对账户名进行解密
                loginAccount=javaDES.decryptDes(encryptAccount);
                //将账户名进行封装；
                login.setLoginAccount(loginAccount);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JWTVerificationException e) {
                e.printStackTrace();
            }
        }
        //如果token不存在，将会返回空的login；
        return login;
    }

}