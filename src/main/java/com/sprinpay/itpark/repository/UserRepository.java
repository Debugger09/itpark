package com.sprinpay.itpark.repository;

import com.sprinpay.itpark.domain.User;
import com.sprinpay.itpark.domain.enums.ROLE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPassword(String login,String password);

    List<User> findAllByRole(ROLE role);
}
