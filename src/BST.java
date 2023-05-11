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

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key.compareTo(focusNode.key) < 0) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    public V get(K key){

    }
    public void delete(K key) {
        Node focusNode = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (focusNode != null && focusNode.key.compareTo(key) != 0) {
            parent = focusNode;
            if (key.compareTo(focusNode.key) < 0) {
                focusNode = focusNode.left;
                isLeftChild = true;
            } else {
                focusNode = focusNode.right;
                isLeftChild = false;
            }
        }

        if (focusNode == null) {
            return;
        }


        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        else if (focusNode.left == null) {
            if (focusNode == root) {
                root = focusNode.right;
            } else if (isLeftChild) {
                parent.left = focusNode.right;
            } else {
                parent.right = focusNode.right;
            }
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
