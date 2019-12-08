package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditTodoDialog extends DialogFragment {

    MainActivity.OnEditClickListener onEditClickListener;
    private int position;
    private String title;
    private Button btn_edit;
    private Button btn_cancel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt("position");
        title = getArguments().getString("todo_edit");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.add_new_item, null);
        btn_edit = view.findViewById(R.id.add_todo_dialog_add_btn);
        btn_edit.setText(R.string.edit);
        btn_cancel = view.findViewById(R.id.add_todo_dialog_cancel_btn);


        final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.edit_Todo)
                .setView(view)
                .create();

        // Cancel button action
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        // Edit button Action
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return alertDialog;
    }


}
