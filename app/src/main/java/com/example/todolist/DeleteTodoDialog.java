package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DeleteTodoDialog extends DialogFragment {

    private Button btn_delete;
    private Button btn_cancel;
    private OnDeleteClickListener onDeleteClickListener;
    private int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View custom_dialog = getActivity().getLayoutInflater().inflate(R.layout.dialog_delete_item, null);
        btn_delete = custom_dialog.findViewById(R.id.delete_dialog_add_btn);
        btn_cancel = custom_dialog.findViewById(R.id.delete_dialog_cancel_btn);

        final AlertDialog alertDialog =
                new AlertDialog.Builder(getContext())
                        .setView(custom_dialog)
                        .setMessage(R.string.do_you_want_to_delete)
                        .setTitle(R.string.delete)
                        .create();

        // Cancel button action
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        // Delete button action
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteClickListener.onDeleteClick(position);
            }
        });
        return alertDialog;
    }

    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }
}
