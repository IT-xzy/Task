package com.ptteng;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ptteng.model.User;
import com.ptteng.util.Jwt;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    Jwt jwt = new Jwt();

    @Test
    public void testSign() {
        String token = null;
        String secret = "set";
        //create a token
        Algorithm algorithm= jwt.getAlgorithm(secret);
        token = JWT.create().withClaim("username", "chexin").sign(algorithm);
        DecodedJWT decodedJWT = null;
        JWTVerifier jwtVerifier =jwt.getJwtVerifier(algorithm);
        DecodedJWT decodedJWT1 =jwt.verifyToken(jwtVerifier, token);
//        System.out.println(decodedJWT.getAlgorithm());
//        System.out.println(decodedJWT.getType());
//        System.out.println(decodedJWT.getToken());
//        System.out.println(decodedJWT.getClaims());
    }
    @Test
    public void testJWT(){
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256("secroet");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String token = JWT.create().withIssuer("auth0").withClaim("iss", "dkjlkjas").withClaim("username", "haha").withClaim("passwod", 123).withExpiresAt(new Date()).sign(algorithm);
        //verify a token
//        JWTVerifier jwtVerifier= JWT.require(algorithm).build();
//        DecodedJWT D = jwtVerifier.verify(token);
        //decode a token
        DecodedJWT decodedJWT= JWT.decode(token);

        System.out.println("token:"+token);
        System.out.println("decoded token and get token:"+decodedJWT.getToken());
        System.out.println("decoded token and get algorithm :"+decodedJWT.getAlgorithm());
        System.out.println("get header:"+decodedJWT.getHeader());
        System.out.println("get payload:" + decodedJWT.getPayload());
        System.out.println("get type:" + decodedJWT.getType());
        System.out.println("get Issuer:" + decodedJWT.getIssuer());
        System.out.println("get claims:" + decodedJWT.getClaims().size());
        System.out.println("check if a claim named username is null:" + decodedJWT.getClaim("username").asString());
        System.out.println("get claim" + decodedJWT.getClaim("username").asString().toString());
        System.out.println(decodedJWT.getAudience());
        System.out.println(decodedJWT.getContentType());
        System.out.println(decodedJWT.getKeyId());

        //create a token with header claims
        Map<String, Claim> headerClaims2 = decodedJWT.getClaims();


        Map<String,Object> headerClaims= new HashMap<>();
        headerClaims.put("user", "jj");
        String token2 = JWT.create().withHeader(headerClaims).withClaim("pp", "qq").sign(algorithm);

        DecodedJWT decodedJWT1 = JWT.decode(token2);
//        decodedJWT1 = jwtVerifier.verify("gsdf");
        System.out.println("***********");
        System.out.println("alg:"+decodedJWT1.getAlgorithm());
        System.out.println("type:"+ decodedJWT1.getType());
        System.out.println("headerClaims:" + decodedJWT1.getHeaderClaim("user").asString());
        System.out.println(decodedJWT1.getClaim("pp").asString());

        token =token+"dsf";
//        System.out.println("D::::"+D.getAlgorithm());
//        DecodedJWT p=jwtVerifier.verify(token);
//        System.out.println("p::::::"+p.getAlgorithm());
    }
    public void testJSON(){

    }
}

