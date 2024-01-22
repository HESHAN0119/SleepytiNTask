package com.xhera.sleepyti;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter<ToDo> {


    private Context context;
    private int resource;
    List<ToDo> todos;

    ToDoAdapter(Context context, int resourse, List<ToDo> todos){
        super(context,resourse,todos);
        this.context=context;
        this.resource=resourse;
        this.todos= todos;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View row =inflater.inflate(resource,parent,false);

        TextView title= row.findViewById(R.id.title);
        TextView description=row.findViewById(R.id.discription);
        ImageView imageView =row.findViewById(R.id.onGoing);

        ToDo toDo =todos.get(position);
        title.setText(toDo.getTitle());
        description.setText(toDo.getDescription());
        imageView.setVisibility(row.INVISIBLE);

        if(toDo.getFinished()>0){

            imageView.setVisibility(View.VISIBLE);
        }


        return row;
    }
}

