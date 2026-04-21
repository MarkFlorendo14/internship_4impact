package com.fourimpact.taskManager.service;
import com.fourimpact.taskManager.dto.CreateUserRequest;
import com.fourimpact.taskManager.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.fourimpact.taskManager.dto.CreateTaskRequest;
import com.fourimpact.taskManager.entity.Task;
import com.fourimpact.taskManager.repository.TaskRepository;
import com.fourimpact.taskManager.repository.UserRepository;
import com.fourimpact.taskManager.repository.CategoryRepository;
import com.fourimpact.taskManager.repository.TagRepository;
import com.fourimpact.taskManager.dto.TaskResponse;
import com.fourimpact.taskManager.entity.Category;
import com.fourimpact.taskManager.entity.Tag;
import com.fourimpact.taskManager.entity.User;
import com.fourimpact.taskManager.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;
    private TagRepository tagRepository;

    public UserService (UserRepository userRepository, TaskRepository taskRepository,
                        CategoryRepository categoryRepository, TagRepository tagRepository ) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    //Create
    public UserResponse createUser(User user) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        User newUser = userRepository.save(user);
        return ToResponse(newUser);
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
