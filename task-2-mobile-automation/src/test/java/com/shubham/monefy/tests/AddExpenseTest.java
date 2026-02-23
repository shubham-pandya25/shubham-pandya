package com.shubham.monefy.tests;

import com.shubham.monefy.base.BaseTest;
import com.shubham.monefy.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddExpenseTest extends BaseTest {

    @Test
    void userCanAddExpense() {
        HomePage home = new HomePage(driver);

        home.openNewExpense()
                .enterAmount("50")
                .tapChooseCategory()
                .selectCategory("Food");

        Assertions.assertTrue(home.isOnDashboard(), "App did not return to dashboard.");
    }
}