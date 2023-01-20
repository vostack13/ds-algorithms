import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public int step;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        step = 256;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int h = 0;

        for (char c : key.toCharArray()) {
            int x = (int) (c - 'a' + 1);
            h = (h * this.step + x) % this.size;
        }

        if (h < 0) {
            h = h * -1;
        }

        return h;
    }

    public boolean isKey(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] == key) {
                return true;
            }

            index = (index + step) % this.size;
        }

        return false;
    }

    public void put(String key, T value) {
        int index = this.seekSlot(key);

        if (index != -1) {
            slots[index] = key;
            values[index] = value;
        }
    }

    public T get(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] != key) {
                index = (index + step) % this.size;
                continue;
            }

            return values[index];
        }

        return null;
    }

    public int seekSlot(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] == null || key.equals(slots[index])) {
                return index;
            }

            index = (index + step) % this.size;
        }

        return -1;
    }
}