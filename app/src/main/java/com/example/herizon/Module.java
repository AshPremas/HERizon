package com.example.herizon;

public class Module {
    private String _id;
    private String title;
    private String description;

    public Module(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

