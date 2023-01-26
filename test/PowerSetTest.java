public class PowerSetTest {
    Utils utils;
    
    public PowerSetTest() {
        this.utils = new Utils();
    }

    public void union() {
        PowerSet powerSetA = new PowerSet();
        PowerSet powerSetB = new PowerSet();
        PowerSet powerSetC = new PowerSet();
        PowerSet powerSetD = new PowerSet();

        System.out.println("test: " + powerSetD.size());

        int size = 20000;

        long start = System.currentTimeMillis();
        
        for (int i = 0; i < size; i++) {
            String value = utils.getRandomSting();
            powerSetA.put(value);
        }

        for (int i = 0; i < size; i++) {
            String value = utils.getRandomSting();
            powerSetB.put(value);
        }

        powerSetC.put("a");
        powerSetC.put("b");
        powerSetC.put("c");
        powerSetC.put("d");
        powerSetC.put("e");

        powerSetD.put("f");
        powerSetD.put("g");
        powerSetD.put("c");
        powerSetD.put("b");
        powerSetD.put("b");
        powerSetD.put("y");
        powerSetD.put("x");
        
        PowerSet powerSetIntersection = powerSetA.intersection(powerSetB);
        PowerSet powerSetUnion = powerSetA.union(powerSetB);
        PowerSet powerSetDifference = powerSetB.difference(powerSetA);

        PowerSet manualSetIntersection = powerSetC.intersection(powerSetD);
        PowerSet manualSetUnion = powerSetC.union(powerSetD);
        PowerSet manualSetDifference = powerSetD.difference(powerSetC);

        long end = System.currentTimeMillis();

        utils.printSize(powerSetIntersection);
        utils.printSize(powerSetUnion);
        utils.printSize(powerSetDifference);
        System.out.println(powerSetA.isSubset(powerSetUnion));

        System.out.println();

        utils.printValues(powerSetC);
        utils.printSize(powerSetC);

        utils.printValues(powerSetD);
        utils.printSize(powerSetD);

        utils.printValues(manualSetIntersection);
        utils.printSize(manualSetIntersection);

        utils.printValues(manualSetUnion);
        utils.printSize(manualSetUnion);

        utils.printValues(manualSetDifference);
        utils.printSize(manualSetDifference);

        System.out.println(powerSetD.isSubset(manualSetIntersection));

        System.out.println("time: " + (double) ((end - start) / 1) + " ms");
    }

    public void remove() {
        PowerSet powerSetC = new PowerSet();

        powerSetC.put("a");
        powerSetC.put("b");
        powerSetC.put("c");
        // powerSetC.put("d");
        // powerSetC.put("e");

        utils.printValues(powerSetC);
        System.out.println("remove size: " + powerSetC.size());

        // powerSetC.remove("a");

        // System.out.println("remove size: " + powerSetC.size());

        powerSetC.remove("a");
        powerSetC.remove("b");
        powerSetC.remove("c");
        // powerSetC.remove("d");
        // powerSetC.remove("e");
        
        System.out.println("remove size: " + powerSetC.size());
        utils.printValues(powerSetC);
    }

    public void run() {
        this.union();
        this.remove();
    }
}