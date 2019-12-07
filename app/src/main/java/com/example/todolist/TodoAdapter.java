package com.example.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter {


    private List<Todo> todos;
    private Context context;
    private OnDeleteClickListener onDeleteClickListener;
    private FragmentManager fragmentManager;

    TodoAdapter(Context context, List<Todo> todos, FragmentManager fragmentManager) {
        this.todos = todos;
        this.context = context;
        this.fragmentManager = fragmentManager;
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

    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }


    interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

    class TodoHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private View color;
        private CheckBox checkBox;
        private ImageView deleteBtn;

        TodoHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_item_title);
            color = itemView.findViewById(R.id.list_item_color);
            checkBox = itemView.findViewById(R.id.list_item_color_checkbox);
            deleteBtn = itemView.findViewById(R.id.list_item_delete_btn);

            // Delete Item
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final DeleteTodoDialog deleteTodoDialog = new DeleteTodoDialog();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", getAdapterPosition());
                    deleteTodoDialog.setArguments(bundle);

                    deleteTodoDialog.show(fragmentManager, "show_delete_dialog");

                    deleteTodoDialog.setOnDeleteClickListener(new DeleteTodoDialog.OnDeleteClickListener() {
                        @Override
                        public void onDeleteClick(int position) {
                            todos.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            deleteTodoDialog.dismiss();
                        }
                    });

/*
                    new AlertDialog.Builder(context)
                            .setTitle("Delete")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .create().show();*/

                }
            });
        }

        void bind(int position) {
            title.setText(todos.get(position).getTitle());
            color.setBackgroundResource(todos.get(position).getColor());
            checkBox.setChecked(todos.get(position).isChecked());

        }
    }
}
