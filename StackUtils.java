public class StackUtils {
    public StackUtils() {
    }

    public boolean getIsBalanced(String value) {
        boolean isBalanced = false;
        Stack<Character> stack = new Stack<Character>();

        for (char c: value.toCharArray()) {
           if (stack.peek() != c) {
            stack.push(c);
           } else {
            stack.pop();
           }
        }

         
        return isBalanced;
    }
}
