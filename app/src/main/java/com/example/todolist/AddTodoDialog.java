package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddTodoDialog extends DialogFragment {

    private Todo todo;
    private OnAddTodoListener onAddTodoListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final EditText editText = new EditText(getContext());
        //View view = getActivity().getLayoutInflater().inflate(R.layout.add_new_item, null);
        //.setView(getLayoutInflater().inflate(R.layout.list_item,null))
        return new AlertDialog
                .Builder(getContext())
                .setTitle("Add new Todo")
                .setView(editText)

                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!editText.getText().toString().equals("")) {
                            todo = new Todo(editText.getText().toString());
                            onAddTodoListener.OnAddTodo(todo);
                            Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), "Field", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })

                .create();

    }

    void setOnAddTodoListener(OnAddTodoListener onAddTodoListener) {
        this.onAddTodoListener = onAddTodoListener;
    }

    interface OnAddTodoListener {
        void OnAddTodo(Todo todo);
    }
}