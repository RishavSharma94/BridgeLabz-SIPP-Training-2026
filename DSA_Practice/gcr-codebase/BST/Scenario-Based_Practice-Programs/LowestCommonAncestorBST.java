public class LowestCommonAncestorBST {

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

    static Node LCA(Node root, int p, int q) {

        while (root != null) {

            if (p < root.data && q < root.data)
                root = root.left;

            else if (p > root.data && q > root.data)
                root = root.right;

            else
                return root;
        }

        return null;
    }

    public static void main(String[] args) {

        Node root = null;

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            root = insert(root, x);

        Node ans = LCA(root, 20, 40);

        System.out.println("Lowest Common Ancestor = " + ans.data);
    }
}