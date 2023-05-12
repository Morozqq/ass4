public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left,right;
        public Node(K key, V val){
            this.key= key;
            this.val=val;
        }
    }
    //putting a node in the tree
    public void put(K key, V val) {
        // new node is created with the given key-value pair
        Node newNode = new Node(key, val);
        //if root is null the new node becomes a root
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            // iterate until a return statement is executed
            while (true) {
                parent = focusNode;
                // if key is less than the focusNode it goes to left
                if (key.compareTo(focusNode.key) < 0) {
                    focusNode = focusNode.left;
                    // if focusNode is null than it makes a child of the left node
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                    //if key is more than focusNode it goes to right
                } else {
                    focusNode = focusNode.right;
                    // if focusNode is null than it makes a child of the right node
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    public V get(K key) {
        //creating new node and giving the value of the root
        Node currentNode = root;
        //starting the loop until the node is zero
        while (currentNode != null) {
            // the result of compares with the current node is stored in result

            int result = key.compareTo(currentNode.key);
            //if in comparing it's less then 0 it goes to left,if more to right(larger)
            if (result < 0) {
                currentNode = currentNode.left;
            }
            else if (result > 0) {
                currentNode = currentNode.right;
            }
            //when its 0 it means that we found our key
            else {
                return currentNode.val;
            }
        }
        return null;
    }
    //delete method
    public void delete(K key) {
        Node focusNode = root;
        Node parent = root;
        boolean isLeftChild = true; //assumption that focus node is a left child initially
        //traversing until focus node is null and its key is not equal to the given key
        while (focusNode != null && focusNode.key.compareTo(key) != 0) {
            parent = focusNode;
            //comparing key with the focus node
            if (key.compareTo(focusNode.key) < 0) {
                focusNode = focusNode.left;
                //left child have to be updated
                isLeftChild = true;
            } else {
                //right child have to be updated
                focusNode = focusNode.right;
                isLeftChild = false;
            }
        }
        //nothing found
        if (focusNode == null) {
            return;
        }

        // it checks if the node have to be deleted have no children
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // if the node to be deleted has only one child, which is the right child.
        else if (focusNode.left == null) {
            if (focusNode == root) {
                root = focusNode.right;
            } else if (isLeftChild) {
                parent.left = focusNode.right;
            } else {
                parent.right = focusNode.right;
            }
            // if the node to be deleted has only one child, which is the left child.
        } else if (focusNode.right == null) {
            if (focusNode == root) {
                root = focusNode.left;
            } else if (isLeftChild) {
                parent.left = focusNode.left;
            } else {
                parent.right = focusNode.left;
            }
        }

        else {
            //This block is executed if the node to be deleted has two children.
            // In this case, a replacement node is found to take the deleted node's place.
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
            replacement.left = focusNode.left;
        }
    }

    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.right;
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }
        if (replacement != replacedNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;
        }
        return replacement;
    }



    public Iterable<K> iterator(){

    }
    public void InOrderTraversal(Node focusNode){
        if (focusNode==null){
            InOrderTraversal(focusNode.left);
            InOrderTraversal(focusNode.right);
        }
    }
}
