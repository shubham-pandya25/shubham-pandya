package com.shubham.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HomePage {

    private final AndroidDriver driver;


    private final By amountText = AppiumBy.id("com.monefy.app.lite:id/amount_text");


    private final By drawerChooseDate =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Choose date\")");


    private final By snackbarCancel =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"CANCEL\")");


    private final By balanceLabel =
            AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"Balance\")");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }


    public HomePage stabilize() {
        closeDrawerIfOpen();
        dismissSnackbarIfPresent();
        return this;
    }

    public TransactionPage openNewExpense() {
        stabilize();

        for (int i = 0; i < 4; i++) {
            dismissSnackbarIfPresent();
            tapExpenseCircle();

            if (isTransactionScreenOpen()) {
                return new TransactionPage(driver);
            }
            sleep(250);
        }

        throw new RuntimeException("Could not open New expense screen (amount_text not found).");
    }

    public TransactionPage openNewIncome() {
        stabilize();

        for (int i = 0; i < 4; i++) {
            dismissSnackbarIfPresent();
            tapIncomeCircle();

            if (isTransactionScreenOpen()) {
                return new TransactionPage(driver);
            }
            sleep(250);
        }

        throw new RuntimeException("Could not open New income screen (amount_text not found).");
    }

    public boolean isOnDashboard() {
        stabilize();
        return !driver.findElements(balanceLabel).isEmpty();
    }


    public String getBalanceText() {
        stabilize();

        List<WebElement> els = driver.findElements(balanceLabel);
        if (!els.isEmpty()) return els.get(0).getText();


        List<WebElement> all = driver.findElements(AppiumBy.className("android.widget.TextView"));
        for (WebElement e : all) {
            String t = e.getText();
            if (t != null && t.startsWith("Balance")) return t;
        }

        throw new RuntimeException("Balance text not found on dashboard.");
    }



    private boolean isTransactionScreenOpen() {
        return !driver.findElements(amountText).isEmpty();
    }

    private void closeDrawerIfOpen() {
        if (!driver.findElements(drawerChooseDate).isEmpty()) {
            driver.navigate().back(); // closes drawer
            sleep(200);
        }
    }

    private void dismissSnackbarIfPresent() {
        if (!driver.findElements(snackbarCancel).isEmpty()) {
            driver.findElement(snackbarCancel).click();
            sleep(150);
        }
    }

    private void tapExpenseCircle() {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.25);
        int y = (int) (size.height * 0.85);
        click(x, y);
    }

    private void tapIncomeCircle() {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.75);
        int y = (int) (size.height * 0.85);
        click(x, y);
    }

    private void click(int x, int y) {
        driver.executeScript("mobile: clickGesture",
                Map.of("x", x, "y", y, "duration", 80));
        sleep(150);
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}