public class SearchBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean search(Node root, int key) {

        while (root != null) {

            if (key == root.data)
                return true;

            if (key < root.data)
                root = root.left;
            else
                root = root.right;
        }

        return false;
    }

    static Node insert(Node root, int data) {

        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    public static void main(String[] args) {

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        Node root = null;

        for (int x : arr)
            root = insert(root, x);

        System.out.println(search(root, 60));
        System.out.println(search(root, 100));
    }
}