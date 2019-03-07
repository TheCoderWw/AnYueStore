package com.springmvc.util;

import com.springmvc.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;

import java.util.Date;


public class JWTUtils {
    private static final String PRIVATEKEY = "wangwei";
    private static final String ISS = "admin";

    //map为主体
    public static String getToken(User user) {
        JSONObject jsonObject = new JSONObject();
        //设置header
        jsonObject.put("alg", "HS256");
        jsonObject.put("typ", "JWT");
        long nowTime = System.currentTimeMillis();
        long overTime = nowTime + (1000 * 60 * 60 * 2);
        Date nowDate = new Date(nowTime);
        Date overDate = new Date(overTime);

        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("userId", user.getId())
                .claim("userName", user.getUserName()).setId(UUIDUtils.getUUID())
                .setIssuedAt(nowDate).setExpiration(overDate).setIssuer(ISS)
                .setSubject(user.getUserName()).signWith(SignatureAlgorithm.HS256, PRIVATEKEY.getBytes()).compact();
    }

    //解密
    public static Integer getUserIdByToken(String jwtToken) {
        Jws<Claims> jws = Jwts.parser().require("iss", ISS)
                .setSigningKey(PRIVATEKEY.getBytes()).parseClaimsJws(jwtToken);
//        String s = jws.getBody().toString();

        return (Integer) jws.getBody().get("userId");
    }
}
