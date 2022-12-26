import java.util.ArrayList;

public class LinkedList2Test {
    public LinkedList2Test() {
    }

    private void showLinkedList(LinkedList2 list) {
        Node node = list.head;
        while (node != null) {
            System.out.print(node.value + " ");
            if (node.prev != null) {
                System.out.print(" (" + node.prev.value + ") ");
            } else {
                System.out.print(" (" + null + ") ");
            }
            node = node.next;
        }

        if (list.tail == null) {
            System.out.print(" | tail: " + null);
        } else {
            System.out.print(" | tail: " + list.tail.value);
            System.out.print(" " + list.tail.next);
        }

        System.out.println();
    }

    private LinkedList2 createLinkedListEmpty() {
        LinkedList2 list = new LinkedList2();

        return list;
    }

    private LinkedList2 createLinkedListSomeItems(int... values) {
        LinkedList2 list = new LinkedList2();

        for (int i = 0; i < values.length; i++) {
            list.addInTail(new Node(values[i]));
        }

        return list;
    }

    private LinkedList2 createLinkedListSomeItems(Node... nodes) {
        LinkedList2 list = new LinkedList2();

        for (int i = 0; i < nodes.length; i++) {
            list.addInTail(nodes[i]);
        }

        return list;
    }

    private ArrayList<Node> createArrayList(int... values) {
        ArrayList<Node> array = new ArrayList<Node>();

        for (int i = 0; i < values.length; i++) {
            array.add(new Node(values[i]));
        }

        return array;
    }

    private ArrayList<Node> createArrayList(Node... values) {
        ArrayList<Node> array = new ArrayList<Node>();

        for (int i = 0; i < values.length; i++) {
            array.add(values[i]);
        }

        return array;
    }

    public void find() {
        TestCase testCase = new TestCase("Searching for a single element — find()");
        Node testNode, actualNode;
        LinkedList2 actualList;

        testNode = null;
        actualList = createLinkedListEmpty();
        actualNode = actualList.find(2);
        testCase.equalsNode("Поиск элемента в пустом списке", testNode, actualNode);

        testNode = new Node(2);
        actualList = createLinkedListSomeItems(testNode);
        actualNode = actualList.find(2);
        testCase.equalsNode("Поиск элемента в списке из одного элемента", testNode, actualNode);

        testNode = new Node(2);
        actualList = createLinkedListSomeItems(new Node(1), testNode, new Node(3));
        actualNode = actualList.find(2);
        testCase.equalsNode("Поиск элемента в списке из трех элементов", testNode, actualNode);

        testNode = new Node(1);
        actualList = createLinkedListSomeItems(testNode, new Node(2), new Node(3));
        actualNode = actualList.find(1);
        testCase.equalsNode("Поиск элемента если он в начале списка", testNode, actualNode);

        testNode = new Node(3);
        actualList = createLinkedListSomeItems(new Node(1), new Node(2), testNode);
        actualNode = actualList.find(3);
        testCase.equalsNode("Поиск элемента если он в конце списка", testNode, actualNode);

        testNode = null;
        actualList = createLinkedListSomeItems(new Node(1), new Node(2), new Node(3));
        actualNode = actualList.find(4);
        testCase.equalsNode("Поиск несуществующего элемента в списке", testNode, actualNode);
    }

