package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter {


    private List<Todo> todos;

    TodoAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new TodoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TodoHolder todoHolder = (TodoHolder) holder;
        todoHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private View color;
        private CheckBox checkBox;

        TodoHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_item_title);
            color = itemView.findViewById(R.id.list_item_color);
            checkBox = itemView.findViewById(R.id.list_item_color_checkbox);
        }

        void bind(int position) {
            title.setText(todos.get(position).getTitle());
            color.setBackgroundResource(todos.get(position).getColor());
            checkBox.setChecked(todos.get(position).isChecked());
        }
    }

}
