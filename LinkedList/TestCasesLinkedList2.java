public class TestCasesLinkedList2 {
    public TestCasesLinkedList2() {
    }

    private void find() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        LinkedList2 list = new LinkedList2();

        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);

        Node findN2 = list.find(2);

        new TestCase<Node>("Поиск элемента в пустом списке").test(n2).equalsLink(findN2);
        new TestCase<Node>("Поиск элемента если он в начале списка").test(n2).equalsLink(findN2);
        new TestCase<Node>("Поиск элемента если он в конце списка").test(n2).equalsLink(findN2);
    }

    public void run() {
        this.find();
    }
}

class TestCase<T> {
    String title;
    T testValue;
    T outValues;

    public TestCase(String _title) {
        this.title = _title;
    }

    public TestCase<T> test(T _testValue) {
        this.testValue = _testValue;

        return this;
    }

    public void equalsLink(T value) {
        if (this.testValue == value)
            System.out.println(this.title + ": success");
        else
            System.out.println(this.title + ": failed");
    }
}
