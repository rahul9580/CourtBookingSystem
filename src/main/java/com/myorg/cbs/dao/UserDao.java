package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntities = new ArrayList<>();
        for(Map.Entry<Integer, UserEntity> entity : Database.userTable.entrySet()) {
            userEntities.add(entity.getValue());
        }
        return userEntities;
    }

    public UserEntity getUserById(int id) {
        return Database.userTable.get(id);
    }

    public void saveOrUpdate(UserEntity userEntity) {
        Database.userTable.put(userEntity.getUserId(), userEntity);
    }

    public void delete(int id) {
        Database.userTable.remove(id);
    }
}
