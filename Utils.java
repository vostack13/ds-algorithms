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

            System.out.print("{ ");

            for (int i = 0; i < powerSet.storage.size; i++) {
                if (powerSet.storage.slots[i] != null) {
                    System.out.print(powerSet.storage.slots[i] + "(" + i + "), ");
                }
            }

            System.out.println("}");
            
            return;
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

        int len = rnd.nextInt(20) + 1;

        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();
    }
}
