package com.project.c2cbooking.controller;

import com.project.c2cbooking.request.AuthenticationRequest;
import com.project.c2cbooking.response.AuthenticationResponse;
import com.project.c2cbooking.response.RoomResponse;
import com.project.c2cbooking.service.MyUserDetailService;
import com.project.c2cbooking.service.RoomService;
import com.project.c2cbooking.service.imp.RoomServiceImp;
import com.project.c2cbooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil  jwtUtil;
    @Autowired
    private RoomServiceImp roomServiceImp;
    @GetMapping("/")
    public ResponseEntity<?> home(HttpServletRequest request){
        final HttpSession session = request.getSession();
        System.out.println("/page");
        System.out.println(session.getAttribute("jwts"));
        return ResponseEntity.ok(roomServiceImp.topFavoriteRooms(5));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneRoom(@PathVariable Integer id){
        return ResponseEntity.ok(roomServiceImp.findOneRoom(id));
    }
    @GetMapping("/user")
    public String user(){
        return ("<h1>User</h1");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Admin</h1");
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request) throws  Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        request.getSession().setAttribute("jwts", jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
