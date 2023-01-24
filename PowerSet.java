public class PowerSet {
    public HashTableByPowerSet storage;

    public PowerSet() {
        this.storage = new HashTableByPowerSet(200000, 256);
    }

    public int size() {
        return this.storage.count;
    }

    public void put(String value) {
        this.storage.putUniq(value);
    }

    public boolean get(String value) {
        return this.storage.findKey(value) != -1;
    }

    public boolean remove(String value) {
        return this.storage.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet resultSet = new PowerSet();
        PowerSet smallSet = this.size() >= set2.size() ? set2 : this;
        PowerSet bigSet = this.size() >= set2.size() ? this : set2;

        for (String value : smallSet.storage.slots) {
            if (value == null) {
                continue;
            }

            if (bigSet.get(value)) {
                resultSet.put(value);
            }
        }

        if (resultSet.size() > 0) {
            return resultSet;
        }

        return null;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet resultSet = new PowerSet();
        PowerSet smallSet = this.size() >= set2.size() ? set2 : this;
        PowerSet bigSet = this.size() >= set2.size() ? this : set2;

        for (String value : bigSet.storage.slots) {
            if (value == null) {
                continue;
            }

            resultSet.put(value);
        }

        for (String value : smallSet.storage.slots) {
            if (value == null) {
                continue;
            }

            if (!resultSet.get(value)) {
                resultSet.put(value);
            }
        }

        if (resultSet.size() > 0) {
            return resultSet;
        }

        return null;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet resultSet = new PowerSet();

        for (String value : this.storage.slots) {
            if (value == null) {
                continue;
            }

            resultSet.put(value);
        }

        for (String value : set2.storage.slots) {
            if (value == null) {
                continue;
            }

            resultSet.remove(value);
        }

        if (resultSet.size() > 0) {
            return resultSet;
        }

        return null;
    }

    public boolean isSubset(PowerSet set2) {
        for (String value : set2.storage.slots) {
            if (value == null) {
                continue;
            }

            if (!this.get(value)) {
                return false;
            }
        }

        return true;
    }

    public void copyUniqValues(PowerSet powerSet, boolean condition) {
        for (String value : powerSet.storage.slots) {
            if (value == null) {
                continue;
            }

            if (condition) {
                powerSet.put(value);
            }
        }
    }
}

class HashTableByPowerSet {
    public int step;
    public int size;
    public int hashSalt;
    public int count;
    public String[] slots;

    public HashTableByPowerSet(int sz, int stp) {
        this.count = 0;
        this.size = sz;
        this.step = stp;
        this.slots = new String[sz];
        this.hashSalt = (int) ('a' + 1);
    }

    public int getHash(String value) {
        int hash = 0;

        for (char c : value.toCharArray()) {
            hash = (hash * this.step + c - this.hashSalt) % this.size;
        }

        if (hash < 0) {
            hash = hash * -1;
        }

        return hash;
    }

    public int getUniqiValueSlot(String value) {
        int hash = this.getHash(value);

        for (int i = 0; i < this.size; i++) {
            if (this.slots[hash] == null) {
                return hash;
            }

            if (value.equals(this.slots[hash])) {
                return -1;
            }

            hash = (hash + this.step) % this.size;
        }

        return -1;
    }

    public void putUniq(String value) {
        int hash = this.getUniqiValueSlot(value);

        if (hash != -1) {
            this.slots[hash] = value;
            this.count++;
        }
    }

    public int findKey(String value) {
        int hash = this.getHash(value);

        for (int i = 0; i < this.size; i++) {
            if (value.equals(this.slots[hash])) {
                return hash;
            }

            hash = (hash + this.step) % this.size;
        }

        return -1;
    }

    public boolean remove(String value) {
        int hash = this.findKey(value);

        if (hash != -1) {
            this.slots[hash] = null;
            this.count--;

            return true;
        }

        return false;
    }

    public void copyUniqValues(HashTableByPowerSet hashTable, boolean condition) {
        for (String value : this.slots) {
            if (value == null) {
                continue;
            }

            if (condition) {
                hashTable.putUniq(value);
            }
        }
    }
}
