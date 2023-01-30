package com.koldtech.PartyOrganizer.controller;

import com.koldtech.PartyOrganizer.dto.UserDTO;
import com.koldtech.PartyOrganizer.model.User;
import com.koldtech.PartyOrganizer.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/data/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    ResponseEntity<List<UserDTO>> findAll() {
        List<User>userEntities=userRepository.findAll();
        List<UserDTO> users=userEntities.stream().map(
                x->new UserDTO(x.getId(), x.getFirstName(), x.getLastName(), x.getEmail(), x.getPassword())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    ResponseEntity<Map<String,User>>createUser(@RequestBody UserDTO userDTO){
        User user=new User(userDTO.getFirstName(),userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok(Collections.singletonMap("Created user: ", user));
    }

}
