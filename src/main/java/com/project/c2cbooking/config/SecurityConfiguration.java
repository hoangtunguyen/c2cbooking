package com.project.c2cbooking.config;

import com.project.c2cbooking.fillter.JwtRequestFillter;
import com.project.c2cbooking.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

    @Autowired
    MyUserDetailService userDetailsService;

    @Autowired
    JwtRequestFillter jwtRequestFillter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll();
//                .and().formLogin().loginPage("/login").permitAll();
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/authenticate").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/login").permitAll()
                    .anyRequest().authenticated()
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http.addFilterBefore(jwtRequestFillter, UsernamePasswordAuthenticationFilter.class);


    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
