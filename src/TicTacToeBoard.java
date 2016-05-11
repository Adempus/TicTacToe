/**
 * Created by adempus on 2/21/16.
 */

public class TicTacToeBoard extends Board
{
    private XO _2DBoardArray[][];
    private int row, col;   // References to current rows and columns
    private int turnCounter;

    TicTacToeBoard(int rows, int cols)
    {
        super(rows, cols);
        _2DBoardArray = new XO[rows][cols];
    }

    public void add(int row, int col) throws
            UnsupportedOperationException, IndexOutOfBoundsException
    {
        if(row > 3 || col > 3)
            throw new IndexOutOfBoundsException("Out of bounds.");
        else if (_2DBoardArray[row-1][col-1] != null)
            throw new UnsupportedOperationException("Space occupied!");
        else
            _2DBoardArray[row-1][col-1] = new XO();

        turnCounter = XO.getTurn();
        this.row = row-1;
        this.col = col-1;
    }

    public boolean isWinner() {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean Diagonal1Match = true;
        boolean Diagonal2Match = true;

        if(_2DBoardArray[row][col] == null)
            return false;

        XO play = _2DBoardArray[row][col];

        // Check the rows and columns
        for (int i = 0 ; i < _2DBoardArray.length ; i++) {
            if (!play.isEqual(_2DBoardArray[row][i]))
                rowMatch = false;
            if (!play.isEqual(_2DBoardArray[i][col]))
                columnMatch = false;
        }

        // Check diagonals
        for (int i = 0 ; i < _2DBoardArray.length ; i++) {
            if (!play.isEqual(_2DBoardArray[i][i]))
                Diagonal1Match = false;
            if (!play.isEqual(_2DBoardArray[i][-1 * i + (_2DBoardArray.length - 1)]))
                Diagonal2Match = false;
        }
        return ( rowMatch || columnMatch || Diagonal1Match || Diagonal2Match );
    }

    public void printBoard() {
        System.out.println();
        for(XO[] xo : _2DBoardArray) {
            for(XO ele : xo) {
                if(ele == null) System.out.print(" _ ");
                else System.out.print(" " + ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isADraw() {
        for(XO[] xo : _2DBoardArray) {
            for (XO obj : xo) {
                if (obj == null) return false;
            }
        }
        return true;
    }

    public int getTurnCounter() {
        return turnCounter;
    }
}
