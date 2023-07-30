package com.ybb.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {


    /**
     * 创建jwt token
     * @param secretKey 密钥
     * @param ttlMillis 过期时间-毫秒
     * @param claims 数据
     * @return token
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims){
        //指定算法名称
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        //生成Jwt的时间
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        //设置jwt body
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * 解析jwt
     * @param secretKey 密钥
     * @param token token
     * @return 数据
     */
    public static Claims parseJWT(String secretKey, String token){
        if(StringUtils.hasLength(token)){
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }else{
            return null;
        }
    }



}
