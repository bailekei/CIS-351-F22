import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

public class LoopsTest {


    /******************************************************************
     *
     * Test max
     *
     ******************************************************************/

    Label array1 = wordData(5, 4, 7, 6, 9, 8, 2, 1, -1);

    @Test
    public void max_findsMaximum() {
        run("max", array1, 9);
        Assert.assertEquals(9, get(v0));
    }

    // Write **a lot** more tests.


    /******************************************************************
     *
     * Test sum13
     *
     ******************************************************************/

    Label sum13_array1 = wordData(1, 2, 2, 1);
    Label sum13_array2 = wordData(1, 2, 13, 2, 1, 13);

    @Test
    public void sum13_sumsAllIfNo13() {
        run("sum13", sum13_array1, 4);
        Assert.assertEquals(6, get(v0));
    }

    @Test
    public void sum13_ignore13_andFollowing() {
        run("sum13", sum13_array2, 6);
        Assert.assertEquals(4, get(v0));
    }

    // Write **a lot** more tests.

}