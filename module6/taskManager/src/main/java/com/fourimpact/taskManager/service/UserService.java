package com.fourimpact.taskManager.service;
import com.fourimpact.taskManager.dto.CreateUserRequest;
import com.fourimpact.taskManager.dto.UserResponse;
import com.fourimpact.taskManager.exception.ResourceNotFoundException;
import com.fourimpact.taskManager.repository.UserRepository;
import com.fourimpact.taskManager.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


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
        User newUser = userRepository.save(user);
        return toResponse(newUser);
    }
    //Read
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    //Update
    public UserResponse updateUser(Long id, CreateUserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("User", id));
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        User newUser = userRepository.save(user);
        return toResponse(newUser);
    }
    //Delete
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", id);
        } else {
            userRepository.deleteById(id);
        }
    }

    private UserResponse toResponse(User user) {
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
