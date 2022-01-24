package com.example.libra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    public ImageButton back;
    public Button submit;
    public TextView search_term;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_term = (TextView) findViewById(R.id.search_term);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            List<bookmodel> result;
            @Override
            public void onClick(View v) {
                try{
                    DataBaseHelper db = new DataBaseHelper(SearchActivity.this);
                    result = db.search(search_term.getText().toString().trim());
                    if(result.isEmpty())
                        throw new Exception();
                    recyclerView = (RecyclerView) findViewById(R.id.result_view);

                    recyclerView.setHasFixedSize(true);

                    recyclerView.setLayoutManager(layoutManager);

                    mAdapter = new RecycleViewAdapter(result,SearchActivity.this);
                    recyclerView.setAdapter(mAdapter);
                }
                catch (Exception e){
                    Toast.makeText(SearchActivity.this,"Book Not Found",Toast.LENGTH_LONG).show();
                }

            }
        });

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });
    }
}