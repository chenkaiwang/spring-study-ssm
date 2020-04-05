package com.study.smm.dao;

import com.study.smm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();

    User findById(Integer id);
}
