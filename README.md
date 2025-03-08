# Library Managment System 
This is a simple Library Management System implemented using Java. It allows users to add, view, edit, and delete books from the library.
## This functionalities are available
  1. Add book with details such as ISBN, title, auther name and publication year
  2. Remove book by entering book ISBN
  3. Borrow and return book
  4. Search for a book by different criteria such as ISBN, auther name and book title
  5. sorting books by different criteria 
  6. View all available books
  7. Generate report
## Data structure used
  - **Binarry search tree:** used to order books by ISBN, it allows fast search with O(logn) time complexity 
  - **HashMap:** used to support fast search by author name and book title with O(1) time complexity
  - **Queue:** used to manage reservation requests, it processes data in FIFO order.
  - **Priority Queue:** used to organize books by most borrowed
  - **ArrayList:** used to store the books ,It allows quick sorting and access to data.
## Time complexity for the main functions
  - **Add Book**: O(log n), it contains adding book to binary search tree.
  - **Remove book**: O(n) contains removing book from ArrayList which require shifting elements.
  - **Sorting functions**: O(nlog n).
  - **Serach by ISBN**: O(log n), search is implemented using a binary search tree.
  - **Search by title or author name**: O(1),  search is implemented using hashmap.
## Prerequisites
  - Java Development Kit (JDK) installed on your system.
  - Any Java IDE.
## How to Run
  1. Clone the repository or download the source code files.
  2. Open the project in your preferred Java IDE.
  3. Build and run the Main.java file.

     
