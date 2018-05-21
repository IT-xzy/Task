package com.hedonglin.util;



import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    public Long tokenAging(HttpServletRequest request) throws Exception {
        String value= CookieUtil.getCookieValueByName(request,"token");
        DesUtil desUtil=new DesUtil();
        String originallyToken = desUtil.decrypt(value);
        Long token= Long.valueOf(originallyToken);
        Long differenceTime= System.currentTimeMillis()-token;
        return differenceTime;
    }
}
