package com.app.ecom_application.repository;

import com.app.ecom_application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
