package com.jnshutask.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

public class TaExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException {
        String string="登录已失效";
        event.getResponse().getWriter().write(mapper.writeValueAsString(string));
        //event.getResponse().getWriter().write(mapper.writeValueAsString(ResponseBo.unAuthorized("登录已失效")));
    }
}