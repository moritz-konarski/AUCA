//inspired by this Quora post: https://www.quora.com/How-does-Arraylist-in-java-internally-implemented-Is-it-change-its-size-to-double-Then-Why-double
// and the java docs: http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/ArrayList.java

class ArrayListIntV2 {
    // Data
    private int size;
    private int[] array;

    // Constructor.
    ArrayListIntV2() {
        size = 0;
        array = new int[10];
    }

    // Behavior.
    // Returns the size of the List.
    int size() {
        return size;
    }

    // Gets the value at the given index.
    int get(int index) throws IndexOutOfBoundsException {
        if (indexInRange(index))
            return array[index];
        else
            throw new IndexOutOfBoundsException(size(), index, "get(int index)");
    }

    // Set the value at the given index.
    void set(int index, int element) throws IndexOutOfBoundsException {
        if (indexInRange(index))
            array[index] = element;
        else
            throw new IndexOutOfBoundsException(size(), index, "set(int index, int element)");
    }

    // Add an element to the end of the list.
    void add(int element) {
        if (size + 1 > array.length) {
            int[] temp = array;
            array = new int[(int) (size * 1.5)];
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[size] = element;
        size++;
    }

    // Add the element e before element with index index.
    void add(int index, int element) throws IndexOutOfBoundsException {
        if (indexInRange(index)) {
            if (size + 1 > array.length) {
                int[] temp = array;
                array = new int[(int) (size * 1.5)];
                System.arraycopy(temp, 0, array, 0, index);
                array[index] = element;
                System.arraycopy(temp, index, array, index + 1, temp.length - index);
            } else {
                int[] temp = array;
                array[index] = element;
                System.arraycopy(temp, index, array, index, temp.length - index);
            }
            size++;
        } else
            throw new IndexOutOfBoundsException(size(), index, "add(int element, int index)");
    }

    // Remove the element at index index.
    void remove(int index) throws IndexOutOfBoundsException {
        if (indexInRange(index)) {
            int[] temp = array;
            shrink();
            System.arraycopy(temp, index + 1, array, index, temp.length - index - 1);
            size--;
        } else
            throw new IndexOutOfBoundsException(size(), index, "remove(int index)");
    }

    // Reverse the order of the elements
    void reverse() {
        int temp;
        for (int i = 0; i < size / 2; i++) {
            temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }

    // Clear the array
    void clear() {
        size = 0;
        array = new int[10];
    }

    // Return a string representing the array.
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++)
            output = output.concat(array[i] + " ");
        return output.trim();
    }

    private boolean indexInRange(int index) {
        return (index < size && index >= 0);
    }

    private void shrink() {
        if (size < array.length / 1.5) {
            array = new int[(int) (size / 1.5)];
        }
    }
}