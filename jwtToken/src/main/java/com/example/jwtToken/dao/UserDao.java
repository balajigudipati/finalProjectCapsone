package com.example.jwtToken.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwtToken.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
