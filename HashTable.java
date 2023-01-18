public class HashTable
  {
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
      size = sz;
      step = stp;
      slots = new String[size];
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {   
        int h = 0;

        for (char c : value.toCharArray()) {
            int x = (int) (c - 'a' + 1);
            h = (h * step + x) % this.size;
        }

        return h;
    }

    public int seekSlot(String value)
    {
        int index = this.hashFun(value);

        for(int i = 0; i < this.size; i++) {
            if (slots[index] == null) {
                return index;
            }

            index = (index + step) % this.size;
        }

        return -1;
    }

     public int put(String value)
     {
        int index = this.seekSlot(value);
        if (index != -1) {
            slots[index] = value;

            return index;
        }

        return -1;
     }

     public int find(String value)
     {
        int index = this.hashFun(value);

        for(int i = 0; i < this.size; i++) {
            if (slots[index] == null) {
                break;
            }

            if (slots[index] == value) {
                return index;
            }

            index = (index + step) % this.size;
        }

        return -1;
     }
  }