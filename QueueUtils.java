public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue) {
        while (queue.size() > 0) {
            queue.enqueue(queue.dequeue());
        }
    }
}
