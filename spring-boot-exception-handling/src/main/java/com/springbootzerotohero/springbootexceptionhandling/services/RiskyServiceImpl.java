package com.springbootzerotohero.springbootexceptionhandling.services;

import com.springbootzerotohero.springbootexceptionhandling.exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class RiskyServiceImpl implements RiskyService {

    @Override
    public void takeRisk() {
        throw new CustomException("Something has gone horribly wrong");
    }
}
