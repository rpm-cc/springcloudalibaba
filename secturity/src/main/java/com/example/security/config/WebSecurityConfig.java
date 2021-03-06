package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author Piming Ren
 * @Date 2021/1/27 17:25
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  DefaultAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    BeforeFilter beforeFilter;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DefaultPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.supports(UsernamePasswordAuthenticationToken.class);
        return authenticationProvider;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());


        auth.authenticationProvider(new AuthenticationProvider() {

            //Authentication????????????????????????????????????????????????????????????????????????????????????
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {

                String username = authentication.getName();
                String password = (String) authentication.getCredentials();

                DefaultUser user = (DefaultUser) userDetailsService.loadUserByUsername(username);


                return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            }

            //??????????????????????????????????????????
            @Override
            public boolean supports(Class<?> aClass) {
                //UsernamePasswordAuthenticationToken???Authentication???????????????????????????
                return UsernamePasswordAuthenticationToken.class.equals(aClass);
            }
        });


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //????????????csrf???????????????PATCH???POST???PUT???DELETE ????????????csrftoken
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",  "/example/**").permitAll()
                .anyRequest().authenticated()
        ;
        http.addFilterBefore(beforeFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
