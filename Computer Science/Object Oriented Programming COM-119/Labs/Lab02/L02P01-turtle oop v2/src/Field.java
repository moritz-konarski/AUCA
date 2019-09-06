class Field {

    //constants
    final private static char UNMARKED = '.';
    final private static char MARKED = '*';
    final private static char TURTLE = 't';
    //instance variables
    private char[][] field;
    private int rows, cols;

    //constructor
    Field(int nRows, int nCols) {
        rows = nRows;
        cols = nCols;
        field = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                field[row][col] = UNMARKED;
            }
        }
    }

    //set the spot of the turtle as marked
    void setFieldMarked(int x, int y){
        field[y][x] = MARKED;
    }

    //get number of rows (y range)
    int getRows(){
        return rows;
    }

    //get number of cols (x range)
    int getCols(){
        return cols;
    }

    //behavior
    //print the field
    void print(Turtle turtle) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == turtle.getPosY() && col == turtle.getPosX()) {
                    System.out.printf("%c ", TURTLE);
                    continue;
                }
                System.out.printf("%c ", field[row][col]);
            }
            System.out.println();
        }
    }

    //reset the whole field (the traces)
    void reset() {
        field = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                field[row][col] = UNMARKED;
            }
        }
    }
}
