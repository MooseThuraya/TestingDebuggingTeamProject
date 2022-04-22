import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Alicia Garcia, Mustafa Abuthuraya, Sanchita Jain
 * Version: 1.0
 * Date: 4/20/2022 12:285
 */

class EnterpriseTest {

    /**
     * OWNER: ALICIA
     */
    @Test
    void getShields() {
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void sufferHitPoints() {
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    public void getEnergy_must_return_current_energy() {
        //ARRANGE
        Enterprise enterprise = new Enterprise();
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
        Enterprise enterprise = new Enterprise();
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
    }

    /**
     * OWNER:
     */
    @Test
    void decreaseTorpedoes() {
    }

    /**
     * OWNER:
     */
    @Test
    void dropShields() {
    }

    /**
     * OWNER:
     */
    @Test
    void getTotalEnergy() {
    }

    /**
     * OWNER:
     */
    @Test
    void getInitialEnergy() {
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void getTorpedoes_must_return_current_torpedoes() {
        //ARRANGE
        Enterprise enterprise = new Enterprise();
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
    }

    /**
     * OWNER:
     */
    @Test
    void getCardinalDirections() {
    }

    /**
     * OWNER:
     */
    @Test
    void setDeviceStatus() {
    }

    /**
     * OWNER:
     */
    @Test
    void isDocked() {
    }

    /**
     * OWNER:
     */
    @Test
    void setDocked() {
    }

    /**
     * OWNER:
     */
    @Test
    void getQuadrant() {
    }

    /**
     * OWNER:
     */
    @Test
    void setQuadrant() {
    }

    /**
     * OWNER:
     */
    @Test
    void getSector() {
    }

    /**
     * OWNER:
     */
    @Test
    void setSector() {
    }

    /**
     * OWNER:
     */
    @Test
    void moveShip() {
    }

    /**
     * OWNER:
     */
    @Test
    void randomRepairCost() {
    }

    /**
     * OWNER:
     */
    @Test
    void repairDamagedDevices() {
    }

    /**
     * OWNER:
     */
    @Test
    void maneuverEnergySR() {
    }

    /**
     * OWNER:
     */
    @Test
    void shieldControl() {
    }

    /**
     * OWNER:
     */
    @Test
    void damageControl() {
    }

    /**
     * OWNER:
     */
    @Test
    void printDeviceName() {
    }
}