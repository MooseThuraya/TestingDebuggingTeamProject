import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;


import static org.junit.jupiter.api.Assertions.*;

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
     *
     * @param input - input string
     */
    @ParameterizedTest
    @NullSource
    void leftStr_returns_null_when_input_is_null(String input) {
        // ARRANGE
        Util util = new Util();

        int len = 3;

        // ACT
        String result = util.leftStr(input, len);

        // ASSERT
        assertNull(result);
    }

    /**
     * OWNER: ALICIA
     *
     * This tests for all conditions where the input string is returned
     * Conditions: empty string,
     *             input.length() < len,
     *             len < 0
     * @param input - input string
     * @param len - lenght of substring returned
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/leftStr_Tests.csv", numLinesToSkip = 1)
    void leftStr_returns_input_string(String input, int len) {
        // ARRANGE
        Util util = new Util();

        // ACT
        String result = util.leftStr(input, len);

        // ASSERT
        assertEquals(input, result);
    }


    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_input_length_less_than_startMinusOne_plusLen_returns_input_string() {
        // ARRANGE
        Util util = new Util();

        String str = "Hi";
        int start = 1;
        int len = 3;

        // ACT
        String result = util.midStr(str, start, len);

        // ASSERT
        assertEquals(str, result);
    }

    /**
     * OWNER: ALICIA
     *
     * @param input - input string
     */
    @ParameterizedTest
    @NullSource
    void midStr_input_null_returns_null(String input) {
        // ARRANGE
        Util util = new Util();

        int start = 5;
        int len = 3;

        // ACT
        String result = util.midStr(input, start, len);

        // ASSERT
        assertNull(result);
    }

    /**
     * OWNER: ALICIA
     * @param input - input string
     */
    @ParameterizedTest
    @EmptySource
    void midStr_input_empty_returns_empty_string(String input) {
        // ARRANGE
        Util util = new Util();

        int start = 5;
        int len = 3;

        // ACT
        String result = util.midStr(input, start, len);

        // ASSERT
        assertEquals(input, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_returns_substring_of_input_string_based_on_start_at_5() {
        // ARRANGE
        Util util = new Util();

        String str = "Whathappened?";
        String expectedStr = "hap";
        int start = 5;
        int len = 3;

        // ACT
        String result = util.midStr(str, start, len);

        // ASSERT
        assertEquals(expectedStr, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_returns_substring_with_spaces_of_input_string_based_on_start_at_8() {
        // ARRANGE
        Util util = new Util();

        String str = "This is not a test";
        String expectedStr = " no";
        int start = 8;
        int len = 3;

        // ACT
        String result = util.midStr(str, start, len);

        // ASSERT
        assertEquals(expectedStr, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_returns_substring_including_special_chars_of_input_string_based_on_start_at_6() {
        // ARRANGE
        Util util = new Util();

        String str = "Hie#'@!?*$)";
        String expectedStr = "@!?";
        int start = 6;
        int len = 3;

        // ACT
        String result = util.midStr(str, start, len);

        // ASSERT
        assertEquals(expectedStr, result);
    }

    /**
     * OWNER: ALICIA
     *
     * Tests when [start] or [len] is negative, input string is returned
     * Conditions: start < 0,
     *             len < 0
     *
     * @param input - input string
     * @param start - start point value
     * @param len - length of substring value
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/midStr_Tests.csv", numLinesToSkip = 1)
    void midStr_returns_input_string(String input, int start, int len) {
        // ARRANGE
        Util util = new Util();

        // ACT
        String result = util.midStr(input, start, len);

        // ASSERT
        assertEquals(input, result);
    }


    /**
     * OWNER: ALICIA
     * Tests all conditions that return an empty string
     *
     * Conditions: Null input,
     *             input.length() < len,
     *             Empty input,
     *             len = 0,
     *             len > input.length(),
     *             len < 0
     *
     * @param input - input string
     * @param len - substring length
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/rightStr_Tests.csv", numLinesToSkip = 1)
    void rightStr_returns_empty_space_with_input_length_less_than_len(String input, int len) {
        // ARRANGE
        Util util = new Util();

        String expectedStr = "";

        // ACT
        String result = util.rightStr(input, len);

        // ASSERT
        assertEquals(expectedStr, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void rightStr_returns_last_5_chars_when_len_equals_5() {
        // ARRANGE
        Util util = new Util();

        String str = "This for testers";
        String expectedStr = "sters";
        int len = 5;

        // ACT
        String result = util.rightStr(str, len);

        // ASSERT
        assertEquals(expectedStr, result);
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
     * OWNER: ALICIA
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
