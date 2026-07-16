import java.util.Stack;

public class ScenarioBasedQ_CompilerStackValidator {

    // Balanced Brackets
    static boolean isBalanced(String code) {

        Stack<Character> stack = new Stack<>();

        for (char ch : code.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '['))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    // Next Greater Price
    static void nextGreaterPrice(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            stack.push(prices[i]);
        }

        System.out.print("Next Greater Price: ");

        for (int x : ans)
            System.out.print(x + " ");

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

        System.out.print("Stock Span: ");

        for (int x : span)
            System.out.print(x + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        String code = "{[()]}";

        if (isBalanced(code))
            System.out.println("Balanced Brackets");
        else
            System.out.println("Not Balanced");

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        nextGreaterPrice(prices);

        stockSpan(prices);
    }
}