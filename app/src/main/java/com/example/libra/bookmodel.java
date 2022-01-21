package com.example.libra;

public class bookmodel {
    private String book_id;
    private String book_name;
    private String author;
    private String genre;

    public bookmodel(String book_id, String book_name, String author, String genre) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.genre = genre;
    }
    public bookmodel(){

    }
    public boolean empty_check(){
        return book_id.isEmpty();
    }
    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "bookmodel{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
