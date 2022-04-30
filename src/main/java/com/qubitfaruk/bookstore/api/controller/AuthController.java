package com.qubitfaruk.bookstore.api.controller;

import com.qubitfaruk.bookstore.business.abstracts.IAuthenticationService;
import com.qubitfaruk.bookstore.core.business.abstracts.IUserService;
import com.qubitfaruk.bookstore.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/authentication")
public class AuthController {
    @Autowired
   private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("/signup") //   /api/authentication/signup
    public ResponseEntity<User> signUp(@RequestBody User user){
        if (this.userService.findByUserName(user.getUserName()).isPresent()){
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/signin")
    public  ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(this.authenticationService.sıgnInAndReturnJwt(user),HttpStatus.OK);
    }
}
