import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;
import static edu.gvsu.dlunit.DLUnit.readPin;

/**
 * Sample test cases for 16-bit set less than circuit
 * <p/>
 * IMPORTANT: These test cases do *not* thoroughly test the circuit. You need to
 * re-name this class and add more tests!
 * <p/>
 * Created by kurmasz on 8/8/16.
 */
public class SampleSlt16BitTest {

    public static final long testIntegers[] = { -32768, -32767, 0, 1, 2, 13, 127, 128, 129, 0x5555, 32766, 32767 };

    public static final long testPosIntegers[] = { 0, 1, 2, 13, 127, 128, 129, 0x5555, 32766, 32767, 65534, 65535 };

    public void verify(long a, long b, boolean signed) {

        if (signed) {
            setPinSigned("InputA", a);
            setPinSigned("InputB", b);
        } else {
            setPinUnsigned("InputA", a);
            setPinUnsigned("InputB", b);
        }

        setPin("Signed", signed);
        run();

        ////////////////////////////////////////
        //
        // Check the correctness of the output
        //
        ///////////////////////////////////////
        String message = String.format("%d < %d (%s): ", a, b, signed ? "signed" : "unsigned");
        Assert.assertEquals("Output " + message, a < b, readPin("LessThan"));
    }

    @Test
    public void zero_zero_signed() {
        verify(0, 0, true);
    }

    @Test
    public void zero_one_signed() {
        verify(0, 1, true);
    }

    @Test
    public void one_zero_signed() {
        verify(1, 0, true);
    }

    @Test
    public void zero_negone_signed() {
        verify(0, -1, true);
    }

    @Test
    public void negone_zero_signed() {
        verify(-1, 0, true);
    }

    @Test
    public void one_negone_signed() {
        verify(1, -1, true);
    }

    @Test
    public void negone_one_signed() {
        verify(-1, 1, true);
    }

    @Test
    public void zero_zero_unsigned() {
        verify(0, 0, false);
    }

    @Test
    public void zero_one_unsigned() {
        verify(0, 1, false);
    }

    @Test
    public void one_zero_unsigned() {
        verify(1, 0, false);
    }

    @Test
    public void testAll_signed() {
        for (long a : testIntegers) {
            for (long b : testIntegers) {
                verify(a, b, true);
            }
        }
    }

    @Test
    public void testAll_unsigned() {
        for (long a : testPosIntegers) {
            for (long b : testPosIntegers) {
                verify(a, b, false);
            }
        }
    }
}