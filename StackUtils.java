public class StackUtils {
    public StackUtils() {
    }

    public boolean getIsBalanced(String value) {
        boolean isBalanced = false;
        Stack<Character> stack = new Stack<Character>();
        Character currentStackValue;

        for (char c : value.toCharArray()) {
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

    private Integer addition(Integer val1, Integer val2) throws Exception {
        if (val1 == null || val2 == null) {
            throw new Exception("Invalid expression entry");
        }

        return val1 + val2;
    }

    private Integer multiply(Integer val1, Integer val2) throws Exception {
        if (val1 == null || val2 == null) {
            throw new Exception("Invalid expression entry");
        }

        return val1 * val2;
    }

    public int calculation(String expression) throws Exception {
        Integer result = 0;
        Integer operator1, operator2;
        String currentValue = "";
        Stack<String> s1 = new Stack<String>();
        Stack<Integer> s2 = new Stack<Integer>();
        char[] chars = expression.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                currentValue = chars[i] + currentValue;

                if (i != 0) {
                    continue;
                }
            }

            if (currentValue.length() > 0) {
                s1.push(currentValue);
                currentValue = "";
            }
        }

        while (s1.size() > 0) {
            currentValue = s1.pop();

            switch (currentValue) {
            case "+":
                operator2 = s2.pop();
                operator1 = s2.pop();
                result = this.addition(operator1, operator2);
                s2.push(result);
                continue;
            case "*":
                operator2 = s2.pop();
                operator1 = s2.pop();
                result = this.multiply(operator1, operator2);
                s2.push(result);
                continue;
            case "=":
                result = s2.peek();
                continue;
            default:
                break;
            }

            try {
                int value = Integer.valueOf(currentValue);
                s2.push(value);
            } catch (Exception e) {
                throw new Exception("The operator is not supported");
            }
        }

        return result;
    }
}
