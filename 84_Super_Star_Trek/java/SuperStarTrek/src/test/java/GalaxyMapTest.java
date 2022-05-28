import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Author: Alicia Garcia, Mustafa Abuthuraya, Sanchita Jain
 * Version: 1.0
 * Date: 4/20/2022 12:28
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 * ****************************** READ ME! ******************************
 * THE TESTS BELOW ARE PLACEHOLDERS AND SHOULD BE USED AS A GUIDE TO IMPLEMENT
 * YOUR TESTS AND DETERMINING WHAT TO TEST. PLEASE BE SURE TO CLAIM YOUR SECTION
 * OF CODE YOU'RE TESTING AND PUSH YOUR CHANGES IMMEDIATELY AND NOTIFY THE TEAM
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 */

class GalaxyMapTest {
    Util util;
    Enterprise enterprise;

    @BeforeEach
    void galaxyMapSetUp() {
        this.util = mock(Util.class);
        this.enterprise = mock(Enterprise.class);

        //Must mock before initializing GalaxyMap for line 52
        int[] quadrantArr = new int[]{0, 0};
        when(enterprise.getQuadrant()).thenReturn(quadrantArr);

        int[] sectorArr = new int[]{0, 0};
        when(enterprise.getSector()).thenReturn(sectorArr);

    }

    /**
     * OWNER: ALICIA - need to rework since the coordinates and klingon
     * locations are arrays filled with 0's
     */
    @Test
    void fnd_returns_zero_when_game_not_played() {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);

        int i = 2;
        double expectedResult = 0;

        // ACT
        double result = map.fnd(i);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     * Test all boundaries for invalid quadrant values
     * <p>
     * Condition:
     * 1. X = 0, -3, -100, 9, 15, 100
     * 2. Y = -5, 0, -100, 9, 15, 100
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/galaxyMap_newQuadrant_invalidCoords.csv", numLinesToSkip = 1)
    void newQuadrant_throwsException_withInvalid_quadrantCoordinates(int X, int Y, String expectedMessage) {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);
        double initialStardate = 0.1 * 20 + 20;
        double stardate = 0.3 * 20 + 20;
        // quadrant we want to
        int[] quadrantXY = new int[]{X, Y};

        when(enterprise.getQuadrant()).thenReturn(quadrantXY);

