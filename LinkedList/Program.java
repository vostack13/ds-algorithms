public class Program {

    public static void main(String args[]) {
        TestCasesLinkedList test = new TestCasesLinkedList();
        test.run();

        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(2));
        list1.addInTail(new Node(3));

        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(4));
        list2.addInTail(new Node(5));
        list2.addInTail(new Node(6));

        LinkedListUtils utils = new LinkedListUtils();
        utils.run(list1, list2);
    }
}