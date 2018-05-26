package com.ptteng.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class Jwt {
    /**
     * 密钥
     */
    private static final byte[] SECRET = "o23843ksdfkuuertqwbrv22f34ywefoef".getBytes();

    /**
     * pick the algorithm
     */
    public Algorithm getAlgorithm(String secret){
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256("secret");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncoding");
            e.printStackTrace();
        }
        return algorithm;
    }


    /**
     * create and sign a token
     */


    /**
     * verify a token
     * first create a JWTVerifier instance by calling JWT.require() and passing the Algorithm instance.And the instance returned by the method build() is reused,so you can defined it once and use it to verify different tokens.
     */
    public JWTVerifier getJwtVerifier(Algorithm algorithm){
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        return jwtVerifier;
    }

    public DecodedJWT verifyToken(JWTVerifier jwtVerifier,String token){
        //call jwtVerifier.verify() passing the token.
        DecodedJWT jwt = jwtVerifier.verify(token);
        return jwt;
    }
}
