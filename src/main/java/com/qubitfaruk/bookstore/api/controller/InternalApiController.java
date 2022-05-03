package com.qubitfaruk.bookstore.api.controller;

import com.qubitfaruk.bookstore.core.business.abstracts.IUserService;
import com.qubitfaruk.bookstore.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {
    @Autowired
    private IUserService userService;

    @PutMapping("/make-admin/{userName}")
    public ResponseEntity<?> makeAdmin(@PathVariable String userName){
        this.userService.makeAdmin(userName);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
