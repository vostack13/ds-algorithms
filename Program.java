public class Program {

    /**
     * @param args
     */
    public static void main(String args[]) {
        // TestCasesLinkedList test = new TestCasesLinkedList();
        // test.run();

        // LinkedList list1 = new LinkedList();
        // list1.addInTail(new Node(1));
        // list1.addInTail(new Node(2));
        // list1.addInTail(new Node(3));

        // LinkedList list2 = new LinkedList();
        // list2.addInTail(new Node(4));
        // list2.addInTail(new Node(5));
        // list2.addInTail(new Node(6));

        // LinkedListUtils utils = new LinkedListUtils();
        // utils.run(list1, list2);

        // LinkedList2Test test2 = new LinkedList2Test();
        // test2.run();

    //     System.out.println();
    //     DynArray array = new DynArray<Integer>(Integer.class);

    //     DynArrayTest dynArrayTest = new DynArrayTest();
    //     dynArrayTest.run();
    
        // StackTest stackTest = new StackTest();
        // stackTest.run();
        
        // StackUtils stackUtils = new StackUtils();
        // System.out.println("1: " + stackUtils.getIsBalanced("())("));
        // System.out.println("2: " + stackUtils.getIsBalanced("))(("));
        // System.out.println("3: " + stackUtils.getIsBalanced("((())"));
        // System.out.println("4: " + stackUtils.getIsBalanced("(()()(()"));
        // System.out.println("5: " + stackUtils.getIsBalanced("(()((())()))"));
        
        // try {
        //     Double calculatorResult = stackUtils.calculation("8 2 + 5 * 9 + 9 - 70 - 3 / =");
        //     System.out.println(calculatorResult);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // QueueTest queueTest = new QueueTest();
        // queueTest.run();

        // QueueUtils queueUtils = new QueueUtils();
        // Queue<Integer> queue = new Queue<Integer>();

        // queue.enqueue(1);
        // queue.enqueue(2);
        // queue.enqueue(3);
        // queue.enqueue(4);
        // queue.enqueue(5);
        // // queueUtils.circleRotateQueue(queue);
        // 
        // QueueOnStacks<Integer> queueOnStacks = new QueueOnStacks<Integer>();
        // queueOnStacks.enqueue(1);
        // queueOnStacks.enqueue(2);
        // queueOnStacks.enqueue(3);
        // queueOnStacks.enqueue(4);
        // queueOnStacks.enqueue(5);
        // 
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        // System.out.println(queueOnStacks.dequeue());
        // System.out.println(queueOnStacks.size());
        
        // DequeUtils dequeUtils = new DequeUtils();
        // System.out.println(dequeUtils.isPalindrome("banana"));
        // System.out.println(dequeUtils.isPalindrome("banab"));
        // System.out.println(dequeUtils.isPalindrome("b"));

        // HashTable hashTable = new HashTable(2, 3);

        // System.out.println(hashTable.hashFun("!"));
        // System.out.println(hashTable.find("!"));
        // System.out.println(hashTable.seekSlot("!"));
        // System.out.println(hashTable.put("!"));
        // System.out.println(hashTable.find("!"));

        // System.out.println(hashTable.find("a"));
        // System.out.println(hashTable.put("a"));
        // System.out.println(hashTable.find("a"));

        // System.out.println(hashTable.find("b"));
        // System.out.println(hashTable.put("b"));
        // System.out.println(hashTable.find("b"));

        // NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        // System.out.println(dictionary.isKey("abc"));

        // System.out.println(dictionary.get("abc"));
        // dictionary.put("abc", 123);
        // System.out.println(dictionary.get("abc"));

        // System.out.println(dictionary.get("!"));
        // dictionary.put("!", 5);
        // System.out.println(dictionary.get("!"));

        // dictionary.put("!", 154);
        // System.out.println(dictionary.get("!"));

        
        
        // dictionary.put("2", 2);
        // System.out.println(dictionary.get("2"));

        // System.out.println(dictionary.isKey("abc"));
        // dictionary.put("3", 3);
        // System.out.println(dictionary.get("3"));

        // dictionary.put("4", 4);
        // System.out.println(dictionary.get("4"));

        // dictionary.put("5", 5);
        // System.out.println(dictionary.get("5"));

        // dictionary.put("5", 5);
        // System.out.println(dictionary.get("5"));
        // HashTable hashTable = new HashTable(12, 10);

        // System.out.println(hashTable.hashFun("abc"));
        //    PowerSetTest powerSetTest = new PowerSetTest();
        //    powerSetTest.run();

        BloomFilter bloom = new BloomFilter(32);
        String str0 = "0123456789";
        String str1 = "1234567890";
        String str2 = "2345678901";
        String str3 = "3456789012";
        String str4 = "4567890123";
        String str5 = "5678901234";
        String str6 = "6789012345";
        String str7 = "7890123456";
        String str8 = "8901234567";
        String str9 = "9012345678";

        System.out.println(str0 + ": " + bloom.isValue(str0));
        bloom.add(str0);
        System.out.println(str0 + ": " + bloom.isValue(str0));
        
        System.out.println();
        System.out.println(str1 + ": " + bloom.isValue(str1));
        bloom.add(str1);
        System.out.println(str1 + ": " + bloom.isValue(str1));

        System.out.println();
        System.out.println(str2 + ": " + bloom.isValue(str2));
        bloom.add(str2);
        System.out.println(str2 + ": " + bloom.isValue(str2));

        System.out.println();
        System.out.println(str3 + ": " + bloom.isValue(str3));
        bloom.add(str3);
        System.out.println(str3 + ": " + bloom.isValue(str3));

        System.out.println();
        System.out.println(str4 + ": " + bloom.isValue(str4));
        bloom.add(str4);
        System.out.println(str4 + ": " + bloom.isValue(str4));

        System.out.println();
        System.out.println(str5 + ": " + bloom.isValue(str5));
        bloom.add(str5);
        System.out.println(str5 + ": " + bloom.isValue(str5));

        System.out.println();
        System.out.println(str6 + ": " + bloom.isValue(str6));
        bloom.add(str6);
        System.out.println(str6 + ": " + bloom.isValue(str6));

        System.out.println();
        System.out.println(str7 + ": " + bloom.isValue(str7));
        bloom.add(str7);
        System.out.println(str7 + ": " + bloom.isValue(str7));

        System.out.println();
        System.out.println(str8 + ": " + bloom.isValue(str8));
        bloom.add(str8);
        System.out.println(str8 + ": " + bloom.isValue(str8));

        System.out.println();
        System.out.println(str9 + ": " + bloom.isValue(str9));
        bloom.add(str9);
        System.out.println(str9 + ": " + bloom.isValue(str9));

        System.out.println();
        System.out.println(": " + bloom.isValue(""));
        bloom.add("");
        System.out.println(": " + bloom.isValue(""));

        System.out.println();
        System.out.println("0: " + bloom.isValue("0"));
        bloom.add("0");
        System.out.println("0: " + bloom.isValue("0"));
     }
}