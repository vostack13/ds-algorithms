public class QueueTest {
    public QueueTest() {
    }

    public void enqueue() {
        QueueTestCase testCase = new QueueTestCase ("Add to queue — enqueue()");
        Integer testCount, actualCount;
        Queue<Integer> actualQueue;

        testCount = 3;
        actualQueue = new Queue<Integer>();
        actualQueue.enqueue(1);
        actualQueue.enqueue(1);
        actualQueue.enqueue(1);
        actualCount = actualQueue.size();
        testCase.start("Добавление элементов в очередь").equals(testCount, actualCount).end();
    }

    public void dequeue() {
        QueueTestCase testCase = new QueueTestCase ("Remove from queue — dequeue()");
        Integer testCount, actualCount;
        Integer testValue, actualValue;
        Queue<Integer> actualQueue;

        testCount = 1;
        testValue = 2;
        actualQueue = new Queue<Integer>();
        actualQueue.enqueue(1);
        actualQueue.enqueue(2);
        actualQueue.enqueue(3);
        actualQueue.dequeue();
        actualValue= actualQueue.dequeue();
        actualCount = actualQueue.size();
        System.out.println(actualValue);
        System.out.println(actualCount);
        testCase.start("Добавление элементов в очередь").equals(testCount, actualCount).equals(testValue, actualValue).end();
    }

    public void size() {}

    public void run() {
        this.enqueue();
        this.dequeue();
        this.size();
    }
}

class QueueTestCase {
    boolean isSuccess;
    String message;
    String description;

    public QueueTestCase(String title) {
        System.out.println("\n" + title);
    }

    private void reset() {
        this.isSuccess = true;
        this.description = null;
        this.message = null;
    }

    public QueueTestCase start(String _message) {
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

    public QueueTestCase equals(Integer value1, Integer value2) {
     if (!isSuccess) {
         return this;
     }

     this.isSuccess = value1 == value2;

     return this;
    }

    public QueueTestCase equalsString(String value1, String value2) {
     if (!isSuccess) {
         return this;
     }

     this.isSuccess = value1 == value2;

     return this;
    }
}