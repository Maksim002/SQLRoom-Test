package com.example.sqlroom_test;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialogBuilder;
    private LayoutInflater inflater;
    private EditText editText;
    private Button button1;

    private AppDetabese db;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        db = Room.databaseBuilder(getApplicationContext(), AppDetabese.class,"production")
                .allowMainThreadQueries()
                .build();
        List<User> users =  db.userDuo().getAllUser();


        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                getDialog();
            }
        });
    }

    private void getDialog(){
        dialogBuilder = new AlertDialog.Builder(this).create();
        inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);

        editText = dialogView.findViewById(R.id.editDialog);
        button1 = dialogView.findViewById(R.id.bottomDialog);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                db.userDuo().insertAll(new User("kh"));

                dialogBuilder.dismiss();
            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }
}
