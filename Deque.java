public class Deque<T> {
    LinkedListByDeque<T> list;
    int size;

    public Deque() {
        list = new LinkedListByDeque<T>();
        this.size = 0;
    }

    public void addFront(T item) {
        this.list.addTail(item);
    }

    public void addTail(T item) {
        this.list.addHead(item);
    }

    public T removeFront() {
        if (this.list.size() > 0) {
            T value = this.list.getTailValue();
            this.list.removeTail();
            return value;
        }

        return null;
    }

    public T removeTail() {
        if (this.list.size() > 0) {
            T value = this.list.getHeadValue();
            this.list.removeHead();
            return value;
        }

        return null;
    }

    public int size() {
        return this.list.size();
    }
}

class LinkedListByDeque<T> {
    private NodeByDeque<T> head;
    private int count;

    public LinkedListByDeque() {
        this.head = new NodeByDeque<T>(null, null, null);
        this.head.next = this.head;
        this.head.prev = this.head;
        this.count = 0;
    }

    public void addHead(T value) {
        this.addItem(value, head.next, head);
    }

    public void addTail(T value) {
        this.addItem(value, head, head.prev);
    }

    public void removeHead() {
        this.head.next = this.head.next.next;
        this.head.next.prev = this.head;
        this.count--;
    }

    public void removeTail() {
        this.head.prev = this.head.prev.prev;
        this.head.prev.next = this.head;
        this.count--;
    }

    public T getHeadValue() {
        return this.head.next.value;
    }

    public T getTailValue() {
        return this.head.prev.value;
    }

    public int size() {
        return this.count;
    }

    private void addItem(T value, NodeByDeque<T> next, NodeByDeque<T> prev) {
        NodeByDeque<T> node = new NodeByDeque<T>(value, next, prev);
        node.next.prev = node;
        node.prev.next = node;
        this.count++;
    }
}

class NodeByDeque<T> {
    public T value;
    public NodeByDeque<T> prev;
    public NodeByDeque<T> next;

    public NodeByDeque(T value, NodeByDeque<T> next, NodeByDeque<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}