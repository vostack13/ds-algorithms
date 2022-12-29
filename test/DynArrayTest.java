import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArrayTest {
    public DynArrayTest() {
    }

    public void makeArray() {
    }

    public void getItem() {
    }

    public void append() {
        TestCase testCase = new TestCase("Append item to end list — append()");
        Integer[] testArray, actualArray;
        int testCount, actualCount, testCapacity, actualCapacity;
        DynArray<Integer> dynArray;

        testArray = (Integer []) Array.newInstance(Integer.class, 16);
        for (int i = 0; i < 15; i++) {
            testArray[i] = i;
        }
        testCount = 15;
        testCapacity = 16;
        dynArray = new DynArray<Integer>(Integer.class);
        actualArray = (Integer[]) dynArray.array;
        for (int i = 0; i < 15; i++) {
            dynArray.append(i);
        }
        actualCount = dynArray.count;
        actualCapacity = dynArray.capacity;
        testCase.start("вставка элемента, когда в итоге размер буфера не превышен").equals(testArray, actualArray)
                .equals(testCount, actualCount).equals(testCapacity, actualCapacity).end();

        testArray = (Integer []) Array.newInstance(Integer.class, 32);
        for (int i = 0; i < 17; i++) {
            testArray[i] = i;
        }
        testCount = 17;
        testCapacity = 32;
        dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            dynArray.append(i);
        }
        actualArray = (Integer[]) dynArray.array;
        actualCount = dynArray.count;
        actualCapacity = dynArray.capacity;
        testCase.start("вставка элемента, когда в результате превышен размер буфера").equals(testArray, actualArray)
                .equals(testCount, actualCount).equals(testCapacity, actualCapacity).end();
    }

    public void insert() {
        TestCase testCase = new TestCase("Insert item to list — insert()");
        Integer[] testArray, actualArray;
        int testCount, actualCount, testCapacity, actualCapacity;
        DynArray<Integer> dynArray;

        testArray = new Integer[] {};
        testCount = 0;
        testCapacity = 16;
        dynArray = new DynArray<Integer>(Integer.class);
        actualArray = (Integer[]) dynArray.array;
        actualCount = dynArray.count;
        actualCapacity = dynArray.capacity;
        for (int i = 0; i < 15; i++) {
            dynArray.append(i + 1);
        }
        dynArray.insert(99, 0);
        testCase.start("попытка вставки элемента в недопустимую позицию").equals(testArray, actualArray)
                .equals(testCount, actualCount).equals(testCapacity, actualCapacity).end();
    }

    public void remove() {
        TestCase testCase = new TestCase("Remove item from list — remove()");
        Integer[] testArray, actualArray;
        int testCount, actualCount, testCapacity, actualCapacity;
        DynArray<Integer> dynArray;

        testArray = new Integer[] {};
        testCount = 0;
        testCapacity = 16;
        dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 32; i++) {
            dynArray.append(i + 1);
        }
        for (int i = 31; i >= 8; i--) {
            dynArray.remove(i);
        }
        actualArray = (Integer[]) dynArray.array;
        actualCount = dynArray.count;
        actualCapacity = dynArray.capacity;
        testCase.start("попытка вставки элемента в недопустимую позицию").equals(testArray, actualArray)
                .equals(testCount, actualCount).equals(testCapacity, actualCapacity).end();
    }

    public void run() {
        this.makeArray();
        this.getItem();
        this.append();
        this.insert();
        this.remove();
    }
}

class TestCase {
    boolean isSuccess;
    String message;
    String description;

    public TestCase(String title) {
        System.out.println("\n" + title);
    }

    private void reset() {
        this.isSuccess = true;
        this.description = null;
        this.message = null;
    }

    public TestCase start(String _message) {
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

    public <T> TestCase equals(T[] array1, T[] array2) {
        if (!isSuccess) {
            return this;
        }

        this.isSuccess = Arrays.equals(array1, array2);

        return this;
    }

    public TestCase equals(Integer array1, Integer array2) {
        if (!isSuccess) {
            return this;
        }

        this.isSuccess = array1 == array2;

        return this;
    }

    public void showDynArray(DynArray<Integer> dynArray) {
        for (int i = 0; i < dynArray.array.length; i++) {
            System.out.println(dynArray.array[i]);
        }

        System.out.println("count: " + dynArray.count);
        System.out.println("capacity: " + dynArray.capacity);
    }

    public <T> void showArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}