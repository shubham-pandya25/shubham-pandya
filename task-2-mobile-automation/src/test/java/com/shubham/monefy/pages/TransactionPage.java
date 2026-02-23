package com.shubham.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TransactionPage {

    private final AndroidDriver driver;

    private final By chooseCategory =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"CHOOSE CATEGORY\")");

    private final By amountText =
            AppiumBy.id("com.monefy.app.lite:id/amount_text"); // marker for transaction screen

    public TransactionPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public TransactionPage enterAmount(String amount) {
        for (char ch : amount.toCharArray()) {
            By key = AppiumBy.androidUIAutomator("new UiSelector().text(\"" + ch + "\")");
            driver.findElement(key).click();
        }
        return this;
    }

    public CategoryPage tapChooseCategory() {
        driver.findElement(chooseCategory).click();
        return new CategoryPage(driver);
    }

    public boolean isOnTransactionScreen() {
        return !driver.findElements(amountText).isEmpty();
    }
}