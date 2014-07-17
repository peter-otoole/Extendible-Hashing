package extendiblehashing;
/**
 *
 * @author Peter OToole
 */
public class Bucket {
    
    private Elem e1 = new Elem();
    private Elem e2 = new Elem();
    private int localDepth = 2;
    
    public Bucket()
        {
        }
    
    public boolean isFull()
        {           
            if(e1.getIsFull() && e2.getIsFull())
                {
                    return true;
                }
            
            else{
                    return false;
                }
        }
    public boolean isEmpty()
        {
            if((!e1.getIsFull()) && (!e2.getIsFull()))
                {
                    return true;
                }else
                    {
                        return false;
                    }
        }

    public void setElemOne(int val, boolean f)
        {
            e1.setValue(val);
            e1.setIsFull(f);
        }
    public Elem getElemOne()
        {
            return e1;
        }
    public void setElemTwo(int val, boolean f)
        {
            e2.setValue(val);
            e2.setIsFull(f);
        }
    public Elem getElemTwo()
        {
            return e2;
        }
    public int getLocalDepth()
        {
            return localDepth;
        }
    public void setLocalDepth(int val)
        {
            localDepth = val;
        }
    
}
