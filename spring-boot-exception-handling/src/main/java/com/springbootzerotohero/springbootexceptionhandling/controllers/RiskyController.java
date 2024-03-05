package com.springbootzerotohero.springbootexceptionhandling.controllers;

import com.springbootzerotohero.springbootexceptionhandling.exceptions.CustomException;
import com.springbootzerotohero.springbootexceptionhandling.services.RiskyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "risks")
public class RiskyController {
    private final RiskyService riskyService;
    @Autowired
    public RiskyController(final RiskyService riskyService) {
        this.riskyService = riskyService;
    }

    @GetMapping()
    public ResponseEntity getRisk() {
        riskyService.takeRisk();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity hanldeCustomException(final CustomException ex) {
        return new ResponseEntity<>("No risks here!", HttpStatus.OK);
    }
}
