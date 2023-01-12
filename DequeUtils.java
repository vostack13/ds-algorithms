public class DequeUtils {
    public DequeUtils() {
    }

    public boolean isPalindrome(String value) {
        Deque<Character> deque = new Deque<Character>();

        for (char c : value.toCharArray()) {
            deque.addTail(c);
        }

        while (deque.size() > 1) {
            char a = deque.removeFront();
            char b = deque.removeTail();

            if (a != b) {
                return false;
            }
        }

        return true;
    }
}
