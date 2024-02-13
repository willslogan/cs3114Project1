
/**
 * 
 */
import student.TestCase;
import java.util.ArrayList;

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
    private ArrayList<KVPair<String, Rectangle>> tests;
    private KVPair<String, Rectangle> rectangle1;
    private KVPair<String, Rectangle> rectangle2;
    private KVPair<String, Rectangle> rectangle3;
    private KVPair<String, Rectangle> rectangle4;
    private KVPair<String, Rectangle> rectangle5;
    private KVPair<String, Rectangle> rectangle6;
    private KVPair<String, Rectangle> rectangle7;
    private KVPair<String, Rectangle> rectangle8;
    private KVPair<String, Rectangle> rectangle9;
    private KVPair<String, Rectangle> rectangle10;
    private KVPair<String, Rectangle> rectangle11;
    private KVPair<String, Rectangle> rectangle12;
    private KVPair<String, Rectangle> rectangle13;
    private KVPair<String, Rectangle> rectangle14;
    private KVPair<String, Rectangle> rectangle15;
    private KVPair<String, Rectangle> rectangle16;
    private KVPair<String, Rectangle> rectangle17;
    private KVPair<String, Rectangle> rectangle18;

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
        tests = new ArrayList<KVPair<String, Rectangle>>();
        rectangle1 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, 0,
            0)); // Reject
        rectangle2 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, 1,
            0)); // Reject
        rectangle3 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, 0,
            1)); // Reject
        rectangle4 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, 1,
            1)); // Accept
        rectangle5 = new KVPair<String, Rectangle>("a", new Rectangle(-1, 0, 1,
            1)); // Reject
        rectangle6 = new KVPair<String, Rectangle>("a", new Rectangle(0, -1, 1,
            1)); // Reject
        rectangle7 = new KVPair<String, Rectangle>("a", new Rectangle(-1, -1, 1,
            1)); // Reject
        rectangle8 = new KVPair<String, Rectangle>("a", new Rectangle(500, 500,
            600, 500)); // Reject
        rectangle9 = new KVPair<String, Rectangle>("a", new Rectangle(500, 500,
            500, 600)); // Reject
        rectangle10 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, -1,
            1)); // Reject
        rectangle11 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, 1,
            -1)); // Reject
        rectangle12 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0, -1,
            -1)); // Reject
        rectangle13 = new KVPair<String, Rectangle>("1a", new Rectangle(0, 0, 1,
            1)); // Reject
        rectangle14 = new KVPair<String, Rectangle>("_a", new Rectangle(0, 0, 1,
            1)); // Reject
        rectangle15 = new KVPair<String, Rectangle>(" a", new Rectangle(0, 0, 1,
            1)); // Reject
        rectangle16 = new KVPair<String, Rectangle>("@a", new Rectangle(0, 0, 1,
            1)); // Reject
        rectangle17 = new KVPair<String, Rectangle>("a", new Rectangle(0, 0,
            1024, 1024)); // Accept
        rectangle18 = new KVPair<String, Rectangle>("a", new Rectangle(1, 1,
            1023, 1023)); // Accept

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
        systemOut().clearHistory();

        list.insert(rectangle1);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, 0, 0)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle2);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, 1, 0)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle3);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, 0, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle4);
        assertFuzzyEquals("Rectangle inserted: (a, 0, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle5);
        assertFuzzyEquals("Rectangle rejected: (a, -1, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle6);
        assertFuzzyEquals("Rectangle rejected: (a, 0, -1, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle7);
        assertFuzzyEquals("Rectangle rejected: (a, -1, -1, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle8);
        assertFuzzyEquals("Rectangle rejected: (a, 500, 500, 600, 500)\n",
            systemOut().getHistory());
        systemOut().clearHistory();

        list.insert(rectangle9);
        assertFuzzyEquals("Rectangle rejected: (a, 500, 500, 500, 600)\n",
            systemOut().getHistory());
        systemOut().clearHistory();

        list.insert(rectangle10);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, -1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle11);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, 1, -1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle12);
        assertFuzzyEquals("Rectangle rejected: (a, 0, 0, -1, -1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle13);
        assertFuzzyEquals("Rectangle rejected: (1a, 0, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle14);
        assertFuzzyEquals("Rectangle rejected: (_a, 0, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle15);
        assertFuzzyEquals("Rectangle rejected: ( a, 0, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle16);
        assertFuzzyEquals("Rectangle rejected: (@a, 0, 0, 1, 1)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(rectangle17);
        assertFuzzyEquals("Rectangle inserted: (a, 0, 0, 1024, 1024)\n",
            systemOut().getHistory());
        systemOut().clearHistory();

        list.insert(rectangle18);
        assertFuzzyEquals("Rectangle inserted: (a, 1, 1, 1023, 1023)\n",
            systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Test Remove
     */
    public void testRemove() {

        list.insert(p1);
        list.remove("a");
        list.remove("b");
        assertEquals(systemOut().getHistory(),
            "Rectangle inserted: (a, 1, 0, 2, 4)\n"
                + "Rectangle removed: (a, 1, 0, 2, 4)\n"
                + "Rectangle not removed: (b)\n");
        systemOut().clearHistory();
        list.remove(-1, -1, 0, 0);
        assertFuzzyEquals("Rectangle rejected: (-1, -1, 0, 0)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.remove(10, 10, 10, 10);
        assertFuzzyEquals("Rectangle not found: (10, 10, 10, 10)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        list.insert(p1);
        systemOut().clearHistory();
        list.remove(1, 0, 2, 4);
        assertFuzzyEquals("Rectangle removed: (a, 1, 0, 2, 4)\n", systemOut()
            .getHistory());
    }


    /**
     * Test that region search works
     */
    public void testRegionSearch() {
        list.regionsearch(1, 1, -1, 5);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (1, 1, -1, 5)\n");
        systemOut().clearHistory();

        list.regionsearch(1, 1, 1, -5);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (1, 1, 1, -5)\n");
        systemOut().clearHistory();

        list.regionsearch(1, 1, 10, 10);
        assertEquals(systemOut().getHistory(),
            "Rectangles intersecting region (1, 1, 10, 10):\n");
        systemOut().clearHistory();

        list.insert(p1);
        systemOut().clearHistory();
        list.regionsearch(0, 0, 20, 20);
        assertEquals(systemOut().getHistory(),
            "Rectangles intersecting region (0, 0, 20, 20):\n"
                + "(a, 1, 0, 2, 4)\n");

    }


    /**
     * Test Intersections method
     */
    public void testIntersections() {
        list.intersections();
        assertEquals(systemOut().getHistory(), "Intersection pairs:\n");
        systemOut().clearHistory();

        list.insert(p1);
        systemOut().clearHistory();
        list.intersections();
        assertEquals(systemOut().getHistory(), "Intersection pairs:\n");
        systemOut().clearHistory();

        Rectangle r3 = new Rectangle(0, 1, 4, 2);
        KVPair<String, Rectangle> p3 = new KVPair<String, Rectangle>("c", r3);
        list.insert(p3);
        Rectangle r4 = new Rectangle(50, 50, 5, 5);
        KVPair<String, Rectangle> p4 = new KVPair<String, Rectangle>("d", r4);
        list.insert(p4);
        systemOut().clearHistory();

        list.intersections();
        assertEquals(systemOut().getHistory(), "Intersection pairs:\n"
            + "(a, 1, 0, 2, 4) | (c, 0, 1, 4, 2)\n"
            + "(c, 0, 1, 4, 2) | (a, 1, 0, 2, 4)\n");

    }


    /**
     * Test search method
     */
    public void testSearch() {
        list.search("a");
        assertEquals(systemOut().getHistory(), "Rectangle not found: (a)\n");
        // can't test rest because search isn't implemented
    }


    /**
     * Test that dump works
     */
    public void testDump() {

        list.dump();
        assertFuzzyEquals(systemOut().getHistory(), "SkipList dump:\n"
            + "Node with depth 1, value null\n" + "SkipList size is: 0\n");
        list.insert(p1);
        systemOut().clearHistory();

        list.dump();
        assertFuzzyEquals(systemOut().getHistory(), "SkipList Dump:\n"
            + "Node with depth 4, value null\n"
            + "Node with depth 4, value (a, 1, 0, 2, 4)\n"
            + "SkipList size is: 1\n");

    }
}
