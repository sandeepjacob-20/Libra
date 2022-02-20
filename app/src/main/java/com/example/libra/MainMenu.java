package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    public Button add,catalogue,delete,search;
    public ImageButton exit;
    public Toast exitToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        add = (Button) findViewById(R.id.add);
        catalogue = (Button) findViewById(R.id.catalogue);
        search = (Button) findViewById(R.id.search);
        delete = (Button) findViewById(R.id.delete);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,AddActivity.class);
                startActivity(intent);
            }
        });
        catalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,ViewActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,DeleteActivity.class);
                startActivity(intent);
            }
        });
        exit = (ImageButton) findViewById(R.id.exit_button);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                System.exit(0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        exitToast = Toast.makeText(getApplicationContext(),"Press exit button to close", Toast.LENGTH_SHORT);
        exitToast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                exitToast.cancel();
            }
        }, 1000);
    }
}