package com.orange.task.API.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orange.task.API.Models.User;

public interface UserRepos extends JpaRepository<User, String> {
	User findByEmail(String email);
}
