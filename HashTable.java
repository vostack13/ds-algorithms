public class HashTable
  {
    public int size;
    public int step;
    public String [] slots;
    private int k = 256;
    private int mod = 19;

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
            h = (h * k + x) % mod;
        }
        return h;
    }

    public int seekSlot(String value)
    {
         return -1;
    }

     public int put(String value)
     {
         return -1;
     }

     public int find(String value)
     {
         return -1;
     }
  }