public class UndoBuffer {

    private String[] data;
    private int top;

    public UndoBuffer(int size) {
        data = new String[size];
        top = -1;
    }

    public void push(String edit) {
        if (top == data.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        data[++top] = edit;
    }

    public String pop() {
        if (isEmpty())
            return "Nothing to Undo";
        return data[top--];
    }

    public String peek() {
        if (isEmpty())
            return "Empty";
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {

        UndoBuffer stack = new UndoBuffer(3);

        stack.push("Edit1");
        stack.push("Edit2");
        stack.push("Edit3");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}