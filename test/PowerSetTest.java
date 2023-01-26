import java.util.ArrayList;

public class PowerSetTest {
    Utils utils;

    public PowerSetTest() {
        this.utils = new Utils();
    }

    public void run() {
        this.put();
        this.remove();
        this.intersection();
        this.union();
        this.difference();
        this.isSubset();
    }

    public void put() {
        this.putItems();
    }

    public void remove() {
        this.removeSubset();
        this.removeAll();
    }

    public void intersection() {
        this.intersectionEmpty();
        this.intersectionSomeItems();
    }

    public void union() {
        this.unionSomeItems();
        this.unionWithEmptySet();
    }

    public void difference() {
        this.differenceSomeItems();
        this.differenceEmptySet();
    }

    public void isSubset() {
        this.isSubsetIncludes();
        this.isSubsetNotIncludes();
    }

    public void putItems() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        boolean result = false;

        PowerSet powerSetA = new PowerSet();

        for (int i = 0; i < testData.listAll.size(); i++) {
            powerSetA.put(testData.listAll.get(i));
        }

        if (testData.listUniq.size() == powerSetA.getArrayList().size()) {
            result = true;
        }

        System.out.println("put(): added items: " + result);
    }

    public void removeSubset() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listAll.size(); i++) {
            powerSetA.put(testData.listAll.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetA.remove(testData.listSubset.get(i));
        }

        ArrayList<String> actualsList = powerSetA.getArrayList();
        result = testData.listAfterRemove.containsAll(actualsList)
                && testData.listAfterRemove.size() == actualsList.size();
        System.out.println("remove() — removed subset: " + result);
        
        result = actualsList.size() == powerSetA.size();
        System.out.println("size(): " + result);
    }

    public void removeAll() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listAll.size(); i++) {
            powerSetA.put(testData.listAll.get(i));
        }

        for (int i = 0; i < testData.listUniq.size(); i++) {
            powerSetA.remove(testData.listUniq.get(i));
        }

        ArrayList<String> actualsList = powerSetA.getArrayList();
        result = actualsList.size() == 0;
        System.out.println("remove() — removed all items: " + result);
        
        result = actualsList.size() == powerSetA.size();
        System.out.println("size(): " + result);
    }

    public void intersectionEmpty() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        int size = testData.listUniq.size();
        int middleList = (int) size / 2;
        boolean result;

        for (int i = 0; i < middleList; i++) {
            powerSetA.put(testData.listUniq.get(i));
        }

        for (int i = middleList; i < size; i++) {
            powerSetB.put(testData.listUniq.get(i));
        }

        PowerSet actualsSet = powerSetA.intersection(powerSetB);
        result = actualsSet == null;
        System.out.println("intersection() — generate empty set: " + result);
    }

    public void intersectionSomeItems() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listUniq.size(); i++) {
            powerSetA.put(testData.listUniq.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        PowerSet actualsSet = powerSetA.intersection(powerSetB);
        ArrayList<String> actualList = actualsSet.getArrayList();
        result = testData.listSubset.size() == actualList.size() && testData.listSubset.containsAll(actualList);
        System.out.println("intersection() — generate some set: " + result);

        result = actualList.size() == actualsSet.size();
        System.out.println("size(): " + result);
    }

    public void unionSomeItems() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listAfterRemove.size(); i++) {
            powerSetA.put(testData.listAfterRemove.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        PowerSet actualsSet = powerSetA.union(powerSetB);
        ArrayList<String> actualList = actualsSet.getArrayList();
        result = testData.listUniq.size() == actualList.size() && testData.listUniq.containsAll(actualList);
        System.out.println("union() — generate some set: " + result);

        result = actualList.size() == actualsSet.size();
        System.out.println("size(): " + result);
    }

    public void unionWithEmptySet() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetA.put(testData.listSubset.get(i));
        }

        PowerSet actualsSetA = powerSetA.union(powerSetB);
        PowerSet actualsSetB = powerSetB.union(powerSetA);
        ArrayList<String> actualListA = actualsSetA.getArrayList();
        ArrayList<String> actualListB = actualsSetB.getArrayList();
        result = testData.listSubset.size() == actualListA.size() && testData.listSubset.size() == actualListB.size()
                && testData.listSubset.containsAll(actualListA) && testData.listSubset.containsAll(actualListB);
        System.out.println("union() — generate from empty set: " + result);

        result = actualListA.size() == actualsSetA.size() && actualListA.size() == actualsSetA.size();
        System.out.println("size(): " + result);
    }

    public void differenceSomeItems() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listUniq.size(); i++) {
            powerSetA.put(testData.listUniq.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        PowerSet actualsSet = powerSetA.difference(powerSetB);
        ArrayList<String> actualList = actualsSet.getArrayList();
        result = testData.listAfterRemove.size() == actualList.size() && testData.listAfterRemove.size() == actualList.size();
        System.out.println("difference() — generate some set: " + result);

        result = actualList.size() == actualsSet.size();
        System.out.println("size(): " + result);
    }

    public void differenceEmptySet() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listUniq.size(); i++) {
            powerSetA.put(testData.listUniq.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        PowerSet actualsSet = powerSetB.difference(powerSetA);
        result = actualsSet == null;
        System.out.println("difference() — generate empty set: " + result);
    }

    public void isSubsetIncludes() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        PowerSet powerSetD = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listUniq.size(); i++) {
            powerSetA.put(testData.listUniq.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        boolean actualA = powerSetA.isSubset(powerSetB);
        boolean actualB = powerSetB.isSubset(powerSetD);
        result = actualA == true && actualB == true;
        System.out.println("isSubset() — subset is included in the set: " + result);
    }

    public void isSubsetNotIncludes() {
        PowerSetTestData testData = new PowerSetTestData(20000);
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        boolean result;

        for (int i = 0; i < testData.listAfterRemove.size(); i++) {
            powerSetA.put(testData.listAfterRemove.get(i));
        }

        for (int i = 0; i < testData.listSubset.size(); i++) {
            powerSetB.put(testData.listSubset.get(i));
        }

        boolean actual = powerSetA.isSubset(powerSetB);
        result = actual == false;
        System.out.println("isSubset() — subset is not included in the set: " + result);
    }
}

class PowerSetTestData {
    public ArrayList<String> listAll;
    public ArrayList<String> listUniq;
    public ArrayList<String> listSubset;
    public ArrayList<String> listAfterRemove;
    Utils utils;

    public PowerSetTestData(int size) {
        this.utils = new Utils();
        this.listAll = this.utils.getRandomStingList(size);
        this.listUniq = this.utils.getUniqList(this.listAll);
        this.listSubset = this.utils.getRandomSubsetList(listUniq);
        this.listAfterRemove = this.utils.getDifferenceList(listUniq, listSubset);
    }
}