    public void findAll() {
        TestCase testCase = new TestCase("Search for all items in the list — findAll()");
        ArrayList<Node> testArrayList;
        ArrayList<Node> actualArrayList;
        Node n1, n2;

        testArrayList = new ArrayList<Node>();
        actualArrayList = createLinkedListEmpty().findAll(2);
        testCase.equalsArrayNodes("Поиск элементов в пустом списке", testArrayList, actualArrayList);

        n1 = new Node(1);
        testArrayList = createArrayList(n1);
        actualArrayList = createLinkedListSomeItems(n1).findAll(1);
        testCase.equalsArrayNodes("Поиск элементов в списке из одного элемента", testArrayList, actualArrayList);

        n1 = new Node(2);
        n2 = new Node(2);
        testArrayList = createArrayList(n1, n2);
        actualArrayList = createLinkedListSomeItems(new Node(1), n1, new Node(3), n2, new Node(4)).findAll(2);
        testCase.equalsArrayNodes("Поиск элементов в списке из пяти элементов", testArrayList, actualArrayList);

        n1 = new Node(1);
        n2 = new Node(1);
        testArrayList = createArrayList(n1, n2);
        actualArrayList = createLinkedListSomeItems(n1, new Node(2), n2).findAll(1);
        testCase.equalsArrayNodes("Поиск элементов в списке на начальной и последней позициях", testArrayList, actualArrayList);

        n1 = new Node(1);
        n2 = new Node(1);
        testArrayList = createArrayList(n1, n2);
        actualArrayList = createLinkedListSomeItems(n1, n2).findAll(1);
        testCase.equalsArrayNodes("Поиск элементов в списке только из искомых значений", testArrayList, actualArrayList);

        testArrayList = new ArrayList<Node>();
        actualArrayList = createLinkedListSomeItems(1, 2, 3, 2, 1).findAll(4);
        testCase.equalsArrayNodes("Поиск несуществущего элемента в списке", testArrayList, actualArrayList);
    }

    public void remove() {
        TestCase testCase = new TestCase("Removing one item from the list — remove()");
        LinkedList2 testList, actualList;
        Boolean testIsRemoved, actualIsRemoved;

        testIsRemoved = false;
        testList = createLinkedListEmpty();
        actualIsRemoved = false;
        actualList = createLinkedListEmpty();
        actualList.remove(1);
        testCase.start("Удаление из пустого списка").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();

        testIsRemoved = true;
        testList = createLinkedListEmpty();
        actualIsRemoved = true;
        actualList = createLinkedListSomeItems(1);
        actualList.remove(1);
        testCase.start("Удаление из списка с одним элементом").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();

        testIsRemoved = true;
        testList = createLinkedListSomeItems(2, 3);
        actualIsRemoved = true;
        actualList = createLinkedListSomeItems(1, 2, 3);
        actualList.remove(1);
        testCase.start("Удаление из списка первого элемента").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();

        testIsRemoved = true;
        testList = createLinkedListSomeItems(1, 2);
        actualIsRemoved = true;
        actualList = createLinkedListSomeItems(1, 2, 3);
        actualList.remove(3);
        testCase.start("Удаление из списка последнего элемента").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();

        testIsRemoved = true;
        testList = createLinkedListSomeItems(1, 3);
        actualIsRemoved = true;
        actualList = createLinkedListSomeItems(1, 2, 3);
        actualList.remove(2);
        testCase.start("Удаление из списка среднего элемента").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();

        testIsRemoved = false;
        testList = createLinkedListSomeItems(1, 2, 3);
        actualIsRemoved = false;
        actualList = createLinkedListSomeItems(1, 2, 3);
        actualList.remove(4);
        testCase.start("Удаление из списка отсутствующего элемента").equals(testIsRemoved, actualIsRemoved)
                .equalsListsValues(testList, actualList).end();
    }

    public void removeAll() {
        TestCase testCase = new TestCase("Removing more than one item from a list — removeAll()");
        LinkedList2 testList, actualList;

        testList = createLinkedListEmpty();
        actualList = createLinkedListEmpty();
        actualList.removeAll(1);
        testCase.start("Удаление из пустого списка").equalsListsValues(testList, actualList).end();

        testList = createLinkedListEmpty();
        actualList = createLinkedListSomeItems(1);
        actualList.removeAll(1);
        testCase.start("Удаление из списка c одним элементом").equalsListsValues(testList, actualList).end();

        testList = createLinkedListEmpty();
        actualList = createLinkedListSomeItems(1, 1, 1);
        actualList.removeAll(1);
        testCase.start("Удаление из списка c одинаковыми значениями").equalsListsValues(testList, actualList).end();

        testList = createLinkedListSomeItems(2);
        actualList = createLinkedListSomeItems(1, 2, 1);
        actualList.removeAll(1);
        testCase.start("Удаление из списка с первой и последней позиций").equalsListsValues(testList, actualList).end();

        testList = createLinkedListSomeItems(1, 3);
        actualList = createLinkedListSomeItems(1, 2, 2, 3);
        actualList.removeAll(2);
        testCase.start("Удаление из списка элементов середины").equalsListsValues(testList, actualList).end();
    }

