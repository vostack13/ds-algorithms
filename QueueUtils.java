public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue) {
        while (queue.size() > 0) {
            T item = queue.dequeue();
            queue.enqueue(item);
        }
    }
}
