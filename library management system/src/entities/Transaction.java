package entities;

import java.util.Date;

public class Transaction {
    private String type;
    private Book book;
    private Date time;


    public Transaction(String type, Book book) {
        this.type = type;
        this.book = book;
        this.time = new Date();
    }

    public String getType() {
        return type;
    }

    public Book getBook() {
        return book;
    }

    public Date getTime() {
        return time;
    }


}
