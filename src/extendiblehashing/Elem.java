package extendiblehashing;

/**
 *
 * @author Peter OToole
 */
public class Elem {
    
    private int value = 0;
    private boolean isFull = false;
    
    public Elem(){}
    
    public void setValue(int val)
        {
            value = val;
        }
    public int getValue()
        {
            return value;
        }
    
    public void setIsFull(boolean val)
        {
            isFull = val;
        }
    public boolean getIsFull()
        {
            return isFull;
        }
}
