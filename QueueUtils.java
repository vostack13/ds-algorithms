public class QueueUtils {
    public QueueUtils() {
    }

    public <T> void circleRotateQueue(Queue<T> queue) {
        while (queue.size() > 0) {
            T item = queue.dequeue();

            try {
                System.out.println(item);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.enqueue(item);
        }
    }
}
