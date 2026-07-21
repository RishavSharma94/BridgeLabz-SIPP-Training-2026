import java.util.Stack;

public class KthSmallestBST {

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

    static int kthSmallest(Node root, int k) {

        Stack<Node> stack = new Stack<>();

        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k)
                return curr.data;

            curr = curr.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        Node root = null;

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            root = insert(root, x);

        int k = 3;

        System.out.println(k + "th Smallest Element = " + kthSmallest(root, k));
    }
}