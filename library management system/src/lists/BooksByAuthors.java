package lists;

import entities.Book;

import java.util.ArrayList;
import java.util.HashMap;

public class BooksByAuthors {
   public static HashMap<String, ArrayList<Book>> booksByAuthor = new HashMap<>();

    public static void add( Book book){
        if(booksByAuthor.get(book.getAuthor())==null){
            ArrayList<Book> books=new ArrayList<>();
            books.add(book);
            booksByAuthor.put(book.getAuthor(),books);
        }
        else {
            booksByAuthor.get(book.getAuthor()).add(book);
        }
    }

    public static void remove (Book book){
        if(search(book.getAuthor())!=null)
        booksByAuthor.get(book.getAuthor()).remove(book);
        else System.out.println("book not found");
    }



    public static ArrayList<Book>  search(String author){
        return  booksByAuthor.get(author);
    }
}
