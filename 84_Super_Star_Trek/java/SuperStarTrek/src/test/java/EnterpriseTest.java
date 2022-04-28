import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
     * Verify that the shields are not up when the enterprise is first starting
     */
    @Test
    void getShields_value_is_zero_atGame_start() {
        // ARRANGE
        Enterprise enterprise = new Enterprise(util);
        int expectedShield = 0;

        // ACT

        // ASSERT
        assertEquals(expectedShield, enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     * Verify the shields increased when control command given to increase
     */
    @Test
    void shieldControl_user_increases_shield_by_500_returns_new_shield_value() {
        int userInput = 500;

        // ARRANGE
        Enterprise enterprise = new Enterprise(util);
        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();

        // ASSERT
        assertEquals(userInput, enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     * Verify the shields do not change when control command is a negative number
     */
    @Test
    void shieldControl_user_increases_shield_by_negative_returns_unchangedMessage() {
        int userInput = -500;

        // ARRANGE
        Enterprise enterprise = new Enterprise(util);
        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();

        // ASSERT
        verify(util).println("<SHIELDS UNCHANGED>");
        assertEquals(0, enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     * Verify the shields do not change when control command is a the same as the current
     * value of the shields (BAD DESIGN!!)
     */
    @Test
    void shieldControl_user_increases_shield_by_currentValueOfShield_returns_unchangedMessage() {
        int userInput = 500;

        // ARRANGE
        Enterprise enterprise = new Enterprise(util);

        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();

        //repeat the user input of the same value
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();

        // ASSERT
        verify(util).println("<SHIELDS UNCHANGED>");
        assertEquals(userInput, enterprise.getShields());
    }
    /**
     * OWNER: ALICIA
     * Verify the shields do not change when control command is greater than available energy (always 3000)
     */
    @Test
    void shieldControl_user_increases_shield_by_more_than_energy_returns_snarkyMessage_and_unchanged() {
        int userInput = 50000;

        // ARRANGE
        Enterprise enterprise = new Enterprise(util);

        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();

        // ASSERT
        verify(util).println("SHIELD CONTROL REPORTS  'THIS IS NOT THE FEDERATION TREASURY.'");
        verify(util).println("<SHIELDS UNCHANGED>");
        assertNotEquals(userInput, enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     * Verify shields are dropped to after energy added when method is called.
     */
    @Test
    void dropShields_validate_shield_drops_to_zero() {
        int userInput = 500;

        // ARRANGE
        Enterprise enterprise = new Enterprise(util);
        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userInput);
        when(util.toInt((float)userInput)).thenReturn(userInput);

        // ACT
        enterprise.shieldControl();
        enterprise.dropShields();

        // ASSERT
        assertEquals(0, enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     * Verify the shields will decrease when the enterprise takes damage
     */
    @Test
    void sufferHitPoints_will_reduce_shields_when_damage_taken() {
        // ARRANGE
        int userShieldInput = 500;
        int shipHitDamage = 300;

        // ACT
        Enterprise enterprise = new Enterprise(util);
        // create the mock environment for user input commands
        when(util.inputFloat(any())).thenReturn((float)userShieldInput);
        when(util.toInt((float)userShieldInput)).thenReturn(userShieldInput);

        enterprise.shieldControl();
        enterprise.sufferHitPoints(shipHitDamage);

        // ASSERT
        assertEquals((userShieldInput - shipHitDamage), enterprise.getShields());
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void damageControl() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void randomRepairCost() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: ALICIA
     */
    @Test
    void repairDamagedDevices() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    public void getEnergy_must_return_3000_energy() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);
        int energy;

        //ACT

        //ASSERT
        Assertions.assertEquals(3000, enterprise.getEnergy());
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void replenishSupplies_must_return_3000_energy_and_10_torpedoes() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);

//        //initial energy = 3000
//        energy = enterprise.energy;
//        //initial torpedoes = 10
//        torpedoes = enterprise.torpedoes;

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
        Assertions.assertEquals(3000, enterprise.energy);
        Assertions.assertEquals(10, enterprise.torpedoes);
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
     * OWNER: Sanchita
     * As the shield value is 0 the total energy returned is 300
     */
    @Test
    void getTotalEnergy() {
        // ARRANGE
        int energy = 3000;
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(energy, enterprise.getTotalEnergy());
    }

    /**
     * OWNER: Sanchita
     * validate that the initial energy is set to 3000
     */
    @Test
    void getInitialEnergy() {
        // ARRANGE
        int energy = 3000;
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(energy, enterprise.getInitialEnergy());
    }

    /**
     * OWNER: MUSTAFA
     */
    @Test
    void getTorpedoes_must_return_10_torpedoes() {
        //ARRANGE
        Enterprise enterprise = new Enterprise(util);

        //ACT

        //ASSERT
        Assertions.assertEquals(10, enterprise.getTorpedoes());
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
    void maneuverEnergySR() {
        // ARRANGE

        // ACT

        // ASSERT
    }

    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_warp_engines_and_input_is_one() {
        // ARRANGE
        String deviceName = "WARP ENGINES";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(1));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_short_range_sensors_and_input_is_two() {
        // ARRANGE
        String deviceName = "SHORT RANGE SENSORS";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(2));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_long_range_sensors_and_input_is_three() {
        // ARRANGE
        String deviceName = "LONG RANGE SENSORS";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(3));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_phaser_control_and_input_is_four() {
        // ARRANGE
        String deviceName = "PHASER CONTROL";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(4));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_photon_tubes_and_input_is_five() {
        // ARRANGE
        String deviceName = "PHOTON TUBES";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(5));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_device_damage_control_and_input_is_six() {
        // ARRANGE
        String deviceName = "DAMAGE CONTROL";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(6));
    }
    /**
     * OWNER: Sanchita
     * to ensure the print device name method is printing the device name according to device number
     */
    @Test
    void printDeviceName_for_invalid_input() {
        // ARRANGE
        String deviceName = "";
        Enterprise enterprise = new Enterprise(util);
        //ACT

        //ASSERT
        Assertions.assertEquals(deviceName, enterprise.printDeviceName(0));
    }

}
