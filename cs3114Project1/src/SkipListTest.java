import java.lang.reflect.Array;
import student.TestCase;

public class SkipListTest extends TestCase {
    private SkipList<String, Rectangle> test1 = null;
    private Rectangle[] rec;
    private Rectangle rnull;    //Leave null
    private KVPair<String, Rectangle>[] listRecs;
    
    @SuppressWarnings("unchecked")
    public void setUp() {
        test1 = new SkipList<String, Rectangle>();
        rec = new Rectangle[5];
        rec[0] = new Rectangle(0, 0, 0, 0);
        rec[1] = new Rectangle(1, 1, 5, 10);
        rec[2] = new Rectangle(-1, -5, 15, 20);
        rec[3] = new Rectangle(20, 20, 10, 10);
        rec[4] = new Rectangle(2, 2, 10, 10);
        listRecs = (KVPair[])Array.newInstance(KVPair.class, 5);
        for(int i = 1; i<=5; i++) {
            listRecs[i-1] = new KVPair<String, Rectangle>("r" + i, rec[i-1]);
        }
        
    }
    
    public void testInsert() {
        test1.insert(listRecs[0]);
        assertEquals(1, test1.size());
        test1.insert(listRecs[1]);
        assertEquals(2, test1.size());
        test1.insert(listRecs[0]);
        assertEquals(3, test1.size());
        test1.insert(listRecs[2]);
        assertEquals(4, test1.size());
        test1.insert(listRecs[3]);
        assertEquals(5, test1.size());
        test1.insert(listRecs[4]);
        assertEquals(6, test1.size());
        for(int i = 1; i<=100; i++) {
            test1.insert(listRecs[3]);
            assertEquals(6+i, test1.size());
        }
        
    }
    
}
