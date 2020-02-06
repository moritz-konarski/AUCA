class ArrayListInt {
    // Data
    private int size;
    private int[] array;

    // Constructor.
    ArrayListInt() {
        size = 0;
        array = new int[1];
    }

    // Behavior.
    // Returns the size of the List.
    int size() {
        return size;
    }

    // Gets the value at the given index.
    int get(int index) throws IndexOutOfBoundsException {
        if (index < size && index >= 0)
            return array[index];
        else
            throw new IndexOutOfBoundsException(size(), index, "get(int index)");
    }

    // Set the value at the given index.
    void set(int index, int element) throws IndexOutOfBoundsException {
        if (index < size && index >= 0)
            array[index] = element;
        else
            throw new IndexOutOfBoundsException(size(), index, "set(int index, int element)");
    }

    // Add an element to the end of the list.
    void add(int element) {
        int[] temp = array;
        array = new int[size + 1];
        for (int i = 0; i < size; i++)
            array[i] = temp[i];
        array[size] = element;
        size++;
    }

    // Add the element e before element with index index.
    void add(int index, int element) throws IndexOutOfBoundsException {
        if (index >= 0 && index <= size) {
            int[] temp = array;
            array = new int[size + 1];
            for (int i = 0; i < index; i++)
                array[i] = temp[i];
            array[index] = element;
            size++;
            for (int i = index + 1; i < size; i++)
                array[i] = temp[i - 1];
        } else
            throw new IndexOutOfBoundsException(size(), index, "add(int element, int index)");
    }

    // Remove the element at index index.
    void remove(int index) {
        int[] temp = array;
        array = new int[size - 1];
        for (int i = 0; i < index; i++)
            array[i] = temp[i];
        size--;
        for (int i = index; i < size; i++)
            array[i] = temp[i + 1];
    }

    void clear() {
        size = 0;
        array = new int[1];
    }

    // Return a string representing the array.
    public String toString() {
        String output = "";
        for (int i : array)
            output = output.concat(i + " ");
        return output.trim();
    }
}
