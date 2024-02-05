
/**
 * 
 */
import student.TestCase;

/**
 * @author Jacob Fast
 * @version 1.0
 */
public class DatabaseTest extends TestCase {

    private Database list;
    private Rectangle r1;
    private KVPair<String, Rectangle> p1;
    private Rectangle r2;
    private KVPair<String, Rectangle> p2;
    private Database list2;

    /**
     * Set up variables used in testing
     */
    public void setUp() {
        list = new Database();
        r1 = new Rectangle(1, 0, 2, 4);
        p1 = new KVPair<String, Rectangle>("a", r1);
        r2 = new Rectangle(-1, -1, 2, 4);
        p2 = new KVPair<String, Rectangle>("b", r2);
        list2 = new Database();

    }


    /**
     * Test that the insert method works
     */
    public void testInsert() {
        list.insert(p1);
        list.insert(p2);
        assertEquals(systemOut().getHistory(),
            "Rectangle inserted: (a, 1, 0, 2, 4)\n"
                + "Rectangle rejected: (b, -1, -1, 2, 4)\n");
    }

// public void testRemove() {
// /* list.insert(p1);
// list.remove("a");
// list.remove("b");
// assertEquals(systemOut().getHistory(), "Rectangle inserted: (a, 1, 0, 2,
// 4)\n" + "Rectangle removed: (a, 1, 0, 2, 4)\n" + "Rectangle not removed:
// b\n");
// */
// }


    /**
     * Test that region search works
     */
    public void testRegionSearch() {
        list.regionsearch(1, 1, -1, -5);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (1, 1, -1, -5)\n");
        systemOut().clearHistory();

        list.regionsearch(1, 1, 10, 10);
        assertEquals(systemOut().getHistory(),
            "Rectangles intersecting region (1, 1, 10, 10):\n");
        systemOut().clearHistory();

        /*
         * list.insert(p1);
         * systemOut().clearHistory();
         * list.regionsearch(0, 0, 20, 20);
         * assertEquals(systemOut().getHistory(),
         * "Rectangles intersection region (0, 0, 20, 20):\n" +
         * "(a, 1, 0, 2, 4)\n");
         */
    }


    /**
     * Test Intersections method
     */
    public void testIntersections() {
        list.intersections();
        assertEquals(systemOut().getHistory(), "Intersection pairs:\n");
        systemOut().clearHistory();

        list.insert(p1);
        Rectangle r3 = new Rectangle(0, 1, 4, 2);
        KVPair<String, Rectangle> p3 = new KVPair<String, Rectangle>("c", r3);
        list.insert(p3);
        systemOut().clearHistory();

        // list.intersections();
        // assertEquals(systemOut().getHistory(), "Intersections pairs:\n" +
        // "(a, 1, 0, 2, 4,) | (c, 0, 1, 4, 2)\n");

    }

// public void testSearch() {
// list.search("a");
// assertEquals(systemOut().getHistory(), "Rectangle not found: (a)\n");
// // can't test rest because search isn't implemented
// }


    /**
     * Test that dump works
     */
    public void testDump() {

        list.dump();
        assertFuzzyEquals(systemOut().getHistory(), "Skiplist Dump:\n"
            + "Node with depth: 0 Value null\n" + "SkipList size is: 0\n");
        list.insert(p1);
        systemOut().clearHistory();

        list.dump();
        assertFuzzyEquals(systemOut().getHistory(), "SkipList Dump:\n"
            + "Node with depth: 4 Value null\n"
            + "Node with depth: 4 Value (a, 1, 0, 2, 4)\n"
            + "SkipList size is: 1\n");

    }
}
