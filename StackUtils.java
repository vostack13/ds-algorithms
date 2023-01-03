public class StackUtils {
    public StackUtils() {
    }

    public boolean getIsBalanced(String value) {
        boolean isBalanced = false;
        Stack<Character> stack = new Stack<Character>();
        Character currentStackValue;

        for (char c: value.toCharArray()) {
            currentStackValue = stack.peek();

            if (currentStackValue != null && currentStackValue != c && c == ')') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        if (stack.size() == 0) {
            isBalanced = true;
        }

        return isBalanced;
    }
}
