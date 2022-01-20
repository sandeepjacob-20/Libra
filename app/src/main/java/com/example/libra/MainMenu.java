package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;

public class MainMenu extends AppCompatActivity {
    public Button add,edit,delete,search;
    public ImageButton exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,AddActivity.class);
                startActivity(intent);
            }
        });
        exit = (ImageButton) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}