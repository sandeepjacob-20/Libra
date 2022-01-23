package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.util.List;

public class ViewActivity extends AppCompatActivity {
    public ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });

        DataBaseHelper db = new DataBaseHelper(ViewActivity.this);
        List<bookmodel> viewall = db.viewAll();

        Toast.makeText(ViewActivity.this,viewall.toString(),Toast.LENGTH_SHORT).show();
    }
}