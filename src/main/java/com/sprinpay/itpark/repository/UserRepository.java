package com.sprinpay.itpark.repository;

import com.sprinpay.itpark.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPassword(String login,String password);
}
