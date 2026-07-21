import java.util.*;

class PersonNode {
    String name;
    PersonNode left;
    PersonNode right;

    public PersonNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}

public class ScenarioBasedFamilyTree {
    private PersonNode root;

    public ScenarioBasedFamilyTree(String rootName) {
        this.root = new PersonNode(rootName);
    }

    public List<String> inorderRecursive(PersonNode node, List<String> result) {
        if (result == null) result = new ArrayList<>();
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.name);
            inorderRecursive(node.right, result);
        }
        return result;
    }

    public List<String> inorderIterative() {
        List<String> result = new ArrayList<>();
        Stack<PersonNode> stack = new Stack<>();
        PersonNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.name);
            curr = curr.right;
        }
        return result;
    }

    public List<String> preorderRecursive(PersonNode node, List<String> result) {
        if (result == null) result = new ArrayList<>();
        if (node != null) {
            result.add(node.name);
            preorderRecursive(node.left, result);
            preorderRecursive(node.right, result);
        }
        return result;
    }

    public List<String> preorderIterative() {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Stack<PersonNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            PersonNode node = stack.pop();
            result.add(node.name);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    public List<String> postorderRecursive(PersonNode node, List<String> result) {
        if (result == null) result = new ArrayList<>();
        if (node != null) {
            postorderRecursive(node.left, result);
            postorderRecursive(node.right, result);
            result.add(node.name);
        }
        return result;
    }

    public List<String> postorderIterative() {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Stack<PersonNode> stack1 = new Stack<>();
        Stack<PersonNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            PersonNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().name);
        }
        return result;
    }

    public List<String> levelOrderRecursive() {
        List<List<String>> levels = new ArrayList<>();
        traverseLevelOrder(root, 0, levels);

        List<String> result = new ArrayList<>();
        for (List<String> level : levels) {
            result.addAll(level);
        }
        return result;
    }

    private void traverseLevelOrder(PersonNode node, int level, List<List<String>> levels) {
        if (node == null) return;
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.name);
        traverseLevelOrder(node.left, level + 1, levels);
        traverseLevelOrder(node.right, level + 1, levels);
    }

    public List<String> levelOrderIterative() {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<PersonNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            PersonNode node = queue.poll();
            result.add(node.name);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

    public int calculateHeight(PersonNode node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public Map<String, Integer> countNodesPerLevel() {
        Map<String, Integer> counts = new LinkedHashMap<>();
        if (root == null) return counts;

        Queue<PersonNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            counts.put("Generation " + level, levelSize);

            for (int i = 0; i < levelSize; i++) {
                PersonNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return counts;
    }

    private int maxDiameter = 0;

    public int computeDiameter() {
        maxDiameter = 0;
        getDiameterHeight(root);
        return maxDiameter;
    }

    private int getDiameterHeight(PersonNode node) {
        if (node == null) return 0;
        int leftH = getDiameterHeight(node.left);
        int rightH = getDiameterHeight(node.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }

    public boolean isBalanced() {
        return checkBalanceHeight(root) != -1;
    }

    private int checkBalanceHeight(PersonNode node) {
        if (node == null) return 0;

        int left = checkBalanceHeight(node.left);
        if (left == -1) return -1;

        int right = checkBalanceHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        ScenarioBasedFamilyTree tree = new ScenarioBasedFamilyTree("Alex");
        tree.root.left = new PersonNode("John");
        tree.root.right = new PersonNode("Mary");
        tree.root.left.left = new PersonNode("Bob");
        tree.root.left.right = new PersonNode("Alice");
        tree.root.right.right = new PersonNode("David");

        System.out.println("Inorder (Rec):   " + tree.inorderRecursive(tree.root, null));
        System.out.println("Inorder (Iter):  " + tree.inorderIterative());

        System.out.println("Preorder (Rec):  " + tree.preorderRecursive(tree.root, null));
        System.out.println("Preorder (Iter): " + tree.preorderIterative());

        System.out.println("Postorder (Rec): " + tree.postorderRecursive(tree.root, null));
        System.out.println("Postorder (Iter):" + tree.postorderIterative());

        System.out.println("LevelOrder (Rec):" + tree.levelOrderRecursive());
        System.out.println("LevelOrder (Iter):" + tree.levelOrderIterative());

        System.out.println("\nHeight of Tree: " + tree.calculateHeight(tree.root));
        System.out.println("Nodes per Level: " + tree.countNodesPerLevel());
        System.out.println("Diameter: " + tree.computeDiameter());
        System.out.println("Is Balanced?: " + tree.isBalanced());
    }
}