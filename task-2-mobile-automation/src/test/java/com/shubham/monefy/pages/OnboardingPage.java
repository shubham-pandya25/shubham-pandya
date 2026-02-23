package com.shubham.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class OnboardingPage {

    private final AndroidDriver driver;

    public OnboardingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage completeOnboardingIfPresent() {

        tapIfVisible("GET STARTED");
        tapIfVisible("AMAZING");
        tapIfVisible("YES PLEASE");

        By continueBtn = AppiumBy.id("com.monefy.app.lite:id/buttonContinue");
        if (!driver.findElements(continueBtn).isEmpty()) {
            driver.findElement(continueBtn).click();
        }

        tapIfVisible("ALLOW");


        By closeOffer = AppiumBy.id("com.monefy.app.lite:id/buttonClose");
        if (!driver.findElements(closeOffer).isEmpty()) {
            driver.findElement(closeOffer).click();
        }

        new HomePage(driver);
        return null;
    }
    private By textContains(String text) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\")"
        );
    }

    private void clickIfPresent(By locator) {
        List<?> elements = driver.findElements(locator);
        if (!elements.isEmpty()) {
            driver.findElement(locator).click();
        }
    }

    private void tapIfVisible(String text) {
        By locator = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\")"
        );

        if (!driver.findElements(locator).isEmpty()) {
            driver.findElement(locator).click();
        }
    }
}