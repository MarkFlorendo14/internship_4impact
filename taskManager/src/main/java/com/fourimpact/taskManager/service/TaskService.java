    package com.fourimpact.taskManager.service;

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
    public class TaskService {
        //Declare repositories
        private final TaskRepository taskRepository;
        private final UserRepository userRepository;
        private final CategoryRepository categoryRepository;
        private final TagRepository tagRepository;


        public TaskService (TaskRepository taskRepository, UserRepository userRepository,
                            CategoryRepository categoryRepository, TagRepository tagRepository)
        {
            this.taskRepository = taskRepository;
            this.userRepository = userRepository;
            this.categoryRepository = categoryRepository;
            this.tagRepository = tagRepository;

        }
        //CREATE
        public TaskResponse createTask(CreateTaskRequest request) {
            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", request.getUserId()));
            Category category = null;
            if (request.getCategoryId() != null) {
                category = categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new ResourceNotFoundException("Category", request.getCategoryId()));
            }
            Task task =  new Task(request.getTitle(), request.getDescription(),
                    request.getStatus(), request.getPriority());

            task.setUser(user);
            task.setCategory(category);
            return toResponse(taskRepository.save(task));
        }
        // READ
        @Transactional(readOnly = true)  // optimized for reads -- Hibernate skips dirty checking
        public List<TaskResponse> getAllTasks() {
            return taskRepository.findAllWithUserAndCategory().stream().map(this::toResponse).collect(Collectors.toList());
        }

        @Transactional(readOnly = true)
        public TaskResponse getTaskById(Long id) {
            Task task = taskRepository.findById(id)
                    .orElseThrow (() -> new ResourceNotFoundException("Task", id));
            return toResponse(task);
        }

        // UPDATE
        public TaskResponse updateTask(Long id, CreateTaskRequest request) {
            Task task = taskRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Task", id));
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setStatus(request.getStatus());
            task.setPriority(request.getPriority());
            // Note: userId and categoryId are not updated here for simplicity.
            // In production you would validate and reassign those fields too.
            return toResponse(taskRepository.save(task));
        }

        // DELETE
        public void deleteTask(Long id) {
            if (!taskRepository.existsById(id)) {
                throw new ResourceNotFoundException("Task", id);
            }
            taskRepository.deleteById(id);
        }

        // ── ASSIGN TAG ─────────────────────────────────────────────────────────
        public TaskResponse addTagToTask(Long taskId, Long tagId) {
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new ResourceNotFoundException("Task", taskId));

            Tag tag = tagRepository.findById(tagId)
                    .orElseThrow(() -> new ResourceNotFoundException("Tag", tagId));

            task.addTags(tag);  // updates both sides of the ManyToMany relationship
            return toResponse(taskRepository.save(task));
        }


        // ── Helper: convert Task entity to TaskResponse DTO ───────────────────
        public TaskResponse toResponse(Task task) {
            String username     = task.getUser()     != null ? task.getUser().getUsername()  : null;
            String categoryName = task.getCategory() != null ? task.getCategory().getName()  : null;
            return new TaskResponse(
                    task.getId(), task.getTitle(), task.getDescription(),
                    task.getStatus(), task.getPriority(),
                    username, categoryName, task.getCreatedAt());
        }

        @Transactional(readOnly = true)
        public Page<TaskResponse> getTasksPaged(Long userId, int page, int size,
                                                String sortBy, String direction) {

            Sort sort = direction.equalsIgnoreCase("asc")
                    ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();

            return taskRepository
                    .findByUserIdPaginated(userId, PageRequest.of(page, size, sort))
                    .map(this::toResponse);  // converts each Task entity to a TaskResponse DTO
        }

    }





