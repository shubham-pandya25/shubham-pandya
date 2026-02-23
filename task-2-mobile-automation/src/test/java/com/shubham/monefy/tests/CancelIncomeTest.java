package com.shubham.monefy.tests;

import com.shubham.monefy.base.BaseTest;
import com.shubham.monefy.pages.HomePage;
import com.shubham.monefy.pages.TransactionPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CancelIncomeTest extends BaseTest {

    @Test
    void userCanCancelIncomeEntry() {

        HomePage home = new HomePage(driver).stabilize();

        TransactionPage tx = home.openNewIncome();
        tx.enterAmount("10");


        driver.navigate().back();


        Assertions.assertFalse(tx.isOnTransactionScreen(),
                "Still on transaction screen after cancel/back.");
    }
}