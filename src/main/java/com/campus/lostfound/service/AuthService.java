package com.campus.lostfound.service;
import com.campus.lostfound.model.User; import com.campus.lostfound.repository.UserRepository; import org.springframework.stereotype.Service;
@Service public class AuthService { private final UserRepository users; public AuthService(UserRepository u){users=u;} public User login(String u,String p){return users.findByUsername(u).filter(x->x.getPassword().equals(p)).orElse(null);} }
