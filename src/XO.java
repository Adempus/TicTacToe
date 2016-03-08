
/**
 * Created on 2/21/16.
 */
public class XO
{
    private String name;
    private static int turn = 0;

    private enum XO_Value { X, O }
    private XO_Value xo;

    XO() {
        // the ^ operator basically is used to flip bits.
        // If turn is 1, it becomes 0 and vice versa
        switch(turn ^= 1) {
            case 0 : xo = XO_Value.O; break;
            case 1 : xo = XO_Value.X; break;
        }
        this.name = xo.toString();
    }

    public boolean isEqual(XO xo) {
        boolean equal;
        // the try/catch here is to prevent errors from null exceptions
        // since there are only nulls on an empty board.
        try {
            equal = (name.equals(xo.toString()));
        } catch (NullPointerException ex) {
            return false;
        }

        return equal;
    }

    public String toString() {
        return name;
    }

    public static int getTurn() {
        return turn;
    }
}