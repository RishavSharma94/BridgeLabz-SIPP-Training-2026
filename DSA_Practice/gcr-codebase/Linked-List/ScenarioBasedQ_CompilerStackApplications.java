import java.util.Stack;

public class ScenarioBasedQ_CompilerStackApplications {

    public static void main(String[] args) {

        String code = "{[()]}";

        System.out.println("Balanced Brackets: " + isBalanced(code));

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("\nNext Greater Price:");
        nextGreaterPrice(prices);

        System.out.println("\nStock Span:");
        stockSpan(prices);
    }

    // Check Balanced Brackets
    static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Next Greater Price
    static void nextGreaterPrice(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(prices[i]);
        }

        for (int value : result) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    // Stock Span
    static void stockSpan(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] span = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() &&
                    prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - stack.peek();

            stack.push(i);
        }

        for (int value : span) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}