package com.project.backend.service;

import com.project.backend.dto.UserDTO;
import com.project.backend.model.User;
import com.project.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO addUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO deleteUser(UserDTO userDTO) {
        userRepository.delete(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
}