        // ACT
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            map.newQuadrant(stardate, initialStardate);
        });
        // ASSERT
        assertEquals(expectedMessage.toUpperCase(Locale.ROOT), exception.getMessage());
    }

    /**
     * OWNER: ALICIA
     * Test for ensuring we reach the message for entering a new quandrant when star date and initial star date are
     * not equal
     */
    @Test
    void newQuadrant_printsNewLocationMessage_whenStarDate_AndInitialstardate_areNotEqual() {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);
        double initialStardate = 0.1 * 20 + 20;
        double stardate = 0.3 * 20 + 20;
        // quadrant we want to
        int[] quadrantXY = new int[]{1, 2};

        when(enterprise.getQuadrant()).thenReturn(quadrantXY);

        // ACT
        map.newQuadrant(stardate, initialStardate);

        // ASSERT - we know the first println(any()) is in this section of code, so if we hit here, we have passed
        verify(util, atLeastOnce()).println("NOW ENTERING " + any() + " QUADRANT . . .");
    }

    /**
     * OWNER: ALICIA
     * Test for ensuring we reach the message for starting location when star date and initial star date are
     * equal
     * <p>
     * NOTE: THIS CLASS IS NOT TESTABLE IN ITS CURRENT FORM AFTER THIS POINT. THE AMOUNT OF WORK TO MOCK THE SCENARIO IS
     * UNREALISTIC FOR OUR PROEJCT AND THE FUNCTION NEEDS TO BE REFACTORED AND OVERHAULED. HOWEVER, THAT LIFT IS BEYOND
     * THIS PROJECTS SCOPE, SO THE COVERAGE WE HAVE HERE IS SUFFICIENT FOR OUR NEEDS.
     */
    @Test
    void newQuadrant_printsStartLocation_whenStarDate_andInitialstardate_areEqual() {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);
        double initialStardate = 0.3 * 20 + 20;
        double stardate = initialStardate;

        // quadrant we want to
        int[] quadrantXY = new int[]{1, 2};

        when(enterprise.getQuadrant()).thenReturn(quadrantXY);
        String message = "YOUR MISSION BEGINS WITH YOUR STARSHIP LOCATED\n" + "IN THE GALACTIC QUADRANT, '";

        // ACT
        map.newQuadrant(stardate, initialStardate);

        // ASSERT - we know the first println(any()) is in this section of code, so if we hit here, we have passed
        verify(util, atLeastOnce()).println(message + any() + "'.");
    }

    /**
     * OWNER: ALICIA
     * Test for ensuring we reach the warning message when we have 3 Klingons in the quadrant
     */
    @Test
    void newQuadrant_printsKlingonWarning_whenKlingonsGreaterThanZero() {
        // ARRANGE
        String warningKlingonMsg = "COMBAT AREA      CONDITION RED";
        double initialStardate = 0.1 * 20 + 20;
        double stardate = 0.3 * 20 + 20;
        int[] quadrantXY = new int[]{1, 2};
        int[] sectorXY = new int[]{3, 7};
        float randNum = 0.98f;
        int fnrNum = 5;

        when(util.random()).thenReturn(randNum); // generate 3 klingons and 1 starbase in constructor
        when(util.fnr()).thenReturn(fnrNum);
        when(enterprise.getQuadrant()).thenReturn(quadrantXY);
        when(enterprise.getSector()).thenReturn(sectorXY);
        when(util.toInt(anyDouble())).thenCallRealMethod();
        when(util.rightStr(any(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works
        when(util.leftStr(any(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works
        when(util.midStr(any(), anyInt(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works

        // ACT
        GalaxyMap map = new GalaxyMap(util, enterprise);
        map.newQuadrant(stardate, initialStardate);

        // ASSERT
        verify(util).println(warningKlingonMsg);
    }

    /**
     * OWNER: ALICIA
     * Test for ensuring we reach the warning message when we have 3 Klingons in the quadrant
     */
    @Test
    void newQuadrant_printsKlingonWarning_and_printsShieldDanger_whenKlingonsGreaterThanZero() {
        // ARRANGE
        String warningKlingonMsg = "COMBAT AREA      CONDITION RED";
        String warningShieldMsg = "   SHIELDS DANGEROUSLY LOW";
        double initialStardate = 0.1 * 20 + 20;
        double stardate = 0.3 * 20 + 20;
        int[] quadrantXY = new int[]{1, 2};
        int[] sectorXY = new int[]{3, 7};
        float randNum = 0.97f;
        int fnrNum = 5;

        when(util.random()).thenReturn(randNum); // generate 2 klingons and 1 starbase in constructor
        when(util.fnr()).thenReturn(fnrNum);
        when(enterprise.getQuadrant()).thenReturn(quadrantXY);
        when(enterprise.getSector()).thenReturn(sectorXY);
        when(util.toInt(anyDouble())).thenCallRealMethod();
        when(util.rightStr(any(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works
        when(util.leftStr(any(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works
        when(util.midStr(any(), anyInt(), anyInt())).thenCallRealMethod(); // we aren't testing this, so any value works

        // ACT
        GalaxyMap map = new GalaxyMap(util, enterprise);
        map.newQuadrant(stardate, initialStardate);

        // ASSERT
        verify(util).println(warningKlingonMsg);
        verify(util).println(warningShieldMsg);

    }

        /**
         * OWNER: MUSTAFA
         * We verify that the quadrantMap is updated correctly, and we also make sure that moving the ship will decrease energy to 2966
         * Based on:
         *  course = 1
         *  warp = 3
         *  n = 24
         *  stardate = 28, initialStardate = 28
         *  missionDuration = 25
         *  quadrantMap = as seen below
         */
    @Test
    void moveEnterprise_verify_quadrantMap_will_update_and_energy_will_decrease_when_courseEqualTo1_warpEqualTo3_nEqualTo24() {
        // ARRANGE
        int[] quadrant = new int[]{6, 4};
        //Must mock before initializing GalaxyMap for line 52
        when(enterprise.getQuadrant()).thenReturn(quadrant);

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        //initialize gamecallback to pass it as a parameter
        GameCallback gameCallback = mock(GameCallback.class, CALLS_REAL_METHODS);

        //initialize mock of SuperStartrekGame
        SuperStarTrekGame superStarTrekGame = mock(SuperStarTrekGame.class);

        float course = 1;
        float warp = 3;
        int n = 24; // n = warp * 8, passed through multiple classes
        double stardate = 28;
        double initialStardate = stardate;
        int missionDuration = 25;
        String quadrantMap =
                "                                                                                                                             >!<                                                               ";
        String initialQuadrantMap = quadrantMap;
        int x = 5;
        int y = 3;
        int initialX = x;
        int initialY = y;
        int[] sectorsXY = new int[]{x, y};
        int[] sector = new int[]{0,
                                 4};//sector = [0,4] is what is it actually returned if the given arguments were passed, so we mock this

        when(enterprise.getSector()).thenReturn(sectorsXY);

        //Mock X coordinate on line 250
        when(util.toInt(sectorsXY[0])).thenCallRealMethod();
        //Mock Y coordinate on line 250
        when(util.toInt(sectorsXY[1])).thenCallRealMethod();

        int pos = y * 3 + x * 24 + 1;

        //Mock on line 778
        when(util.leftStr(quadrantMap, (pos - 1))).thenCallRealMethod();
        //Mock on line 778
        when(util.rightStr(quadrantMap, (190 - pos))).thenCallRealMethod();

        //quadrant map is updated to newQuadrantMap in insertMarker on line 257
        quadrantMap =
                "                                                                                                                             >!<                                                                ";

        //Mock on line 259
        when(enterprise.moveShip(course, n, quadrantMap, stardate, initialStardate, missionDuration,
                                 gameCallback)).thenReturn(sector);

        //Mock on line 264
        when(util.toInt(sector[0])).thenCallRealMethod();
        when(util.toInt(sector[1])).thenCallRealMethod();

        //pos is updated
        x = 0;
        y = 4;
        pos = y * 3 + x * 24 + 1;

        //Mock on line 778
        when(util.leftStr(quadrantMap, (pos - 1))).thenCallRealMethod();
        //Mock on line 778
        when(util.rightStr(quadrantMap, (190 - pos))).thenCallRealMethod();

        //Set energy so that method can function as expected (no nulls)
        enterprise.energy = 3000;
        //This calls the actual method that is void
        doCallRealMethod().when(enterprise).maneuverEnergySR(n);

        // ACT
        //We pass initial versions of the variables because we update the variables in order to mock above
        enterprise.setSector(initialX, initialY);
        map.quadrantMap = initialQuadrantMap;
        map.moveEnterprise(course, warp, n, stardate, initialStardate, missionDuration, gameCallback);
        String resultQuadrantMap =
                "            <*>                                                                                                              >!<                                                                ";

        // ASSERT
        assertEquals(2966, enterprise.energy);
        assertEquals(resultQuadrantMap, map.quadrantMap);
    }

    /**
     * OWNER: MUSTAFA
     * We verify that the quadrantMap is updated correctly, and we also make sure that moving the ship will decrease energy to 2966
     * Based on:
     * course = 1
     * warp = 0
     * n = 24
     * stardate = 29, initialStardate = 28
     * missionDuration = 0
     * quadrantMap = as seen below
     */
    @Test
    void moveEnterprise_verify_quadrantMap_will_update_and_energy_will_decrease_when_courseEqualTo1_warpEqualTo0_missionEqualTo0() {
        // ARRANGE
        int[] quadrant = new int[]{6, 4};
        //Must mock before initializing GalaxyMap for line 52
        when(enterprise.getQuadrant()).thenReturn(quadrant);

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        //initialize gamecallback to pass it as a parameter
        GameCallback gameCallback = mock(GameCallback.class, CALLS_REAL_METHODS);

        //initialize mock of SuperStartrekGame
        SuperStarTrekGame superStarTrekGame = mock(SuperStarTrekGame.class);

        float course = 1;
        float warp = 0;
        int n = 24; // n = warp * 8, passed through multiple classes
        double stardate = 29;
        double initialStardate = 28;
        int missionDuration = 0;
        String quadrantMap =
                "                                                                                                                             >!<                                                               ";
        String initialQuadrantMap = quadrantMap;
        int x = 5;
        int y = 3;
        int initialX = x;
        int initialY = y;
        int[] sectorsXY = new int[]{x, y};
        int[] sector = new int[]{0,
                                 4};//sector = [0,4] is what is it actually returned if the given arguments were passed, so we mock this

        when(enterprise.getSector()).thenReturn(sectorsXY);

        //Mock X coordinate on line 250
        when(util.toInt(sectorsXY[0])).thenCallRealMethod();
        //Mock Y coordinate on line 250
        when(util.toInt(sectorsXY[1])).thenCallRealMethod();

        int pos = y * 3 + x * 24 + 1;

        //Mock on line 778
        when(util.leftStr(quadrantMap, (pos - 1))).thenCallRealMethod();
        //Mock on line 778
        when(util.rightStr(quadrantMap, (190 - pos))).thenCallRealMethod();

        //quadrant map is updated to newQuadrantMap in insertMarker on line 257
        quadrantMap =
                "                                                                                                                             >!<                                                                ";

        //Mock on line 259
        when(enterprise.moveShip(course, n, quadrantMap, stardate, initialStardate, missionDuration,
                                 gameCallback)).thenReturn(sector);

        //Mock on line 264
        when(util.toInt(sector[0])).thenCallRealMethod();
        when(util.toInt(sector[1])).thenCallRealMethod();

        //pos is updated
        x = 0;
        y = 4;
        pos = y * 3 + x * 24 + 1;

        //Mock on line 778
        when(util.leftStr(quadrantMap, (pos - 1))).thenCallRealMethod();
        //Mock on line 778
        when(util.rightStr(quadrantMap, (190 - pos))).thenCallRealMethod();

        //Set energy so that method can function as expected (no nulls)
        enterprise.energy = 3000;
        //This calls the actual method that is void
        doCallRealMethod().when(enterprise).maneuverEnergySR(n);

        // ACT
        //We pass initial versions of the variables because we update the variables in order to mock above
        enterprise.setSector(initialX, initialY);
        map.quadrantMap = initialQuadrantMap;
        map.moveEnterprise(course, warp, n, stardate, initialStardate, missionDuration, gameCallback);
        String resultQuadrantMap =
                "            <*>                                                                                                              >!<                                                                ";

        // ASSERT
        assertEquals(2966, enterprise.energy);
        assertEquals(resultQuadrantMap, map.quadrantMap);
    }

    /**
     * OWNER: MUSTAFA
     * Test all boundaries that are valid
     * Condition:
     * 1. x = 0, y = 4
     * 2. x = 0, y = 0
     * 3. x = 5, y = 23
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/galaxyMap_insertMaker_Test.csv", numLinesToSkip = 1)
    void insertMarker_update_quadrantMap_when_pos_isValid(int x, int y, String marker, String currentQuadrantMap,
                                                          String quadrantMapResult) {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);

        int[] xy = new int[]{x, y};

        //Set quadrantMap to later assert quadrantMapResult
        map.quadrantMap = currentQuadrantMap;

        //Mock: Case of pos == 1 on line 789
        when(util.rightStr(currentQuadrantMap, 189)).thenCallRealMethod();

        //Mock: Case of pos == 190 on line 793
        when(util.rightStr(currentQuadrantMap, 189)).thenCallRealMethod();

        //Mock on line 779
        when(util.toInt(x)).thenCallRealMethod();
        //Mock on line 780
        when(util.toInt(y)).thenCallRealMethod();

        int pos = y * 3 + x * 24 + 1;

        //Mock on line 796
        when(util.leftStr(currentQuadrantMap, (pos - 1))).thenCallRealMethod();
        //Mock on line 796
        when(util.rightStr(currentQuadrantMap, (190 - pos))).thenCallRealMethod();

        // ACT
        map.insertMarker(marker, xy);

        // ASSERT
        assertEquals(quadrantMapResult, map.quadrantMap);
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void insertMarker_update_quadrantMap_when_markerLengthIsEqualTo3_and_isInvalid() {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);

        int[] xy = new int[]{5, 4};

        String marker = " <*>";

        // ACT
        map.insertMarker(marker, xy);

        // ASSERT
        verify(util).println("ERROR");
    }

    /**
     * OWNER: Sanchita
     * ship condition red
     * docked = false
     * Klingons = 1
     */
    @Test
    void shortRangeSensorScan_check_docked_status_and_calculate_the_ship_condition_red() {
        // ARRANGE
        int [] quadrant = new int [] {6,4};
        double [] deviceStatus = new double [] {1.00,2.00};
        when(enterprise.getSector()).thenReturn(quadrant);
        when(enterprise.getDeviceStatus()).thenReturn(deviceStatus);

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        // ACT
        map.klingons = 1;
        map.shortRangeSensorScan(10.00);
        when(util.toInt(anyDouble())).thenCallRealMethod();
        when(util.midStr(anyString(), anyInt(), anyInt())).thenReturn(">!<");

        // ASSERT
        assertEquals(false, enterprise.isDocked());
    }

    /**
     * OWNER: Sanchita
     * ship condition yellow
     * docked = false
     * Klingons = 0
     * energy less than initial energy
     */
    @Test
    void shortRangeSensorScan_check_docked_status_and_calculate_the_ship_condition_yellow() {
        // ARRANGE
        int [] quadrant = new int [] {6,4};
        double [] deviceStatus = new double [] {1.00,2.00};

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        // ACT
        when(enterprise.getSector()).thenReturn(quadrant);

        when(enterprise.getDeviceStatus()).thenReturn(deviceStatus);

        when(enterprise.getEnergy()).thenReturn(20);

        when(enterprise.getInitialEnergy()).thenReturn(3000);

        map.klingons = 0;

        map.shortRangeSensorScan(12.00);

        when(util.toInt(anyDouble())).thenCallRealMethod();

        when(util.midStr(anyString(), anyInt(), anyInt())).thenReturn(">!<");

        // ASSERT
        assertEquals(false, enterprise.isDocked());
    }

    /**
     * OWNER: Sanchita
     * ship condition green
     * docked = false
     * Klingons = 0
     * energy = initial energy
     */
    @Test
    void shortRangeSensorScan_check_docked_status_and_calculate_the_ship_condition_green() {
        // ARRANGE
        int [] quadrant = new int [] {6,4};
        double [] deviceStatus = new double [] {1.00,2.00};

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        // ACT
        when(enterprise.getSector()).thenReturn(quadrant);

        when(enterprise.getDeviceStatus()).thenReturn(deviceStatus);

        map.klingons = 0;

        map.shortRangeSensorScan(12.00);

        when(util.toInt(anyDouble())).thenCallRealMethod();

        when(util.midStr(anyString(), anyInt(), anyInt())).thenReturn(">!<");

        // ASSERT
        assertEquals(false, enterprise.isDocked());
    }


    /**
     * OWNER: Sanchita
     * docked = true
     * klingons = 1
     * ship condition = docked
     */
    @Test
    void shortRangeSensorScan_check_docked_status_false() {
        // ARRANGE
        int[] quadrant = new int[]{6, 4};
        double[] deviceStatus = new double[]{1.00, 2.00};
        when(enterprise.getSector()).thenReturn(quadrant);
        when(enterprise.getDeviceStatus()).thenReturn(deviceStatus);

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        //ACT
        when(util.toInt(anyDouble())).thenCallRealMethod();
        when(util.midStr(anyString(), anyInt(), anyInt())).thenReturn(">!<");
        map.klingons = 1;
        map.shortRangeSensorScan(10.00);

        String message ="SHIELDS DROPPED FOR DOCKING PURPOSES";

        //ASSERT
        assertEquals(false,enterprise.isDocked());
        verify(util, atLeastOnce()).println(message + any() + "'.");
    }

    /**
     * OWNER: Sanchita
     * docked = true
     * device status less than 0. short range sensors are out
     */
    @Test
    void shortRangeSensorScan_check_docked_status_true_shrot_range_sensors_out() {
        // ARRANGE
        int[] quadrant = new int[]{6, 4};
        double[] deviceStatus = new double[]{1.00,-2.00};
        when(enterprise.getSector()).thenReturn(quadrant);
        when(enterprise.getDeviceStatus()).thenReturn(deviceStatus);

        //initialize Galaxymap to test it
        GalaxyMap map = new GalaxyMap(util, enterprise);

        //ACT
        when(util.toInt(anyDouble())).thenCallRealMethod();

        when(util.midStr(anyString(), anyInt(), anyInt())).thenReturn(">!<");

        map.klingons = 0;
        map.shortRangeSensorScan(10.00);

        //ASSERT
        assertEquals(false,enterprise.isDocked());
        verify(util).println("\n*** SHORT RANGE SENSORS ARE OUT ***\n");
    }

    /**
     * OWNER: ALICIA
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/galaxyMap_getQuadrantName.csv", numLinesToSkip = 1)
    void getQuadrantName_returnsCorrectQuadrant(int X, int Y, String expectedResult) {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);

        // ACT
        String result = map.getQuadrantName(false, X, Y);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/galaxyMap_getRegionName.csv", numLinesToSkip = 1)
    void getRegionName_returnsCorrectRegion(int Y, String expectedResult) {
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);

        // ACT
        String result = map.getRegionName(false, Y);

        // ASSERT
        assertEquals(expectedResult, result);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void printNoEnemyShipsMessage_return_expected_string_message(){
        // ARRANGE
        GalaxyMap map = new GalaxyMap(util, enterprise);
        String expectedResult1 = "SCIENCE OFFICER SPOCK REPORTS  'SENSORS SHOW NO ENEMY SHIPS";
        String expectedResult2 = "                                IN THIS QUADRANT'";

        // ACT
        map.printNoEnemyShipsMessage();

        // ASSERT
        verify(util).println(expectedResult1);
        verify(util).println(expectedResult2);
    }

    /**
     * OWNER: ALICIA
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/galaxyMap_starbaseNavData.csv", numLinesToSkip = 1)
    void starbaseNavData_prints_correctMessage_forStarbaseCount(float randNum, String expectedMessage) {
        // ARRANGE
        when(util.random()).thenReturn(randNum); // generate 3 klingons and 1 starbase in constructor
        when(util.fnr()).thenCallRealMethod();

        when(enterprise.getSector()).thenCallRealMethod();

        // ACT
        GalaxyMap map = new GalaxyMap(util, enterprise);
        map.starbaseNavData();

        // ASSERT - if we hit this message, we know the directions are printed
        verify(util).println(expectedMessage);
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void klingonsMoveAndFire() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void klingonsShoot() {
        // ARRANGE

        // ACT

        // ASSERT
    }


    /**
     * OWNER:
     */
    @Test
    void longRangeSensorScan() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void firePhasers() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void firePhotonTorpedo() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void cumulativeGalacticRecord() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void photonTorpedoData() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void directionDistanceCalculator() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void printDirection() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void printNoEnemyShipsMessage() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void findEmptyPlaceInQuadrant() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void compareMarker() {
        // ARRANGE

        // ACT

        // ASSERT
    }
}
