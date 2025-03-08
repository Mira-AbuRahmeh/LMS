package lists;

import entities.Book;

import java.util.HashMap;

public class BooksByTitle {
   public static HashMap<String, Book> bookByTitle=new HashMap<String, Book>();
    public static void add(Book book){
        bookByTitle.put(book.getTitle(),book);
    }
    public static void remove(Book book){
        if( search(book.getTitle()) !=null)
        bookByTitle.remove(book.getTitle());
        else
            System.out.println("book not found");

    }
    public static Book search(String title){
        return bookByTitle.get(title);
    }

}
