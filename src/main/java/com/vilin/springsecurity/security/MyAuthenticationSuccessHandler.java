package com.vilin.springsecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger log = Logger.getLogger(MyAuthenticationSuccessHandler.class);

    //ObjectMapper: jackson 框架的工具类，用于转换对象为 json 字符串
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //返回 json 字符串给前端
        Map result = new HashMap();
        result.put("userLogin",true);

        String json = objectMapper.writeValueAsString(result);
        log.info(json);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(json);
    }
}
