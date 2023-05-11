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
//
    }
    public V get(K key){

    }
    public void delete (K key){

    }
    public Iterable<K> iterator(){

    }
}
