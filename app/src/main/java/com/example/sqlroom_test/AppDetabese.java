package com.example.sqlroom_test;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class AppDetabese extends RoomDatabase {

    public abstract UserDuo userDuo();
}
