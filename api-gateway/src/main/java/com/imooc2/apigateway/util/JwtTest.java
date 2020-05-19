//package com.imooc2.apigateway.util;
//
//import java.util.Date;
//
///**
// * @Author snail
// * @Description:
// * @create: 2020-05-13 14:18
// * @Param $
// * @return $
// * @Version 1.0
// **/
//public class JwtTest {
//    public static void main(String[] args) {
//        //获取系统的当前时间
//        long currentTimeMillis = System.currentTimeMillis();
//        Date date = new Date(currentTimeMillis+10000);
//
//        //生成jwt令牌
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .setId("66")//设置jwt编码
//                .setSubject("JWT主题")//设置jwt主题
//                .setIssuedAt(new Date())//设置jwt签发日期
//                .setExpiration(date) //过期时间设置
//                .signWith(SignatureAlgorithm.HS256, "irong")
//                .claim("username","admin")
//                .claim("password","123456");
//
//        //生成jwt
//        String jwtToken = jwtBuilder.compact();
//        System.out.println(jwtToken);
//
//        /*eyJhbGciOiJIUzI1NiJ9
//        .eyJqdGkiOiI2NiIsInN1YiI6Ium7kemprOeoi-W6j-
//		 WRmCIsImlhdCI6MTU4MzI4Nzc3NiwiZXhwIjoxNTgzMjg3Nzc2LCJ1c2VybmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiIxMjM0NTYifQ
//		 .x9ljHiu856h5FQCKNJeu--k2eQV0P4KtntKuHLm9G2A*/
//
//
//        //解析jwt,得到其内部的数据
//        Claims claims = Jwts.parser().setSigningKey("irong").parseClaimsJws(jwtToken).getBody();
//        System.out.println(claims);
//    }
//}
