import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (new_capacity < 16) {
            new_capacity = 16;
        }

        T[] temp_array = array;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;

        if (temp_array != null) {
            System.arraycopy(temp_array, 0, array, 0, this.count);
        }

    }

    public T getItem(int index) {
        if (index < this.count) {
            return array[index];
        }

        return null;
    }

    public void append(T itm) {
        if (this.count == this.capacity) {
            this.makeArray(capacity * 2);
        }

        array[this.count] = itm;
        this.count++;

    }

    public void insert(T itm, int index) {
        if (index > this.count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (this.count == this.capacity) {
            this.makeArray(capacity * 2);
        }

        T[] tail_array = Arrays.copyOfRange(array, index, this.count);
        array[index] = itm;
        System.arraycopy(tail_array, 0, array, index + 1, tail_array.length);
        this.count++;
    }

    public void remove(int index) {
        if (index >= this.count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (this.count <= this.capacity * 0.5) {
            int new_capacity = (int) (this.capacity / 1.5);
            makeArray(new_capacity);
        }

        T[] tail_array = Arrays.copyOfRange(array, index + 1, this.count);
        System.arraycopy(tail_array, 0, array, index, tail_array.length);
        array[this.count - 1] = null;
        this.count--;
    }
}