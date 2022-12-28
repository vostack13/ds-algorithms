import java.util.ArrayList;

public class LinkedListTest {
    private Node n1;
    private Node n2;
    private Node n3;

    public LinkedListTest() {
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
    }

    private void find() {
        String title = "Finding in a linked list: ";

        try {
            LinkedList list = new LinkedList();
            Node n2 = new Node(2);

            list.addInTail(new Node(1));
            list.addInTail(n2);
            list.addInTail(new Node(3));

            Node findNode = list.find(2);

            if (findNode != n2) {
                throw new Exception();
            }

            Node findMissingNode = list.find(6);

            if (findMissingNode != null) {
                throw new Exception();
            }

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(title + "failed");
        }
    }

    private void findAll() {
        String title = "Finding all in a linked list: ";

        try {
            LinkedList list = new LinkedList();
            ArrayList<Node> correctArray = new ArrayList<Node>();
            Node n2 = new Node(2);
            Node n4 = new Node(2);

            correctArray.add(n2);
            correctArray.add(n4);

            list.addInTail(new Node(1));
            list.addInTail(n2);
            list.addInTail(new Node(3));
            list.addInTail(n4);

            ArrayList<Node> findNodes = list.findAll(2);

            if (correctArray.equals(findNodes) != true) {
                throw new Exception();
            }

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(title + "failed");
        }
    }

    private void remove() {
        String title = "Remove in a linked list: ";

        try {
            LinkedList list = new LinkedList();
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);

            list.addInTail(n1);
            list.addInTail(n2);
            list.addInTail(n3);
            list.addInTail(n4);

            list.remove(2);

            Node node = list.head;
            ArrayList<Node> nodes = new ArrayList<Node>();

            while (node != null) {
                nodes.add(node);
                node = node.next;
            }

            if (nodes.contains(n2) == true) {
                throw new Exception();
            }

            list.remove(1);

            node = list.head;
            ArrayList<Node> nodesWithoutFirstElement = new ArrayList<Node>();

            while (node != null) {
                nodesWithoutFirstElement.add(node);
                node = node.next;
            }

            if (nodesWithoutFirstElement.contains(n1) == true) {
                throw new Exception();
            }

            list.remove(4);

            node = list.head;
            ArrayList<Node> nodesWithoutLastElement = new ArrayList<Node>();

            while (node != null) {
                nodesWithoutLastElement.add(node);
                node = node.next;
            }

            if (nodesWithoutLastElement.contains(n4) == true || list.tail.value == 4) {
                throw new Exception();
            }

            list.remove(5);

            node = list.head;
            ArrayList<Node> correctWithoutRemove = new ArrayList<Node>();
            correctWithoutRemove.add(n3);

            ArrayList<Node> listWithoutRemove = new ArrayList<Node>();
            while (node != null) {
                listWithoutRemove.add(node);
                node = node.next;
            }

            if (correctWithoutRemove.equals(listWithoutRemove) != true) {
                throw new Exception();
            }

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(title + "failed");
        }
    }

    private void removeAll() {
        String title = "Remove all in a linked list: ";

        try {
            LinkedList list = new LinkedList();
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n5 = new Node(5);
            Node n3 = new Node(2);
            Node n4 = new Node(1);

            list.addInTail(n1);
            list.addInTail(n2);
            list.addInTail(n5);
            list.addInTail(n3);
            list.addInTail(n4);

            list.removeAll(2);

            Node node = list.head;
            ArrayList<Node> correctList = new ArrayList<Node>();
            correctList.add(n1);
            correctList.add(n5);
            correctList.add(n4);

            ArrayList<Node> listRemove = new ArrayList<Node>();
            while (node != null) {
                listRemove.add(node);
                node = node.next;
            }

            if (correctList.equals(listRemove) != true) {
                throw new Exception();
            }

            list.removeAll(1);

            if (list.head.value != 5 || list.tail.value != 5) {
                throw new Exception();
            }

            list.removeAll(6);

            if (list.head.value != 5) {
                throw new Exception();
            }

            list.removeAll(5);

            if (list.head != null) {
                throw new Exception();
            }

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(title + "failed");
        }
    }

    private void clear() {
        String title = "Clear linked list: ";

        try {
            LinkedList list = new LinkedList();

            list.addInTail(n1);
            list.addInTail(n2);
            list.addInTail(n3);
            list.clear();

            if (list.head != null)
                throw new Exception();

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(title + "failed");
        }
    }

    private void count() {
        String title = "Count linked list: ";

        try {
            LinkedList list = new LinkedList();

            list.addInTail(new Node(1));
            list.addInTail(new Node(2));
            list.addInTail(new Node(3));
            int count = list.count();

            if (count != 3) {
                throw new Exception();
            }

            LinkedList listEmpty = new LinkedList();
            int countEmptyList = listEmpty.count();

            if (countEmptyList != 0) {
                throw new Exception();
            }

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(title + "failed");
        }
    }

    private void insertAfter() {
        String title = "Inserting into a linked list: ";

        try {
            LinkedList list = new LinkedList();
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);
            Node n5 = new Node(5);
            Node n6 = new Node(6);

            list.addInTail(n1);
            list.addInTail(n2);
            list.addInTail(n3);

            ArrayList<Node> correctListInsertMiddle = new ArrayList<Node>();
            correctListInsertMiddle.add(n1);
            correctListInsertMiddle.add(n2);
            correctListInsertMiddle.add(n4);
            correctListInsertMiddle.add(n3);

            list.insertAfter(n2, n4);

            Node node = list.head;
            ArrayList<Node> listInsertMiddle = new ArrayList<Node>();
            while (node != null) {
                listInsertMiddle.add(node);
                node = node.next;
            }

            if (correctListInsertMiddle.equals(listInsertMiddle) != true) {
                throw new Exception();
            }

            ArrayList<Node> correctListInsertFirst = new ArrayList<Node>();
            correctListInsertFirst.add(n5);
            correctListInsertFirst.add(n1);
            correctListInsertFirst.add(n2);
            correctListInsertFirst.add(n4);
            correctListInsertFirst.add(n3);

            list.insertAfter(null, n5);

            node = list.head;
            ArrayList<Node> listInsertFirst = new ArrayList<Node>();
            while (node != null) {
                listInsertFirst.add(node);
                node = node.next;
            }

            if (correctListInsertFirst.equals(listInsertFirst) != true) {
                throw new Exception();
            }

            ArrayList<Node> correctListInsertLast = new ArrayList<Node>();
            correctListInsertLast.add(n5);
            correctListInsertLast.add(n1);
            correctListInsertLast.add(n2);
            correctListInsertLast.add(n4);
            correctListInsertLast.add(n3);
            correctListInsertLast.add(n6);

            list.insertAfter(n3, n6);

            node = list.head;
            ArrayList<Node> listInsertLast = new ArrayList<Node>();
            while (node != null) {
                listInsertLast.add(node);
                node = node.next;
            }

            if (correctListInsertLast.equals(listInsertLast) != true || list.tail.value != 6) {
                throw new Exception();
            }

            LinkedList listEmpty = new LinkedList();

            listEmpty.insertAfter(null, new Node(1));

            System.out.println(title + "success");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(title + "failed");
        }
    }

    public void run() {
        this.find();
        this.findAll();
        this.remove();
        this.removeAll();
        this.clear();
        this.count();
        this.insertAfter();
    }
}
