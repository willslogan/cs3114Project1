import java.util.Iterator;
import java.util.ArrayList;

/**
 * This class is responsible for interfacing between the command processor and
 * the SkipList. The responsibility of this class is to further interpret
 * variations of commands and do some error checking of those commands. This
 * class further interpreting the command means that the two types of remove
 * will be overloaded methods for if we are removing by name or by coordinates.
 * Many of these methods will simply call the appropriate version of the
 * SkipList method after some preparation.
 * 
 * Also note that the Database class will have a clearer role in Project2,
 * where we will have two data structures. The Database class will then
 * determine
 * which command should be directed to which data structure.
 * 
 * @author CS Staff
 * 
 * @version 2021-08-23
 */
public class Database {

    // this is the SkipList object that we are using
    // a string for the name of the rectangle and then
    // a rectangle object, these are stored in a KVPair,
    // see the KVPair class for more information
    private SkipList<String, Rectangle> list;

    // This is an Iterator object over the SkipList to loop through it from
    // outside the class.
    // You will need to define an extra Iterator for the intersections method.
    private Iterator<KVPair<String, Rectangle>> itr1;

    /**
     * The constructor for this class initializes a SkipList object with String
     * and Rectangle a its parameters.
     */
    public Database() {
        list = new SkipList<String, Rectangle>();
    }


    /**
     * Inserts the KVPair in the SkipList if the rectangle has valid coordinates
     * and dimensions, that is that the coordinates are non-negative and that
     * the rectangle object has some area (not 0, 0, 0, 0). This insert will
     * add the KVPair specified into the sorted SkipList appropriately
     * 
     * @param pair
     *            the KVPair to be inserted
     */
    public void insert(KVPair<String, Rectangle> pair) {
        // Delegates the decision mostly to SkipList, only
        // writing the correct message to the console from
        // that
        Rectangle currentRec = pair.getValue();
        if (currentRec.isInvalid()) {
            System.out.println("Rectangle rejected: (" + pair.getKey() + " "
                + currentRec.toString() + ")");
        }

        else {
            list.insert(pair);
            System.out.println("Rectangle inserted: (" + pair.getKey() + " "
                + currentRec.toString() + ")");
        }

    }


    /**
     * Removes a rectangle with the name "name" if available. If not an error
     * message is printed to the console.
     * 
     * @param name
     *            the name of the rectangle to be removed
     */
    public void remove(String name) {
        // Making temp variable to make life easier
        Rectangle currentRec = list.remove(name).getValue();

        // Rectangle was found and successfully removed from the list
        if (list.remove(name) != null) {
            System.out.println("Rectangle removed: (" + name + " " + currentRec
                .toString() + ")");
        }

        // Rectangle with specified rectangle doesn't exist within the list
        else {
            System.out.println("Rectangle not removed: " + name);
        }

    }


    /**
     * Removes a rectangle with the specified coordinates if available. If not
     * an error message is printed to the console.
     * 
     * @param x
     *            x-coordinate of the rectangle to be removed
     * @param y
     *            x-coordinate of the rectangle to be removed
     * @param w
     *            width of the rectangle to be removed
     * @param h
     *            height of the rectangle to be removed
     */
    public void remove(int x, int y, int w, int h) {
        Rectangle tempRec = new Rectangle(x, y, w, h);
        // Case where dimensions given are invalid
        if (tempRec.isInvalid()) {
            System.out.println("Rectangle rejected: (" + tempRec.toString()
                + ")");
            return;
        }

        // Making temp variables to make life easier
        KVPair<String, Rectangle> tempKVPair = list.removeByValue(tempRec);
        Rectangle currentRec = tempKVPair.getValue();

        // Case where Rectangle is found
        if (currentRec != null) {
            System.out.println("Rectangle removed: (" + tempKVPair.getKey()
                + " " + currentRec.toString() + ")");
        }

        // Case where rectangle is not found
        else {
            System.out.println("Rectangle not found: (" + tempRec.toString()
                + ")");
        }
    }


    /**
     * Displays all the rectangles inside the specified region. The rectangle
     * must have some area inside the area that is created by the region,
     * meaning, Rectangles that only touch a side or corner of the region
     * specified will not be said to be in the region.
     * 
     * @param x
     *            x-Coordinate of the region
     * @param y
     *            y-Coordinate of the region
     * @param w
     *            width of the region
     * @param h
     *            height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {
        // Create rectangle with the values of the region search
        Rectangle tempRec = new Rectangle(x, y, w, h);
        // Check skiplist for intersections with region and display them
        if (!tempRec.isInvalid()) // Check if the rectangle region is valid
        {
            // Output expecterd header
            System.out.println("Rectangles intersecting region (" + x + ", " + y
                + ", " + w + ", " + h + "):");
            Iterator<KVPair<String, Rectangle>> it = list.iterator();
            while (it.hasNext()) { // Iterate through entire skiplist
                if (it.next().getValue().intersect(tempRec)) {
                    // If the current element intersects the region print it out
                    System.out.println(it.next().toString());
                }
            }
        }
        else {
            // Print out reject statment
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
    }


    /**
     * Prints out all the rectangles that intersect each other. Note that
     * it is better not to implement an intersections method in the SkipList
     * class
     * as the SkipList needs to be agnostic about the fact that it is storing
     * Rectangles.
     */
    public void intersections() {
        // Print header
        System.out.println("Intersection pairs: ");

        // Create outer iterator for looping
        Iterator<KVPair<String, Rectangle>> outer = list.iterator();
        while (outer.hasNext()) {
            // Create inner iterator for comparing, set it to outer so we don't
            // have to check the entire list every time and can skip pairs we
            // already
            // know intersect
            Iterator<KVPair<String, Rectangle>> inner = outer;
            // Set the inner iterator equal to the one after so we don't compare
            // the same item
            if (inner.hasNext()) {
                inner.next();
            }
            while (inner.hasNext()) {
                if (outer.next().getValue().intersect(inner.next()
                    .getValue())) {
                    // If the outer and inner intersect print out the
                    // intersection
                    System.out.println(outer.next().toString() + " | " + inner
                        .next().toString());
                }
            }
        }
    }


    /**
     * Prints out all the rectangles with the specified name in the SkipList.
     * This method will delegate the searching to the SkipList class completely.
     * 
     * @param name
     *            name of the Rectangle to be searched for
     */
    public void search(String name) {
        ArrayList<KVPair<String, Rectangle>> results = list.search(name);
        // List is empty case
        if (results == null) {
            System.out.println("Rectangle not found: (" + name + ")");
        }
        // List has items in it
        else {
            System.out.println("Rectangles Found:");
            for (int i = 0; i < results.size(); i++) {
                // temp variable so it less writing
                Rectangle currentRec = results.get(i).getValue();
                System.out.println("(" + name + " " + currentRec.toString()
                    + ")");
            }
        }
    }


    /**
     * Prints out a dump of the SkipList which includes information about the
     * size of the SkipList and shows all of the contents of the SkipList. This
     * will all be delegated to the SkipList.
     */
    public void dump() {
        System.out.println("SkipList dump:");
        list.dump();
    }

}
