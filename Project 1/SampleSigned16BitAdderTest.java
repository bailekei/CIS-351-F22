import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Sample test cases for an signed, 16-bit adder with a carry-in and overflow.
 * IMPORTANT: These test cases do *not* thoroughly test the adder. You need to
 * re-name this class and add more tests!
 */
public class SampleSigned16BitAdderTest {

    // The complete list of integers to be tests.
    // (IMPORTANT !!! You need to add to this list !!!)
    public static final long testIntegers[] = { -32768, -32767, -32766, -32765, -32764, -32763, -32762, -32761, -32760,
            -32759, -32758, -32757, -32756, -32755, -32754, -32753, -32752, -32751,
            -32750, -32749, -32748, -32747,
            -32746, -32745, -32744, -32743, -32742, -32741, -32740, -32739, -32738,
            -32737, -32736, -32735, -32734,
            -32733, -32732, -32731, -32730, -32729, -32728, -32727, -32726, -32725,
            -32724, -32723, -32722, -32721,
            -32720, -32719, -32718, -32717, -32716, -32715, -32714, -32713, -32712,
            -32711, -32710, -32709, -32708,
            -32707, -32706, -32705, -32704, -32703, -32702, -32701, -32700, -32699,
            -32698, -32697, -32696, -32695,
            -32694, -32693, -32692, -32691, -32690, -32689, -32688, -32687, -32686,
            -32685, -32684, -32683, -32682,
            -32681, -32680, -32679, -32678, -32677, -32676, -32675, -32674, -32673,
            -32672, -32671, -32670, -32669,
            -100, -99, -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86,
            -85, -84, -83, -82, -81, -80,
            -79, -78, -77, -76, -75, -74, -73, -72, -71, -70, -69, -68, -67, -66, -65,
            -64, -63, -62, -61, -60, -59,
            -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44,
            -43, -42, -41, -40, -39, -38,
            -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23,
            -22, -21, -20, -19, -18, -17,
            -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1,
            2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38,
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
            58, 59, 60, 61, 62, 63, 64, 65,
            66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 91, 92,
            93, 94, 95, 96, 97, 98, 99, 100, 32667, 32668, 32669, 32670, 32671, 32672,
            32673, 32674, 32675, 32676,
            32677, 32678, 32679, 32680, 32681, 32682, 32683, 32684, 32685, 32686, 32687,
            32688, 32689, 32690, 32691, 32692, 32693, 32694, 32695, 32696, 32697, 32698, 32699, 32700, 32701, 32702,
            32703, 32704, 32705, 32706, 32707, 32708, 32709, 32710, 32711, 32712, 32713, 32714, 32715, 32716, 32717,
            32718, 32719, 32720, 32721, 32722, 32723, 32724, 32725, 32726, 32727, 32728, 32729, 32730, 32731, 32732,
            32733, 32734, 32735, 32736, 32737, 32738, 32739, 32740, 32741, 32742, 32743, 32744, 32745, 32746, 32747,
            32748, 32749, 32750, 32751, 32752, 32753, 32754, 32755, 32756, 32757, 32758, 32759, 32760, 32761, 32762,
            32763, 32764, 32765, 32766, 32767 };

    // Helper method that runs a test for a given pair of integers and a carryIn.
    protected static void verify(long a, long b, boolean carryIn) {

        //////////////////////////////////
        //
        // Compute the expected outputs
        //
        /////////////////////////////////
        long carryInAsInt = (carryIn ? 1 : 0); // convert the Boolean to 0 or 1
        long expected = a + b + carryInAsInt; // expected output value

        // The `overflow` output should be `true` if the expected output is not in the
        // range [-(2^15), (2^15)-1]
        // (In java "1 << 15" takes the bit string 0000000000000001 and shifts it left
        // 15 spaces, effectively
        // generating the value 2^15.)
        boolean expectedOverflow = ((expected >= (1 << 15)) || (expected < -(1 << 15)));

        // Output "wraps around" if there is an overflow
        if (expectedOverflow && expected > 0) {
            expected -= 65536;
        } else if (expectedOverflow && expected < 0) {
            expected += 65536;
        }

        ////////////////////////////////////////
        //
        // Configure and simulate the circuit
        //
        ///////////////////////////////////////
        setPinSigned("InputA", a);
        setPinSigned("InputB", b);
        setPin("CarryIn", carryIn);
        run();

        ////////////////////////////////////////
        //
        // Check the correctness of the output
        //
        ///////////////////////////////////////
        String message = "of " + a + " + " + b + " with " + (carryIn ? "a " : " no ") + " carry in";
        Assert.assertEquals("Output " + message, expected, readPinSigned("Output"));
        Assert.assertEquals("Overflow " + message, expectedOverflow, readPin("Overflow"));
    }

    //
    // Quick tests designed to quickly catch major errors. (Also serve as example
    // tests)
    //

    @Test
    public void zero_zero_false() {
        verify(0, 0, false);
    }

    @Test
    public void zero_one_false() {
        verify(0, 1, false);
    }

    @Test
    public void zero_zero_true() {
        verify(0, 0, true);
    }

    @Test
    public void zero_one_true() {
        verify(0, 1, true);
    }

    // This is actually rather gross; but, it is an effective way to thoroughly test
    // your adder without
    // having to write hundreds of individual methods.
    @Test
    public void testAll() {
        for (long a : testIntegers) {
            for (long b : testIntegers) {
                verify(a, b, false);
                verify(a, b, true);
            }
        }
    } // end testAll
}