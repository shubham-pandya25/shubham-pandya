
package com.shubham.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CategoryPage {

    private final AndroidDriver driver;

    public CategoryPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage selectCategory(String category) {
        By locator = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + escape(category) + "\")"
        );
        driver.findElement(locator).click();
        return new HomePage(driver);
    }

    public boolean isCategoryPresent(String category) {
        By direct = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"" + escape(category) + "\")"
        );
        if (!driver.findElements(direct).isEmpty()) return true;

        try {
            By scroll = AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().textContains(\"" + escape(category) + "\"))"
            );
            return !driver.findElements(scroll).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    private String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}