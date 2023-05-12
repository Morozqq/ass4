public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        // Test putting nodes
        bst.put(10, "Asik");
        bst.put(20, "Basik");
        bst.put(5, "Casic");
        bst.put(15, "Dasic");
        bst.put(3, "Esik");
        bst.put(7, "Fesic");
        bst.put(17, "Gesic");
        bst.put(23, "Hesik");
        bst.put(19, "Ibala");

        // Test getting nodes
        System.out.println(bst.get(10));
        System.out.println(bst.get(20));
        System.out.println(bst.get(5));
        System.out.println(bst.get(15));


        // Test deleting nodes
        bst.delete(20);
        bst.delete(3);
        bst.delete(23);
        System.out.println(bst.get(20));
        System.out.println(bst.get(3));
        System.out.println(bst.get(23));

    }
}