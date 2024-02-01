/**
 * 
 */
import student.TestCase;
/**
 * 
 */
public class RectangleTest extends TestCase {
    private Rectangle r1;
    private Rectangle r2; 
    private Rectangle r3;
    private Rectangle r4;
    private Rectangle r5;
    private Rectangle rnull;    //Leave null
    
    public void setUp() {
        r1 = new Rectangle(0, 0, 0, 0);
        r2 = new Rectangle(1, 1, 5, 10);
        r3 = new Rectangle(-1, -5, 15, 20);
        r4 = new Rectangle(20, 20, 10, 10);
        r5 = new Rectangle(2, 2, 10, 10);
    }
    
    public void testGetxCoordinate() {
        assertEquals(0, r1.getxCoordinate());
        assertEquals(1, r2.getxCoordinate());
    }
    
    public void testGetyCoordinate() {
        assertEquals(0, r1.getyCoordinate());
        assertEquals(1, r2.getyCoordinate());
    }
    
    public void testGetWidth() {
        assertEquals(0, r1.getWidth());
        assertEquals(5, r2.getWidth());
    }
    
    public void testGetHeight() {
        assertEquals(0, r1.getHeight());
        assertEquals(10, r2.getHeight());
    }
    
    public void testIntersect() {
        assertFalse(r2.intersect(r4));
        assertTrue(r2.intersect(r5));
        assertTrue(r2.intersect(r2)); 
    }
    
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(r1.equals(r1));
        assertFalse(r1.equals(rnull));
        assertFalse(r1.equals("Different Class"));
        assertFalse(r1.equals(r2));
        Rectangle copy = new Rectangle(0, 0, 0, 0);
        assertTrue(r1.equals(copy));
        
    }
    
    public void testToString() {
        assertEquals(r1.toString(), "X coordinate: 0, Y coordinate: 0, Width: 0, Height: 0");
        assertEquals(r2.toString(), "X coordinate: 1, Y coordinate: 1, Width: 5, Height: 10");
        assertEquals(r3.toString(), "X coordinate: -1, Y coordinate: -5, Width: 15, Height: 20");
    }
    
    public void testIsInvalid() {
        assertFalse(r1.isInvalid());
        assertTrue(r2.isInvalid());
        assertFalse(r3.isInvalid());
    }
}
