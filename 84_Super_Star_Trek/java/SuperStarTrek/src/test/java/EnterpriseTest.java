import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Author: Alicia Garcia, Mustafa Abuthuraya, Sanchita Jain
 * Version: 1.0
 * Date: 4/20/2022 12:285
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 * ********************  READ ME!   **************************************
 * THE TESTS BELOW ARE PLACEHOLDER AND SHOULD BE USED AS A GUIDE TO IMPLEMENT
 * YOUR TESTS AND DETERMINING WHAT TO TEST. PLEASE BE SURE TO CLAIM YOUR SECTION
 * OF CODE YOU'RE TESTING AND PUSH YOUR CHANGES IMMEDIATELY AND NOTIFY THE TEAM
 * **********************************************************************
 * **********************************************************************
 * **********************************************************************
 */

class EnterpriseTest {
    Util util;

    @BeforeEach
    void setup_testing_environment() {
        this.util = mock(Util.class);
    }
/**
     * OWNER: ALICIA
     */
    @Test
    void getShields_value_is_zero_atGame_start() {
        // ARRANGE
        Enterprise enterprise = new Enterprise(util);



        // ACT

        // ASSERT

    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void dropShields() {
        // ARRANGE

        // ACT

        // ASSERT
    }
    /**
     * OWNER: ALICIA
     */
    @Test
    void shieldControl() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void sufferHitPoints() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    public void getEnergy_must_return_current_energy() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);
        int energy;

        //ACT
        //change energy = 2000
        enterprise.energy = 2000;
        energy = enterprise.energy;

        //ASSERT
        Assertions.assertEquals(energy, enterprise.getEnergy());
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void replenishSupplies_must_return_energy_and_torpedoes_equalTo_initialEnergy_and_initialTorpedoes() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);
        int energy;
        int torpedoes;

        //initial energy = 3000
        energy = enterprise.energy;
        //initial torpedoes = 10
        torpedoes = enterprise.torpedoes;


        //ACT
        // energy left = 3000-50 = 2950
        enterprise.decreaseEnergy(50.0);

        // torpedoes left = 10-3 = 7
        enterprise.decreaseTorpedoes(3);

        //replenishSupplies:
        //energy left = 3000
        //torpedoes left = 10
        enterprise.replenishSupplies();

        //ASSERT
        Assertions.assertEquals(energy, enterprise.energy);
        Assertions.assertEquals(torpedoes, enterprise.torpedoes);
    }

    /**
     * OWNER:
     */
    @Test
    void decreaseEnergy() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void decreaseTorpedoes() {
        // ARRANGE

        // ACT

        // ASSERT
    }



    /**
     * OWNER:
     */
    @Test
    void getTotalEnergy() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void getInitialEnergy() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void getTorpedoes_must_return_current_torpedoes() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);
        int torpedoes;

        //ACT
        enterprise.torpedoes = 7;
        torpedoes = enterprise.torpedoes;

        //ASSERT
        Assertions.assertEquals(torpedoes, enterprise.getTorpedoes());
    }

    /**
     * OWNER:
     */
    @Test
    void getDeviceStatus() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void getCardinalDirections() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void setDeviceStatus() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void isDocked() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void setDocked() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void getQuadrant() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void setQuadrant() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void getSector() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void setSector() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void moveShip() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void randomRepairCost() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void repairDamagedDevices() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void maneuverEnergySR() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void damageControl() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER:
     */
    @Test
    void printDeviceName() {
        // ARRANGE

        // ACT

        // ASSERT
    }
}
