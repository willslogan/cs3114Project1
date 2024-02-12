
/**
 * 
 */
import student.TestCase;

/**
 * @author Jacob Fast
 * @version 1.0
 */
public class CommandProcessorTest extends TestCase {
    private CommandProcessor cmdProc;
    private String insert;
    private String insx;
    private String removebn;
    private String removebx;
    private String rsearch;
    private String rsearchin;
    private String intersect;
    private String search;
    private String dump;
    private String unrecognized;

    /**
     * Set up variables used in testing
     */
    public void setUp() {
        cmdProc = new CommandProcessor();
        insert = "insert a 1 0 2 4";
        insx = "insart";
        removebn = "remove b";
        removebx = "remove 2 0 4 8";
        rsearch = "regionsearch 0 500 20 1";
        rsearchin = "regionsearch -5 -5 0 0";
        intersect = "intersections";
        search = "search a";
        dump = "dump";
        unrecognized = "Hello World";
    }


    /**
     * Test that all branches are reached in the processor function
     */
    // print checks for each line
    public void testProcessor() {
        cmdProc.processor(insert);
        assertFuzzyEquals("Rectangle inserted: (a, 1, 0, 2, 4)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        cmdProc.processor(insx);
        assertFuzzyEquals("Unrecognized command.\n", systemOut().getHistory());
        systemOut().clearHistory();

        cmdProc.processor(removebn);
        systemOut().clearHistory();

        cmdProc.processor(removebx);
        assertFuzzyEquals("Rectangle not found: (2, 0, 4, 8)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        cmdProc.processor(rsearch);
        assertFuzzyEquals("Rectangles intersecting region (0, 500, 20, 1)\n",
            systemOut().getHistory());
        systemOut().clearHistory();

        cmdProc.processor(rsearchin);
        assertFuzzyEquals("Rectangle rejected: (-5, -5, 0, 0)\n", systemOut()
            .getHistory());
        systemOut().clearHistory();

        cmdProc.processor(intersect);
        assertFuzzyEquals("Intersection pairs:\n", systemOut().getHistory());
        systemOut().clearHistory();

        cmdProc.processor(search);
        systemOut().clearHistory();

        cmdProc.processor(dump);
        assertFuzzyEquals("Skiplist Dump:\n" + "Node with depth: 4 Value null\n"
            + "Node with depth: 4 Value (a, 1, 0, 2, 4)\n"
            + "SkipList size is: 1", systemOut().getHistory());
        systemOut().clearHistory();

        cmdProc.processor(unrecognized);
        assertEquals(systemOut().getHistory(), "Unrecognized command.\n");
    }
}
