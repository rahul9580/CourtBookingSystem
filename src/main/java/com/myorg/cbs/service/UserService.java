package com.myorg.cbs.service;

import com.myorg.cbs.dao.UserDao;
import com.myorg.cbs.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void saveOrUpdate(UserEntity userEntity) {
        userDao.saveOrUpdate(userEntity);
    }

    public void delete(int id) {
        userDao.delete(id);
    }
}
