import java.lang.reflect.Array;
import student.TestCase;
import student.TestableRandom;

/**
 * @author Will Logan
 * @version 1.0
 */
public class SkipListTest extends TestCase {
    private SkipList<String, Rectangle> test1 = null;
    private Rectangle[] rec;
    private Rectangle rnull; // Leave null
    private KVPair<String, Rectangle>[] listRecs;

    @SuppressWarnings("unchecked")
    public void setUp() {
        test1 = new SkipList<String, Rectangle>();
        rec = new Rectangle[10];
        rec[0] = new Rectangle(0, 0, 0, 0);
        rec[1] = new Rectangle(1, 1, 5, 10);
        rec[2] = new Rectangle(-1, -5, 15, 20);
        rec[3] = new Rectangle(20, 20, 10, 10);
        rec[4] = new Rectangle(2, 2, 10, 10);
        rec[5] = new Rectangle(-10, -10, 10, 10);
        rec[6] = new Rectangle(9, 4, 10, 10);
        rec[7] = new Rectangle(-100, 4, 10, 10);
        rec[8] = new Rectangle(-100, 4, 20, 10);
        rec[9] = new Rectangle(-100, 4, 10, 8);
        listRecs = (KVPair[])Array.newInstance(KVPair.class, 10);
        for (int i = 1; i <= 5; i++) {
            listRecs[i - 1] = new KVPair<String, Rectangle>("r" + i, rec[i
                - 1]);
        }
        for (int i = 5; i <= 10; i++) {
            listRecs[i - 1] = new KVPair<String, Rectangle>("a" + i, rec[i
                - 1]);
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
        for (int i = 0; i <= 9; i++) {
            test1.insert(listRecs[i]);
            assertEquals(7 + i, test1.size());
        }
        KVPair<String, Rectangle> endList = new KVPair<String, Rectangle>(
            "zeta", rec[9]);
        test1.insert(endList);
        assertEquals(17, test1.size());
    }


    public void testDump() {
// 4
// 0
// 5
// 1
// 4
// 0
// 1
// 4
// 0
        test1.dump();
        assertFuzzyEquals("SkipList dump:" + "\nNode with depth 0, Value null"
            + "\nSkipList size is: 0", systemOut().getHistory());
        systemOut().clearHistory();
        test1.insert(listRecs[0]);
        test1.dump();
        assertFuzzyEquals("SkipList dump:" + "\nNode with depth 4, Value null"
            + "\nNode with depth 4, Value (r1, 0, 0, 0, 0)"
            + "\nSkipList size is: 1", systemOut().getHistory());
        systemOut().clearHistory();
        test1.insert(listRecs[1]);
        test1.dump();
        assertFuzzyEquals("SkipList dump:\nNode with depth 4, Value null"
            + "\nNode with depth 4, Value (r1, 0, 0, 0, 0)"
            + "\nNode with depth 0, Value (r2, 1, 1, 5, 10)"
            + "\nSkipList size is: 2", systemOut().getHistory());
        systemOut().clearHistory();
        test1.insert(listRecs[5]);
        test1.dump();
        assertFuzzyEquals("SkipList dump:" + "\nNode with depth 5, Value null"
            + "\nNode with depth 5, Value (a6, -10, -10, 10, 10)"
            + "\nNode with depth 4, Value (r1, 0, 0, 0, 0)"
            + "\nNode with depth 0, Value (r2, 1, 1, 5, 10)"
            + "\nSkipList size is: 3", systemOut().getHistory());
        systemOut().clearHistory();
        test1.insert(listRecs[2]);
        test1.dump();
        assertFuzzyEquals("SkipList dump:" + "\nNode with depth 5, Value null"
            + "\nNode with depth 5, Value (a6, -10, -10, 10, 10)"
            + "\nNode with depth 4, Value (r1, 0, 0, 0, 0)"
            + "\nNode with depth 0, Value (r2, 1, 1, 5, 10)"
            + "\nNode with depth 1, Value (r3, -1, -5, 15, 20)"
            + "\nSkipList size is: 4", systemOut().getHistory());

    }

}
