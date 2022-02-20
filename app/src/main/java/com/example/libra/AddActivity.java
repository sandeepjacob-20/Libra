package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
        public ImageButton back;
        public Button submit;
        public TextView id,name,author,genre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        id = (TextView) findViewById(R.id.id);
        name = (TextView) findViewById(R.id.name);
        author = (TextView) findViewById(R.id.author);
        genre = (TextView) findViewById(R.id.genre);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try{

                        String null_check = id.getText().toString().trim();
                        if(null_check.isEmpty())
                            throw new Exception();
                        bookmodel new_book = new bookmodel(id.getText().toString().trim(),name.getText().toString().trim(),author.getText().toString().trim(),genre.getText().toString().trim());
                        DataBaseHelper db = new DataBaseHelper(AddActivity.this);
                        boolean res = db.addOne(new_book);
                        if(res){
                            Toast.makeText(AddActivity.this,"Book Added",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(AddActivity.this,"Error adding book",Toast.LENGTH_SHORT).show();
                        }
                        id.setText("");
                        name.setText("");
                        author.setText("");
                        genre.setText("");
                        finish();
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(AddActivity.this, "Error Adding Book", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        back = (ImageButton) findViewById(R.id.exit_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });
    }
}