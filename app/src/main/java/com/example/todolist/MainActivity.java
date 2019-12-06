package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TodoAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private FloatingActionButton fab;
    private List<Todo> todos;
    // float action button click listener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "clicked !", Toast.LENGTH_SHORT).show();

            AddTodoDialog addTodoDialog = new AddTodoDialog();
            Bundle bundle = new Bundle();
            bundle.putString("list",  "bundle");
            addTodoDialog.setArguments(bundle);

            addTodoDialog.setOnAddTodoListener(new AddTodoDialog.OnAddTodoListener() {
                @Override
                public void OnAddTodo(Todo todo) {
                    todos.add(todo);
                }
            });
            addTodoDialog.show(getSupportFragmentManager(),"show");



        }
    };

    // end onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate
        recyclerView = findViewById(R.id.recyclerview);
        fab = findViewById(R.id.fab);


        //Function
        buildRecyclerView();

        fab.setOnClickListener(onClickListener);


    }

    // build recyclerview and put the data
    public void buildRecyclerView() {
        todos = new ArrayList<>();
        todos.add(new Todo("One Title"));
        todos.add(new Todo("Two Title"));
        todos.add(new Todo("Three Title"));
        todos.add(new Todo("four Title"));
        todos.add(new Todo("five Title"));
        todos.add(new Todo("six Title"));
        todos.add(new Todo("seven Title"));
        todos.add(new Todo("eight Title"));
        todos.add(new Todo("nine Title"));
        todos.add(new Todo("ten Title"));
        todos.add(new Todo("twelve Title"));
        todos.add(new Todo("thirteen Title"));
        todos.add(new Todo("fourteen Title"));
        todos.add(new Todo("fifteen Title"));

        adapter = new TodoAdapter(todos);

        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}
