public class ValidateBST {

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
        else
            root.right = insert(root.right, data);

        return root;
    }

    static boolean isValid(Node root, long min, long max) {

        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isValid(root.left, min, root.data)
                && isValid(root.right, root.data, max);
    }

    public static void main(String[] args) {

        Node root = null;

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            root = insert(root, x);

        System.out.println(isValid(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}