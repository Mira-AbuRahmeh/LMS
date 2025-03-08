package main;
import entities.Book;
import entities.Transaction;
import lists.BooksByAuthors;
import lists.BooksByTitle;
import lists.binary_search_tree.BST;
import lists.binary_search_tree.Node;
import java.util.*;

public class Library {
   public static BST books =new BST();
   public static ArrayList <Book> collection =new ArrayList<>();
   public static Stack<Transaction> transactions=new Stack<>();
   private static int borrowedBooksCount =0;
   private static int booksCount=0;
   public static PriorityQueue<Book> bookQueue =new PriorityQueue<>(new Comparator<Book>(){

       @Override
       public int compare(Book o1, Book o2) {
           if(o1.getBorrowingTimes()<o2.getBorrowingTimes())
               return 1;
           else if(o1.getBorrowingTimes()>o2.getBorrowingTimes())
               return -1;
           return  0;
       }
   });

   static public void add(Book book){
       if(books.search(books.root,book.getISBN())==null){
        books.add(book);
        collection.add(book);
        BooksByAuthors.add(book);
        BooksByTitle.add(book);
        book.setAvailability(true);
        booksCount++;
           System.out.println("book with title "+book.getTitle()+" added successfully");
       }
       else {
           System.out.println("This book already exists");
       }
    }

  static  public Book remove(int ISBN){
      Book book= searchByISBN(ISBN);
      if(book != null) {
          collection.remove(book);
          books.remove(book);
          BooksByAuthors.remove(book);
          BooksByTitle.remove(book);
          booksCount--;
          System.out.println("book with title " + book.getTitle() + " removed successfully");
      }
      return  book;
    }
  public static Book searchByISBN(int ISBN){
       Node n= books.search(books.root,ISBN);
       if (n!=null){
       return n.data;
       }
       return  null;
  }
   public static Book searchByTitle(String title){
        return BooksByTitle.search(title);
    }

    public static  ArrayList<Book> searchByAuthor(String author){
          return BooksByAuthors.search(author);
    }

    public static void borrowBook(int ISBN){
       Book book= searchByISBN(ISBN);
        if(book!=null) {
            if (book.checkAvailability()) {
                borrowedBooksCount++;
                book.borrowBook();
                transactions.add(new Transaction("Borrow", book));
                System.out.println("book has been borrowed successfully");
            }
            else {
                System.out.println("book is not available");
            }
        }
    }

    public static void returnBook(int ISBN){
        Book book= searchByISBN(ISBN);
       if(book!=null && !book.checkAvailability()){
           borrowedBooksCount--;
           book.returnBook();
           transactions.add(new Transaction("Return",book));
       }
    }

    public static ArrayList<Book> sortByTitle(){
        collection.sort(Comparator.comparing(Book::getTitle));
        return collection;
    }

    public static ArrayList<Book> sortByYear(){
        collection.sort(Comparator.comparing(Book::getYear));
        return collection;
    }

    public static PriorityQueue<Book> sortByPopularity(){
        bookQueue.clear();;
        bookQueue.addAll(collection);
        return  bookQueue;

//        collection.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                if(o1.getBorrowingTimes()< o2.getBorrowingTimes())
//                    return  1;
//                else if(o1.getBorrowingTimes()> o2.getBorrowingTimes())
//                return -1;
//                return 0;
//            }
//        });
//        return collection;
    }

    public static ArrayList<Book> sortByGenre(){
        collection.sort(Comparator.comparing(Book::getGenre));
        return collection;
    }

    public static void displayAllBooks(){
        for (Book book : collection) {
            System.out.println(book.getBookInfo());
        }
    }
    public  static int getAvailableBooksCount(){
       return booksCount-borrowedBooksCount;
    }
    public static void  displayAvailableBooks(){
       if(getAvailableBooksCount()!=0){
        ArrayList <Book> a = sortByGenre();
        int counter=1;
        for(int i=0;i<a.size();i++){
            if(i==0) {
                System.out.println(a.get(i).getGenre()+":");
            }
            else {
                if(a.get(i).getGenre().compareTo(a.get(i-1).getGenre())!=0){
                    if (counter==1)
                        System.out.println("No books available from this genre");
                    System.out.println(a.get(i).getGenre()+":");
                    counter=1;
                }

            }
            if (a.get(i).checkAvailability()) {
                System.out.print((counter++) + ". ");
                System.out.println(a.get(i).getBookInfo());
            }
        }
        if (counter==1)
            System.out.println("No books available from this genre");}
       else
        System.out.println("No any available books");
    }

    public static  void displayMostBorrowedBook(){
        Queue <Book> a = sortByPopularity();
        for (int i=0;i<10;i++){
            if(i<a.size() && a.peek()!=null && a.peek().getBorrowingTimes()!=0)
                System.out.println( a.poll().getBookInfo());}
    }


    public static void generateReport(){
        System.out.println("Total number of books: "+booksCount+"\n"+"Number of borrowed books: "+ borrowedBooksCount +"\n" +"Number of available books: "+ (booksCount-borrowedBooksCount) );
        System.out.println("Most borrowed books: ");
        displayMostBorrowedBook();
        System.out.println("Available books:");
        displayAvailableBooks();
   }
    }






