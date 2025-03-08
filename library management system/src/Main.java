import entities.Book;
import main.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
    System.out.println("-----------------------------------------------------");
    System.out.println("Welcome to our library");
    System.out.println("-----------------------------------------------------");
    System.out.println("Following functionalities are available\n");
    System.out.println("1. Add book to the library\n" +
            "2. remove book from the library\n" +
            "3. view all available books\n"+
            "4. view most popular books\n"+
            "5. borrow a book\n"+
            "6. return a book\n"+
            "7. check book availability\n"+
            "8. search for a book using author name\n"+
            "9. search for a book using ISBN \n"+
            "10. search for a book using title \n"+
            "11. generate report\n"+
            "12. exit");
    System.out.println("-----------------------------------------------------");

    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    int choice;
    boolean flag=true;
    while (flag) {
        System.out.println("Enter your choice");
        choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1:{
                System.out.println("Enter book ISBN");
                int isbn =Integer.parseInt(reader.readLine());
                System.out.println("Enter book title");
                String title=reader.readLine().toLowerCase();
                System.out.println("Enter book author name");
                String author= reader.readLine().toLowerCase();
                System.out.println("Enter book genre");
                String genre = reader.readLine();;
                System.out.println("Enter book publication year");
                int year = Integer.parseInt(reader.readLine());
                Library.add(new Book(isbn,title,author,genre,year));}
                break;
            case 2:{
                System.out.println("Enter book ISBN");
                int isbn =Integer.parseInt(reader.readLine());
                Library.remove(isbn);
               }
                break;
            case 3:
                System.out.println("Available books :");
                Library.displayAvailableBooks();
                break;
            case 4:
                Library.displayMostBorrowedBook();
                break;
            case 5:
            {
                System.out.println("Enter book ISBN");
                int isbn =Integer.parseInt(reader.readLine());
                Library.borrowBook(isbn);
            }
            break;
            case 6:
            {
                System.out.println("Enter book ISBN");
                int isbn =Integer.parseInt(reader.readLine());
                Library.returnBook(isbn);
            }
            break;
            case 7:
            {
                System.out.println("Enter book ISBN");
                int isbn =Integer.parseInt(reader.readLine());
                Book b =Library.searchByISBN(isbn);
                if(b==null)
                    System.out.println("this book is not exist");

                else if(!b.checkAvailability())
                    System.out.println("book is not available");
                else
                System.out.println(b.getBookInfo());

            }
            break;
            case 8:
                System.out.println("Enter author name");
                String author= reader.readLine().toLowerCase();
                ArrayList<Book> list =Library.searchByAuthor(author);
                if(!list.isEmpty()){
                    for (int i=0;i<list.size();i++)
                        System.out.println(list.get(i).getBookInfo());
                }
                else {
                    System.out.println("No books found for "+author);
                }
                break;
            case 9:
            {
                System.out.println("Enter book ISBN");
                int isbn = Integer.parseInt(reader.readLine());
                Book b= Library.searchByISBN(isbn);
                System.out.println(b!=null? b.getBookInfo():"No book found with this ISBN");

            }
                break;
            case 10:{
                System.out.println("Enter book title");
                String title= reader.readLine().toLowerCase();
                Book b= Library.searchByTitle(title);
                System.out.println(b!=null? b.getBookInfo():"No book found with this title");
            }
                break;
            case 11:
                Library.generateReport();
                break;
            case 12:
                flag=false;
        }
    }


  }
}