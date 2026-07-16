public class CallStack {

    static class Node {
        String function;
        Node next;

        Node(String function) {
            this.function = function;
        }
    }

    Node top;

    void push(String function) {

        Node newNode = new Node(function);
        newNode.next = top;
        top = newNode;
    }

    String pop() {

        if (top == null)
            return "Empty";

        String value = top.function;
        top = top.next;

        return value;
    }

    String peek() {

        if (top == null)
            return "Empty";

        return top.function;
    }

    public static void main(String[] args) {

        CallStack stack = new CallStack();

        stack.push("main()");
        stack.push("login()");
        stack.push("validate()");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}