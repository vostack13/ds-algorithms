public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue, int count) {
        while (count != 0) {
            queue.enqueue(queue.dequeue());
            count--;
        }
    }
}
