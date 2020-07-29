public class BST {

    /**
     * Creates a node in the tree
     */
    private static class Node {

        /**
         * Word is the data
         */
        private Word data;

        /**
         * Left branch
         */
        private Node left;

        /**
         * Right branch
         */
        private Node right;

        /**
         * Creates a node with a word
         * @param d the word
         */
        public Node (Word d){

            data = d;

            left = null;

            right = null;
        }

        /**
         * Makes the data into a printable string
         * @return  a printable string of data
         */
        public String toString(){

            return "" + data;
        }
    }

    /**
     * The start of the tree
     */
    private Node root;

    /**
     * Creates the tree
     */
    public BST() {

        root = null;
    }

    /**
     * Checks if the tree is empty or not
     * @return  true if empty, false otherwise
     */
    public boolean isEmpty() {

        return root == null;
    }

    /**
     * Adds a word into the tree
     * @param d word to be added
     */
    public void add(Word d) {

        root = add(d, root);

    }

    /**
     * Adds the word into its rightful branch
     * @param d the word
     * @param n current branch
     * @return  branch to be added in
     */
    private Node add(Word d, Node n){

        if(n == null){

            return new Node(d);
        }
        else{

            if(d.compareTo(n.data) == 0){
                n.data.incFrequency();
            }

            else if(d.compareTo(n.data) < 0){

                n.left = add(d, n.left);
            }
            else{

                n.right = add(d, n.right);
            }

            return n;
        }
    }

    /**
     * Prints out the tree
     */
    public void printBST(){

        if(isEmpty()){

            System.out.println("The tree is empty");
        }
        else{

            printBST(root);
        }
    }

    /**
     * Prints the node at a branch
     * @param n current branch
     */
    public void printBST(Node n){

        if(n.left != null){

            printBST(n.left);
        }

        System.out.print(n.data + "\n");

        if(n.right != null){

            printBST(n.right);
        }
    }

    /**
     * Check if the tree contains a word
     * @param d word to check
     * @return  word at a specified branch
     */
    public Word contains(Word d){

        if(root == null){

            return null;
        }
        else{

            return contains(d, root);
        }
    }

    /**
     * Checks to see if the tree contains a word
     * @param d word to check
     * @param n branch it's at
     * @return  word and the next branch
     */
    private Word contains(Word d, Node n){

        if(d.compareTo(n.data) == 0){

            return n.data;
        }
        if(d.compareTo(n.data) < 0){

            if(n.left == null){

                return null;
            }
            else{

                return contains(d, n.left);
            }
        }
        else{
            if(n.right == null){

                return null;
            }
            else{

                return contains(d, n.right);
            }
        }
    }
}
