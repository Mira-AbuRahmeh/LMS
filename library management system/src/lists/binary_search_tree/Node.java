package lists.binary_search_tree;


import entities.Book;

public class Node {
    public Book data ;
    Node right;
    Node left;

    public Node(Book data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
}
