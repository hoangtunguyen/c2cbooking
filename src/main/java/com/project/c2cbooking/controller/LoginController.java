package com.project.c2cbooking.controller;

import com.project.c2cbooking.request.AuthenticationRequest;
import com.project.c2cbooking.response.AuthenticationResponse;
import com.project.c2cbooking.service.MyUserDetailService;
import com.project.c2cbooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String createAuthenticationToken(HttpServletRequest request) throws  Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken("hoangtu", "pass")
            );
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername("hoangtu");
        final String jwt = jwtUtil.generateToken(userDetails);
        request.getSession().setAttribute("jwts", jwt);
        return "home";
    }
}
