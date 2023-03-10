import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
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

    public boolean remove(int _value)
    {
        if (this.head == null) {
            return false;
        }

        boolean isRemoved = false;
        Node node = this.head;
        Node previewNode = null;

        while (node != null) {
            if (node.value != _value) {
                previewNode = node;
            } else {
                if (previewNode == null) {
                    this.head = node.next;
                } else {
                    previewNode.next = node.next;
                }

                if (node.next == null) {
                    this.tail = previewNode;
                }

                isRemoved = true;
                break;
            }
            node = node.next;
        }

        if (isRemoved) {
            return true;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null)
            return;

        Node node = this.head;
        Node previewNode = null;

        while (node != null) {
            if (node.value != _value) {
                previewNode = node;
            } else {
                if (previewNode == null) {
                    this.head = node.next;
                } else {
                    previewNode.next = node.next;
                }

                if (node.next == null) {
                    this.tail = previewNode;
                }
            }

            node = node.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        Node node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeToInsert == null) {
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;

            if (this.head.next == null) {
                this.tail = _nodeToInsert;
            }
            return;
        }

        Node node = this.head;

        while (node != null) {
            if (node == _nodeAfter) {
                if (node.next == null) {
                    this.tail = _nodeToInsert;
                }

                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
                return;
            }
            node = node.next;
        }
    }
}

// class Node
// {
//     public int value;
//     public Node next;
//     public Node(int _value)
//     {
//         value = _value;
//         next = null;
//     }
// }