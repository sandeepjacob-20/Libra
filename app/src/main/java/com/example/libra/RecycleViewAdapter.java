package com.example.libra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    List<bookmodel> booklist;
    Context context;

    public RecycleViewAdapter(List<bookmodel> booklist, Context context) {
        this.booklist = booklist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(booklist.get(position).getBook_id());
        holder.name.setText(booklist.get(position).getBook_name());
        holder.author.setText(booklist.get(position).getAuthor());
        holder.genre.setText(booklist.get(position).getGenre());
    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        TextView author;
        TextView genre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.slot_id);
            name = itemView.findViewById(R.id.slot_name);
            author = itemView.findViewById(R.id.slot_author);
            genre = itemView.findViewById(R.id.slot_genre);
        }
    }
}
