public class DiameterOfTree {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int diameter = 0;

    static int height(Node root) {

        if (root == null)
            return -1;

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int treeDiameter(Node root) {

        diameter = 0;

        height(root);

        return diameter;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Diameter = " + treeDiameter(root));
    }
}