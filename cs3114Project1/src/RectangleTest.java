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
        Rectangle center = new Rectangle(0, 0, 10, 10);
        
        Rectangle r6 = new Rectangle(0, 11, 10, 10);
        assertFalse(center.intersect(r6));
        
        Rectangle r7 = new Rectangle(-10, 0, 5, 5);
        assertFalse(center.intersect(r7));
        
        Rectangle r8 = new Rectangle(0, -10, 5, 5);
        assertFalse(center.intersect(r8));
        
        Rectangle r9 = new Rectangle(11, 0, 10, 10);
        assertFalse(center.intersect(r9));
        
        Rectangle r10 = new Rectangle(6, 1, 5, 5);
        assertTrue(center.intersect(r10));
        
        Rectangle r11 = new Rectangle(1, 6, 5, 5);
        assertTrue(center.intersect(r11));
        
        Rectangle r12 = new Rectangle(-1, 1, 5, 5);
        assertTrue(center.intersect(r12));
        
        Rectangle r13 = new Rectangle(1, -1, 5, 5);
        assertTrue(center.intersect(r13));
        
        Rectangle r14 = new Rectangle(3, 3, 2, 2);
        assertTrue(center.intersect(r14));
        
        Rectangle r15 = new Rectangle(-2, -2, 5, 5);
        assertTrue(center.intersect(r15));
        
        Rectangle r16 = new Rectangle(8, -2, 5, 5);
        assertTrue(center.intersect(r16));
        
        Rectangle r17 = new Rectangle(8, 8, 5, 5);
        assertTrue(center.intersect(r17));
        
        Rectangle r18 = new Rectangle(-2, 8, 5, 5);
        assertTrue(center.intersect(r18));
        
        Rectangle r19 = new Rectangle(5, 0, 10, 0);
        Rectangle r20 = new Rectangle(20, 0, 0, 0);
        assertFalse(r20.intersect(r19));
        assertFalse(r19.intersect(r20));
        
        assertTrue(r2.intersect(r5));
        assertTrue(r2.intersect(r2)); 
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
        
        Rectangle r6 = new Rectangle(0, 1, 1, 1);
        assertFalse(r1.equals(r6));
        Rectangle r7 = new Rectangle(0, 0, 1, 1);
        assertFalse(r1.equals(r7));
        Rectangle r8 = new Rectangle(0, 0, 0, 1);
        assertFalse(r1.equals(r8));
        Rectangle r9 = new Rectangle(1, 0, 0, 0);
        assertFalse(r1.equals(r9));
        Rectangle r10 = new Rectangle(0, 1, 0, 0); 
        assertFalse(r1.equals(r10));
        Rectangle r11 = new Rectangle(0, 0, 1, 0); 
        assertFalse(r1.equals(r11));
        
    }
    
    public void testToString() {
        assertEquals(r1.toString(), "X coordinate: 0, Y coordinate: 0, Width: 0, Height: 0");
        assertEquals(r2.toString(), "X coordinate: 1, Y coordinate: 1, Width: 5, Height: 10");
        assertEquals(r3.toString(), "X coordinate: -1, Y coordinate: -5, Width: 15, Height: 20");
    }
    
    public void testIsInvalid() {
        assertTrue(r1.isInvalid());
        Rectangle r6 = new Rectangle(1, 1, -5, 10);
        Rectangle r7 = new Rectangle(1, 1, 10, 0);
        assertTrue(r6.isInvalid());
        assertTrue(r7.isInvalid());
        Rectangle r8 = new Rectangle(1, -5, 10, 10);
        Rectangle r9 = new Rectangle(-5, 10, 10, 10);
        assertTrue(r8.isInvalid());
        assertTrue(r3.isInvalid());
        assertTrue(r9.isInvalid());
        
        assertFalse(r2.isInvalid());
    }
}
