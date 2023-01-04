public class Queue<T> {
    QueueLinkedList<T> list;

    public Queue() {
        this.list = new QueueLinkedList<T>();
    }

    public void enqueue(T item) {
        this.list.addInTail(item);
    }

    public T dequeue() {
        if (this.list.count() > 0) {
            T value = this.list.getFirstItem();
            this.list.removeFirstItem();

            return value;
        }

        return null;
    }

    public int size() {
        return this.list.count();
    }
}

class QueueLinkedList<T> {
    public QueueNodeList<T> head;
    public QueueNodeList<T> tail;

    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addInTail(T val) {
        QueueNodeList<T> _item = new QueueNodeList<T>(val);

        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public void prepend(T val) {
        QueueNodeList<T> _item = new QueueNodeList<T>(val);

        if (this.head == null) {
            this.head = _item;
            this.tail = _item;
            return;
        }

        this.head.prev = _item;
        _item.next = this.head;
        this.head = _item;
    }

    public void removeFirstItem() {
        if (this.head == null) {
            return;
        }

        this.head.prev = null;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;

            return;
        }

        if (this.head.next == null) {
            this.tail = this.head;
        }
    }

    public int count() {
        QueueNodeList<T> node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public T getFirstItem() {
        return this.head.value;
    }
}

class QueueNodeList<T> {
    public T value;
    public QueueNodeList<T> prev;
    public QueueNodeList<T> next;

    public QueueNodeList(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}