import java.util.*;

public class SortedLeaderboardRetrieval {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root, List<Integer> result) {

        if (root == null)
            return;

        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    static List<Integer> getSortedLeaderboard(Node root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println(getSortedLeaderboard(root));
    }
}