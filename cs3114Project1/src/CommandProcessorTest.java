
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
    private String removebn;
    private String removebx;
    private String rsearch;
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
        removebn = "remove b";
        removebx = "remove 2 0 4 8";
        rsearch = "regionsearch 0 500 20 1";
        intersect = "intersections";
        search = "search a";
        dump = "dump";
        unrecognized = "Hello World";
    }


    /**
     * Test that all branches are reached in the processor function
     */
    public void testProcessor() {
        cmdProc.processor(insert);

        cmdProc.processor(removebn);

        // cmdProc.processor(removebx);

        cmdProc.processor(rsearch);

        cmdProc.processor(intersect);

        cmdProc.processor(search);

        // cmdProc.processor(dump);

        systemOut().clearHistory();
        cmdProc.processor(unrecognized);
        assertEquals(systemOut().getHistory(), "Unrecognized command.\n");
    }
}