    public void clear() {
        TestCase testCase = new TestCase("Clearing the linked list — clear()");
        LinkedList2 testList;
        LinkedList2 actualList;

        testList = createLinkedListEmpty();
        actualList = createLinkedListSomeItems(2);
        actualList.clear();
        testCase.equalsListsValues("Очистка пустого списка", testList, actualList);

        testList = createLinkedListEmpty();
        actualList = createLinkedListSomeItems(2);
        actualList.clear();
        testCase.equalsListsValues("Очистка списка из одного элемента", testList, actualList);

        testList = createLinkedListEmpty();
        actualList = createLinkedListSomeItems(1, 2, 3, 4, 5);
        actualList.clear();
        testCase.equalsListsValues("Очистка списка из 5-ти элементов", testList, actualList);
    }

    public void count() {
        TestCase testCase = new TestCase("Counting the number of elements — count()");
        int testValue;
        int actialValue;

        testValue = 0;
        actialValue = createLinkedListEmpty().count();
        testCase.equals("Размер пустого списка", testValue, actialValue);

        testValue = 1;
        actialValue = createLinkedListSomeItems(1).count();
        testCase.equals("Размер списка из одного элемента", testValue, actialValue);

        testValue = 3;
        actialValue = createLinkedListSomeItems(1, 2, 3).count();
        testCase.equals("Размер списка из 3-х элементов", testValue, actialValue);
    }

