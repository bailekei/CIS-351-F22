import org.junit.*;

import static edu.gvsu.mipsunit.munit.MUnit.Register.*;
import static edu.gvsu.mipsunit.munit.MUnit.*;

public class BranchTest {


    /******************************************************************
     *
     * Test makes10
     *
     *****************************************************************/

    @Test
    public void makes10_aIs9_bIs10() {
        run("makes10", 9, 10);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs9_bIs9() {
        run("makes10", 9, 9);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void makes10_aIs1_bIs9() {
        run("makes10", 1, 9);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs10_bIs1() {
        run("makes10", 10, 1);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs10_bI10() {
        run("makes10", 10, 10);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs8_bI2() {
        run("makes10", 8, 2);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs8_bI3() {
        run("makes10", 8, 3);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void makes10_aIs10_bI42() {
        run("makes10", 10, 42);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void makes10_aIs12_bIsNeg2() {
        run("makes10", 12, -2);
        Assert.assertEquals(1, get(v0));
    }


    /******************************************************************
     *
     * Test intMax
     *
     *****************************************************************/

    @Test
    public void intMax_123() {
        run("intMax", 1, 2, 3);
        Assert.assertEquals(3, get(v0));
    }
    @Test
    public void intMax_132() {
        run("intMax", 1, 3, 2);
        Assert.assertEquals(3, get(v0));
    }
    @Test
    public void intMax_321() {
        run("intMax", 3, 2, 1);
        Assert.assertEquals(3, get(v0));
    }
    @Test
    public void intMax_933() {
        run("intMax", 9, 3, 3);
        Assert.assertEquals(9, get(v0));
    }
    @Test
    public void intMax_393() {
        run("intMax", 3, 9, 3);
        Assert.assertEquals(9, get(v0));
    }
    @Test
    public void intMax_339() {
        run("intMax", 3, 3, 9);
        Assert.assertEquals(9, get(v0));
    }
    @Test
    public void intMax_823() {
        run("intMax", 8, 2, 3);
        Assert.assertEquals(8, get(v0));
    }
    @Test
    public void intMax_neg3neg1neg2() {
        run("intMax", -3, -1, -2);
        Assert.assertEquals(-1, get(v0));
    }
    @Test
    public void intMax_625() {
        run("intMax", 6, 2, 5);
        Assert.assertEquals(6, get(v0));
    }
    @Test
    public void intMax_562() {
        run("intMax", 5, 6, 2);
        Assert.assertEquals(6, get(v0));
    }
    @Test
    public void intMax_526() {
        run("intMax", 5, 2, 6);
        Assert.assertEquals(6, get(v0));
    }


    /******************************************************************
     *
     * Test close10
     *
     *****************************************************************/

    @Test
    public void close10_a8b13() {
        run("close10", 8, 13);
        Assert.assertEquals(8, get(v0));
    }
    @Test
    public void close10_a13b8() {
        run("close10", 13, 8);
        Assert.assertEquals(8, get(v0));
    }
    @Test
    public void close10_a13b7() {
        run("close10", 13, 7);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void close10_a7b13() {
        run("close10", 7, 13);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void close10_a9b13() {
        run("close10", 9, 13);
        Assert.assertEquals(9, get(v0));
    }
    @Test
    public void close10_a10b12() {
        run("close10", 10, 12);
        Assert.assertEquals(10, get(v0));
    }
    @Test
    public void close10_a11b10() {
        run("close10", 11, 10);
        Assert.assertEquals(10, get(v0));
    }
    @Test
    public void close10_a5b21() {
        run("close10", 5, 21);
        Assert.assertEquals(5, get(v0));
    }
    @Test
    public void close10_a0b20() {
        run("close10", 0, 20);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void close10_aClosest() {
        run("close10", 10, 10);
        Assert.assertEquals(0, get(v0));
    }


    /******************************************************************
     *
     * Test dateFashion
     *
     *****************************************************************/

    @Test
    public void dateFashion_you5_date10() {
        run("dateFashion", 5, 10);
        Assert.assertEquals(2, get(v0));
    }
    @Test
    public void dateFashion_you5_date2() {
        run("dateFashion", 5, 2);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void dateFashion_you5_date5() {
        run("dateFashion", 5, 5);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void dateFashion_you3_date3() {
        run("dateFashion", 3, 3);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void dateFashion_you10_date2() {
        run("dateFashion", 10, 2);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void dateFashion_you2_date9() {
        run("dateFashion", 2, 9);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void dateFashion_you9_date9() {
        run("dateFashion", 9, 9);
        Assert.assertEquals(2, get(v0));
    }
    @Test
    public void dateFashion_you10_date5() {
        run("dateFashion", 10, 5);
        Assert.assertEquals(2, get(v0));
    }
    @Test
    public void dateFashion_you2_date2() {
        run("dateFashion", 2, 2);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void dateFashion_you3_date7() {
        run("dateFashion", 3, 7);
        Assert.assertEquals(1, get(v0));
    }
    @Test
    public void dateFashion_you2_date7() {
        run("dateFashion", 2, 7);
        Assert.assertEquals(0, get(v0));
    }
    @Test
    public void dateFashion_you6_date2() {
        run("dateFashion", 6, 2);
        Assert.assertEquals(0, get(v0));
    }



} // end class
