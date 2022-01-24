package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(username.getText().toString().trim().equals("admin")&&password.getText().toString().trim().equals("12345"))
                {
                    Intent intent = new Intent(MainActivity.this,MainMenu.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}