    public void insertAfter() {
        TestCase testCase = new TestCase("Inserting after the specified element — insertAfter()");
        Node afterNode, insertNode;
        LinkedList2 testList;
        LinkedList2 actualList;

        afterNode = null;
        insertNode = new Node(1);
        testList = createLinkedListSomeItems(1);
        actualList = createLinkedListEmpty();
        actualList.insertAfter(afterNode, insertNode);
        testCase.equalsListsValues("Вставка элемента в пустой список", testList, actualList);

        afterNode = null;
        insertNode = new Node(2);
        testList = createLinkedListSomeItems(2, 1);
        actualList = createLinkedListSomeItems(1);
        actualList.insertAfter(afterNode, insertNode);
        testCase.equalsListsValues("Вставка элемента в список из одного элемента", testList, actualList);

        afterNode = new Node(2);
        insertNode = new Node(6);
        testList = createLinkedListSomeItems(1, 2, 6, 3);
        actualList = createLinkedListSomeItems(new Node(1), afterNode, new Node(3));
        actualList.insertAfter(afterNode, insertNode);
        testCase.equalsListsValues("Вставка элемента в середину списка из 3-х элементов", testList, actualList);

        afterNode = new Node(3);
        insertNode = new Node(6);
        testList = createLinkedListSomeItems(1, 2, 3, 6);
        actualList = createLinkedListSomeItems(new Node(1), new Node(2), afterNode);
        actualList.insertAfter(afterNode, insertNode);
        testCase.equalsListsValues("Вставка элемента в конец списка из 3-х элементов", testList, actualList);

        afterNode = new Node(6);
        insertNode = new Node(7);
        testList = createLinkedListSomeItems(1, 2, 3);
        actualList = createLinkedListSomeItems(1, 2, 3);
        actualList.insertAfter(afterNode, insertNode);
        testCase.equalsListsValues("Вставка элемента после несуществующего элемента", testList, actualList);
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

class TestCase {
    boolean isSuccess;
    String message;
    String description;

    public TestCase(String title) {
        System.out.println("\n" + title);
    }

    private void reset() {
        this.isSuccess = true;
        this.description = null;
        this.message = null;
    }

    public TestCase start(String _message) {
        reset();
        this.message = _message;
        return this;
    }

    public void end() {
        showResultMessage(this.message, this.isSuccess, this.description);
        reset();
    }

    public TestCase equals(int value1, int value2) {
        if (!isSuccess) {
            return this;
        }

        this.isSuccess = value1 == value2;

        return this;
    }

    public TestCase equals(Boolean value1, Boolean value2) {
        if (!isSuccess) {
            return this;
        }

        this.isSuccess = value1 == value2;

        return this;
    }

    public void equals(String message, int value1, int value2) {
        this.showResultMessage(message, value1 == value2, null);
    }

    public void equalsNode(String message, Node testValue, Node actualValue) {
        this.showResultMessage(message, isEqualsNode(testValue, actualValue), null);
    }

    public void equalsArrayNodes(String message, ArrayList<Node> array1, ArrayList<Node> array2) {
        boolean is_success = true;

        
        if (array1.size() != array2.size()) {
            is_success = false;
            this.showResultMessage(message, is_success, null);
            return;
        }
        
        for (int i = 0; i < array1.size(); i++) {
            if (!isEqualsNode(array1.get(i), array2.get(i))) {
                is_success = false;
                break;
            }
        }

        this.showResultMessage(message, is_success, null);
    }

    public TestCase equalsListsValues(LinkedList2 list1, LinkedList2 list2) {
        if (!this.isSuccess) {
            return this;
        }

        if (getLastNode(list1) != list1.tail || getLastNode(list2) != list2.tail) {
            this.isSuccess = false;
            this.description = "Некорректный связанный список";
            return this;
        }

        Node n1 = list1.head;
        Node n2 = list2.head;

        while (n1 != null) {
            if (!isEqualsNode(n1, n2)) {
                this.isSuccess = false;
                this.description = null;
                break;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        if (!isEqualsNode(list1.tail, list2.tail)) {
            this.isSuccess = false;
            this.description = null;
        }

        return this;
    }

    public void equalsListsValues(String message, LinkedList2 list1, LinkedList2 list2) {
        boolean is_success = true;

        if (getLastNode(list1) != list1.tail || getLastNode(list2) != list2.tail) {
            is_success = false;
            this.showResultMessage(message, is_success, "Некорректный связанный список");
            return;
        }

        Node n1 = list1.head;
        Node n2 = list2.head;

        while (n1 != null) {
            if (!isEqualsNode(n1, n2)) {
                is_success = false;
                break;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        if (!isEqualsNode(list1.tail, list2.tail)) {
            is_success = false;
        }

        this.showResultMessage(message, is_success, null);
    }

    private boolean isEqualsNode(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.prev != null && node2.prev != null && node1.prev.value != node2.prev.value) {
            return false;
        }

        if (node1.prev == null && node2.prev != null || node2.prev == null && node1.prev != null) {
            return false;
        }

        if (node1.next != null && node2.next != null && node1.next.value != node2.next.value) {
            return false;
        }

        if (node1.next == null && node2.next != null || node2.next == null && node1.next != null) {
            return false;
        }

        if (node1.value != node2.value) {
            return false;
        }

        return true;
    }

    private Node getLastNode(LinkedList2 list) {
        Node lastNode = null;
        Node node = list.head;
        while (node != null) {
            lastNode = node;
            node = node.next;
        }

        return lastNode;
    }

    private void showResultMessage(String message, boolean is_success, String description) {
        if (is_success)
            System.out.println(" ✓ success — " + message);
        else
            System.out.println(" ✕ failed  — " + message);

        if (description != null) {
            System.out.println("   ◦ " + description);
        }
    }
}
