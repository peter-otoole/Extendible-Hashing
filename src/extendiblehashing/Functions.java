package extendiblehashing;

/**
 *
 * @author Peter OToole
 */
public class Functions {
    
    public static Bucket[] addElement(int value, Bucket[] bucks)
        {
            int position = value %((int)Math.pow(2, (int)(Test.globalDepth)));
           
            if(!bucks[position].isFull())
                {
                    if(!bucks[position].getElemOne().getIsFull())
                        {
                            bucks[position].getElemOne().setValue(value);
                            bucks[position].getElemOne().setIsFull(true);
                        }else 
                            {
                                bucks[position].getElemTwo().setValue(value);
                                bucks[position].getElemTwo().setIsFull(true);
                            }
                }else
                    {   
                         bucks = collisionDetected(bucks, value, position);
                    }
            
            return bucks;
        }
    
    public static Bucket[] collisionDetected(Bucket[] buckets, int value, int probBucket)
        {
            int position = value %((int)Math.pow(2, (int)(Test.globalDepth)));
        
            if(buckets[position].getLocalDepth()<Test.globalDepth)
                {
                    buckets = splitBucket(buckets, value, probBucket);
                }else
                    {
                        buckets = doubleDirectory(buckets);
                        buckets = addElement(value, buckets);
                    }
         
            return buckets;
        }
    
    public static Bucket[] doubleDirectory(Bucket[] buckets)
        {
            Test.globalDepth = Test.globalDepth + 1;
            int arrayLen = (int)Math.pow(2, Test.globalDepth);
            Bucket[] newBuckets = new Bucket[arrayLen];
            
            for(int q=0; q<arrayLen; q++)
                {
                    if(q<((int) Math.pow(2, (Test.globalDepth-1))))
                        {
                            newBuckets[q]= buckets[q];
                        }else
                            {
                                newBuckets[q] = new Bucket();
                                newBuckets[q].getElemOne().setIsFull(false);
                                newBuckets[q].getElemTwo().setIsFull(false);
                            }
                }
        
            return newBuckets;
        }
    
    public static Bucket[] splitBucket(Bucket[] buckets, int value, int probBucket)
        {
                        int temp1a = buckets[probBucket].getElemOne().getValue();
                        int temp2a = buckets[probBucket].getElemTwo().getValue();
                        //set both poitions to being empty
                        buckets[probBucket].getElemOne().setIsFull(false);
                        buckets[probBucket].getElemTwo().setIsFull(false);
                        
                        //add elements back into the array
                        buckets = addElement(temp1a, buckets);
                        buckets = addElement(temp2a, buckets);
                        buckets = addElement(value, buckets); 
        
            return buckets;
        }
    
    
    
    public static void printAllStoredData(int globalDepth, Bucket[] bucks)
        {
            int loopLen = (int) Math.pow(2, globalDepth);               
                    
            for(int i=0; i<loopLen; i++)
                {
                    if(bucks[i]!=null)
                        {
                            if(!bucks[i].isEmpty())
                                {
                                    if(bucks[i].getElemOne().getIsFull())
                                        {
                                            System.out.println("In bucket "+i+", element one contains: "+bucks[i].getElemOne().getValue());
                                        }
                                    if(bucks[i].getElemTwo().getIsFull())
                                        {
                                            System.out.println("In bucket "+i+", element two contains: "+bucks[i].getElemTwo().getValue());
                                        }
                                
                                }
                        }
                }
        }
    
}
