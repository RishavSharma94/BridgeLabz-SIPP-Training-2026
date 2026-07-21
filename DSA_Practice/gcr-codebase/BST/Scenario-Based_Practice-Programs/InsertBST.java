public class InsertBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int data) {

        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);

        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        Node root = null;

        for (int x : arr)
            root = insert(root, x);

        inorder(root);
    }
}