package com.sprinpay.itpark.services;

import com.sprinpay.itpark.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> findAll();

    Optional<User> showOne(Long id);
    User save(User user);

    void  delete(Long id);


}
