package com.fourimpact.taskManager.service;

import com.fourimpact.taskManager.dto.CreateUserRequest;
import com.fourimpact.taskManager.dto.UserResponse;
import com.fourimpact.taskManager.entity.User;
import com.fourimpact.taskManager.repository.UserRepository;
import com.fourimpact.taskManager.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Create
    public UserResponse createUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setRole(userRequest.getRole());
        user.setPassword(userRequest.getPassword());

        User newUser = userRepository.save(user);
        return ToResponse(newUser);
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        return ToResponse(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::ToResponse)
                .collect(Collectors.toList());
    }

    private UserResponse ToResponse(User user) {
       return new UserResponse(
               user.getId(),
               user.getUsername(),
               user.getEmail(),
               user.getFirstName(),
               user.getLastName(),
               user.getRole()
               );
    }
}
