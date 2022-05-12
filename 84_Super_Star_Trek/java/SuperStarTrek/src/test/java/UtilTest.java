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
     * OWNER: Sanchita
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
    void print_verified_prints_expected_string() {
        // ARRANGE
        Util util = new Util();
        String str = "this is a test";

        // ACT
        util.print(str);

        // ASSERT
        verify(util).print(str);
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
    void midStr() {
        // ARRANGE

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
