package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    public ImageButton back;
    public TextView id_value;
    public Button delete,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id_value = (TextView) findViewById(R.id.search_term);
        delete = (Button) findViewById(R.id.delete_data);
        cancel = (Button) findViewById(R.id.cancel_operation);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper db = new DataBaseHelper(DeleteActivity.this);
                String value = id_value.getText().toString().trim();
                if(db.deleteOne(value))
                    Toast.makeText(DeleteActivity.this, value + " Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DeleteActivity.this, value + " not found", Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });
    }
}