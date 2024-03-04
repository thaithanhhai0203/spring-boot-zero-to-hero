package com.springbootzerotohero.springbootvalidation.controller;

import com.springbootzerotohero.springbootvalidation.dto.UserDTO;
import com.springbootzerotohero.springbootvalidation.entity.User;
import com.springbootzerotohero.springbootvalidation.exception.UserNotFoundException;
import com.springbootzerotohero.springbootvalidation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody @Valid UserDTO userDTO) {
        return new ResponseEntity<User>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getOne(id));
    }
}
