public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            queue.enqueue(queue.dequeue());
        }

        queue.dequeue();

        if (queue.size() > 0) {
            this.circleRotateQueue(queue);
        }
    }
}
