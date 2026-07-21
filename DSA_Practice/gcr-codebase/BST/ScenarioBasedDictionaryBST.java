public class ScenarioBasedDictionaryBST {

    static class Node {
        String word;
        Node left, right;

        Node(String word) {
            this.word = word;
        }
    }

    static Node root;
    static int count = 0;
    static int kWordFound = 0;

    // Insert Word
    static Node insert(Node root, String word) {

        if (root == null)
            return new Node(word);

        if (word.compareTo(root.word) < 0)
            root.left = insert(root.left, word);
        else if (word.compareTo(root.word) > 0)
            root.right = insert(root.right, word);

        return root;
    }

    // Search Word
    static boolean search(Node root, String word) {

        if (root == null)
            return false;

        if (root.word.equals(word))
            return true;

        if (word.compareTo(root.word) < 0)
            return search(root.left, word);

        return search(root.right, word);
    }

    // Find Minimum
    static Node minimum(Node root) {

        while (root.left != null)
            root = root.left;

        return root;
    }

    // Delete Word
    static Node delete(Node root, String word) {

        if (root == null)
            return null;

        if (word.compareTo(root.word) < 0)
            root.left = delete(root.left, word);

        else if (word.compareTo(root.word) > 0)
            root.right = delete(root.right, word);

        else {

            // Case 1 : Leaf Node
            if (root.left == null && root.right == null)
                return null;

            // Case 2 : One Child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3 : Two Children
            Node temp = minimum(root.right);

            root.word = temp.word;

            root.right = delete(root.right, temp.word);
        }

        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.word + " ");

        inorder(root.right);
    }

    // Kth Alphabetical Word
    static void kthWord(Node root, int k) {

        if (root == null)
            return;

        kthWord(root.left, k);

        count++;

        if (count == k)
            kWordFound = count;

        if (count == k)
            System.out.println("\n" + k + "th Alphabetical Word : " + root.word);

        kthWord(root.right, k);
    }

    // Validate BST
    static boolean isBST(Node root, String min, String max) {

        if (root == null)
            return true;

        if (min != null && root.word.compareTo(min) <= 0)
            return false;

        if (max != null && root.word.compareTo(max) >= 0)
            return false;

        return isBST(root.left, min, root.word)
                && isBST(root.right, root.word, max);
    }

    // Lowest Common Ancestor
    static Node LCA(Node root, String w1, String w2) {

        if (root == null)
            return null;

        if (w1.compareTo(root.word) < 0 && w2.compareTo(root.word) < 0)
            return LCA(root.left, w1, w2);

        if (w1.compareTo(root.word) > 0 && w2.compareTo(root.word) > 0)
            return LCA(root.right, w1, w2);

        return root;
    }

    public static void main(String[] args) {

        String words[] = {
                "Mango", "Apple", "Banana", "Orange", "Grapes",
                "Peach", "Cherry", "Lemon", "Kiwi", "Guava",
                "Papaya", "Berry", "Coconut", "Fig", "Date",
                "Pear", "Plum", "Apricot", "Avocado", "Lychee"
        };

        // Insert 20 Words
        for (String word : words)
            root = insert(root, word);

        System.out.println("Dictionary (Inorder Traversal):");
        inorder(root);

        // Search
        System.out.println("\n\nSearch Mango : " + search(root, "Mango"));
        System.out.println("Search Watermelon : " + search(root, "Watermelon"));

        // Delete (Leaf, One Child, Two Children)
        root = delete(root, "Fig");
        root = delete(root, "Kiwi");
        root = delete(root, "Orange");

        System.out.println("\nDictionary After Deletion:");
        inorder(root);

        // Kth Alphabetical Word
        count = 0;
        kthWord(root, 5);

        // Validate BST
        System.out.println("\nValid BST : " + isBST(root, null, null));

        // Lowest Common Ancestor
        Node lca = LCA(root, "Apple", "Cherry");

        System.out.println("Lowest Common Ancestor of Apple and Cherry : " + lca.word);
    }
}