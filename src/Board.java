/**
 * Created by adempus on 2/21/16.
 */
public class Board
{
    private int rows;
    private int cols;

    Board() { }

    Board (int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }
}
