package com.springbootzerotohero.springbootvalidation.service;

import com.springbootzerotohero.springbootvalidation.dto.UserDTO;
import com.springbootzerotohero.springbootvalidation.entity.User;
import com.springbootzerotohero.springbootvalidation.exception.UserNotFoundException;
import com.springbootzerotohero.springbootvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO) {
        User user = User.build(0, userDTO.getName(),
                userDTO.getEmail(), userDTO.getMobile(), userDTO.getGender(),
                userDTO.getAge(), userDTO.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(int id) throws UserNotFoundException{

        User user = userRepository.findByUserId(id);
        if(user==null) {
            throw new UserNotFoundException("User not found with id=" + id);
        }

        return user;
    }
}
