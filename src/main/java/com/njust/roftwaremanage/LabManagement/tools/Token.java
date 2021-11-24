package com.njust.roftwaremanage.LabManagement.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


/**
 * 用于认证用户的Token类
 * */
public class Token {
    private String id;
    private String name;
    private String role;
    private int err = 0;
    public static final int ExpiredJwtError = 1;
    public static final int SignatureError = 2;

    public Token(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(Auth.key).parseClaimsJws(token).getBody();
            this.id = claims.get("id").toString();
            this.name = claims.get("name").toString();
            this.role = claims.get("role").toString();
        } catch (ExpiredJwtException e){
            this.err = ExpiredJwtError;
        } catch (SignatureException e) {
            this.err = SignatureError;
        }

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getErr() {
        return err;
    }
}
