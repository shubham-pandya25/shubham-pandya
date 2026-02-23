package com.shubham.monefy.base;

import com.shubham.monefy.pages.OnboardingPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = DriverFactory.createAndroidDriver();


        new OnboardingPage(driver).completeOnboardingIfPresent();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}