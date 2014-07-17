package extendiblehashing;
/**
 *
 * @author Peter OToole
 */
public class Test {
        public static int globalDepth = 2;
        
    public static void main(String[] args) {
        
        Bucket[] bucks = new Bucket[100];
        for(int q=0; q<100; q++){bucks[q]=new Bucket();}   

        bucks = Functions.addElement(2369, bucks);
        bucks = Functions.addElement(3760, bucks);
        bucks = Functions.addElement(4692, bucks);
        bucks = Functions.addElement(4871, bucks);
        bucks = Functions.addElement(5659, bucks);
        bucks = Functions.addElement(1821, bucks);
        bucks = Functions.addElement(1074, bucks);
        bucks = Functions.addElement(7115, bucks);
        bucks = Functions.addElement(1620, bucks);
        
        Functions.printAllStoredData(globalDepth, bucks);
    }
}
