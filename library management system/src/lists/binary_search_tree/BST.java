package lists.binary_search_tree;
import entities.Book;

public class BST  {
    public Node root;


    private Node addHelper(Node root, Book data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            if (data.getISBN()>=root.data.getISBN() )
                root.right = addHelper(root.right, data);
            else
                root.left = addHelper(root.left, data);
            return root;
        }
    }


    public void add(Book data) {
        root = addHelper(root, data);
    }


    public void remove(Book data) {
      root = removeHelper(root,data);
    }

    private Node removeHelper(Node root,Book data){
        if(root == null)
            return root;
       if( data.getISBN()<root.data.getISBN())
           root.left=removeHelper(root.left,data);
       else if( data.getISBN()>root.data.getISBN())
           root.right=removeHelper(root.right,data);
       else{
           if(root.left == null)
               return  root.right;
           else  if(root.right == null)
               return  root.left;
           root.data=minVal(root.right);
           root.right=removeHelper(root.right,root.data);
       }
                   return root;
    }

    private Book minVal(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return  root.data;
    }


    public Node search(Node root,int ISBN) {
        if(root==null)
            return  null;
        if(root.data.getISBN()==ISBN)
            return  root;
        else if (ISBN > root.data.getISBN()) {
            root=root.right;
            return  search(root,ISBN);
        } else if (ISBN<root.data.getISBN()) {
            root=root.left;
            return  search(root,ISBN);
        }
        return root;
    }


}
