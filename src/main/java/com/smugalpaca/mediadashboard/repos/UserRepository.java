package com.smugalpaca.mediadashboard.repos;

import org.springframework.data.repository.CrudRepository;
import com.smugalpaca.mediadashboard.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
}