package com.smugalpaca.mediadashboard.repos;

import com.smugalpaca.mediadashboard.models.ChatSession;
import com.smugalpaca.mediadashboard.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChatSessionRepository extends CrudRepository<ChatSession,Long> {


    List<ChatSession> findByUserId(long userId);

    List<ChatSession> findByUser(User user);
}
