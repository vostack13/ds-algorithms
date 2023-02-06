public class BloomFilter {
    public int filter_len;
    public byte[] filter;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter = new byte[f_len];
    }

    private int hashCommon(String str, int step) {
        final byte[] bytes = str.getBytes();

        int h = MurmurHash.hash32(bytes, bytes.length, step) % this.filter_len;

        if (h < 0) {
            h = h * -1;
        }

        return h;
    }

    public int hash1(String str1) {
        return hashCommon(str1, 17);
    }

    public int hash2(String str1) {
        return hashCommon(str1, 223);
    }

    public void add(String str1) {
        int idx1 = hash1(str1);
        int idx2 = hash2(str1);

        filter[idx1] |= 1;
        filter[idx2] |= 1;
    }

    public boolean isValue(String str1) {
        int idx1 = hash1(str1);
        int idx2 = hash2(str1);

        if (filter[idx1] == 0 || filter[idx2] == 0) {
            return false;
        }

        return true;
    }
}

class MurmurHash {
    private MurmurHash() {
    }

    public static int hash32(final byte[] data, int length, int seed) {
        final int m = 0x5bd1e995;
        final int r = 24;

        int h = seed ^ length;
        int length4 = length / 4;

        for (int i = 0; i < length4; i++) {
            final int i4 = i * 4;
            int k = (data[i4 + 0] & 0xff) + ((data[i4 + 1] & 0xff) << 8) + ((data[i4 + 2] & 0xff) << 16)
                    + ((data[i4 + 3] & 0xff) << 24);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }

        switch (length % 4) {
        case 3:
            h ^= (data[(length & ~3) + 2] & 0xff) << 16;
        case 2:
            h ^= (data[(length & ~3) + 1] & 0xff) << 8;
        case 1:
            h ^= (data[length & ~3] & 0xff);
            h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;

        return h;
    }
}