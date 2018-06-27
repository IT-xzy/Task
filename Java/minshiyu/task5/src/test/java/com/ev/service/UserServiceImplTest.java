package com.ev.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ev.dao.UserDAO;
import com.ev.utils.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.HashMap;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/22/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;

    /**
     * Method: findUser(String str)
     */
    @Test
    public void testFindUser() throws Exception {
//        User user=new User();
//        user.setEmail("123@email.com");
//        user.setName("adwad");
//        user.setPassword("adawd");
//        user.setPhoneNumber("13111111111");
//        userService.signUp(user);













    }
@Test
    public void dosth() throws UnsupportedEncodingException {
    JWTUtil jwtUtil=new JWTUtil();
    String token = jwtUtil.createToken("233333", 60);

    // 打印token
    System.out.println("token: " + token);

    // 解密token

    DecodedJWT jwt = jwtUtil.decodeToken(token);

    System.out.println(jwt);
    System.out.println("issuer: " + jwt.getIssuer());
    System.out.println("name:     " + jwt.getClaim("name").asString());
    System.out.println("过期时间：      " + jwt.getExpiresAt());
    System.out.println(jwt.toString());

    JWTVerifier verifier = JWT.require(Algorithm.HMAC256("mysecret"))
            .withIssuer("auth0")
            .build(); //Reusable verifier instance
    jwt = verifier.verify(token);
    System.out.println(jwt);
    System.out.println("issuer: " + jwt.getIssuer());
    System.out.println("name:     " + jwt.getClaim("name").asString());
    System.out.println("过期时间：      " + jwt.getExpiresAt());
    System.out.println(jwt.toString());

    System.out.println(jwt);
}




@Test
    public void random() throws Exception{
        for(int i=0;i<10;i++) {
            SecureRandom csprng = new SecureRandom();
            byte[] randomBytes = new byte[32];
            csprng.nextBytes(randomBytes);
            System.out.println(randomBytes);
            System.out.println(Arrays.toString(randomBytes));
        }
}
} 
