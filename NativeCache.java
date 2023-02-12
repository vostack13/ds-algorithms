import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public int hashKey;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        this.hashKey = 256;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        this.initHits();
    }

    public void initHits() {
        this.hits = new int[size];

        for (int i = 0; i < hits.length; i++) {
            this.hits[i] = 0;
        }
    }

    public int hashFun(String key) {
        int h = 0;

        for (char c : key.toCharArray()) {
            int x = (int) (c - 'a' + 1);
            h = (h * this.hashKey + x) % this.size;
        }

        if (h < 0) {
            h = h * -1;
        }

        return h;
    }

    public int seekSlot(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] == null || key.equals(slots[index])) {
                return index;
            }

            index = (index + this.hashKey) % this.size;
        }

        return -1;
    }

    public T get(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] != key) {
                index = (index + this.hashKey) % this.size;
                continue;
            }

            this.hits[index]++;
            return values[index];
        }

        return null;
    }

    public boolean isKey(String key) {
        int index = this.hashFun(key);

        for (int i = 0; i < this.size; i++) {
            if (slots[index] == key) {
                this.hits[index]++;
                return true;
            }

            index = (index + this.hashKey) % this.size;
        }

        return false;
    }

    private void removeOldItem() {
        int indexMin = 0;
        int value = 0;

        for (int i = 0; i < hits.length; i++) {
            if (hits[i] <= value) {
                indexMin = i;
                value = hits[i];
            }
        }

        slots[indexMin] = null;
        values[indexMin] = null;
        hits[indexMin] = 0;
    }

    public void put(String key, T value) {
        int index = this.seekSlot(key);

        if (index == -1) {
            this.removeOldItem();
        }

        index = this.seekSlot(key);

        if (index != -1) {
            slots[index] = key;
            values[index] = value;
        }
    }
}