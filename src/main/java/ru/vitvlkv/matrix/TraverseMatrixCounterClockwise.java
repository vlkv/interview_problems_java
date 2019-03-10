/* Program to print last element of matrix by traversing a matrix by anticlockwise starting from cell(0,0) and skiping alternate.
Ex:
Input:
1 2 3 4
2 4 5 1
7 9 6 2
3 5 2 7
Output: 5
Start traversing matrix:
Move down from cell(0,0) to cell(0,3). 
Turn right and move to cell(3,3). 
Turn up and move to cell(0,3).
Turn left and move to cell(1,0).
Turn down and move to cell(1,2).
Turn right and move to cell(2,2).
Turn up and move to cell(2,1). Done!

If Input: 
1 2
3 4
Output: 2

Input:
1 2 3
4 5 6
7 8 9
Output: 5
*/
public class TraverseMatrixCounterClockwise {
    
    /** @return last elem of the traversal */
    public static int traverseToLastElem(int[][] matrix) {
        assertMatrixIsSquare(matrix);
        int rows = matrix.length();
        int cols = matrix[0].length();
        State state = new State(rows, cols);
        while (true) {
            if (state.isAbleToMove()) {
                state.move();
            } else {
                state.turnCounterClockwise();
                state.reduceTheBoundaries();
                if (!state.isAbleToMove()) {
                    break;
                }
                state.move();
            }
        }
        return matrix[state.currentRow][state.currentCol];
    }

    private static class State {
        int currentRow = 0;
        int currentCol = 0;
        int rowLowerBound = -1;
        int rowHigherBound;
        int colLowerBound = -1;
        int colHigherBound;
        int[] deltaRows = {1, 0, -1, 0};
        int[] deltaCols = {0, 1, 0, -1};
        int deltaIndex = 0;

        public State(int rows, int cols) {
            rowHigherBound = rows;
            colHigherBound = cols;
        }

        public void turnCounterClockwise() {
            // 1,0  0,1  -1,0  0,-1
            // -,+  -,-   +,-  +, +
            deltaIndex = ++deltaIndex % 4;
        }

        public void reduceTheBoundaries() {
            if (deltaRow() > 0) {
                rowLowerBound++;
            } else if (deltaRow() < 0) {
                rowHigherBound--;
            }
            if (deltaCol() > 0) {
                colLowerBound++;
            } else if (deltaCol() < 0) {
                colHigherBound--;
            }
        }

        private int deltaRow() {
            return deltaRows[deltaIndex];
        }

        private int deltaCol() {
            return deltaCols[deltaIndex];
        }

        public void move() {
            currentRow += deltaRow();
            currentCol += deltaCol();
        }

        public boolean isAbleToMove() {
            int newRow = currentRow + deltaRow();
            int newCol = currentCol + deltaCol();
            boolean rowIsInBounds = newRow > rowLowerBound && newRow < rowHigherBound;
            boolean colIsInBounds = newCol > colLowerBound && newCol < colHigherBound;
            return rowIsInBounds && colIsInBounds;
        }
    }

    private static void assertMatrixIsSquare(int[][] matrix) {
        // TODO
    }
}