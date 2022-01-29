package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public Button button,sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        sign_up = (Button) findViewById(R.id.sign_up_btn);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DataBaseHelper db = new DataBaseHelper(MainActivity.this);
                if(db.login(username.getText().toString().trim(),password.getText().toString().trim()))
                {
                    Intent intent = new Intent(MainActivity.this,MainMenu.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_SHORT).show();
                }
                username.setText("");
                password.setText("");
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}