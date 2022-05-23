import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: Alicia Garcia, Mustafa Abuthuraya, Sanchita Jain
 * Version: 1.0
 * Date: 4/20/2022 12:28
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 * ****************************** READ ME! ******************************
 * THE TESTS BELOW ARE PLACEHOLDER AND SHOULD BE USED AS A GUIDE TO IMPLEMENT
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
        int [] quadrantArr = new int [] {6,4}; //6,4 are random
        when(enterprise.getQuadrant()).thenReturn(quadrantArr);

        int [] sectorArr = new int [] {0,0};
        when(enterprise.getSector()).thenReturn(sectorArr);

    }

    /**
     * OWNER: ALICIA - need to rework since the coordinates and klingon locations are arrays filled with 0's
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
     */
    @Test
    void newQuadrant() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void klingonsMoveAndFire() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void klingonsShoot() {
        // ARRANGE

        // ACT

        // ASSERT
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
        int [] quadrant = new int [] {6,4};
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
        String quadrantMap = "                                                                                                                             >!<                                                               ";
        String initialQuadrantMap = quadrantMap;
        int x = 5;
        int y = 3;
        int initialX = x;
        int initialY = y;
        int [] sectorsXY = new int[] {x,y};
        int [] sector = new int [] {0,4};//sector = [0,4] is what is it actually returned if the given arguments were passed, so we mock this

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
        quadrantMap = "                                                                                                                             >!<                                                                ";

        //Mock on line 259
        when(enterprise.moveShip(course, n, quadrantMap,stardate, initialStardate, missionDuration, gameCallback)).thenReturn(sector);

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
        enterprise.setSector(initialX,initialY);
        map.quadrantMap = initialQuadrantMap;
        map.moveEnterprise(course, warp, n, stardate, initialStardate, missionDuration, gameCallback);
        String resultQuadrantMap = "            <*>                                                                                                              >!<                                                                ";

        // ASSERT
        assertEquals(2966, enterprise.energy);
        assertEquals(resultQuadrantMap, map.quadrantMap);
    }

    /**
     * OWNER: MUSTAFA
     * We verify that the quadrantMap is updated correctly, and we also make sure that moving the ship will decrease energy to 2966
     * Based on:
     *  course = 1
     *  warp = 0
     *  n = 24
     *  stardate = 29, initialStardate = 28
     *  missionDuration = 0
     *  quadrantMap = as seen below
     */
    @Test
    void moveEnterprise_verify_quadrantMap_will_update_and_energy_will_decrease_when_courseEqualTo1_warpEqualTo0_missionEqualTo0() {
        // ARRANGE
        int [] quadrant = new int [] {6,4};
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
        String quadrantMap = "                                                                                                                             >!<                                                               ";
        String initialQuadrantMap = quadrantMap;
        int x = 5;
        int y = 3;
        int initialX = x;
        int initialY = y;
        int [] sectorsXY = new int[] {x,y};
        int [] sector = new int [] {0,4};//sector = [0,4] is what is it actually returned if the given arguments were passed, so we mock this

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
        quadrantMap = "                                                                                                                             >!<                                                                ";

        //Mock on line 259
        when(enterprise.moveShip(course, n, quadrantMap,stardate, initialStardate, missionDuration, gameCallback)).thenReturn(sector);

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
        enterprise.setSector(initialX,initialY);
        map.quadrantMap = initialQuadrantMap;
        map.moveEnterprise(course, warp, n, stardate, initialStardate, missionDuration, gameCallback);
        String resultQuadrantMap = "            <*>                                                                                                              >!<                                                                ";

        // ASSERT
        assertEquals(2966, enterprise.energy);
        assertEquals(resultQuadrantMap, map.quadrantMap);
    }

    /**
     * OWNER:
     */
    @Test
    void shortRangeSensorScan() {
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
    void starbaseNavData() {
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
     * OWNER: MUSTAFA
     */
    @Test
    void insertMarker() {
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
