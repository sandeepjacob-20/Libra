package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {
    public Button signup;
    public ImageButton back_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView user_name = (TextView) findViewById(R.id.person_name);
        TextView username = (TextView) findViewById(R.id.person_username);
        TextView pass = (TextView) findViewById(R.id.person_pass);
        TextView confirm = (TextView) findViewById(R.id.person_pass2);

        signup = (Button) findViewById(R.id.sign_up);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String user_check = username.getText().toString().trim();
                    if (user_check.isEmpty()) {
                        throw new Exception();
                    }
                    else {
                        if (pass.getText().toString().trim().equals(confirm.getText().toString().trim())) {
                            UserModel new_user = new UserModel(user_name.getText().toString().trim(), user_check, pass.getText().toString().trim());
                            DataBaseHelper db = new DataBaseHelper(SignupActivity.this);
                            boolean result = db.addUser(new_user);
                            if (result) {
                                Toast.makeText(SignupActivity.this, "User added", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                                Toast.makeText(SignupActivity.this, "Error adding user", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                            pass.setText("");
                            confirm.setText("");
                        }
                    }
            }
            catch (Exception e) {
                    Toast.makeText(SignupActivity.this,"Username cannot be null", Toast.LENGTH_SHORT).show();
                }
                user_name.setText("");
                username.setText("");
                pass.setText("");
                confirm.setText("");
            }
        });

        back_2 = (ImageButton) findViewById(R.id.back_2);
        back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}