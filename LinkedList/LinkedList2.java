import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
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

    public Node find(int _value) {
        Node findNode = null;

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                findNode = node;
                break;
            }
            node = node.next;
        }

        return findNode;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null) {
            return false;
        }

        boolean isRemoved = false;
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    this.head = node.next;
                }

                if (node.next != null) {
                    node.next.prev = node.prev;
                } else {
                    this.tail = node.prev;
                }

                isRemoved = true;
                break;
            }

            node = node.next;
        }

        return isRemoved;
    }

    public void removeAll(int _value) {
        if (this.head == null) {
            return;
        }

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    this.head = node.next;
                }

                if (node.next != null) {
                    node.next.prev = node.prev;
                } else {
                    this.tail = node.prev;
                }
            }

            node = node.next;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeToInsert == null) {
            return;
        }

        if (this.head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;

            return;
        }

        if (_nodeAfter == null) {
            this.head.prev = _nodeToInsert;
            _nodeToInsert.prev = null;
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;

            return;
        }

        Node node = this.head;
        while (node != null) {
            if (node == _nodeAfter) {
                if (node.next != null) {
                    node.next.prev = _nodeToInsert;
                } else {
                    this.tail = _nodeToInsert;
                }

                _nodeToInsert.prev = node;
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;

                return;
            }

            node = node.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}