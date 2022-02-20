package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;

import java.util.List;

public class ViewActivity extends AppCompatActivity {
    public ImageButton back;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DataBaseHelper db = new DataBaseHelper(ViewActivity.this);
        List<bookmodel> viewall = db.viewAll();

        back = (ImageButton) findViewById(R.id.exit_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.book_lst);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecycleViewAdapter(viewall,ViewActivity.this);
        recyclerView.setAdapter(mAdapter);

    }
}