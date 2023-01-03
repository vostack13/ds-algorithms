public class Stack<T> {
    private LinkedListAll<T> list;

    public Stack() {
        this.list = new LinkedListAll<T>();
    }

    public int size() {
        return this.list.count();
    }

    public T pop() {
        if (this.list.head != null) {
            T value = this.list.head.value;
            this.list.removeFirstItem();

            return value;
        }
        return null;
    }

    public void push(T val) {
        this.list.prepend(val);
    }

    public T peek() {
        if (this.list.head != null) {
            return this.list.head.value;
        }

        return null;
    }
}

class LinkedListAll<T> {
    public NodeList<T> head;
    public NodeList<T> tail;

    public LinkedListAll() {
        this.head = null;
        this.tail = null;
    }

    public void prepend(T val) {
        NodeList<T> _item = new NodeList<T>(val);

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
        NodeList<T> node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}

class NodeList<T> {
    public T value;
    public NodeList<T> prev;
    public NodeList<T> next;

    public NodeList(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}