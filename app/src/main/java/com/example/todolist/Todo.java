package com.example.todolist;

public class Todo {

    private String title;
    private int color;
    private boolean checked;

    public Todo(String title, int color, boolean checked) {
        this.title = title;
        this.color = color;
        this.checked = checked;
    }

    public Todo(String title, int color) {
        this.title = title;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isChecked() {
        return checked;
    }

    public Todo(String title) {
        this.title = title;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public Todo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
