package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddTodoDialog extends DialogFragment {

    private EditText ed_add_title;
    private Button btn_add;
    private Button btn_cancel;
    private RadioGroup rg_color;
    private RadioButton rb_selected;

    private Todo todo;
    private OnAddTodoListener onAddTodoListener;
    private int color_id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final View view_layout = getActivity().getLayoutInflater().inflate(R.layout.add_new_item, null);

        // inflate dialog
        ed_add_title = view_layout.findViewById(R.id.add_todo_dialog_add_title_edit_text);
        btn_add = view_layout.findViewById(R.id.add_todo_dialog_add_btn);
        btn_cancel = view_layout.findViewById(R.id.add_todo_dialog_cancel_btn);
        rg_color = view_layout.findViewById(R.id.rg_colors);

        //
        final AlertDialog alertDialog = new AlertDialog
                .Builder(getContext())
                .setTitle("Add new Todo")
                .setView(view_layout)
                .create();


        // Add button action
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!ed_add_title.getText().toString().equals("")
                        && rg_color.getCheckedRadioButtonId() != -1) {

                    int selected = rg_color.getCheckedRadioButtonId();
                    rb_selected = view_layout.findViewById(selected);

                    System.out.println("selected id " + rb_selected.getId());
                    switch (rb_selected.getId()) {
                        case R.id.rb_blue:
                            color_id = R.color.blue;
                            break;
                        case R.id.rb_green:
                            color_id = R.color.green;
                            break;
                        case R.id.rb_red:
                            color_id = R.color.red;
                            break;
                        case R.id.rb_yellow:
                            color_id = R.color.yellow;
                            break;
                    }

                    todo = new Todo();
                    todo.setTitle(ed_add_title.getText().toString());
                    todo.setColor(color_id);

                    onAddTodoListener.OnAddTodo(todo);
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "Add title and Choose color", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // cancel button action
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        return alertDialog;
    }

    void setOnAddTodoListener(OnAddTodoListener onAddTodoListener) {
        this.onAddTodoListener = onAddTodoListener;
    }
    interface OnAddTodoListener {
        void OnAddTodo(Todo todo);
    }
}