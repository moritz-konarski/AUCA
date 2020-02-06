class IndexOutOfBoundsException extends Exception {
    private static String message = "Can not \"%s\" with index = %d. Index out of bounds [0-%d]";

    IndexOutOfBoundsException(int arraySize, int index, String function) {
        message = String.format(message, function, index, arraySize - 1);
    }

    public String getMessage() {
        return message;
    }

}
