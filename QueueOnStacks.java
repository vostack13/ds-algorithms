public class QueueOnStacks<T> {
    Stack<T> stackIn;
    Stack<T> stackOut;

    public QueueOnStacks() {
        this.stackIn = new Stack<T>();
        this.stackOut = new Stack<T>();
    }

    public void enqueue(T value) {
        this.stackIn.push(value);
    }

    public T dequeue() {
        this.moveToStackOut();

        return this.stackOut.pop();
    }
    
    public int size() {
        return this.stackIn.size() + this.stackOut.size();
    }

    private void moveToStackOut() {
        if (this.stackOut.size() > 0) {
            return;
        }

        while (this.stackIn.size() > 0) {
            T item = this.stackIn.pop();
            this.stackOut.push(item);
        }
    }
}
