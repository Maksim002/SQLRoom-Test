package com.example.sqlroom_test;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDuo {
    @Query("SELECT * FROM user")
    List<User> getAllUser();
    @Insert
    void insertAll(User... users);
}
