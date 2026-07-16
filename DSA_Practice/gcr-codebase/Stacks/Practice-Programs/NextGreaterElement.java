import java.util.Stack;

public class NextGreaterElement {

    static int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
            ans[i] = -1;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    arr[i] > arr[stack.peek()]) {

                ans[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 25};

        int[] ans = nextGreater(arr);

        for (int x : ans)
            System.out.print(x + " ");
    }
}