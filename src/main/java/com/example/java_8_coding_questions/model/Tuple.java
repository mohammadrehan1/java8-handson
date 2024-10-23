package com.example.java_8_coding_questions.model;

public class Tuple {
    BlogPostType type;
    String author;

    public Tuple(BlogPostType type, String author) {
        this.type = type;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "type=" + type +
                ", author='" + author + '\'' +
                '}';
    }
}
