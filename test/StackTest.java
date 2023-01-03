public class StackTest {
    public StackTest() {
    }
    
    public void size() {
        StackTestCase testCase = new StackTestCase("Size Stack — size()");
        Integer testValue, actualValue;
        Stack<String> actualStack;

        testValue = 0;
        actualStack = new Stack<String>();
        actualValue = actualStack.size();
        testCase.start("Размер пустого стэка").equals(testValue, actualValue).end();

        testValue = 3;
        actualStack = new Stack<String>();
        actualStack.push("1");
        actualStack.push("2");
        actualStack.push("3");
        actualValue = actualStack.size();
        testCase.start("Размер стека из 3-х элементов").equals(testValue, actualValue).end();
    }

    public void pop() {
        StackTestCase testCase = new StackTestCase("Size Stack — pop()");
        Integer testCount, actualCount;
        String testValue, actualValue;
        Stack<String> actualStack;
        
        testCount = 2;
        testValue = "3"; 
        actualStack = new Stack<String>();
        actualStack.push("1");
        actualStack.push("2");
        actualStack.push("3");
        actualValue = actualStack.pop();
        actualCount = actualStack.size();
        testCase.start("Получени первого элемента и его удаление из стека").equals(testCount, actualCount).equalsString(testValue, actualValue).end();

        testCount = 0;
        testValue = null; 
        actualStack = new Stack<String>();
        actualStack.push("1");
        actualStack.push("2");
        actualStack.push("3");
        actualStack.pop();
        actualStack.pop();
        actualValue = actualStack.pop();
        actualValue = actualStack.pop();
        actualCount = actualStack.size();
        testCase.start("Получени первого элемента и его удаление из стека").equals(testCount, actualCount).equalsString(testValue, actualValue).end();
    }

    public void push() {
        StackTestCase testCase = new StackTestCase("Size Stack — push()");
        Integer testCount, actualCount;
        String testValue, actualValue;
        Stack<String> actualStack;
        
        testCount = 1;
        testValue = "1"; 
        actualStack = new Stack<String>();
        actualStack.push("1");
        actualCount = actualStack.size();
        actualValue = actualStack.peek();
        testCase.start("Добавление 1 элемента").equals(testCount, actualCount).equalsString(testValue, actualValue).end();

        testCount = 3;
        testValue = "3"; 
        actualStack = new Stack<String>();
        actualStack.push("1");
        actualStack.push("2");
        actualStack.push("3");
        actualCount = actualStack.size();
        actualValue = actualStack.peek();
        testCase.start("Добавление 3-х элементов").equals(testCount, actualCount).equalsString(testValue, actualValue).end();
    }

    public void peek() {
        StackTestCase testCase = new StackTestCase("Size Stack — peek()");
        Integer testCount, actualCount;
        String testValue, actualValue;
        Stack<String> actualStack;
        
        testCount = 0;
        testValue = null; 
        actualStack = new Stack<String>();
        actualCount = actualStack.size();
        actualStack.pop();
        actualValue = actualStack.peek();
        testCase.start("Получение первого элемента").equals(testCount, actualCount).equalsString(testValue, actualValue).end();
    }

    public void run() {
        this.size();
        this.pop();
        this.push();
        this.peek();
    }
}

class StackTestCase {
    boolean isSuccess;
    String message;
    String description;

    public StackTestCase(String title) {
        System.out.println("\n" + title);
    }

    private void reset() {
        this.isSuccess = true;
        this.description = null;
        this.message = null;
    }

    public StackTestCase start(String _message) {
        reset();
        this.message = _message;
        return this;
    }

    public void end() {
        showResultMessage(this.message, this.isSuccess, this.description);
        reset();
    }

    private void showResultMessage(String message, boolean is_success, String description) {
        if (is_success)
            System.out.println(" ✓ success — " + message);
        else
            System.out.println(" ✕ failed  — " + message);

        if (description != null) {
            System.out.println("   ◦ " + description);
        }
    }

    // public <T> TestCase equals(T[] array1, T[] array2) {
    //     if (!isSuccess) {
    //         return this;
    //     }

    //     this.isSuccess = Arrays.equals(array1, array2);

    //     return this;
    // }

    public StackTestCase equals(Integer value1, Integer value2) {
     if (!isSuccess) {
         return this;
     }

     this.isSuccess = value1 == value2;

     return this;
    }

    public StackTestCase equalsString(String value1, String value2) {
     if (!isSuccess) {
         return this;
     }

     this.isSuccess = value1 == value2;

     return this;
    }
    // public void showDynArray(DynArray<Integer> dynArray) {
    //     for (int i = 0; i < dynArray.array.length; i++) {
    //         System.out.println(dynArray.array[i]);
    //     }

    //     System.out.println("count: " + dynArray.count);
    //     System.out.println("capacity: " + dynArray.capacity);
    // }

    // public <T> void showArray(T[] array) {
    //     for (int i = 0; i < array.length; i++) {
    //         System.out.println(array[i]);
    //     }
    // }
}