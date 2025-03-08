package entities;

import java.util.LinkedList;
import java.util.Queue;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean isAvailable;
    private int borrowingTimes;
    public static Queue<Transaction> reservationRequest =new LinkedList<>();

    public Book(int ISBN, String title, String author, String genre, int year) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.borrowingTimes=0;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable= isAvailable;
    }

    public int getBorrowingTimes() {
        return borrowingTimes;
    }

    public void borrowBook(){
        if(isAvailable){
            isAvailable=false;
            borrowingTimes+=1;
        }
    }

    public void returnBook(){
        if(!isAvailable){
          isAvailable = true;
          System.out.println("book has been returned successfully");

        }
    }

    public void reserveBook(int userId){
        if(!isAvailable)
            reservationRequest.add(new Transaction("Reserve",this));
    }

    public String getBookInfo(){
        return "ISBN: " + ISBN + " ,Book Title :" + title + " ,Author Name: " + author+" ,borrowing times: "+getBorrowingTimes()+" ,status: "+(isAvailable?"Available":"Not available");
    }

}
