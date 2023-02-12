import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Utils {
    public Utils() {

    }

    public <T> void printValues(T data) {
        if (data == null) {
            System.out.println("null");

            return;
        }

        if (data instanceof PowerSet) {
            PowerSet powerSet = (PowerSet) data;

            System.out.println("{ ");

            for (int i = 0; i < powerSet.storage.size; i++) {
                if (powerSet.storage.slots[i] != null) {
                    System.out.println("    (" + i + ") - " + powerSet.storage.slots[i] );
                }
            }

            System.out.println("}");
            
            return;
        }

        if (data instanceof NativeCache) {
            NativeCache<T> cache = (NativeCache) data;
            System.out.println("{");

            for (int i = 0; i < cache.values.length; i++) {
                if (cache.values[i] != null) {
                    System.out.println("   \"" + cache.slots[i] + "\": " + cache.values[i] );
                }
            }

            System.out.println("}");
        }
    }

    public <T> void printSize(T data) {
        if (data == null) {
            System.out.println("null");

            return;
        }

        
        if (data instanceof PowerSet) {
            PowerSet powerSet = (PowerSet) data;
            System.out.println("Size: " + powerSet.size());

            return;
        }
    }

    public String getRandomSting() {
        String SALTCHARS = "!(){}/,.^%$#@&*-+=_abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        int len = rnd.nextInt(5) + 1;

        while (salt.length() < len) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();
    }

    public ArrayList<String> getRandomStingList(int size) {
        ArrayList<String> list = new ArrayList<String>(size);

        for (int i = 0; i < size; i++) {
            String value = this.getRandomSting();
            list.add(value);
        }

        return list;
    }

    public ArrayList<String> getUniqList(ArrayList<String> list) {
        ArrayList<String> uniqList = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            if (!uniqList.contains(list.get(i))) {
                uniqList.add(list.get(i));
            }
        }

        return uniqList;
    }

    public ArrayList<String> getRandomSubsetList(ArrayList<String> list) {
        ArrayList<String> resultList = new ArrayList<String>();
        Random rnd = new Random();
        int randomIndex = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            randomIndex = rnd.nextInt(list.size());
            String value = list.get(randomIndex);

            if (!resultList.contains(value)) {
                resultList.add(value);
            }
        }

        return resultList;
    }

    public ArrayList<String> getDifferenceList(ArrayList<String> listA, ArrayList<String> listB) {
        ArrayList<String> resultList = new ArrayList<String>();

        for (int i = 0; i < listA.size(); i++) {
            if (!listB.contains(listA.get(i))) {
                resultList.add(listA.get(i));
            }
        }

        return resultList;
    }
}
