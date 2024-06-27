package com.project.backend.controller;

import com.project.backend.dto.UserDTO;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/allusers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteuser")
    public UserDTO deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO);
    }
}
