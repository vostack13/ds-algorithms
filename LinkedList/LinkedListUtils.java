public class LinkedListUtils {
    public LinkedListUtils() {
    }

    public LinkedList run(LinkedList list1, LinkedList list2) {
        int countList1 = list1.count();
        int countList2 = list2.count();

        LinkedList resultList = new LinkedList();

        if (countList1 == countList2) {
            Node nodeList1 = list1.head;
            Node nodeList2 = list2.head;

            while (nodeList1 != null) {
                int sumValues = nodeList1.value + nodeList2.value;
                resultList.addInTail(new Node(sumValues));
                nodeList1 = nodeList1.next;
                nodeList2 = nodeList2.next;
            }
        }

        return resultList;
    }
}
