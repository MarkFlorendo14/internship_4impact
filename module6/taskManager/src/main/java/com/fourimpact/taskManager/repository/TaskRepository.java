package com.fourimpact.taskManager.repository;

import com.fourimpact.taskManager.entity.Status;
import com.fourimpact.taskManager.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
    List<Task> findByUserId(Long userId);
    List<Task> findByStatusAndUserId(Status status, Long userId);
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByPriorityOrderByCreatedAtDesc(String priority);

    @Query("SELECT t from Task t LEFT JOIN FETCH t.user LEFT JOIN FETCH t.category")
    List<Task> findAllWithUserAndCategory();

    @Query(value      = "SELECT t FROM Task t WHERE t.user.id = :userId",
            countQuery = "SELECT COUNT(t) FROM Task t WHERE t.user.id = :userId")
    Page<Task> findByUserIdPaginated(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT t FROM Task t WHERE t.status = :status AND t.user.id = :userId")
    List<Task> findByStatusAndUser(@Param("status") Status status,
                                   @Param("userId") Long userId);

    long countByStatus(Status status);
}

