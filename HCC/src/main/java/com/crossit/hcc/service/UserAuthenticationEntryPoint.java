package com.crossit.hcc.service;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
 
/**
 * 인증하지 않은 상황에서 호출시 발생
 * @auther ddakker 2013. 12. 6.
 */
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
 
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        // 에러 페이지에 대한 확장자를 현재 호출한 확장자와 마추어준다.
        
    	req.getRequestDispatcher("/WEB-INF/views/denied.jsp").forward(req, res);
        
    }
 
}


