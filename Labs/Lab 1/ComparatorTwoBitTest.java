import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Sample test cases for an unsigned, 2-bit comparator.
 *
 * IMPORTANT:  These test cases do *not* thoroughly test the comparator.
 * You need to rename this class and add more tests!
 *
 * Written by Nathan Bowman, 1/20/2021
 */
public class ComparatorTwoBitTest {

    /* Note: it is generally considered bad form to put several tests into a
     * single method. However, for purposes of this assignment, I suggest
     * you do not bother making 16 different methods and instead find a simpler
     * way.
     *
     * You can feel free to remove the existing tests as well.
     */

    @Test
    public void zero_zero() {
        setPinUnsigned("InputA", 0);
        setPinUnsigned("InputB", 0);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }

    @Test
    public void zero_one() {
        setPinUnsigned("InputA", 0);
        setPinUnsigned("InputB", 1);
        run();
        Assert.assertEquals(1, readPinUnsigned("Output"));
    }

    @Test
    public void zero_two() {
        setPinUnsigned("InputA", 0);
        setPinUnsigned("InputB", 2);
        run();
        Assert.assertEquals(1, readPinUnsigned("Output"));
    }
    @Test
    public void zero_three() {
        setPinUnsigned("InputA", 0);
        setPinUnsigned("InputB", 3);
        run();
        Assert.assertEquals(1, readPinUnsigned("Output"));
    }
    @Test
    public  void one_zero(){
        setPinUnsigned("InputA", 1);
        setPinUnsigned("InputB", 0);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }
    @Test
    public  void one_one(){
        setPinUnsigned("InputA", 1);
        setPinUnsigned("InputB", 1);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }
    @Test
    public  void one_two(){
        setPinUnsigned("InputA", 1);
        setPinUnsigned("InputB", 2);
        run();
        Assert.assertEquals(1, readPinUnsigned("Output"));
    }
    @Test
    public  void one_three(){
        setPinUnsigned("InputA", 1);
        setPinUnsigned("InputB", 3);
        run();
        Assert.assertEquals(1, readPinUnsigned("Output"));
    }
    @Test
    public  void three_zero(){
        setPinUnsigned("InputA", 3);
        setPinUnsigned("InputB", 0);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }
    @Test
    public  void three_one(){
        setPinUnsigned("InputA", 3);
        setPinUnsigned("InputB", 1);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }
    @Test
    public  void three_two(){
        setPinUnsigned("InputA", 3);
        setPinUnsigned("InputB", 2);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }
    @Test
    public  void three_three(){
        setPinUnsigned("InputA", 3);
        setPinUnsigned("InputB", 3);
        run();
        Assert.assertEquals(0, readPinUnsigned("Output"));
    }

}