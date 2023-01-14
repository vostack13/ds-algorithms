import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
      value = _value;
      next = null;
      prev = null;
    }
  }

 public class OrderedList<T>
  {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            Integer a = (Integer) v1;
            Integer b = (Integer) v2;
            
            if (a < b) {
                return -1;
            }

            if (a > b) {
                return 1;
            }
        }

        if (v1 instanceof String && v2 instanceof String) {
            String str1 = (String) v1;
            String str2 = (String) v2;
            str1.trim();
            str2.trim();
            int length = str1.length() > str2.length() ? str1.length() : str2.length();

            for (int i = 0; i < length; i++) {
                char char1 = str1.charAt(i);
                char char2 = str2.charAt(i);

                if (char1 < char2) {
                    return -1;
                }

                if (char1 > char2) {
                    return 1;
                }
            }
        }

      return 0;
    }

    public void add(T value)
    {
        Node<T> newNode = new Node<T>(value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;

            return;
        }

        Node<T> currNode = head;
        int continueCompare = this._ascending ? 1 : -1;

        while (currNode != null) {
            if (this.compare(newNode.value, currNode.value) == continueCompare) {
                currNode = currNode.next;
                continue;
            }

            newNode.prev = currNode.prev;
            newNode.next = currNode;
            currNode.prev = newNode;

            if (newNode.prev == null) {
                this.head = newNode;
            } else {
                newNode.prev.next = newNode;
            }

            return;
        }

        if (this.tail.prev == null) {
            this.head.next = newNode;
            newNode.prev = this.head;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public Node<T> find(T val)
    {
        Node<T> findNode = null;
        int continueCompare = this._ascending ? 1 : -1;

        Node<T> node = this.head;
        while (node != null) {
            if (node.value == val) {
                findNode = node;
                break;
            }

            if (this.compare(val, node.value) != continueCompare) {
                return null;
            }

            node = node.next;
        }

        return findNode;
    }

    public void delete(T val)
    {
        if (this.head == null) {
            return;
        }

        
        int continueCompare = this._ascending ? 1 : -1;
        Node<T> node = this.head;
        
        while (node != null) {
            if (node.value == val) {
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

                break;
            }

            if (this.compare(val, node.value) != continueCompare) {
                return;
            }

            node = node.next;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        Node<T> node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
  }