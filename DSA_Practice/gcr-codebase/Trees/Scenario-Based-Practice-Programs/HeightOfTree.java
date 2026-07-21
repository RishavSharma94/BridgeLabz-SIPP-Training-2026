public class HeightOfTree {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {

        if (root == null)
            return -1;

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isTooDeep(Node root, int threshold) {

        return height(root) > threshold;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height = " + height(root));

        int threshold = 2;

        if (isTooDeep(root, threshold))
            System.out.println("Tree exceeds threshold.");
        else
            System.out.println("Tree is within threshold.");
    }
}