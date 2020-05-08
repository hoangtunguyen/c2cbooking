//package com.project.c2cbooking.service;
//
//import com.project.c2cbooking.model.MyUserDetail;
//import com.project.c2cbooking.model.UserEntity;
//import com.project.c2cbooking.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserEntity> user = userRepository.findByUsername(username);
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));
//        MyUserDetail userDetail = user.map(MyUserDetail::new).get();
//        return userDetail;
////        return new User(userDetail.getUsername(), userDetail.getPassword(),
////                userDetail.getAuthorities());
//    }
//}
