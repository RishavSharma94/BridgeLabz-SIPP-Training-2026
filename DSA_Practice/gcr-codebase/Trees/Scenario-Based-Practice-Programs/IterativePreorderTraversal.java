import java.util.*;

public class IterativePreorderTraversal {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static List<Integer> iterativePreorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Node curr = stack.pop();

            result.add(curr.data);

            if (curr.right != null)
                stack.push(curr.right);

            if (curr.left != null)
                stack.push(curr.left);
        }

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(iterativePreorder(root));
    }
}