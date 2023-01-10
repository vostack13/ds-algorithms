public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue, int count) {
        for (int i = 0; i < count; i++) {
            queue.enqueue(queue.dequeue());
        }
    }
}
