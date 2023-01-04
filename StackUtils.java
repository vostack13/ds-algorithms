import java.util.Objects;

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

    public double calculation(String expression) throws Exception {
        Double result = 0.0;
        Double operator1, operator2;
        String currentValue = "";
        Stack<String> s1 = new Stack<String>();
        Stack<Double> s2 = new Stack<Double>();
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

            if (Objects.equals(currentValue, "=")) {
                result = s2.peek();
                break;
            }

            try {
                Double value = Double.valueOf(currentValue);
                s2.push(value);
                continue;
            } catch (Exception e) {
            }

            operator2 = s2.pop();
            operator1 = s2.pop();

            if (operator1 == null || operator2 == null) {
                throw new Exception("Invalid expression entry");
            }

            switch (currentValue) {
            case "+":
                result = this.addition(operator1, operator2);
                break;
            case "*":
                result = this.multiply(operator1, operator2);
                break;
            case "-":
                result = this.subtraction(operator1, operator2);
                break;
            case "/":
                result = this.division(operator1, operator2);
                break;
            default:
                throw new Exception("The operator is not supported");
            }

            s2.push(result);
        }

        return result;
    }

    private Double addition(Double val1, Double val2) {
        return val1 + val2;
    }

    private Double multiply(Double val1, Double val2) {
        return val1 * val2;
    }

    private Double subtraction(Double val1, Double val2) {
        return val1 - val2;
    }

    private Double division(Double val1, Double val2) {
        return val1 / val2;
    }
}
