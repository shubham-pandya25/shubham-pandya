package com.shubham.monefy.tests;

import com.shubham.monefy.base.BaseTest;
import com.shubham.monefy.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DriverBootTest extends BaseTest {

    @Test
    void appLaunchesAndDashboardIsVisible() {
        HomePage home = new HomePage(driver).stabilize();


        Assertions.assertNotNull(driver.getSessionId(), "Driver session was not created.");
    }
}