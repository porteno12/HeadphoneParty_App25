package com.example.headphoneparty_app25;

public class Song {

    private String id;
    private String name;
    private int categoryIcon;
    private String url;
    private String categoryName;


    public Song() {
        //for firebase
    }

    public Song(String id, String name, int categoryIcon, String url, String categoryName) {
        this.id = id;
        this.name = name;
        this.categoryIcon = categoryIcon;
        this.url = url;
        this.categoryName = categoryName;
    }

    public Song(String name, int categoryIcon, String url) {
        this.name = name;
        this.categoryIcon = categoryIcon;
        this.url = url;
    }

    public Song(String name, int categoryIcon, String url, String categoryName) {
        this.name = name;
        this.categoryIcon = categoryIcon;
        this.url = url;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Song(String name, String url, String category, int categoryIcon) {
    }

    public String getName() {
        return name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(int categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
