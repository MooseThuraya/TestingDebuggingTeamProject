import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: Alicia Garcia, Mustafa Abuthuraya, Sanchita Jain
 * Version: 1.0
 * Date: 4/20/2022 12:30
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 * *********************  READ ME!   **************************************
 * THE TESTS BELOW ARE PLACEHOLDER AND SHOULD BE USED AS A GUIDE TO IMPLEMENT
 * YOUR TESTS AND DETERMINING WHAT TO TEST. PLEASE BE SURE TO CLAIM YOUR SECTION
 * OF CODE YOU'RE TESTING AND PUSH YOUR CHANGES IMMEDIATELY AND NOTIFY THE TEAM
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 */

class UtilTest {

    /**
     * OWNER: Sanchita
     */
    @Test
    void toInt() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: Sanchita - no point in testing since we have verified this in other tests
     */
    @Test
    void println() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: Sanchita
     */
    @Test
    void inputStr() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: Sanchita
     */
    @Test
    void inputCoords() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: Sanchita
     */
    @Test
    void inputFloat() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void leftStr_returns_first_three_letters_of_input_string() {
        // ARRANGE
        Util util = new Util();

        String str = "test";
        String expectedStr = "tes";
        int len = 3;

        // ACT
        String result = util.leftStr(str, len);

        // ASSERT
        assertEquals(expectedStr, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void leftStr_returns_null_when_input_is_null() {
        // ARRANGE
        Util util = new Util();
        int len = 3;

        // ACT
        String result = util.leftStr(null, len);

        // ASSERT
        assertNull(result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void leftStr_returns_input_when_input_is_less_than_three_char() {
        // ARRANGE
        Util util = new Util();
        String str = "Hi";
        int len = 3;

        // ACT
        String result = util.leftStr(str, len);

        // ASSERT
        assertEquals(str, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_input_length_less_than_startMinusOne_plusLen_returns_input_string() {
        // ARRANGE
        Util util = new Util();

        String str = "";
        int start = 1;
        int len = 3;

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void rightStr() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void random() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void fnr() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void tab() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void strlen() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void round() {
        // ARRANGE

        // ACT

        // ASSERT
    }
}
