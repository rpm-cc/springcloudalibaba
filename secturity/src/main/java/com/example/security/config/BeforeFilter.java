package com.example.security.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Piming Ren
 * @date: 2021/7/1 16:15
 * @version: 1.0
 * @description:
 */
@Component
public class BeforeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("beforeFilter");
        DefaultUser  defaultUser  = new DefaultUser();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(defaultUser, null, defaultUser.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        System.out.println("authorizated user '{}', setting security context renpiming");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
