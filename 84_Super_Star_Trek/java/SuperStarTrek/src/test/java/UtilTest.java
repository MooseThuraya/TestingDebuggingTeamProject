import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;


import java.math.BigDecimal;
import java.util.Random;

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
    Random rand;

    @BeforeEach
    public void utilSetUp() {
        this.rand = mock(Random.class, withSettings().withoutAnnotations());
    }

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
     * <p>
     * This tests for all conditions where the input string is returned
     * Conditions:
     * 1. empty string,
     * 2. input.length() < len,
     * 3. len < 0,
     * 4. null string
     * 5. Substring is first 3 chars of input str
     *
     *
     * @param input - input string
     * @param len   - lenght of substring returned
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/util_leftStr_Tests.csv", numLinesToSkip = 1)
    void leftStr_parameterized_test(String input, int len, String expectedResult) {
        // ARRANGE
        Util util = new Util(rand);

        // ACT
        String result = util.leftStr(input, len);

        // ASSERT
        assertEquals(expectedResult, result);
    }


    /**
     * OWNER: ALICIA
     */
    @Test
    void midStr_input_length_less_than_startMinusOne_plusLen_returns_input_string() {
        // ARRANGE
        Util util = new Util(rand);

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
        Util util = new Util(rand);

        int start = 5;
        int len = 3;

        // ACT
        String result = util.midStr(input, start, len);

        // ASSERT
        assertNull(result);
    }

    /**
     * OWNER: ALICIA
     *
     * @param input - input string
     */
    @ParameterizedTest
    @EmptySource
    void midStr_input_empty_returns_empty_string(String input) {
        // ARRANGE
        Util util = new Util(rand);

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
        Util util = new Util(rand);

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
        Util util = new Util(rand);

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
        Util util = new Util(rand);

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
     * <p>
     * Tests when [start] or [len] is negative, input string is returned
     * Conditions: start < 0,
     *             len < 0
     *
     * @param input - input string
     * @param start - start point value
     * @param len   - length of substring value
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/util_midStr_Tests.csv", numLinesToSkip = 1)
    void midStr_returns_input_string(String input, int start, int len, String expectedResult) {
        // ARRANGE
        Util util = new Util(rand);

        // ACT
        String result = util.midStr(input, start, len);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     * Tests all conditions that return an empty string
     * <p>
     * Conditions: Null input,
     *             input.length() < len,
     *             Empty input,
     *             len = 0,
     *             len > input.length(),
     *             len < 0
     *
     * @param input - input string
     * @param len   - substring length
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/util_rightStr_Tests.csv", numLinesToSkip = 1)
    void rightStr_returns_empty_space_with_input_length_less_than_len(String input, int len, String expectedResult) {
        // ARRANGE
        Util util = new Util(rand);

        // ACT
        String result = util.rightStr(input, len);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void rightStr_returns_last_5_chars_when_len_equals_5() {
        // ARRANGE
        Util util = new Util(rand);

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
        Util util = new Util(rand);
        float expectedValue = 0.123f;

        when(rand.nextFloat()).thenReturn(expectedValue);

        // ACT
        float result = util.random();

        // ASSERT
        assertEquals(expectedValue, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void fnr_returns_integer_value_between_1_and_8() {
        // ARRANGE
        Util util = new Util(rand);
        float randomValue = 0.251f;
        int expectedResult = 2;
        when((rand.nextFloat())).thenReturn(randomValue);

        // ACT
        int result = util.fnr();

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void strlen_return_6_for_string_with_6_letters() {
        // ARRANGE
        Util util = new Util(rand);

        String str = "System";
        int expectedResult = 6;

        // ACT
        int result = util.strLen(str);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     * <p>
     * Tests all conditions for invalid string to return a zero value
     * Conditions: NULL input,
     * Empty string input
     *
     * @param input
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/util_strlen_Tests.csv", numLinesToSkip = 1)
    void strLen_returns_zero(String input) {
        // ARRANGE
        Util util = new Util(rand);

        // ACT
        int result = util.strLen(input);

        // ASSERT
        assertEquals(0, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void tab_returns_n_minus_one_spaces() {
        // ARRANGE
        Util util = new Util(rand);

        int n = 6;
        String expectedResult = "     ";

        // ACT
        String result = util.tab(n);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     * <p>
     * Tests values of n less than or equal to 0, and 1.
     * Conditions: n =0,
     * n = 1,
     * n = -1,
     * n = 100
     *
     * @param n - value of spaces
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/util_Tab_Tests.csv", numLinesToSkip = 1)
    void tab_returns_no_spaces(int n) {
        // ARRANGE
        Util util = new Util(rand);

        String expectedResult = "";

        // ACT
        String result = util.tab(n);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void round_throws_illegalArgumentException_message_null_when_places_lessThan_0() {
        // ARRANGE
        Util util = new Util(rand);

        double value = 20.0;
        int places = -12;

        // ACT
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            util.round(value, places);
        });

        // ASSERT
        assertNull(exception.getMessage());
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void round_returns_double_value_rounded_up_to_6_decimal_places() {
        // ARRANGE
        Util util = new Util(rand);

        double value = 20.66325854;
        int places = 6;
        double expectedResult = 20.663259;

        // ACT
        double result = util.round(value, places);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void round_returns_value_rounded_up_when_places_is_zero() {
        // ARRANGE
        Util util = new Util(rand);

        double value = 20.6;
        int places = 0;
        double expectedResult = 21;

        // ACT
        double result = util.round(value, places);

        // ASSERT
        assertEquals(expectedResult, result);
    }
}
